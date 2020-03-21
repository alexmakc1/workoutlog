package ser321.assign2.lindquis;

import java.io.*;
import java.util.*;
import java.net.URL;
import org.json.JSONObject;

public class Track{
	
	String trackName;
	String trackArtist;
	int trackRankOrder;
	int Duration;
	
	
	
	public static Track parseLastFMJson(JSONObject trackjb, String artist, int rank) {
		Track temp = new Track();
		temp.trackName = trackjb.getString("name");
		
		temp.trackArtist = artist;
		temp.trackRankOrder = rank;
		
		
		
		return temp;
		
	}
	
	
}
