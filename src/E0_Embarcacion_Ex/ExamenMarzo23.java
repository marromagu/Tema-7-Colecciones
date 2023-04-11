/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package E0_Embarcacion_Ex;

/**
 *
 * @author JMRivera
 */
public class ExamenMarzo23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmpresaAlquiler miEmpresa = new EmpresaAlquiler("Barquitos de papel", "Mario Romero Aguilar", "A123", 1000.0);
        cargarDatos(miEmpresa);
        int opcion = menu();
        int n;
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    miEmpresa.verDatos();
                    System.out.println("¿Desea cambiar el propietario? [ 1 = Si | 2 = No]");
                    n = Entrada.leerEntero();
                    switch (n) {
                        case 1: {
                            System.out.println("Escriba el nuevo propietario");
                            String propietario = Entrada.leerCadena();
                            miEmpresa.setPropietario(propietario);
                            miEmpresa.verDatos();
                        }
                        break;
                        case 2: {
                            System.out.println("OK");
                        }
                        break;
                        default:
                            throw new AssertionError();
                    }

                    break;
                case 2:
                    System.out.println("¿Que datos desa ver? [ 1 = Todos | 2 = Veleros | 3 = Lanchas ]");
                    n = Entrada.leerEntero();
                    switch (n) {
                        case 1:
                            miEmpresa.listarBarcos();
                            break;
                        case 2:
                            miEmpresa.lsitarVeleros();
                            break;
                        case 3:
                            miEmpresa.listarLanchas();
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case 3:
                    miEmpresa.insertarEmbarcacion(miEmpresa.pedirDatos());
                    break;
                case 4:
                    System.out.println("Dime una matricula:");
                    String matricula = Entrada.leerCadena();
                    int pos;
                    miEmpresa.buscarEmbarcacion(matricula);
                    pos = miEmpresa.buscarEmbarcacion(matricula);
                    System.out.println("Posicion : " + miEmpresa.buscarEmbarcacion(matricula) + " " + matricula);
                    //Barco miBarco = miEmpresa.buscarEmbarcacion(miEmpresa.buscarEmbarcacion(matricula));
                    if (pos >= 0) {
                        System.out.println("¿Que hacer? [ 1 = Borrar | 2 = Alquilar | 3 = Devolverla ]");
                        n = Entrada.leerEntero();
                        switch (n) {
                            case 1:
                                miEmpresa.borrarEmbarcacion(pos);
                                break;
                            case 2:
                                System.out.println("Numero de dias");
                                int dias = Entrada.leerEntero();
                                miEmpresa.alquilarEmbarcacion(pos, dias);
                                break;
                            case 3:
                                miEmpresa.devolverAlquiler(pos);
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Selecciona el modo de ordenacion: [ Matrícula = 1| Eslora = 2| Precio Alquiler = 3 ] ");
                    n = Entrada.leerEntero();
                    miEmpresa.ordenar(n);
                    break;
            }
            Entrada.leerCadena("\nPulse INTRO para continuar.");
            opcion = menu();
        }
        System.out.println("Fin de la ejecución de la aplicación.");
    }

    /**
     * Método que muestra el menú
     *
     * @return la opción elegida por el usuario
     */
    public static int menu() {
        int opcion;
        System.out.println("Alquiler de embarcaciones");
        System.out.println("-------------------------");
        System.out.println("1. Consultar datos de la empresa/¿Modificar propietario?.");
        System.out.println("2. Listado de embarcaciones: todas, veleros o lanchas.");
        System.out.println("3. Insertar una nueva embarcación.");
        System.out.println("4. Buscar una embarcación por su matrícula: ver datos y (¿borrarla?|¿alquilarla?|¿devolverla?");
        System.out.println("5. Ordenar las embarcaciones por: matrícula|eslora|precio de alquiler");
        System.out.println("0. Salir");
        opcion = Entrada.leerEntero("\n¿Opción?: ");
        return opcion;
    }

    /**
     * Método para cargar 5 embarcaciones en el array para pruebas
     *
     * @param empresa Objeto de la aplicación parqa cargar las embarcaciones
     */
    public static void cargarDatos(EmpresaAlquiler empresa) {
        Barco unBarco;
        unBarco = new Velero(1, 3, "N10", 5, 3, true);
        empresa.insertarEmbarcacion(unBarco);
        unBarco = new Lancha(100, "Z10", 6, 3, true);
        empresa.insertarEmbarcacion(unBarco);
        unBarco = new Velero(2, 6, "A10", 10, 3, true);
        empresa.insertarEmbarcacion(unBarco);
        unBarco = new Lancha(150, "J10", 8, 2, true);
        empresa.insertarEmbarcacion(unBarco);
        unBarco = new Velero(1, 4, "F10", 6, 2, true);
        empresa.insertarEmbarcacion(unBarco);
    }
}
