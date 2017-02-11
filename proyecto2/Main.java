/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @authors Giuli Latella & Douglas Torres
 */
public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();
        Recorridos r = new Recorridos(g.obtenerNodos().size(), g);
        System.out.println("Este es el orden topologico realizado: " + r.ordenTopologico());
        
        //System.out.println("Cantidad Componentes: " + r.contarComponentesConexas());
        //g.imprimir();
        //g.imprimirSeparado();
    }
}
