/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E0_Garaje_E5;

/**
 *
 * @author DAM_T
 */
/*Clase Coche: tiene como atributo propio numPlazas. Tiene el constructor con parámetros y el getter para su atributo.
El método trucarVehiculo se implementa multiplicando por 2 la potencia del coche.*/
public class Coche extends Vehiculo{
    private int numPlazas;

    public Coche(int numPlazas, float potencia, String matricula) {
        super(potencia,matricula);
        this.numPlazas = numPlazas;
        
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    @Override
    public void trucarVehiculo() {
          this.setPotencia(this.getPotencia()*2);
    }
}