package com.ejemplo.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero_version;

    @Column(name = "codigo_producto",length = 50)
    private Integer codigo_producto;

    @Column(name = "caracteristicas",length = 50)
    private String caracteristicas;

    public Version(){

    }
    public Version(Integer numero_version,Integer codigo_producto,String caracteristicas){
        this.caracteristicas = caracteristicas;
        this.numero_version = numero_version;
        this.codigo_producto = codigo_producto;
    }

    public Integer getNumero_version() {
        return numero_version;
    }

    public void setNumero_version(Integer numero_version) {
        this.numero_version = numero_version;
    }

    public Integer getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(Integer codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
