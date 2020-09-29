package DartSystem.Music;

public class Songs {

    private String title;
    private String artist;
    private double length;
    private String genre;
    private Songs [ ] songs;
    //constructor
    public Songs(String title, String artist){
        this.title = title;
        this.artist = artist;

    }
    //getters
    public String getTitle(){ return title; }
    public String getArtist(){ return artist; }
    public Songs [] getSong() { return songs; }




}
