package com.ejemplo.demo.entity;


import com.ejemplo.demo.estado.Estado;
import com.ejemplo.demo.estado.EstadoAbierto;
import com.ejemplo.demo.estado.EstadoCerrado;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "CUIT_cliente",length = 50)
    private String CUIT;

    @Column(name = "fecha_creacion",length = 50)
    private String fechaDeCreacion;

    @Column(name = "fecha_finalizacion",length = 50)
    private String fechaDeFinalizacion;

    /*@Column(name = "estado",length = 50)
    private Estado estado;*/
    @Column(name = "descripcion",length = 50)
    private String descripcion;
    @Column(name = "severidad",length = 50)
    private Integer severidad;

    public Ticket() {
    }

    public Ticket(Integer id, String descripcion, Integer severidad,String fechaDeCreacion,String fechaDeFinalizacion,String CUIT){
        super();
        this.codigo = id;
        this.descripcion = descripcion;
        this.severidad = severidad;
        //this.estado = new EstadoAbierto();
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeFinalizacion = fechaDeFinalizacion;
        this.CUIT = CUIT;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getSeveridad() {
        return severidad;
    }

    public void setSeveridad(Integer severidad) {
        this.severidad = severidad;
    }

    public String getFechaDeFinalizacion() {
        return fechaDeFinalizacion;
    }

    public void setFechaDeFinalizacion(String fechaDeFinalizacion) {
        this.fechaDeFinalizacion = fechaDeFinalizacion;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    /*public void cambiarEstado(){
        this.estado = new EstadoCerrado();
    }*/
}
