package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;

import java.util.*;

public class HotelManagementRepository {
    private Map<String, Hotel> hotelDb= new HashMap<>();
    private Map<Integer, User> userDb= new HashMap<>();
    private Map<String, Booking> bookingDb= new HashMap<>();
    HashMap<Integer, List<Booking>> userBookingDb = new HashMap<>();
    private int maxFacility=0;
    private String hotelNameWithMostFacilities= "";


    public String addHotel(Hotel hotel){

        if(hotel == null || hotel.getHotelName() == null) {
            return "FAILURE";
        }else if(hotelDb.containsKey(hotel.getHotelName())) {
            return "FAILURE";
        }

        String name = hotel.getHotelName();

        hotelDb.put(name, hotel);

        return "SUCCESS";

    }
    //    public Optional<Hotel> getByName(String hotelname){
//        if(hotelDb.containsKey(hotelname)){
//            return Optional.of(hotelDb.get(hotelname));
//        }
//        return Optional.empty();
//    }
    public int addUser(User user){
        userDb.put(user.getAadharCardNo(),user);
        return user.getAadharCardNo();
    }
    public String getHotelWithMostFacilities(){
        String res = "";
        int cnt = 1;

        for(String hotels : hotelDb.keySet()) {
            Hotel hotel = hotelDb.get(hotels);
            char ch = hotels.charAt(0);
            List<Facility> facilities = hotel.getFacilities();
            int size = facilities.size();

            if(cnt <= size) {
                if(cnt == size) {
                    if(res.equals("")) {
                        res = hotels;
                    } else {
                        res = res.charAt(0) > ch ? hotels : res;
                    }
                } else {
                    res = hotels;
                    cnt = size;
                }
            }
        }
        return res;
    }
    public int bookARoom(Booking booking){
        UUID uuid = UUID.randomUUID();
        booking.setBookingId(String.valueOf(uuid));

        int pricePerRoom = hotelDb.get(booking.getHotelName()).getPricePerNight();
        int noOfRooms = booking.getNoOfRooms();

        if(noOfRooms > hotelDb.get(booking.getHotelName()).getAvailableRooms()) {
            return -1;
        }

        booking.setAmountToBePaid(pricePerRoom * noOfRooms);
        List<Booking> list = userBookingDb.getOrDefault(booking.getBookingAadharCard(), new ArrayList<>());
        list.add(booking);
        userBookingDb.put(booking.getBookingAadharCard(), list);
        bookingDb.put(String.valueOf(uuid), booking);

        return booking.getAmountToBePaid();
    }
    public int getBookings(Integer aadharCard) {
        List<Booking> bookings = userBookingDb.get(aadharCard);

        return bookings.size();
    }
    public Hotel update(List<Facility> newFacilities, String hotelName) {

        Hotel hotel = hotelDb.get(hotelName);

        List<Facility> facilityList = hotel.getFacilities();

        HashSet<Facility> facilities = new HashSet<>(facilityList);

        facilities.addAll(newFacilities);

        List<Facility> finalList = new ArrayList<>(facilities);

        hotel.setFacilities(finalList);

        hotelDb.put(hotelName, hotel);

        return hotel;

    }
}































