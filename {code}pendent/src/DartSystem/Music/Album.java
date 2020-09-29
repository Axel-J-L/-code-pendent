package DartSystem.Music;

public class Album {
    private String songID;
    private String title;
    private String artist;
    private boolean rentStatus;
    private int rating;
    private Songs [ ] trackList;
    public Album( ){

    };

    public Album(String songId, String title, String artist, Songs getSong[ ]){
        this.songID = songId;
        this.title = title;
        this.artist = artist;
        this.rentStatus = false;
        this.trackList = getSong;

    }
 public String toString( ) {
        return this.getID + " : " + this.getTitle + " - by " + this.getArtist + ". " + "Released in " + this.getYear + ". " + " Price:" + this.getDailyRent + " SEK. Status: " + this.getRentStatus;
 }

 public String getID( )   {
        return songID;
 }

    public String getTitle( )      {
        return title;
    }

    public String getArtist( )           {
        return artist;
    }

    public String getYear( ){
    }

    public String getDailyRent( ){
    }

    public String getRentStatus( ){
    }
}
