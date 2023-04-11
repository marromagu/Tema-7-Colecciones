/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package E0_Garaje_E5;

/**
 *
 * @author DAM_T
 */
public class GarajeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Garaje garaje = new Garaje(3);
        
        for (int i = 0; i < 3; i++) {
            garaje.añadirVehiculo();
        }
        
        //No creamos un objeto, creamos una referencia de este objeto.
        Vehiculo vehiculo;
        for (int i = 0; i < 3; i++) {
            vehiculo = garaje.devuelveVehiculo(i);
            if (vehiculo instanceof Coche) {
                System.out.println("Es un coche");
            }else{
                System.out.println("Es una moto");
            }
            System.out.println(vehiculo.getMatricula() + garaje.cuotaMes(i));
            
        }
        
    }
    
}
