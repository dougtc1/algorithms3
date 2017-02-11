/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Descripcion:  Clase que representa las aristas.
 *
 * @author Giuli Latella 08-10596
 * @author Douglas Torres 11-11027
 *
 * @version: 03/01/2015
 *
 */
public class Arista {
    
    //Campos de la clase  
    private Nodo destino;

    /**
     *
     * Constructor de la clase Arista. Establece los 
     * atributos de la estructura. 
     * @param Nodo destino define el destino de la arista.
     * 
     */
    public Arista(Nodo destino) {
        this.destino = destino;
    }

    /**
     * 
     * Sobreescritura del método toString para adaptarlo. 
     * @return el nombre del destino.
     * 
     */
    @Override
    public String toString() {
        return destino.obtenerNombre();
    }
    
    
}
