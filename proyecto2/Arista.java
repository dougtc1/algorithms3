/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giuli Latella & Douglas Torres
 */
public class Arista {
    
    private Nodo destino;

    public Arista(Nodo destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return destino.obtenerNombre();
    }
    
    
}
