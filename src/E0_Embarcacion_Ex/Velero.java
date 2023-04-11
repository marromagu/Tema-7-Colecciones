/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E0_Embarcacion_Ex;

/**
 *
 * @author DAM_T
 */
public class Velero extends Barco {

    //Atributos
    private int numeroMastiles;
    private float superficieVela;

    public Velero(int numeroMastiles, float superficieVela, String matricula, float eslora, float manga, boolean conPatron) {
        super(matricula, eslora, manga, conPatron);
        this.numeroMastiles = numeroMastiles;
        this.superficieVela = superficieVela;
    }

    @Override
    public float precioAlquiler() {
        if (super.isConPatron()) {
            return (float) (super.getEslora() * numeroMastiles + 100.0 + superficieVela);
        } else {
            return (float) (super.getEslora() * numeroMastiles + superficieVela);
        }

    }

    public int getNumeroMastiles() {
        return numeroMastiles;
    }

    public float getSuperficieVela() {
        return superficieVela;
    }

    public void verDatos() {
        System.out.println("----------");
        System.out.println("| Velero |");
        System.out.println("----------");
        System.out.println("Numero de Mastiles: "+numeroMastiles);
        System.out.println("Superficie Vela: "+superficieVela);
        super.verDatos();
    }

}
