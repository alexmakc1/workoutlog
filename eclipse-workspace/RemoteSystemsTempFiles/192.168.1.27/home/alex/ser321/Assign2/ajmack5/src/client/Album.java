package ser321.assign2.lindquis;

import java.io.*;
import java.util.*;
import java.net.URL;
import org.json.JSONObject;

import org.json.JSONArray;

public class Album{
	String albumName;
	String artist;
	List<Track> tracks;
	String image;
	List<String> genre;
	String summary = "";
	int runTime;
	String aJsonString;
	
	public Album() {
		
	}
	
	public static Album parseLastFMJson(String aJsonString) {
		Album temp = new Album();
		temp.tracks = new ArrayList<Track>();
		//GETS ALBUM NAME AND ARTIST NAME FROM JSON//
		JSONObject albumJson = new JSONObject(aJsonString);
		JSONObject albumAttr = albumJson.getJSONObject("album");
		String albumName = albumAttr.getString("name");
		String artist = albumAttr.getString("artist");
		
		//GETS THE IMAGE URL FROM JSON//
		JSONArray jsonImageArray = albumAttr.getJSONArray("image");
		JSONObject imageOb = jsonImageArray.getJSONObject(3);
		String image = imageOb.getString("#text");
		
		
		//GETS SUMMARY FROM ALBUM JSON//
		JSONObject summ = albumAttr.getJSONObject("wiki");
		String summString = summ.getString("summary");
		
		
		//GET GENRE FROM ALBUM JSON//
		
		JSONArray tags = albumAttr.getJSONObject("tags").getJSONArray("tag");
	
		List<String> genre = new ArrayList();
		for(int i = 0; i < tags.length(); i++) {
			genre.add(tags.getJSONObject(i).getString("name"));
			
		}
		
		//GETS RUN TIME AND CREATES TRACK OBJECTS FROM ALBUM JSON//
		
		JSONArray tracks = albumAttr.getJSONObject("tracks").getJSONArray("track");
		int totalAlbumDuration = 0;
		
		for(int i = 0; i < tracks.length(); i++) {
			totalAlbumDuration += tracks.getJSONObject(i).getInt("duration");
			Track tempTrack = Track.parseLastFMJson(tracks.getJSONObject(i), artist, i);
			temp.tracks.add(Track.parseLastFMJson(tracks.getJSONObject(i), artist, i));		
			
			
		}
				
			
		
				
				temp.albumName = albumName;
				temp.artist = artist;
				temp.image = image;
				temp.genre = genre;
				temp.summary = summString;
				temp.runTime = totalAlbumDuration;
				
				
		
		return temp;
	}
	

	
	
}