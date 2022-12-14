package com.usa.reto3.reto3.controller;

import com.usa.reto3.reto3.Personalizado.CountClient;
import com.usa.reto3.reto3.Personalizado.StatusAmount;
import com.usa.reto3.reto3.entities.Reservation;
import com.usa.reto3.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

@RestController
@RequestMapping("/api/Reservation")

public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return reservationService.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-clients")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<CountClient> getReservationReportClient(){ return reservationService.getTopClients();
    }

    @GetMapping("/report-status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public StatusAmount getReservationStatus(){ return reservationService.getReservationStatusReport(); }

    @GetMapping("/report-dates/{dataOne}/{datetwo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Reservation> getReservationReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo ){
        return reservationService.getReservationPeriod(dateOne,dateTwo);
    }
}