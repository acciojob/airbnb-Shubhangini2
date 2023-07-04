

package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class HotelManagementService {
    HotelManagementRepository repo= new HotelManagementRepository();
    public String addHotel(Hotel hotel){
        return repo.addHotel(hotel);
    }
    public int addUser(User user){
        return repo.addUser(user);
    }
    public String getHotelWithMostFacilities(){
        return repo.getHotelWithMostFacilities();
    }
    public int bookARoom(Booking booking){
        return repo.bookARoom(booking);
    }
    public int getBookings(Integer aadharCard) {
        return repo.getBookings(aadharCard);
    }

    public Hotel update(List<Facility> newFacilities, String hotelName) {
        return repo.update(newFacilities, hotelName);
    }
}




























//package com.driver.controllers;
//import java.awt.print.Book;
//import java.util.Optional;
//
//import com.driver.model.Booking;
//import com.driver.model.Facility;
//import com.driver.model.Hotel;
//import com.driver.model.User;
//import org.springframework.http.server.DelegatingServerHttpResponse;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.Set;
//import java.util.HashSet;
//import java.util.ArrayList;
//public class HotelManagementService {
//
//    HotelManagementRepository hotelManagementRepository = new HotelManagementRepository();
//
//    public String addHotel(Hotel hotel) {
//        //You need to add a hotel to the database
//        //Incase the hotelName is null or the hotel Object is null return an empty a FAILURE
//        Optional<Hotel> hotelOpt = hotelManagementRepository.getByName(hotel.getHotelName());
//        //Incase somebody is trying to add the duplicate hotelName return FAILURE
//        if (hotelOpt.isPresent()) {
//            return "FAILURE";
//        }
//        if (hotel.getHotelName().isEmpty()) {
//            return "FAILURE";
//        }
//        //in all other cases return SUCCESS after successfully adding the hotel to the hotelDb.
//        hotelManagementRepository.addHotel(hotel);
//        return "SUCCESS";
//    }
//
//
//    public Integer addUser(User user) {
//        hotelManagementRepository.addUser(user);
//        return user.getAadharCardNo();
//    }
//
//
//    public String getHotelWithMostFacilities() {
//        //Out of all the hotels we have added so far, we need to find the hotelName with most no of facilities
//        //Incase there is a tie return the lexicographically smaller hotelName
//        //Incase there is not even a single hotel with atleast 1 facility return "" (empty string)
//
//
//        String hotelWithMostFacilities = "";
//        int maxFacilities = 0;
//
//        List<Hotel> hotels = hotelManagementRepository.getAllHotels();
//
//        for (Hotel hotel : hotels) {
//            int currFacilities = hotel.getFacilities().size();
//            if (currFacilities > maxFacilities) {
//                hotelWithMostFacilities = hotel.getHotelName();
//                maxFacilities = currFacilities;
//            }
//            if (currFacilities > 0 && currFacilities == maxFacilities) {
//                if (hotel.getHotelName().compareTo(hotelWithMostFacilities) < 0) {
//                    hotelWithMostFacilities = hotel.getHotelName();
//                }
//            }
//        }
//        return hotelWithMostFacilities;
//
//    }
//
//
//    public int bookARoom(Booking booking) {
//
//        int totalAmountToBePaid = 0;
//
//
//        List<Hotel> hotels = hotelManagementRepository.getAllHotels();
//
//
//        //Have bookingId as a random UUID generated String
//        String bookingId = UUID.randomUUID().toString();
//        booking.setBookingId(bookingId);
//        //save the booking Entity and keep the bookingId as a primary key
//        hotelManagementRepository.addBooking(booking);
//        //Calculate the total amount paid by the person based on no. of rooms booked and price of the room per night.
//        for (Hotel hotel : hotels) {
//            if (booking.getHotelName().equals(hotel.getHotelName())) {
//                totalAmountToBePaid += booking.getNoOfRooms() * hotel.getPricePerNight();
//                //If there arent enough rooms available in the hotel that we are trying to book return -1
//                if (booking.getNoOfRooms() > hotel.getAvailableRooms()) {
////                    totalAmountToBePaid = -1;
//                    return totalAmountToBePaid;
//                }
//                //Set total amount to be paid
//                booking.setAmountToBePaid(totalAmountToBePaid);
//                //in other case return total amount paid
//            }
//
//        }
//        return totalAmountToBePaid;
//    }
//
//
//    public int getBookings(Integer aadharCard) {
//
//        int totalBookings = 0;
//        List<Booking> bookings = hotelManagementRepository.getAllBookings();
//
//        for (Booking booking : bookings) {
//            if (booking.getBookingAadharCard() == aadharCard) {
//                totalBookings = booking.getNoOfRooms();
//            }
//        }
//        return totalBookings;
//    }
//}
//
//    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {
//
//        //We are having a new facilites that a hotel is planning to bring.
//        //If the hotel is already having that facility ignore that facility otherwise add that facility in the hotelDb
//        //return the final updated List of facilities and also update that in your hotelDb
//        //Note that newFacilities can also have duplicate facilities possible
//
//        List<Hotel> hotels = hotelManagementRepository.getAllHotels();
//
//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ;
//        for (Hotel hotel : hotels) {
//            if (hotel.getHotelName().equals(hotelName)){
//
//                List<Facility> existingFacilities = hotel.getFacilities();
//                if (!hotel.getFacilities().equals(newFacilities)) {
//                    existingFacilities.add();
//                    hotelManagementRepository.updateHotel(hotel);
//                }
//
//                for (Facility facility : hotel.getFacilities()) {
//                    existingFacilities.add(facility);
//                }
//            }
//        }
//        return hotel;
//    }
//}
//
//
////    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {
////        //We are having a new facilites that a hotel is planning to bring.
////        //If the hotel is already having that facility ignore that facility otherwise add that facility in the hotelDb
////        //return the final updated List of facilities and also update that in your hotelDb
////        //Note that newFacilities can also have duplicate facilities possible
////        Hotel hotel = hotelManagementRepository.getHotelName(hotelName);
////        Set<Facility> existingFacilities = new HashSet<>();
////
////        for (Facility facility : hotel.getFacilities()) {
////            existingFacilities.add(facility.getName());
////        }
////        hotelManagementRepository.addHotel(hotel);
////    }
////}
//
//
////    public int bookARoom(Booking booking, int roomPricePerNight, int availableRooms) {
////
////        //The booking object coming from postman will have all the attributes except bookingId and amountToBePaid;
////        //Have bookingId as a random UUID generated String
////        String bookingId = UUID.randomUUID().toString();
////        booking.setBookingId(bookingId);
////        //save the booking Entity and keep the bookingId as a primary key
////        hotelManagementRepository.saveBooking(booking);
////        //Calculate the total amount paid by the person based on no. of rooms booked and price of the room per night.
////        int totalAmountPaid = booking.getNoOfRooms() * roomPricePerNight;
////        //If there arent enough rooms available in the hotel that we are trying to book return -1
////        if (booking.getNoOfRooms() > availableRooms) {
////            return -1;
////        }
////        //Set total amount to be paid
////        booking.setAmountToBePaid(totalAmountPaid);
////        //in other case return total amount paid
////
////        return totalAmountPaid;
////    }
//
//
////    public int getBookings(int aadharCard) {
////
////        return hotelManagementRepository.getBookings(aadharCard);
////    }
