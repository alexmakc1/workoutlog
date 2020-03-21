package ser321.assign2.lindquis;

import java.io.*;
import java.util.*;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;

public class MusicLibrary{
	   private Hashtable<String,MediaDescription> aLib;
	   private static final String fileName="music.json";
	
	public MusicLibrary(){
	      this.aLib = new Hashtable<String,MediaDescription>();
	      try{
	          InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.fileName);
	          if(is==null){
	             is = new FileInputStream(new File(this.fileName));
	          }
	          JSONObject media = new JSONObject(new JSONTokener(is));
	          Iterator<String> it = media.keys();
	          while (it.hasNext()){
	             String mediaTitle = it.next();
	             JSONObject aMed = media.optJSONObject(mediaTitle);
	             if (aMed != null){
	                MediaDescription md = new MediaDescription(aMed);
	                aLib.put(mediaTitle, md);
	             }
	          }
	       }catch (Exception ex){
	          System.out.println("Exception reading "+fileName+": "+ex.getMessage());
	       }
	    }
	
	
	
	
	public void getAlbumNames(){
		
	}
	
	
}