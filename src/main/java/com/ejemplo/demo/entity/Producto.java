package com.ejemplo.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(name = "fase", length = 50)
    private String fase;

    public Producto() {

    }

    public Producto(Integer codigo, String fase) {
        this.fase = fase;
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {this.fase = fase;
    }

}
