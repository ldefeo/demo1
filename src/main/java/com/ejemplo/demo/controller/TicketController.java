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
    public ResponseEntity<?> create(@RequestBody Ticket ticket){
      return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.save(ticket));
    }

    @GetMapping("/{id}") //get by id
    public ResponseEntity<?> read(@PathVariable Integer id){
        Optional<Ticket> oTicket = ticketService.findById(id);
        if(!oTicket.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Ticket ticketDetails,@PathVariable Integer id){
        Optional<Ticket> ticket = ticketService.findById(id);
        if(!ticket.isPresent()){
            return ResponseEntity.notFound().build();
        }
        ticket.get().setDescripcion(ticketDetails.getDescripcion());
        ticket.get().setSeveridad((ticketDetails.getSeveridad()));
        ticket.get().setCUIT(ticketDetails.getCUIT());
        ticket.get().setFechaDeCreacion(ticketDetails.getFechaDeCreacion());
        ticket.get().setFechaDeFinalizacion(ticketDetails.getFechaDeFinalizacion());
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.save(ticket.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(!ticketService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        ticketService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping //todos los tickets
    public List<Ticket> readAllTickets(){
        List<Ticket> tickets = StreamSupport.stream(ticketService.findAll().spliterator(),false).collect(Collectors.toList());
        return tickets;
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
