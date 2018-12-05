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


    double getCharge(){

        double result =0;


        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
            movie.getTitle();
                break;

            case Movie.CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;

                }
                break;
            case Movie.NEW_RELEASE:
                result += 2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;

                }
                break;


        }
        return  result;
    }
}
