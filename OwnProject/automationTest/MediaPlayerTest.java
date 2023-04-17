package automationTest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class MediaPlayerTest {
	  
	    private static HashMap<String, ArrayList<String>> Songbox = new HashMap<String, ArrayList<String>>();
	    private static int MaxSongs = 3;

	    public static void main(String[] args) {
	    	Scanner scan = new Scanner(System.in);
	    	System.out.println("Max limit of Songs " + MaxSongs);
	        SongTOplay("user1", "S1");
	        SongTOplay ("user1", "S2");
	        SongTOplay ("user1", "S3");

	        ArrayList<String> playlist = Songbox.get("user1");
	        System.out.println( "Orignal Playlist  "  + playlist);
	        if (playlist.size() == 3 && playlist.get(0).equals("S1") && playlist.get(1).equals("S2") && playlist.get(2).equals("S3")) {
	        	
	        	System.out.println("Enter songs name to play"); // U have to provide the song value.
	        	
	        	String songName =scan.next();
	        	
	        	SongTOplay("user1", songName);
	        	 playlist = Songbox.get("user1");
		            System.out.println( "Recent playlist  " + playlist);
	 	       
	        } else {
	            System.out.println("Error in Max limit of songs");
	        }
             scan.close();
	    }

	    public static void SongTOplay(String user, String song) {
	    	
	        if (!Songbox.containsKey(user)) {
	            Songbox.put(user, new ArrayList<String>());
	        }
	        ArrayList<String> playlist = Songbox.get(user);
	        if (playlist.size() == MaxSongs) {
	            playlist.remove(0);
	        }
	       
	        playlist.add(song);
	    }
}