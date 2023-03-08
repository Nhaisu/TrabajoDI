/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajodi.dao;

import com.mycompany.trabajodi.model.Clases;
import com.mycompany.trabajodi.model.Clientes;
import com.mycompany.trabajodi.util.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rootcristian
 */
public class ClasesDAO {
    
    Clases clases = new Clases();
    
    Conexion miconexion;
    
    ResultSet resul;
    
    private int idClase;
    
    public Conexion conexion() {
        miconexion = new Conexion();
        Connection conexion = miconexion.getConexion();
        return miconexion;
    }
    
    public void muestraTablaClases(DefaultTableModel modeloTabla) {

        try {
            //booleano para saber si los datos introducidos son correctos
            Connection prueba = conexion().getConexion();

            Statement sentencia = prueba.createStatement();
            String sql = "SELECT IDClase,IDUsuario,Nombre,Fecha_Creacion,Fecha,Max_Asistentes FROM cjcl_Clases";

            //Ejecutamos la sentencia
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("IDClase");
                int idUsuario = rs.getInt("IDUsuario");
                String nombre = rs.getString("Nombre");
                Date fechaCreacion = rs.getDate("Fecha_Creacion");
                Date fecha = rs.getDate("Fecha");
                int maxAsist = rs.getInt("Max_Asistentes");

                modeloTabla.addRow(new Object[]{id, idUsuario, nombre, fechaCreacion, fecha, maxAsist});

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public boolean insertarClase (Clases clase){
        
        try {
            //Obtenemos la conexión
            Connection conexion = conexion().getConexion();

            String sql = "INSERT INTO cjcl_Clases "
                    + "(IDClase,IDUsuario,Nombre,Fecha_Creacion,Fecha,Max_Asistentes)  VALUES "
                    + "(?,?,?,?,?,?)";

            //Sentencia preparada 
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, clase.getId());
            sentencia.setInt(2, clase.getIdusuario());
            sentencia.setString(3, clase.getNombreClase());
            sentencia.setDate(4, clase.getFechaCreacion());
            sentencia.setString(5, clase.getFecha());
            sentencia.setInt(6, clase.getMaxAsist());

            sentencia.execute();

            sentencia.close();
            //se desconecta de la base de datos
            miconexion.desconectar();
            //Se ha insertado un cliente
            System.out.println("Insertado con exito la clase");
            return true;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            //No se ha podido añadir usuario
            return false;
        }
    }
    
    public int ultimoId() {

        int numUlt = 0;

        try {
            //Obtenemos la conexión
            Connection conexion = conexion().getConexion();

            Statement sentencia = conexion.createStatement();
            //Consulta solo para los is de los usuarios
            String sql = "SELECT IDClase FROM cjcl_Clases";

            resul = sentencia.executeQuery(sql);

            while (resul.next()) {

                if (resul.getInt("id") > numUlt) {

                    numUlt = resul.getInt("id");

                }
            }

            return numUlt;
        } catch (SQLException ex) {
            System.out.println("Error a obtener el último usuario");
            return -1;
        }

    }
    public boolean eliminarClase(int id) {

        try {
            //Obtenemos la conexión
            Connection conexion = conexion().getConexion();

            String sql = "DELETE FROM cjcl_Clases WHERE IDClase = ? ";

            //Sentencia preparada
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, id);
            sentencia.execute();

            //se desconecta de la base de datos
            miconexion.desconectar();

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
    public int getIdClase() {
        return idClase;
    }
    
}
