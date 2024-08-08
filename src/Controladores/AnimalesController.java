/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Animales;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marlon Ramirez
 */
public class AnimalesController implements IGenericController {

    private ConnectionSQLController conectController;

    Connection conect = conectController.obtenerConexion();

    @Override
    public boolean crearRegistro(Object object) {
        //Ejemplo casting
        Animales animal = (Animales) object;

        // Ejemplo de conversión de List<String> a String
        List<String> habitats = animal.getHabitat_posible();
        String habitatsConcatenados = String.join(", ", habitats);

        try {
            String sql = "INSERT INTO animales (nombre, documento, familia, habitat_posible) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conect.prepareStatement(sql);
            ps.setString(1, animal.getNombre());
            ps.setString(2, animal.getDocumento());
            ps.setString(3, animal.getFamilia());
            ps.setString(4, habitatsConcatenados);
            ps.executeUpdate();
            System.out.println("Registro insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el registro: " + e);
        }
        return true;
    }

    @Override
    public List<Animales> obtenerRegistros() {
        List<Animales> animales = new ArrayList<>();
        try {
            String sql = "SELECT * FROM animales";
            PreparedStatement ps = conect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                String habitatString = rs.getString("habitat_posible");
                String[] habitats = habitatString.split(",");

                List<String> listaAnimales = new ArrayList<>();
                for(String habitat : habitats)
                {
                    listaAnimales.add(habitat.trim());
                }
                Animales animal = new Animales(
                        rs.getString("nombre"),
                        rs.getString("documento"),
                        rs.getString("familia"),
                        listaAnimales
                );
                animales.add(animal);
            }
            System.out.println("Consulta exitosa");
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return animales;
    }
}
