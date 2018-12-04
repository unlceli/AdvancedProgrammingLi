package com.example.li.lll.advancedprogrammingli.reconstitution;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {


    private String name;
    private Vector rentals = new Vector();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Enumeration rentalss = rentals.elements();

        String result = "Rental Record for" + getName() + "\n";

        while (rentalss.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentalss.nextElement();



            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getMovie().getPriceCode() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf( each.getCharge()) + "\n";
            totalAmount +=   each.getCharge();


        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";

        result += "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter ponits";


        return result;
    }


}
