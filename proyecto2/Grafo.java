import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @authors Giuli Latella & Douglas Torres
 */
public class Grafo {

    private ArrayList<Nodo> estructura;
    
    public TreeMap<String, Integer> obtenerPosicionDeNodo;
    
    public int i = 0;

    public Nodo getNode(int position){
        return estructura.get(position);
    }
    
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
                //Para verificar
                System.out.println(actual + " VERIFICACION");
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

                System.out.println(origen + " --> " + destino + " VERIFICACION");
            }
        }
    }
    
    public void agregarNodo(Nodo nodo){
        estructura.add(nodo);
    }
    
    public ArrayList<Nodo> obtenerNodos(){
        return estructura;
    }
    
    public void imprimir(){
        System.out.println(estructura);
    }
    
    public void imprimirSeparado(){
        for ( Nodo n : estructura ){
            System.out.println(n);
        }
    }
}
