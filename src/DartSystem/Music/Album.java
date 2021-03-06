package src.DartSystem.Music;

import src.DartSystem.Helper;

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
    //private ArrayList<Album> albums = new ArrayList<Album>();

    // public Album testAlbum = new Album("something","something else ","something else else",45,45);


    private Helper helper = new Helper();

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
        return this.getID() + " : " + this.getTitle() + " - by " + this.getArtist() + ". " + "Released in " + this.getYear() + ". " + " Price:" + this.getDailyRent() + " SEK. Status: " + this.getRentStatus();
 }

 public String getID(){
        return songID;
 }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public int getYear(){
        return year;
    }

    public double getDailyRent(){
        return dailyRent;
    }

    public String getRentStatus(){
        if(this.rentStatus){
            return "Not available";
        }else return "available";
    }

    public Album addAlbum(){
        //viewAlbums();
        String addId = helper.getInput("ID: ");
        String addTitle = helper.getInput("Title: ");
        String addArtist = helper.getInput("Artist: ");
        int addYear = helper.getInt("Year: ");
        double addDailyRent = helper.getDouble("Daily Rent amount: ");
        Album album = new Album(addId, addTitle, addArtist, addYear, addDailyRent);
        return album;
    }

//    public void removeAlbum(){
//        viewAlbums();
//        String removeAlbum = helper.getInput("Enter id of album to remove: ");
//        for(int i = 0; i < dartController.getAlbums().size(); i++){
//            if(dartController.getAlbums().get(i).getID().equalsIgnoreCase(removeAlbum)){
//                dartController.getAlbums().remove(i);
//            }else{
//                System.out.println("This album doesn't exist. Please check the id again.");
//            }
//        }
//        viewAlbums();
//        EmployeeMenu.employeeMenu();
//    }

    public void rentAlbum(){

    }
    public void returnAlbum(){

    }
//    public void viewAlbums(){
////        for(int i = 0; i < dartController.getAlbums().size(); i++){
////            System.out.println(dartController.getAlbums().toString());
//        for (Album album : dartController.getAlbums()){
//            System.out.println(album.toString());
//        }
//    }
}
