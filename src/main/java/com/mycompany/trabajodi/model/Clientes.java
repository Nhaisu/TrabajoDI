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
public class Clientes {
    
    int id;
    int idUsuario;
    Date fechaModifica;
    String nombre;
    String apellido;
    String DNI;
    String Localidad;
    
    public Clientes(){
        
    }

    public Clientes(int id, int idUsuario, Date fechaModifica, String nombre, String apellido, String DNI, String Localidad) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fechaModifica = fechaModifica;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.Localidad = Localidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }
    
    
}
