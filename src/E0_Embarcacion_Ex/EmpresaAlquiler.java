/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E0_Embarcacion_Ex;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAM_T
 */
public class EmpresaAlquiler {

    //Atributos
    private String nombre;
    private String propietario;
    private String cif;
    //private Barco[] embarcaciones;
    private ArrayList<Barco> embarcaciones;
    private Cuenta cuenta;
    private int numeroEmbarcaciones;

    public EmpresaAlquiler(String nombre, String propietario, String cif, double saldo) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.cif = cif;
       // embarcaciones = new Barco[20];
       embarcaciones = new ArrayList();
        numeroEmbarcaciones = 0;
        cuenta = new Cuenta(propietario, cif, saldo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getPropietario() {
        return propietario;
    }
// con isEmpty devuelve verdadero o falso si esta vacio o no el string 
    public void setPropietario(String propietario) {
        if (!propietario.isEmpty()) {//propietario != ""
            this.propietario = propietario;
        }

    }

    public String getCif() {
        return cif;
    }

    public ArrayList<Barco> getEmbarcaciones() {
        return embarcaciones;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public int getNumeroEmbarcaciones() {
        return numeroEmbarcaciones;
    }
// Metodo q añade barcos al vector de embarcaciones solo si el numeroEmbarcaciones es menor q embarcaciones.length y no es null

    public boolean insertarEmbarcacion(Barco nuevoBarco) {
        if (numeroEmbarcaciones < embarcaciones.size() && nuevoBarco != null) {
            embarcaciones.set(numeroEmbarcaciones++, nuevoBarco);
            System.out.println("OK");
            return true;
        }

        return false;
    }
//MEtodo q borra los barcos 
    public boolean borrarEmbarcacion(int pos) {
        if (embarcaciones.get(pos) != null && pos < numeroEmbarcaciones && pos >= 0) {//Controla q la posicion exista y tenga un objeto dentro 
            embarcaciones.set(pos, embarcaciones.get(numeroEmbarcaciones - 1));
            embarcaciones.set(numeroEmbarcaciones--, null);
            return true;
        }

        return false;
    }
//Meetodo que busca barcos por su matricula y devuelve su posicion 
    public int buscarEmbarcacion(String matricula) {
        for (int i = 0; i < numeroEmbarcaciones; i++) {
            if (embarcaciones.get(i).getMatricula().equals(matricula)) {
                return i;
            }

        }
        return -1;

    }
// metodo q busca barcos por su posicion y devuelve el objeto
    public Barco buscarEmbarcacion(int pos) {
        if (embarcaciones.get(pos) != null) {
            return embarcaciones.get(pos);
        } else {
            return null;
        }
    }
//metodo que laquila barcos, comprueba que no este alquilado y lo alquila.
    public boolean alquilarEmbarcacion(int pos, int numDias) {
        if (embarcaciones.get(pos) != null && embarcaciones.get(pos).alquilarBarco(numDias)) {
            cuenta.ingreso(embarcaciones.get(pos).precioAlquiler());
            System.out.println(embarcaciones.get(pos).precioAlquiler());
            embarcaciones.get(pos).verDatos();
            embarcaciones.get(pos).alquilarBarco(numDias);
            return true;
        }
        return false;

    }
//metodo q devuelve los alquileres si estos estan alquilados
    public boolean devolverAlquiler(int pos) {
        if (embarcaciones.get(pos) != null && embarcaciones.get(pos).devolverBarco()) {
            cuenta.ingreso(embarcaciones.get(pos).precioAlquiler());
            System.out.println(embarcaciones.get(pos).precioAlquiler());
            embarcaciones.get(pos).verDatos();
            embarcaciones.get(pos).devolverBarco();
            return true;
        }
        return false;

    }
// pide los datos para crear los objetos
    public Barco pedirDatos() {//String matricula, float eslora, float manga, boolean conPatron
        Scanner t = new Scanner(System.in);
        System.out.println("Tipo de Barco [L/V]");
        char r = t.nextLine().charAt(0);
        System.out.println("Matricula");
        String matricula = Entrada.leerCadena();
        System.out.println("Eslora");
        float eslora = Entrada.leerFloat();
        System.out.println("Manga");
        float manga = Entrada.leerFloat();
        System.out.println("¿Con Patron? [s/n]");
        boolean conPatron;
        char s = t.nextLine().charAt(0);
        conPatron = switch (s) {
            case 's','S' ->
                true;
            default ->
                false;
        };
        switch (r) {
            case 'v','V' -> {
                System.out.println("Numero Mastiles");
                int numeroMastiles = Integer.parseInt(t.nextLine());
                System.out.println("Superficie Vela");
                float superficieVela = Entrada.leerFloat();

                Velero nuevoVelero = new Velero(numeroMastiles, superficieVela, matricula, eslora, manga, conPatron);
                System.out.println("Velero...");
                return nuevoVelero;
            }
            case 'l','L' -> {
                System.out.println("Potencia");
                float potencia = Entrada.leerFloat();
                Lancha nuevaLancha = new Lancha(potencia, matricula, eslora, manga, conPatron);
                System.out.println("Lancha...");
                return nuevaLancha;
            }

            default -> {
            }
        }
        return null;
    }

    public void verDatos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa Alquiler");
        sb.append("\nNombre: ").append(nombre);
        sb.append("\nPropietario: ").append(propietario);
        sb.append("\nEmbarcaciones: ").append(numeroEmbarcaciones);
        sb.append("\nSaldo: ").append(cuenta.getSaldo());
        System.out.println(sb.toString());
    }

    public void listarBarcos() {
        for (int i = 0; i < embarcaciones.size(); i++) {
            embarcaciones.get(i).verDatos();
        }
    }
// con el instanceof comprobamos que sean de la misma clase q la deseada
    public void lsitarVeleros() {
        for (int i = 0; i < numeroEmbarcaciones; i++) {
            if (embarcaciones.get(i) instanceof Velero) {
                embarcaciones.get(i).verDatos();
            }

        }
    }

    public void listarLanchas() {
        for (int i = 0; i < numeroEmbarcaciones; i++) {
            if (embarcaciones.get(i) instanceof Lancha) {
                embarcaciones.get(i).verDatos();
            }

        }
    }
// metodo q ordena de menos a mayor y de A a la Z
    public void ordenar(int orden) {
        Barco aux = null;
        switch (orden) {
            case 1 -> {
                for (int i = 0; i < numeroEmbarcaciones; i++) {
                    for (int j = numeroEmbarcaciones - 1; j > i; j--) {
                        if (embarcaciones.get(j).menorQue(embarcaciones.get(j - 1), 1)) {
                            System.out.println("Ordenado");
                            embarcaciones.set(j, embarcaciones.get(j));
                            embarcaciones.set(j, embarcaciones.get(j - 1));
                            embarcaciones.set(j - 1, aux);
                        }
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < numeroEmbarcaciones; i++) {
                    for (int j = numeroEmbarcaciones - 1; j > i; j--) {
                        if (embarcaciones.get(j).menorQue(embarcaciones.get(j - 1), 2)) {
                            System.out.println("Ordenado");
                            embarcaciones.set(j, embarcaciones.get(j));
                            embarcaciones.set(j, embarcaciones.get(j - 1));
                            embarcaciones.set(j - 1, aux);
                        }
                    }
                }
            }
            case 3 -> {
                for (int i = 0; i < numeroEmbarcaciones; i++) {
                    for (int j = numeroEmbarcaciones - 1; j > i; j--) {
                        if (embarcaciones.get(j).menorQue(embarcaciones.get(j - 1), 3)) {
                            System.out.println("Ordenado");
                            embarcaciones.set(j, embarcaciones.get(j));
                            embarcaciones.set(j, embarcaciones.get(j - 1));
                            embarcaciones.set(j - 1, aux);
                        }
                    }
                }
            }
        }
    }

}
