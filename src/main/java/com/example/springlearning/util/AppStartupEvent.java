package com.example.springlearning.util;

import com.example.springlearning.data.entity.Guest;
import com.example.springlearning.data.entity.Reservation;
import com.example.springlearning.data.entity.Room;
import com.example.springlearning.data.repo.GuestRepository;
import com.example.springlearning.data.repo.ReservationRepository;
import com.example.springlearning.data.repo.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach(System.out::println);
        Iterable<Guest> guests = guestRepository.findAll();
        guests.forEach(System.out::println);
        Iterable<Reservation> reservations = reservationRepository.findReservationByResDate(Date.valueOf("2022-01-01"));
        reservations.forEach(System.out::println);
    }
}
