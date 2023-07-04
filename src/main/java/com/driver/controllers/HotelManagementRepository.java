package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.Map;


public class HotelManagementRepository {

    HashMap<String, Hotel> hotelMap = new HashMap<>();

    HashMap<Integer, User> userMap = new HashMap<>();

    HashMap<String, List<Facility>> hotelFacilitiesMap = new HashMap<>();

    HashMap<String, Booking> bookingMap = new HashMap<>();
    int maxFacility = 0;
    String hotelNameWithMostFacilities = "";


    public void /*Boolean*/ addHotel(Hotel hotel) {
        hotelMap.put(hotel.getHotelName(), hotel);
        // return true;
    }


    public List<Hotel> getAllHotels() {

        return new ArrayList<>(hotelMap.values());
    }

    public Optional<Hotel> getByName(String hotelName) {
        //duplicate
        if (hotelMap.containsKey(hotelName)) {
            return Optional.of(hotelMap.get(hotelName));
        }
        //Not found
        return Optional.empty();
    }


    public Hotel getHotelName(String hotelName) {

        return hotelMap.get(hotelName);
    }

    public void addUser(User user) {
        userMap.put(user.getAadharCardNo(), user);
    }



    // WE CAN DO IT WITHOUT MAKING NEW MAP

    public String getHotelWithMostFacilities(){

        //Out of all the hotels we have added so far, we need to find the hotelName with most no of facilities
        //Incase there is a tie return the lexicographically smaller hotelName
        //Incase there is not even a single hotel with atleast 1 facility return "" (empty string)

        for(Map.Entry<String, Hotel> entry : hotelMap.entrySet()){
            String hotelName = entry.getKey();
            List<Facility> facilities = entry.getValue().getFacilities();
            int numFacilities = facilities.size();
            if (numFacilities > maxFacility) {
                maxFacility = numFacilities;
                hotelNameWithMostFacilities = hotelName;
            }

            //Incase there is a tie return the lexicographically smaller hotelName
            //Incase there is not even a single hotel with atleast 1 facility return "" (empty string)
            if(numFacilities>0 && numFacilities== maxFacility && hotelName.compareTo(hotelNameWithMostFacilities)<0){
                maxFacility=numFacilities;
                hotelNameWithMostFacilities=hotelName;
            }
        }
        return hotelNameWithMostFacilities;
        }





    public void saveBooking(Booking booking) {
        bookingMap.put(booking.getBookingId(), booking);
        //bookings.add(booking);
    }

    public List<Booking> getAllBookings() {

        return new ArrayList<>(bookingMap.values());
    }
}





//    public int getBookings(int aadharCard) {
//        int bookingCount=0;
//        for(Booking booking: bookings){
//            if(booking.getBookingAadharCard()== aadharCard){
//                bookingCount++;
//            }
//        }
//        return bookingCount;
//    }




//   List<Booking> bookings= new ArrayList<>();
//
//    public HotelManagementRepository() {
//        this.hotelMap = new HashMap<String, Hotel>();
//       this.userMap = new HashMap<Integer, User>();
//        this.hotelFacilitiesMap = new HashMap<String, List<Facility>>();
//        this.bookingMap= new HashMap<String,Booking>();
////        this.bookings= new ArrayList<>();
//
//



//    public void addHotelWithFacilities(Hotel hotel) {
//        if (hotelMap.containsKey(hotel)) {
//            hotelFacilitiesMap.put(hotel.getHotelName(), hotel.getFacilities());
//        }
//    }



//    public String getHotelWithMostFacilities() {
//
//        //Out of all the hotels we have added so far, we need to find the hotelName with most no of facilities
//
//        for (Map.Entry<String, List<Facility>> entry : hotelFacilitiesMap.entrySet()) {
//            String hotelName = entry.getKey();
//            List<Facility> facilities = entry.getValue();
//            int numFacilities = facilities.size();
//            if (numFacilities > maxFacility) {
//                maxFacility = numFacilities;
//                hotelNameWithMostFacilities = hotelName;
//            }
//
//
//            //Incase there is a tie return the lexicographically smaller hotelName
//            //Incase there is not even a single hotel with atleast 1 facility return "" (empty string)
//            if (numFacilities > 0 && numFacilities == maxFacility && hotelName.compareTo(hotelNameWithMostFacilities) < 0) {
//                maxFacility = numFacilities;
//                hotelNameWithMostFacilities = hotelName;
//            }
//        }
//        return hotelNameWithMostFacilities;
//    }