package com.aerolinea.reservationevents.util;

import com.aerolinea.reservationevents.model.ReservationEvent;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ReservationFilters {

    public static final Predicate<ReservationEvent> isValid = event ->
            event.getPrice() != null
                    && event.getPrice() > 0
                    && event.getEmails() != null
                    && !event.getEmails().isEmpty();

    public static final Consumer<ReservationEvent> printReservation = event ->
            System.out.println("Procesando reserva: " + event);
}