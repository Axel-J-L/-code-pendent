package DartSystem.Music;

import java.util.ArrayList;

public class Songs {

    private String title;
    private String artist;
    private double length;
    private String genre;
    private ArrayList<Songs> songs;
    //constructor
    public Songs(String title, String artist){
        this.title = title;
        this.artist = artist;

    }
    //getters
    public String getTitle(){ return title;}
    public String getArtist(){ return artist;}
    public ArrayList<Songs> getSong() { return songs;}



}
