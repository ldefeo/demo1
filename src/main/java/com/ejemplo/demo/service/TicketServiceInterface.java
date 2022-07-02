package com.ejemplo.demo.service;

import com.ejemplo.demo.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TicketServiceInterface {

    Iterable<Ticket> findAll();
    Page<Ticket> findAll(Pageable pageable);
    Optional<Ticket> findById(Integer id);
    Ticket save(Ticket ticket);
    void deleteById(Integer id);

}
