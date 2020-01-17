package sample;

public class Memes {

    private String meme;
    private int date;
    private double rating;
    private String about;

    public Memes() {

        this.meme = "";
        this.date = 0;
        this.rating = 0.0;
        this.about = "";

    }
    public Memes(String meme, int date, double rating, String about) {

        this.meme = meme;
        this.date = date;
        this.rating = rating;
        this.about = about;

    }

    public String getMeme(){
        return meme;
    }
    public void setMeme(String meme){
       this.meme = meme;
    }

    public int getDate(){
        return date;
    }

    public void setDate(int date){
        this.date = date;
    }

    public double getRating(){
        return rating;
    }

    public void setRating(double rating){
        this.rating = rating;
    }

    public String getAbout(){
        return about;
    }

    public void setAbout(String about){
        this.about = about;
    }
}
