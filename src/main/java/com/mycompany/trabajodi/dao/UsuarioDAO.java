/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajodi.dao;

import com.mycompany.trabajodi.model.Usuarios;
import com.mycompany.trabajodi.util.Conexion;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
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
public class UsuarioDAO {
    
    Usuarios usuario = new Usuarios();

    ResultSet resul;

    Conexion miconexion;

    private int resultado;

    private int idUsuario;

    public UsuarioDAO() {

    }

    public Conexion conexion() {
        miconexion = new Conexion();
        Connection conexion = miconexion.getConexion();
        return miconexion;
    }
    
    //Metodo que logea al usuario
    public ResultSet loginUsuario(String usuario, String contrasena) throws NoSuchAlgorithmException {

        try {

            //booleano para saber si los datos introducidos son correctos
            Connection prueba = conexion().getConexion();

            Statement sentencia = prueba.createStatement();
            String sql = "SELECT Contraseña,esAdmin,Nombre_Usuario,ID FROM cjcl_Usuarios;";

            //Ejecutamos la sentencia
            resul = sentencia.executeQuery(sql);

            while (resul.next()) {

                String usuariobbd = resul.getString("Usuario");
                String contrasenabbd = resul.getString("Contraseña");

                boolean EsAdminbbd = resul.getBoolean("esAdmin");

                if (usuariobbd.equals(usuario) && contrasenabbd.equals(contrasena)) {

                    System.out.println("Login hecho");

                    if (EsAdminbbd == true) {

                        System.out.println("Es admin");
                        System.out.println("Entrando al JFrame de administradores..");

                        this.resultado = 1;
                        this.idUsuario = resul.getInt("ID");

                    } else {
                        //Entar al Jframe de Cliente
                        System.out.println("Es usuario");
                        System.out.println("Entrando al JFrame de usuario..");

                        this.resultado = 2;

                        this.idUsuario = resul.getInt("ID");

                    }

                }

            }

        } catch (SQLException e) {

            System.out.println("Error a hacer la sentencia" + e);

        }

        return resul;

    }
    
    public void muestraTablaUsuarios(DefaultTableModel modeloTabla) {

        try {
            
            Connection prueba = conexion().getConexion();

            Statement sentencia = prueba.createStatement();
            String sql = "SELECT ID,Contraseña,esAdmin,Id_Usuario_Modifica,FechaModifica,Nombre_Usuario FROM cjcl_Usuarios";

            
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID");
                String contraseña = rs.getString("Contraseña");
                int esAdmin = rs.getInt("esAdmin");
                int idModifica = rs.getInt("Id_Usuario_Modifica");
                Date fechaModifica = rs.getDate("FechaModifica");
                String nomUsuario = rs.getString("Nombre_Usuario");

                
                modeloTabla.addRow(new Object[]{id, contraseña, esAdmin, idModifica, fechaModifica, nomUsuario});

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
