package com.example.li.lll.advancedprogrammingli.reconstitution;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie,int daysRented){
        this.daysRented = daysRented;
        this.movie =movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }
}
