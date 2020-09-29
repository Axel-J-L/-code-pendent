package DartSystem.Music;

import DartSystem.Helper;

import java.util.ArrayList;

public class Album {
    private String songID;
    private String title;
    private String artist;
    private int year;
    private double dailyRent;
    private boolean rentStatus;
    private int rating;
    private ArrayList<Songs> trackList = new ArrayList<>();
    private ArrayList<Album> albums;

    Helper helper = new Helper();

    public Album(){
    };

    public Album(String songId, String title, String artist, int year, double dailyRent){
        this.songID = songId;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.dailyRent = dailyRent;
        this.rentStatus = false;
    }

    public Album(String songId, String title, String artist, int year, ArrayList<Songs> trackList){
        this.songID = songId;
        this.title = title;
        this.artist = artist;
        this.year = year;
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

    public void addAlbum(){
        String addId = helper.getInput("ID: ");
        String addTitle = helper.getInput("Title: ");
        String addArtist = helper.getInput("Artist: ");
        int addYear = helper.getInt("Year: ");
        double addDailyRent = helper.getDouble("Daily Rent amount: ");
       albums.add(addId, addTitle, addArtist, addYear, addDailyRent);
    }

    public removeAlbum(){

    }
    public rentAlbum(){

    }
    public returnAlbum(){

    }
}
