package ser321.assign2.lindquis;

import java.io.*;
import java.util.*;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.json.JSONString;
import java.io.FileWriter;
import java.io.IOException;

import org.json.*;
import com.google.gson.*;

public class MusicLibrary extends Object implements Serializable{
	
JSONObject library;
	
	
private Hashtable<String,MediaDescription> aLib;
private static final String fileName="library.json";

public void getMusicLibrary() {
	Gson gson = new Gson();
	try {
		 Reader reader = File.newBufferedReader(Path.get("library.json"));

		    //create JsonObject instance
		    JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
				
	} catch (Exception e)
    {
        e.printStackTrace();
    }
}
	
public void writeAlbum(Album album) {
	getMusicLibrary();
	try
    {
	JSONObject albumObject = new JSONObject();
	JSONObject albumDetails = new JSONObject();
	
	albumDetails.put("artist", album.artist);
	albumDetails.put("image", album.image);
	albumDetails.put("runtime", album.runTime);
	
	JSONArray Tracks = new JSONArray();
	for(int i = 0; i < album.tracks.size(); i++) {
		JSONObject trackDetails = new JSONObject();
		
		trackDetails.put("title", album.tracks.get(i).trackName);
		trackDetails.put("rank", album.tracks.get(i).trackRankOrder);
		trackDetails.put("duration", album.tracks.get(i).Duration);
		Tracks.put(trackDetails);
		
	}
	albumDetails.put("tracks", Tracks);
	albumObject.put(album.albumName,albumDetails);
	
	FileWriter file = new FileWriter("library.json", true);
	
	
	
	file.write(albumObject.toString() + "\n");
	file.close();
	
    } catch (Exception e)
    {
        e.printStackTrace();
    }
	readJson();
}
	


public void readJson(){
	

	
    }
	
}
