import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Descripcion:  Clase que representa al grafo.
 *
 * @author Giuli Latella 08-10596
 * @author Douglas Torres 11-11027
 *
 * @version: 03/01/2015
 *
 */
public class Grafo {

    //Campos de la clase. Inicializacion de variables.
    private ArrayList<Nodo> estructura;
    
    public TreeMap<String, Integer> obtenerPosicionDeNodo;
    
    public int i = 0;
    
/**
     *
     * Constructor de la clase Grafo. Establece los 
     * atributos de la estructura. Genera el grafo a partir de los datos 
     * introducidos por entrada estándar.
     * 
     */
    public Grafo(){
        
        estructura = new ArrayList<Nodo>();

        obtenerPosicionDeNodo = new TreeMap<String, Integer>();

        boolean seguir = true;

        System.out.println("Introduzca las habitaciones de la casa que desea:");

        while (seguir) {

            Scanner nodos = new Scanner(System.in);
            
            String actual = nodos.nextLine();
            
            if (actual.length() == 0) {
              
                seguir = false;
            
            } else {
                
                agregarNodo(new Nodo(actual));
                
                obtenerPosicionDeNodo.put(actual, i);
                
                i ++;
                
            }

        }

        seguir = true;

        System.out.println("Introduzca la forma en que estan conectadas las habitaciones de la casa que desea:");

        while (seguir) {
            
            Scanner aristas = new Scanner(System.in);
            String linea = aristas.nextLine();
            String[] nombre = linea.split(" ");

            if (linea.length() == 0) {
                
                seguir = false;
            
            } else {
            
                String origen = nombre[0];
                String destino = nombre[1];
                int positionOrigen = obtenerPosicionDeNodo.get(origen);
                int positionDestino = obtenerPosicionDeNodo.get(destino);

                estructura.get(positionOrigen).agregarArista(
                        estructura.get(positionDestino)
                );
            }
        }
    }
    
    /**
     * 
     * Método que se utiliza para obtener el nodo dada la posicion. 
     * @param position posicion del nodo.
     * @return el nodo de posicion indicada dentro del arreglo estructura.
     * 
     */    
    public Nodo getNode(int position){
        return estructura.get(position);
    }
    
    /**
     * 
     * Método que se utiliza para agregar el nodo al arreglo estructura. 
     * @param nodo nodo a agregar.
     * 
     */
    public void agregarNodo(Nodo nodo){
        estructura.add(nodo);
    }
    
    /**
     * 
     * Método que se utiliza para obtener los nodos del arreglo estructura. 
     * @return devuelve el arreglo estructura.
     * 
     */
    public ArrayList<Nodo> obtenerNodos(){
        return estructura;
    }
    
}