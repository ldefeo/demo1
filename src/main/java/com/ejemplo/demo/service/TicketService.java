package com.ejemplo.demo.service;


import com.ejemplo.demo.entity.Ticket;
import com.ejemplo.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TicketService  implements TicketServiceInterface {

    @Autowired
    private TicketRepository ticketRepository;
    private List<Ticket> tickets = new ArrayList<>(Arrays.asList(
            new Ticket(1,"abrir",1,"01-01-22","08-01-22","27-41800179-3"),
            new Ticket(2,"cerrar",3,"01-01-22","08-01-22","27-41800179-3"),
            new Ticket(3,"modificar",2,"01-01-22","08-01-22","27-41800179-3")
    ));

    /*@Override
    @Transactional(readOnly = true)
    public Iterable<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Ticket> findAll(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ticket> findById(Integer id) {
        return ticketRepository.findById(id);
    }

    @Override
    @Transactional
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        ticketRepository.deleteById(id);
    }*/

    /*public Ticket getTicket(Integer id) {
        return tickets.stream().filter(t->t.getCodigo().equals(id)).findFirst().get();
    }*/

    /*public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }*/
    @Override
    public List<Ticket> getAllTickets(){
        return tickets;
    }
    @Override
    public Ticket getTicket(Integer id) {
        return tickets.stream().filter(t->t.getCodigo().equals(id)).findFirst().get();
    }
    @Override
    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
    @Override
    public void updateTicket(Ticket ticket,Integer id){
        for(int i = 0; i<tickets.size();i++){
            Ticket t = tickets.get(i);
            if(t.getCodigo().equals(id)){
                tickets.set(i,ticket);
            }
        }
    }

    @Override
    public void delete(Integer id){
        tickets.removeIf(t->t.getCodigo().equals(id));
    }
}
