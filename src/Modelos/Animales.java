package Modelos;

import java.util.List;

public class Animales extends Zoo {
    
    String nombre;
    String documento;
    String familia;
    List<String> habitat_posible;

    public Animales(
            String nombre, 
            String documento, 
            String familia, 
            List<String> habitat_posible
            ) 
    {
        this.nombre = nombre;
        this.documento = documento;
        this.familia = familia;
        this.habitat_posible = habitat_posible;
    }

    @Override
    public double cantar(double num) {
        double canto = Math.sqrt(num);
        System.out.println("Animales cantando..." + canto);
        return canto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public List<String> getHabitat_posible() {
        return habitat_posible;
    }

    public void setHabitat_posible(List<String> habitat_posible) {
        this.habitat_posible = habitat_posible;
    }
}