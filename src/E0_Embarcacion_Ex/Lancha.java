/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E0_Embarcacion_Ex;

/**
 *
 * @author DAM_T
 */
public class Lancha extends Barco {

    //Atributos
    private float potencia;

    public Lancha(float potencia, String matricula, float eslora, float manga, boolean conPatron) {
        super(matricula, eslora, manga, conPatron);
        this.potencia = potencia;
    }

    @Override
    public float precioAlquiler() {
        if (super.isConPatron()) {
            return (float) (super.getEslora() * potencia + 60.0);
        } else {
            return super.getEslora() * potencia;
        }

    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public void verDatos() {
        System.out.println("----------");
        System.out.println("| Lancha |");
        System.out.println("----------");
        System.out.println("Potencia: "+potencia);
        super.verDatos();
    }
}
