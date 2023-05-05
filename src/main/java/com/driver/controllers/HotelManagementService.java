package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;

import java.util.List;

public class HotelManagementService {


    HotelManagementRepository hotelManagementRepository = new HotelManagementRepository();

    public void addHotel(Hotel hotel) {
        hotelManagementRepository.addHotel(hotel);
    }

    public Integer addUser(User user) {
       return  hotelManagementRepository.addUser(user);
    }

    public Hotel findHotel(String hotelName) {

        return hotelManagementRepository.findHotel(hotelName);
    }

    public int addBooking(Booking booking) {
        hotelManagementRepository.addBooking(booking);
        int totalAmountPaidByUser = + booking.getAmountToBePaid();
        if(booking.getNoOfRooms()==0){
            return -1;
        }
        return booking.getAmountToBePaid();
    }

    public int findBookingsByPerson(Integer aadharCard) {
       return hotelManagementRepository.findBookingsByPerson(aadharCard);

    }

    public void createNewFacilities(List<Facility> newFacilities, String hotelName) {

    }
}
