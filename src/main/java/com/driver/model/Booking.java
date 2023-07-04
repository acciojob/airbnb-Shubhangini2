package com.driver.model;

import java.util.UUID;
public class Booking {

    private String bookingId; //This will be a random UUID generated String

    private int bookingAadharCard;

    private int noOfRooms;

    private String bookingPersonName;

    private String hotelName;

    private int amountToBePaid;

    public Booking(int bookingAadharCard, int noOfRooms, String bookingPersonName, String hotelName) {

       // this.bookingId= UUID.randomUUID().toString();
        this.bookingAadharCard = bookingAadharCard;
        this.noOfRooms = noOfRooms;
        this.bookingPersonName = bookingPersonName;
        this.hotelName = hotelName;
    }

    public String getBookingId() {
        return bookingId;
    }

    public int getBookingAadharCard() {
        return bookingAadharCard;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public String getBookingPersonName() {
        return bookingPersonName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getAmountToBePaid() {
        return amountToBePaid;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setAmountToBePaid(int amountToBePaid) {

        this.amountToBePaid = amountToBePaid;
    }
}


