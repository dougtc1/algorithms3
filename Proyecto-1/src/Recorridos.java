import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Descripcion:  Clase que representa la verificación basica sobre la validez
 * de la casa creada. Realiza los recorridos pertinentes para realizar el chequeo.
 *
 * @author Giuli Latella 08-10596
 * @author Douglas Torres 11-11027
 *
 * @version: 03/01/2015
 *
 */
public class Recorridos {
    
    //Campos de la clase. Inicializacion de variables.
    public int[] tiempoFinalizacion;
    
    public int[] visitados;
    
    public int contador = 0; 
    
    ArrayList<String> puntosArticulados = new ArrayList<String>();
    
    ArrayList<Nodo> cola = new ArrayList<Nodo>();
       
    Grafo g;
    
/**
     *
     * Constructor de la clase Recorridos. Establece los 
     * atributos de la estructura. 
     * 
     */    
    public Recorridos(int n, Grafo _g) {
        
        Arrays.fill(tiempoFinalizacion, -1);
        
        tiempoFinalizacion = new int [n];
        
        Arrays.fill(visitados, -1);
        
        visitados = new int[n];
        
        g = _g;
    }

     /**
     * 
     * Método que implementa el dfs. 
     * @param nodo.
     * 
     */   
    private void dfs(Nodo nodo) {
        
        if (nodo == null) { //Si el nodo es null no hace nada.
            return;
        }
        
        //Inicializacion.
        contador = contador + 1; 
        nodo.numerodfs = contador;
	nodo.low = nodo.numerodfs;
        ArrayList<Arista> hijosAdyacentes = nodo.obtenerAristas();
        String nombreNodo = nodo.toString();
        
        for (int i = 0; i < hijosAdyacentes.size(); i++) {
            
            String nombreHijoAdyacente = hijosAdyacentes.get(i).toString();
            //Posicion del nodo hijo
            int posicionHijoAdyacente = g.obtenerPosicionDeNodo.get(nombreHijoAdyacente); 
            Nodo hijoAdyacente = g.getNode(posicionHijoAdyacente);
            
            
            if (hijoAdyacente.numerodfs == -1) {
                
                hijoAdyacente.nivel = nodo.nivel + 1;
                
                nodo.numerohijos += 1;
                
                dfs(hijoAdyacente);
                
                nodo.low = Math.min(nodo.low, hijoAdyacente.low);
                
                if (nodo.numerodfs == 1) {
                    
                    if (nodo.numerohijos >= 2) {
                        
                        if (!puntosArticulados.contains(nombreNodo)) {
                            
                            puntosArticulados.add(nombreNodo);
                        }
                    }
                    
                } else {

                    if (hijoAdyacente.low >= nodo.numerodfs) {

                        if(!puntosArticulados.contains(nombreNodo)) {

                            puntosArticulados.add(nombreNodo);
                        }
                    }
                }
            }
        }
    }
    
/**
     * 
     * Método que implementa el bfs. Se utiliza para evaluar futuramente la 
     * validez de la casa creada. 
     * @return una variable booleana.
     * 
     */           
        private boolean bfs() {
            
            //Inicializacion.
            int valorNuevo = 0;
            Arrays.fill(visitados, -1);
            boolean resultado = false;
            Nodo inicial = g.getNode(0);
            visitados[0] = valorNuevo; // Se comienza siempre desde el "primer" 
                                       //nodo agregado.
            
            cola.add(inicial);
            
            while (cola.size() > 0) {
                
                Nodo vertice = cola.get(0);
                cola.remove(0);             
                ArrayList<Arista> adyacentes = vertice.obtenerAristas();
                String nombreVertice = vertice.toString();
                            
                for (int i = 0; i < adyacentes.size(); i++) {
                    
                    String nombreVerticeSiguiente = adyacentes.get(i).toString();
                    
                    int posicion = g.obtenerPosicionDeNodo.get(nombreVerticeSiguiente); //Posicion del vertice
                    
                    vertice = g.getNode(posicion);
                    
                    if (visitados[posicion] == -1){
                        
                        visitados[posicion] = valorNuevo;
                        
                        cola.add(vertice);
                    }
            
                }
            }
            
            for (int i = 0; i < visitados.length;i ++) {
                
                if (visitados[i] == -1) {
                    
                    resultado = false;
                
                } else {
                    
                    resultado = true;
                    
                }
            }
            
            return resultado;
        }
        
/**
* 
* Método que se utiliza para verificar si la casa creada es valida o invalida.
* Una casa se considera invalida si tiene secciones aisladas del
* resto de la casa.
* En caso de ser valida, el sistema advertira al usuario sobre
* secciones de la casa que considere riesgosas en una lista, entendiendose por 
* éstas, areas cualesquiera de la casa que en caso de ser bloqueada por un 
* incendio o derrumbe, deje incomunicadava una parte de la casa.
* 
* @return la validez de la casa.
* @return la lista de habitaciones riesgosas.
* 
*/    
    public void VerificacionCasa(){
    
        boolean validez;

        validez = bfs();

        if (validez) {

            System.out.println("VALIDA");

        } else {
            
            System.out.println("INVALIDA");
            return;
        }  
    
        Nodo nodoActual = g.getNode(0);
        
        dfs(nodoActual);
        
        Collections.sort(puntosArticulados); //Arregla la lista en orden 
                                             //alfabetico.
        
        System.out.println("Las secciones riesgosas de la casa son: " + puntosArticulados);
    }
}