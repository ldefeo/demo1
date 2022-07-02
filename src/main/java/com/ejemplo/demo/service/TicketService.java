package com.ejemplo.demo.service;


import com.ejemplo.demo.entity.Ticket;
import com.ejemplo.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService  implements TicketServiceInterface {

    @Autowired
    private TicketRepository ticketRepository;
    private List<Ticket> tickets = Arrays.asList(
            new Ticket(1,"abrir",1,"01-01-22","08-01-22","27-41800179-3"),
            new Ticket(2,"cerrar",3,"01-01-22","08-01-22","27-41800179-3"),
            new Ticket(3,"modificar",2,"01-01-22","08-01-22","27-41800179-3")
    );

    @Override
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
    }

    /*public Ticket getTicket(Integer id) {
        return tickets.stream().filter(t->t.getCodigo().equals(id)).findFirst().get();
    }*/

    /*public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }*/
}
