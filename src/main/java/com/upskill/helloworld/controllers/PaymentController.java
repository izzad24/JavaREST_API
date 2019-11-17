package com.upskill.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.upskill.helloworld.models.Payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaymentController
 */
@RestController
public class PaymentController {

    @GetMapping(value = "/payment")
    public List<Payment> payment(@RequestParam(name = "status", required = false) Boolean status){
        ArrayList<Payment> payments = seedDatas();
        ArrayList<Payment> result = new ArrayList<>();
        for (Payment payment : result) {
            if(payment.getIsPaid() == status){
                result.add(payment);
            }
        }
        if(!result.isEmpty()){
            return result;
        }else{
            return payments;
        }
    }

    @GetMapping(value = "/payment/{id}")
    public Payment showPayment(@PathVariable("id") int id){
        Payment payment = new Payment();
        payment.setId(id);
        payment.setIsPaid(false);
        payment.setAmount(100);

        return payment;
    }

    @PostMapping(value = "/createPayment")
    public Payment createPayment(@RequestBody Payment pay){
        Payment payment = new Payment();
        payment.setId(pay.getId());
        payment.setIsPaid(pay.getIsPaid());
        payment.setAmount(pay.getAmount());

        return payment;
    }

    ArrayList<Payment> seedDatas(){
        Random rand = new Random();
        ArrayList<Payment> payments = new ArrayList<>();
        Boolean status = true;
        for(int i = 1; i<11; i++){
            Payment payment = new Payment();
            payment.setId(i);
            payment.setIsPaid(status);
            payment.setAmount(rand.ints(88, 299).findFirst().getAsInt());
            status = !status;
            payments.add(payment);
        }

        return payments;
    }
}