/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Douglas Torres
 * Carnet: 11-11027
 */
public class Arista {
    
    public Nodo destino;
    
    public double peso;

    public Arista(Nodo destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return destino.obtenerNombre();
    }
}
