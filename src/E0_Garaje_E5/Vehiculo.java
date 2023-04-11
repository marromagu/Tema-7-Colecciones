/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E0_Garaje_E5;

/**
 *
 * @author jmrivera
 */

/*Clase Vehiculo: de esta clase no se podrán crear objetos (clase abstracta).
Tiene dos atributo que sólo pueden verse desde esta clase,  la potencia, de tipo float y la matrícula, de tipo String.
Constructor con parámetro, getter y setter, y un método que no será implementado en esta clase, será implementado en las clases hijas.
El método se llama trucarVehiculo que no devuelve nada ni recibe parámetros.*/

public abstract class Vehiculo {

  private float potencia;
  private String matricula;

  public Vehiculo(float potencia, String matricula) {
    this.potencia = potencia;
    this.matricula = matricula;
  }

  public float getPotencia() {
    return this.potencia;
  }

  public void setPotencia(float potencia) {
    this.potencia = potencia;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }
  /*
  * Método abstracto *************************************************
  */
  public abstract void trucarVehiculo();

}

