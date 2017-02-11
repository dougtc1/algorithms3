import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @authors Giuli Latella & Douglas Torres
 */
public class Recorridos {
    
    public int[] asignaciones;
    public int[] tiempoFinalizacion;
    Grafo g;
    ArrayList<Integer> ordenPostDFS = new ArrayList<Integer>();
    ArrayList<String> nodosOrdenados = new ArrayList<String>();
    public int contador = 0; 

    public Recorridos(int n, Grafo _g) {
        asignaciones = new int[n];
        Arrays.fill(asignaciones, -1);
        tiempoFinalizacion = new int [n];
        Arrays.fill(tiempoFinalizacion, -1);
        g = _g;
    }
    
    public int contarComponentesConexas(){
        
        int cantidadComponentes = 0;
        
        for (int i = 0; i < asignaciones.length; i++) {
            int currentValue = asignaciones[i];
            if ( currentValue == -1 ){
                dfs(i, asignaciones, cantidadComponentes, contador);
                ++cantidadComponentes;
            }
        }
        
        for (int i = 0; i < asignaciones.length; i++) {
            System.out.println("Nodo " + i + " pertenece a: " + asignaciones[i]);            
        }
        
        return cantidadComponentes;
    }
    
    private int dfs(int nodo, int[] asignaciones, int etiqueta, int contador) {
        
        contador = contador + 1;
        
         if ( asignaciones[nodo] == -1 ){
            Nodo actual = g.getNode(nodo);
            //System.out.println(actual + " ACTUAL");
            asignaciones[nodo] = etiqueta;
    
            ArrayList<Arista> hijos = actual.obtenerAristas();
            
            for (int i = 0; i < hijos.size(); i++) {
                
                //System.out.println(asignaciones[nodo] + " --- " + tiempoFinalizacion[nodo]);
                //System.out.println(nodo + " NODO ");
                String nombreHijo = hijos.get(i).toString();
                int position = g.obtenerPosicionDeNodo.get(nombreHijo);
                //System.out.println(position + " POSITION");
                
                if (asignaciones[position] == -1){
                    
                    contador = dfs(position, asignaciones, etiqueta, contador);
                    ordenPostDFS.add(position);
                    ///System.out.println(asignaciones[etiqueta] + " --- " + asignaciones[nodo]);
               }
            }
            
                contador = contador + 1;
                tiempoFinalizacion[nodo] = contador;
                //System.out.println(contador + " CONTADOR ");
                
               //System.out.println(asignaciones[nodo]);
                //Collections.reverseOrder(1,asignaciones);
        }
         
           return contador;
}
    
    
/*private void dfsTraspuesto(int nodo, int[] asignaciones, int etiqueta) {
        
        if ( asignaciones[nodo] == -1 ){
            Nodo actual = g.getNode(nodo);
            asignaciones[nodo] = etiqueta;
            
            ArrayList<Arista> hijos = actual.obtenerAristas();
            
            for (int i = 0; i < hijos.size(); i++) {
                String nombreHijo = hijos.get(i).toString();
                int position = g.obtenerPosicionDeNodo.get(nombreHijo);
                
                if (asignaciones[position] == -1){
                    
                    dfsTraspuesto(position, asignaciones, etiqueta);
                    ordenPostDFS.add(position);
                
               }
            }
        }
    }*/
    
     public ArrayList ordenTopologico(){
          
        int cantidadComponentes = 0;
        
        for (int i = 0; i < asignaciones.length; i++) {
            int currentValue = asignaciones[i];
            if ( currentValue == -1 ){
                contador = dfs(i, asignaciones, cantidadComponentes, contador);
                ordenPostDFS.add(i);
            }
        }
        System.out.println(Arrays.toString(tiempoFinalizacion) + " Tiempo finalizacion");
        Collections.reverse(ordenPostDFS);
        
        for (int i = 0; i < ordenPostDFS.size(); i++) {
            
            nodosOrdenados.add(g.getNode(i).toString());
            
        }
        
        return nodosOrdenados;
    }
     
    
}