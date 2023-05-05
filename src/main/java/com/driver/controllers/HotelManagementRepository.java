package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;

import java.util.HashMap;

import java.util.Optional;
import java.util.List;

public class HotelManagementRepository {


    private HashMap<String, Hotel> hotelMap= new HashMap<>();

    private HashMap<Integer, User> userMap= new HashMap<>();

    private HashMap<String, Booking> bookingMap= new HashMap<>();



    //You need to add a hotel to the database
    public  Boolean addHotel(Hotel hotel) {
        hotelMap.put(hotel.getHotelName(),hotel);
        return true;
    }
    //getByHotelName
    public Optional<Hotel> getByHotelName(String hotelName){
        if(hotelMap.containsKey(hotelName)){
            return Optional.of(hotelMap.get(hotelName));
        }
        return Optional.empty();
    }

    //You need to add a User Object to the database
    public Integer addUser(User user) {
        userMap.put(user.getaadharCardNo(), user);
        return user.getaadharCardNo();
    }


    //Out of all the hotels we have added so far, we need to find the hotelName with most no of facilities
    //Incase there is a tie return the lexicographically smaller hotelName
    //Incase there is not even a single hotel with atleast 1 facility return "" (empty string)
    public Boolean getHotelWithMostFacilities(Hotel hotelName) {
        return true;

    }


    public void addBooking(Booking booking) {

        bookingMap.put(booking.getBookingId(), booking);
    }

    public int findBookingsByPerson(Integer aadharCard) {
        int bookings=0;
        if(userMap.containsKey(aadharCard))
            bookings ++;
        return bookings;
    }
}
