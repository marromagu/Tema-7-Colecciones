/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E0_Garaje_E5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAM_T
 */

/*La clase Garaje está formada por un vector tipo Vehiculo llamado vehiculos,
un atributo entero numPlazas que marca el número de vehículos que se pueden guardar en el garaje y plazaLibre que señala a la primera posición del vector que está libre para añadir un vehículo.
El constructor con parámetro sólo tiene un parámetro que marca cuantos vehículos se pueden meter en el garaje. Tendrá un getter que devuelva el atributo plazaLibre.*/
public class Garaje {

    int numPlazas;
    private int plazasLibres;
    //private Vehiculo[] vehiculos;
    private ArrayList<Vehiculo> vehiculos;

    public Garaje(int numPlazas) {
        //this.vehiculos = new Vehiculo[numPlazas];
        this.vehiculos = new ArrayList();
        this.numPlazas = numPlazas;
        this.plazasLibres = 0;
    }

    public int getPlazasLibres() {
        return plazasLibres;
    }

    /*añadirVehiculo: que no recibe parámetros. Si puede guardar un nuevo vehículo en el garaje,
    pregunta al usuario por el tipo de vehículo que quiere guardar (coche o moto), crea el objeto correspondiente y lo guarda en la primera posición libre.
    Devuelve TRUE si puede guardar el vehículo y FALSE en caso contrario.*/
    protected boolean añadirVehiculo() {
        Scanner t = new Scanner(System.in);
        if (plazasLibres < numPlazas) {
            System.out.println("Que vehiculo deseas guardar.(coche o moto)");
            String respuesta = t.nextLine();

            String matricula;
            float potencia;
            int numPlazas;

            Vehiculo vehiculo = null;

            System.out.println("¿Cual es su matricula?");
            matricula = "A001";//t.nextLine();
            System.out.println("¿Que potencia tiene?");
            potencia = 50;//t.nextFloat();

            switch (respuesta) {
                case "coche":
                    System.out.println("¿Cuantas plazas tiene el coche?");
                    numPlazas = 4;//t.nextInt();
                    vehiculo = new Coche(numPlazas, potencia, matricula);
                    break;
                case "moto":
                    vehiculo = new Moto(potencia, matricula);
                    break;
                default:
            }
            //vehiculos[plazasLibres] = vehiculo;
            vehiculos.add(vehiculo);
            plazasLibres++;
            return true;
        }

        return false;
    }

    /*devuelveVehiculo: que recibe una posición y devuelve el vehículo que está en esa posición. Si la posición no es correcta devuelve null.*/
    protected Vehiculo devuelveVehiculo(int posicion) {
        if ((vehiculos.get(posicion) != null) && (posicion < numPlazas) && (posicion >= 0)) {
// if ((vehiculos[posicion] != null) && (posicion < numPlazas) && (posicion >= 0))
            return vehiculos.get(posicion);
        }

        return null;
    }

    /*cuotaMes: recibe como parámetro una posición del vector. 
    Devuelve la cuota mensual que tiene que pagar el vehículo que está en esa posición. Si hay una moto la cuota será la potencia multiplicada por 2. 
    Si hay un coche la cuota será la potencia por el número de plazas del coche. Si la posición no es correcta el método devuelve un 0.*/
    protected double cuotaMes(int posicion) {
        Vehiculo miVehiculo = this.devuelveVehiculo(posicion);
        if (miVehiculo != null) {
            if (miVehiculo instanceof Moto) {
                return miVehiculo.getPotencia() * 2;
            }
            if (miVehiculo instanceof Coche) {
                return miVehiculo.getPotencia() * ((Coche) miVehiculo).getNumPlazas();
            }
        }

        return 0;
    }

    /*hayPlazas: que no recibe parámetros. Devuelve TRUE o FALSE según haya plazas libres o no.*/
    protected boolean hayPlazas() {

        return plazasLibres < numPlazas;
    }
}
