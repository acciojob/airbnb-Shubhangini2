package com.driver.controllers;
import java.util.Optional;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;
import org.springframework.http.server.DelegatingServerHttpResponse;

import java.util.List;
import java.util.Optional;

public class HotelManagementService {

    HotelManagementRepository hotelManagementRepository = new HotelManagementRepository();

    //You need to add an hotel to the database
    //incase the hotelName is null or the hotel Object is null return an empty a FAILURE
    //Incase somebody is trying to add the duplicate hotelName return FAILURE
    //in all other cases return SUCCESS after successfully adding the hotel to the hotelDb.
    public Boolean addHotel(Hotel hotel) {
        Optional<Hotel> hotelOpt= hotelManagementRepository.getByHotelName(hotel.getHotelName());//Check for duplicacy
        if(hotelOpt.isPresent()){
            return false;
        }
        return hotelManagementRepository.addHotel(hotel);
    }


    //You need to add a User Object to the database
    public Integer addUser(User user) {

        return  hotelManagementRepository.addUser(user);
    }


    //Out of all the hotels we have added so far, we need to find the hotelName with most no of facilities
    //Incase there is a tie return the lexicographically smaller hotelName
    //Incase there is not even a single hotel with atleast 1 facility return "" (empty string)
    public Boolean getHotelWithMostFacilities(Hotel hotelName) {

        if(hotelManagementRepository.getHotelWithMostFacilities(hotelName)){
            return true;
        }
        return false;
    }



    //The booking object coming from postman will have all the attributes except bookingId and amountToBePaid;
    //Have bookingId as a random UUID generated String
    //save the booking Entity and keep the bookingId as a primary key
    //Calculate the total amount paid by the person based on no. of rooms booked and price of the room per night.
    //If there arent enough rooms available in the hotel that we are trying to book return -1
    //in other case return total amount paid

    public void addBooking(Booking booking) {
        hotelManagementRepository.addBooking(booking);
    }



    public int findBookingsByPerson(Integer aadharCard) {
       return hotelManagementRepository.findBookingsByPerson(aadharCard);

    }



    public void createNewFacilities(List<Facility> newFacilities, String hotelName) {

    }
}
