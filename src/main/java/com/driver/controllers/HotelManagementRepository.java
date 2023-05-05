package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Hotel;
import com.driver.model.User;

import java.util.HashMap;

public class HotelManagementRepository {


    private HashMap<String, Hotel> hotelMap= new HashMap<>();

    private HashMap<Integer, User> userMap= new HashMap<>();

    private HashMap<String, Booking> bookingMap= new HashMap<>();

    public void addHotel(Hotel hotel) {
        hotelMap.put(hotel.getHotelName(), hotel);
    }

    public Integer addUser(User user) {
        userMap.put(user.getaadharCardNo(), user);
        return user.getaadharCardNo();
    }

    public Hotel findHotel(String hotelName) {
        return hotelMap.get(hotelName);
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
