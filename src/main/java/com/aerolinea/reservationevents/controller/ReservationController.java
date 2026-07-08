package com.aerolinea.reservationevents.controller;

import com.aerolinea.reservationevents.model.ReservationEvent;
import com.aerolinea.reservationevents.util.ReservationFilters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class ReservationController {

    @GetMapping("/api/reservations/stream")
    public Flux<ReservationEvent> streamReservations() {

        ReservationEvent r1 = new ReservationEvent("R1", "Ana Torres", 250.0, List.of("ana@mail.com"));
        ReservationEvent r2 = new ReservationEvent("R2", "Luis Pérez", 0.0, List.of("luis@mail.com"));
        ReservationEvent r3 = new ReservationEvent("R3", "Carla Ruiz", 180.0, List.of("carla@mail.com", "carla2@mail.com"));
        ReservationEvent r4 = new ReservationEvent("R4", "Jorge Díaz", 300.0, List.of());
        ReservationEvent r5 = new ReservationEvent("R5", "Marta Gómez", 420.0, List.of("marta@mail.com"));

        ReservationEvent defaultEvent = new ReservationEvent("DEFAULT", "Sin reservas", 0.0, List.of());

        return Flux.just(r1, r2, r3, r4, r5)
                .filter(ReservationFilters.isValid)
                .doOnNext(ReservationFilters.printReservation)
                .defaultIfEmpty(defaultEvent);
    }
}