/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Animales;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author elpow
 */
public interface IGenericController {
    public boolean crearRegistro(Object object);
    public List<Animales> obtenerRegistros();
}
