/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplohashmap;

import java.util.HashMap;

/**
 *
 * @author JMRivera
 */
public class EjemploHashMap {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    HashMap<Integer,Persona> agenda = new HashMap<Integer,Persona>();
    Persona p = null;
    int tlf;
    int op;
    do{
      op = menu();
      switch (op) {
        case 1:
          ver(agenda);
          break;
        case 2:
          p = new Persona();
          agenda.put(p.hashCode(), p);
          break;
        case 3:
          tlf = Entrada.leerEntero("Telefono a borrar:");
          agenda.remove((Integer)tlf);
          break;
        case 4:
          tlf = Entrada.leerEntero("Telefono a buscar:");
          p = agenda.get((Integer)tlf);
          System.out.println(p.toString());
          break;
        default:

      }
    }while(op != 0);
  }
  
  public static int menu(){
    int opcion;
    System.out.println("\t MENU\t");
    System.out.println("1.- Ver agenda");
    System.out.println("2.- Dar de alta");
    System.out.println("3.- Dar de baja");
    System.out.println("4.- Buscar persona");
    opcion = Entrada.leerEntero("Introduzca opcion:");
    return opcion;
  }
  
  public static void ver(HashMap<Integer,Persona> agenda ) {
    System.out.println("Nombre \t telefono \t email");
    for(Persona p: agenda.values()){
      System.out.println(p.toString());
    }

  }
}