//package com.driver.controllers;
//
//import com.driver.model.Booking;
//import com.driver.model.Facility;
//import com.driver.model.Hotel;
//import com.driver.model.User;
//import org.springframework.beans.factory.FactoryBeanNotInitializedException;
//
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Optional;
//import java.util.List;
//import java.util.Map;
//
//
//public class HotelManagementRepository {
//
//    HashMap<String, Hotel> hotelMap = new HashMap<>();
//
//    HashMap<Integer, User> userMap = new HashMap<>();
//
//    HashMap<String, List<Facility>> hotelFacilitiesMap = new HashMap<>();
//
//    HashMap<String, Booking> bookingMap = new HashMap<>();
//
//
//    public void addHotel(Hotel hotel) {
//        hotelMap.put(hotel.getHotelName(), hotel);
//        // return true;
//    }
//
//
//    public List<Hotel> getAllHotels() {
//        return new ArrayList<>(hotelMap.values());
//    }
//
//
//    public Optional<Hotel> getByName(String hotelName) {
//        //duplicate
//        if (hotelMap.containsKey(hotelName)) {
//            return Optional.of(hotelMap.get(hotelName));
//        }
//        //Not found
//        return Optional.empty();
//    }
//
//
//    public void addUser(User user) {
//        userMap.put(user.getAadharCardNo(), user);
//    }
//
//
//    public void addBooking(Booking booking) {
//        bookingMap.put(booking.getBookingId(), booking);
//        //bookings.add(booking);
//    }
//
//    public List<Booking> getAllBookings() {
//
//        return new ArrayList<>(bookingMap.values());
//    }
//
//    public void updateHotel(Hotel hotel) {
//        List<Facility> facilities = hotelFacilitiesMap.get(hotel.getFacilities());
//
//
//    }
//}
//
//
//
//
//
////    public int getBookings(int aadharCard) {
////        int bookingCount=0;
////        for(Booking booking: bookings){
////            if(booking.getBookingAadharCard()== aadharCard){
////                bookingCount++;
////            }
////        }
////        return bookingCount;
////    }
//
//
//
//
////   List<Booking> bookings= new ArrayList<>();
////
////    public HotelManagementRepository() {
////        this.hotelMap = new HashMap<String, Hotel>();
////       this.userMap = new HashMap<Integer, User>();
////        this.hotelFacilitiesMap = new HashMap<String, List<Facility>>();
////        this.bookingMap= new HashMap<String,Booking>();
//////        this.bookings= new ArrayList<>();
////
////
//
//
//
////    public void addHotelWithFacilities(Hotel hotel) {
////        if (hotelMap.containsKey(hotel)) {
////            hotelFacilitiesMap.put(hotel.getHotelName(), hotel.getFacilities());
////        }
////    }
//
//
//
////    public String getHotelWithMostFacilities() {
////
////        //Out of all the hotels we have added so far, we need to find the hotelName with most no of facilities
////
////        for (Map.Entry<String, List<Facility>> entry : hotelFacilitiesMap.entrySet()) {
////            String hotelName = entry.getKey();
////            List<Facility> facilities = entry.getValue();
////            int numFacilities = facilities.size();
////            if (numFacilities > maxFacility) {
////                maxFacility = numFacilities;
////                hotelNameWithMostFacilities = hotelName;
////            }
////
////
////            //Incase there is a tie return the lexicographically smaller hotelName
////            //Incase there is not even a single hotel with atleast 1 facility return "" (empty string)
////            if (numFacilities > 0 && numFacilities == maxFacility && hotelName.compareTo(hotelNameWithMostFacilities) < 0) {
////                maxFacility = numFacilities;
////                hotelNameWithMostFacilities = hotelName;
////            }
////        }
////        return hotelNameWithMostFacilities;
////    }
//
//
////     WE CAN DO IT WITHOUT MAKING NEW MAP
////
////    public String getHotelWithMostFacilities(){
////
////        //Out of all the hotels we have added so far, we need to find the hotelName with most no of facilities
////        //Incase there is a tie return the lexicographically smaller hotelName
////        //Incase there is not even a single hotel with atleast 1 facility return "" (empty string)
////
////        for(Map.Entry<String, Hotel> entry : hotelMap.entrySet()){
////            String hotelName = entry.getKey();
////            List<Facility> facilities = entry.getValue().getFacilities();
////            int numFacilities = facilities.size();
////            if (numFacilities > maxFacility) {
////                maxFacility = numFacilities;
////                hotelNameWithMostFacilities = hotelName;
////            }
////
////            //Incase there is a tie return the lexicographically smaller hotelName
////            //Incase there is not even a single hotel with atleast 1 facility return "" (empty string)
////            if(numFacilities>0 && numFacilities== maxFacility && hotelName.compareTo(hotelNameWithMostFacilities)<0){
////                maxFacility=numFacilities;
////                hotelNameWithMostFacilities=hotelName;
////            }
////        }
////        return hotelNameWithMostFacilities;
////        }
