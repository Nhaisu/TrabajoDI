/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajodi.model;

import java.sql.Date;

/**
 *
 * @author rootcristian
 */
public class Clases {
    
    int id;
    int idusuario;
    String nombreClase;
    Date fechaCreacion;
    String fecha;
    int maxAsist;

    public Clases() {
    }

    public Clases(int id, int idusuario, String nombreClase, Date fechaCreacion, String fecha, int maxAsist) {
        this.id = id;
        this.idusuario = idusuario;
        this.nombreClase = nombreClase;
        this.fechaCreacion = fechaCreacion;
        this.fecha = fecha;
        this.maxAsist = maxAsist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMaxAsist() {
        return maxAsist;
    }

    public void setMaxAsist(int maxAsist) {
        this.maxAsist = maxAsist;
    }
    
    
    
}
