package com.saraya.hotelmanagementndeyegaye.controller;

import com.saraya.hotelmanagementndeyegaye.dto.PaymentDTO;
import com.saraya.hotelmanagementndeyegaye.model.Payment;
import com.saraya.hotelmanagementndeyegaye.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/auth/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Payment> getAll(){
        LOGGER.info("All of the Payment");
        return service.getAll();
    }


    @GetMapping("/{name}")
    public Payment getByName(@PathVariable String name){
        LOGGER.info("Get the Payment by the name");
        return service.getByName(name);
    }

    @GetMapping("/{paymentId}")
    public Optional<Payment> getById(@PathVariable int paymentId){
        LOGGER.info("Get the Payment by the id");
        return service.getById(paymentId);
    }

    @PostMapping
    public Payment create(@RequestBody Payment payment){
        LOGGER.info("CREATING NEW PAYMENT...");
        return service.create(payment);
    }

    @PutMapping
    public Payment update(@RequestBody Payment payment){
        LOGGER.info("Update a payment...");
        return service.update(payment);
    }

    @DeleteMapping("delete/{name}")
    public void deleteByName(@PathVariable String name){
        LOGGER.info("Delete Payment by tne name....");
        service.deleteByName(name);
    }

    @DeleteMapping("/{paymentId}")
    public void deleteById(@PathVariable int paymentId){
        LOGGER.info("Delete a payment by ID.....");
        service.deleteById(paymentId);
    }

}
