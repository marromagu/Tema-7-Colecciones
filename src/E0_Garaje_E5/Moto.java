/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E0_Garaje_E5;

/**
 *
 * @author DAM_T
 */
public class Moto extends Vehiculo {

    public Moto(float potencia, String matricula) {
        super(potencia, matricula);
    }

    @Override
    public void trucarVehiculo() {
        this.setPotencia(this.getPotencia() * 4);
    }

}
