/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E0_Embarcacion_Ex;

import java.util.Objects;

/**
 *
 * @author JMRivera
 */
public abstract class Barco {

    // Atributos de la clase
    private String matricula;
    private float eslora;
    private float manga;
    private boolean conPatron;
    private boolean alquilado;
    private int diasNavegacion;
    private int diasAlquiler;

    // Constructor con parámetros
    public Barco(String matricula, float eslora, float manga, boolean conPatron) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.manga = manga;
        this.conPatron = conPatron;
        this.alquilado = false;
        this.diasNavegacion = 0;
        this.diasAlquiler = 0;
    }

    /**
     * Método abstracto que devuelve el precio del alquiler
     *
     * @return precio del alquiler
     */
    public abstract float precioAlquiler();

    /**
     * Método para alquilar el barco los días que recibe como parámetro
     *
     * @param dias
     * @return Verdadero o Falso, según se haya realizado con éxito la
     * operación.
     */
    public boolean alquilarBarco(int dias) {
        if (!alquilado) {
            alquilado = true;
            diasAlquiler = dias;
            return true;
        }
        return false;
    }

    /**
     * Método que actualiza los parámetros en la devolución del barco alquilado
     *
     * @return Verdadero o Falso, según se haya realizado con éxito la
     * operación.
     */
    public boolean devolverBarco() {
        if (alquilado) {
            alquilado = false;
            diasNavegacion -= diasAlquiler;
            diasAlquiler = 0;
            return true;
        }
        return false;
    }

    /**
     * Método que compara el objeto "this" con el que recibe como parámetro con
     * el siguiente criterio, según el valor del parámetro "orden": - Si vale 1:
     * compara las matriculas alfabéticamente. - Si vale 2: compara las esloras.
     * - Si vale 3: compara los precios de alquiler.
     *
     * @param otroBarco, objeto con el que se compara
     * @param orden, indicara el criterio de ordenación. Debe valer 1, 2 o 3.
     * @return devolverá "true" si es menor y "false", en caso contrario.
     */
    public boolean menorQue(Barco otroBarco, int orden) {

        switch (orden) {
            case 1 -> {
                if (this.matricula.compareTo(otroBarco.matricula) <0) {
                    return true;
                } else {

                    return false;
                }
            }

            case 2 -> {
                if (this.eslora < otroBarco.eslora) {
                    return true;
                } else {

                    return false;
                }
            }

            case 3 -> {
                if (this.precioAlquiler() < otroBarco.precioAlquiler()) {
                    return true;
                } else {

                    return false;
                }
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * Método que compara el objeto "this" con el que recibe como parámetro con
     * el siguiente criterio, según el valor del parámetro "orden": - Si vale 1:
     * compara las matriculas alfabéticamente. - Si vale 2: compara las esloras.
     * - Si vale 3: compara los precios de alquiler.
     *
     * @param otroBarco, objeto con el que se compara
     * @param orden, indicara el criterio de ordenación. Debe valer 1, 2 o 3.
     * @return devolverá "true" si es mayor y "false", en caso contrario.
     */
    public boolean mayorQue(Barco otroBarco, int orden) {
        switch (orden) {
            case 1 -> {
                if (this.matricula.compareTo(otroBarco.matricula) >0) {
                    return true;
                } else {

                    return false;
                }
            }

            case 2 -> {
                if (this.eslora > otroBarco.eslora) {
                    return true;
                } else {

                    return false;
                }
            }

            case 3 -> {
                if (this.precioAlquiler() > otroBarco.precioAlquiler()) {
                    return true;
                } else {

                    return false;
                }
            }
            default -> {
                return false;
            }
        }

    }

    /**
     * Método que compara el objeto "this" con el que recibe como parámetro con
     * el siguiente criterio, según el valor del parámetro "orden": - Si vale 1:
     * compara las matriculas. - Si vale 2: compara las esloras. - Si vale 3:
     * compara los precios de alquiler.
     *
     * @param otroBarco, objeto con el que se compara
     * @param orden, indicara el criterio de ordenación. Debe valer 1, 2 o 3.
     * @return devolverá "true" si es igual y "false", en caso contrario.
     */
    public boolean igualQue(Barco otroBarco, int orden) {
         switch (orden) {
            case 1 -> {
                if (this.matricula.equals(otroBarco.matricula)) {
                    return true;
                } else {

                    return false;
                }
            }

            case 2 -> {
                if (this.eslora == otroBarco.eslora) {
                    return true;
                } else {

                    return false;
                }
            }

            case 3 -> {
                if (this.precioAlquiler() == otroBarco.precioAlquiler()) {
                    return true;
                } else {

                    return false;
                }
            }
            default -> {
                return false;
            }
        }

    }

    /**
     * Método que muestra los datos del Barco
     */
    public void verDatos() {
        System.out.println(matricula + " ha navegado " + diasNavegacion + " días");
        System.out.println("E: " + eslora + " mts M: " + manga + " mts");
        System.out.println("Alquilado: " + (alquilado ? "Sí " : "No ") + diasAlquiler + " días");
        System.out.println("Precio: " + precioAlquiler());
    }

    // Getters de la clase Barco
    public String getMatricula() {
        return matricula;
    }

    public float getEslora() {
        return eslora;
    }

    public float getManga() {
        return manga;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public boolean isConPatron() {
        return conPatron;
    }

    public int getDiasNavegacion() {
        return diasNavegacion;
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

}
