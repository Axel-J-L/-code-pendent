package DartSystem.Music;

public class Album {
    private String songID;
    private String title;
    private String artist;
    private boolean rentStatus;
    private int rating;

    public Album(){

    };

    public Album(String songId, String title, String artist){
        this.songID = songId;
        this.title = title;
        this.artist = artist;
        this.rentStatus = false;
    }
 public String toString() {
        return this.getID + " : " + this.getTitle + " - by " + this.getArtist + ". " + "Released in " + this.getYear + ". " + " Price:" + this.getDailyRent + " SEK. Status: " + this.getRentStatus;
 }

 public String getID(){
 }

    public String getTitle(){
    }

    public String getArtist(){
    }

    public String getYear(){
    }

    public String getDailyRent(){
    }

    public String getRentStatus(){
    }
}
