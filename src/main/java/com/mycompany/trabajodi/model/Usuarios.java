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
public class Usuarios {
    
    int id;
    String nombre;
    String contraseña;
    int esAdmin;
    Date fechaModifica;
    int idUsuarioModifica;
    
    public Usuarios() {

    }


    public Usuarios(int id, String nombre, String contraseña, int esAdmin, Date fechaModifica, int idUsuarioModifica) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.esAdmin = esAdmin;
        this.fechaModifica = fechaModifica;
        this.idUsuarioModifica = idUsuarioModifica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(int esAdmin) {
        this.esAdmin = esAdmin;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public int getIdUsuarioModifica() {
        return idUsuarioModifica;
    }

    public void setIdUsuarioModifica(int idUsuarioModifica) {
        this.idUsuarioModifica = idUsuarioModifica;
    }
    
    
}
