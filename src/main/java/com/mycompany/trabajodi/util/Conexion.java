/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajodi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rootcristian
 */
public class Conexion {
    
    private static Connection conexion;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://188.164.193.188/appevent_grupo4";
    private static final String usuario = "grupo4";
    private static final String contrasena = "#Xkqy7387";

    public Conexion() {
        //conexion = null;

        try {

            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, contrasena);

            if (conexion != null) {

                System.out.println("Conexion establecida...");
            }

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("error al conectar" + e);

        }

    }

    //metodo que nos retorna la conexion
    public Connection getConexion() {

        return conexion;

    }

    //Metodo que desconecta de la base de datos
    public void desconectar() {

        conexion = null;
        if (conexion == null) {

            System.out.println("Conexion terminada");
        }

    }
    
}
