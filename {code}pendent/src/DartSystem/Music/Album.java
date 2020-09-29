package DartSystem.Music;

import java.util.ArrayList;

public class Album {
    private String songID;
    private String title;
    private String artist;
    private int year;
    private boolean rentStatus;
    private int rating;
    private double dailyRent;
    private  ArrayList<Songs> trackList = new ArrayList<>();
    private ArrayList<Album> albums;

    public Album(){
    };

    public Album(String songId, String title, String artist, ArrayList<Songs> trackList){
        this.songID = songId;
        this.title = title;
        this.artist = artist;
        this.rentStatus = false;
        this.trackList = trackList;

    }
 public String toString( ){
        return this.getID + " : " + this.getTitle + " - by " + this.getArtist + ". " + "Released in " + this.getYear + ". " + " Price:" + this.getDailyRent + " SEK. Status: " + this.getRentStatus;
 }

 public String getID( ){
        return songID;
 }

    public String getTitle( ){
        return title;
    }

    public String getArtist( ){
        return artist;
    }

    public int getYear( ){
        return year;
    }

    public double getDailyRent( ){
        return dailyRent;
    }

    public String getRentStatus( ){
        if(this.rentStatus){
            return "Not available";
        }else return "available";
    }
}
