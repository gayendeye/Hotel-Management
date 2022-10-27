package com.saraya.hotelmanagementndeyegaye.service;

import com.saraya.hotelmanagementndeyegaye.model.Payment;
import com.saraya.hotelmanagementndeyegaye.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentService {


    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }


    public List<Payment> getAll(){
        return repo.findAll();
    }

    public Optional<Payment> getById(
            int paymentId){
        return repo.findById(paymentId);
    }
    public Payment getByName(
            String name){
        return repo.findByName(name);
    }

    public Payment create (Payment payment){
        return repo.save(payment);
    }


    public Payment update(Payment payment){
        return repo.save(payment);
    }

    public void deleteByName(
            String name){
        Payment payment = repo.findByName(name);
        repo.delete(payment);
    }

    public void deleteById(int paymentId){
        repo.deleteById(paymentId);
    }

    public Payment findByName(String name){
        return repo.findByName(name);
    }


}
