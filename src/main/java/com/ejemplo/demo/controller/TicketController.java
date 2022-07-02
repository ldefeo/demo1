package com.ejemplo.demo.controller;


import com.ejemplo.demo.entity.Ticket;
import com.ejemplo.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public void addTicket(@RequestBody Ticket ticket){
      ticketService.addTicket(ticket);
    }

    @GetMapping("/{id}") //get by id
    public Optional<Ticket> getTicket(@PathVariable Integer id){
        return ticketService.getTicket(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Ticket ticket,@PathVariable Integer id){
        ticketService.updateTicket(ticket,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        ticketService.delete(id);
    }

    @GetMapping //todos los tickets
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    /*@RequestMapping("/tickets")
    public List<Ticket> getAllTicket(){
        return ticketService.getAllTickets();
    }*/

    /*@RequestMapping(method= RequestMethod.GET,value = "/tickets/{id}")
    public Ticket getTicket(@PathVariable Integer id){
        return service.getTicket(id);
    }*/

    /*@RequestMapping(method= RequestMethod.POST,value = "/tickets")
    public void addTicket(@RequestBody Ticket ticket){
        service.addTicket(ticket);
    }*/
}
