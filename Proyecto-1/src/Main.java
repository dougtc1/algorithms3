/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /**
 * Descripcion: Representa la clase principal. 
 *
 * @author Giuli Latella 08-10596.
 * @author Douglas Torres 11-11027
 *
 * @version: 03/01/2015.
 *
 */

public class Main {
    
     /**
     *
     * Unidad de prueba del software.  
     * @param args argumentos.
     */
    public static void main(String[] args) {
        Grafo g = new Grafo();
        Recorridos r = new Recorridos(g.obtenerNodos().size(), g);
        r.VerificacionCasa();
    }
}
