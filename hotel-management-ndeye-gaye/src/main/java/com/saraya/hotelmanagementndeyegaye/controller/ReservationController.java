package com.saraya.hotelmanagementndeyegaye.controller;

import com.saraya.hotelmanagementndeyegaye.dto.ReservationDTO;
import com.saraya.hotelmanagementndeyegaye.model.Reservation;
import com.saraya.hotelmanagementndeyegaye.model.Room;
import com.saraya.hotelmanagementndeyegaye.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
@RequestMapping("/api/test/reservation")
//@CrossOrigin(origins = "*", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
@CrossOrigin(origins = "*")
public class ReservationController {

    private final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reservation> getAll(){
        LOGGER.info("The list of the reservation");
        return service.getAll();
    }


    @GetMapping("/{reservationId}")
    public Reservation getById(@PathVariable int reservationId){
        LOGGER.info("Get the Reservation by the id");
        return service.getById(reservationId).get();
    }


    @GetMapping("date/{dateInn}")
    public Reservation getByDateInn(@PathVariable String dateInn){
        LOGGER.info("Get the reservation by the DateIn");
        return service.getByDateInn(dateInn);
    }

    @PostMapping
    public ReservationDTO create(@RequestBody ReservationDTO reservationDTO){
        LOGGER.info("CREATING NEW RESERVATION...");
        return service.create(reservationDTO);
    }

    @PutMapping
    public Reservation update(@RequestBody ReservationDTO reservationDTO){
        LOGGER.info("Update reservation...");
        return service.update(reservationDTO);
    }

    @DeleteMapping("delete/{dateInn}")
    public void deleteByDateInn(@PathVariable String dateInn){
        LOGGER.info("Delete reservation by the DateIn....");
        service.deleteByDateInn(dateInn);
    }

    @DeleteMapping("/{reservationId}")
    public void deleteById(@PathVariable int reservationId){
        LOGGER.info("Delete reservation by the ID.....");
        service.deleteById(reservationId);
    }
}
