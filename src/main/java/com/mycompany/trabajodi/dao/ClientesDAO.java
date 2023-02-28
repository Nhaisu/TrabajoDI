/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajodi.dao;

import com.mycompany.trabajodi.model.Clientes;
import com.mycompany.trabajodi.model.Usuarios;
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
public class ClientesDAO {
    
    Clientes clientes = new Clientes();
    
    Conexion miconexion;
    
    ResultSet resul;
    
    private int idCliente;
    
    public Conexion conexion() {
        miconexion = new Conexion();
        Connection conexion = miconexion.getConexion();
        return miconexion;
    }
    
    public void muestraTablaClientes(DefaultTableModel modeloTabla) {

        try {
            //booleano para saber si los datos introducidos son correctos
            Connection prueba = conexion().getConexion();

            Statement sentencia = prueba.createStatement();
            String sql = "SELECT ID_Cliente,IDUsuario,Fecha_Usuario,Nombre,Apellido,DNI,Localidad FROM cjcl_Clientes";

            //Ejecutamos la sentencia
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID_Cliente");
                int idUsuario = rs.getInt("IDUsuario");
                Date fechaModifica = rs.getDate("Fecha_Usuario");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String DNI = rs.getString("DNI");
                String Localidad = rs.getString("Localidad");

                modeloTabla.addRow(new Object[]{id, idUsuario, fechaModifica, nombre, apellido, DNI, Localidad});

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public boolean insertarCliente (Clientes cliente){
        
        try {
            //Obtenemos la conexión
            Connection conexion = conexion().getConexion();

            String sql = "INSERT INTO cjcl_Clientes "
                    + "(ID_cliente,IDUsuario,Fecha_Usuario,Nombre,Apellido,DNI,Localidad)  VALUES "
                    + "(?,?,?,?,?,?,?)";

            //Sentencia preparada 
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, cliente.getId());
            sentencia.setInt(2, cliente.getIdUsuario());
            sentencia.setDate(3, cliente.getFechaModifica());
            sentencia.setString(4, cliente.getNombre());
            sentencia.setString(5, cliente.getApellido());
            sentencia.setString(6, cliente.getDNI());
            sentencia.setString(7, cliente.getLocalidad());

            sentencia.execute();

            sentencia.close();
            //se desconecta de la base de datos
            miconexion.desconectar();
            //Se ha insertado un cliente
            System.out.println("Insertado con exito el usuario");
            return true;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            //No se ha podido añadir usuario
            return false;
        }
    }
    
    public boolean eliminarCliente(int id) {

        try {
            //Obtenemos la conexión
            Connection conexion = conexion().getConexion();

            String sql = "DELETE FROM cjcl_Clientes WHERE ID_cliente = ? ";

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
    public boolean editarCliente(Clientes cliente, int id) {

        try {
            //Obtenemos la conexión
            Connection conexion = conexion().getConexion();

            String sql = "UPDATE cjcl_Clientes SET Fecha_Usuario = ?,Nombre = ?,Apellido = ?,DNI = ?, Localidad = ? WHERE ID_cliente = ? ";
            //Sentencia preparada
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setDate(1, cliente.getFechaModifica());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getApellido());
            sentencia.setString(4, cliente.getDNI());
            sentencia.setString(5, cliente.getLocalidad());

            sentencia.setInt(6, id);

            sentencia.executeUpdate();

            sentencia.close();
            miconexion.desconectar();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
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
            String sql = "SELECT ID_cliente FROM cjcl_Clientes";

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
    public int getIdCliente() {
        return idCliente;
    }
    
}
