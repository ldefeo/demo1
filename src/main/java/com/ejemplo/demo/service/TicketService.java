package com.ejemplo.demo.service;


import com.ejemplo.demo.entity.Ticket;
import com.ejemplo.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService  implements TicketServiceInterface {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets(){
        List<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAll().forEach(tickets::add);
        return tickets;
    }
    @Override
    public Optional<Ticket> getTicket(Integer id) {
        return ticketRepository.findById(id);
    }
    @Override
    public void addTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }
    @Override
    public void updateTicket(Ticket ticket,Integer id){
        ticketRepository.save(ticket);
    }

    @Override
    public void delete(Integer id){
        ticketRepository.deleteById(id);
    }


}
