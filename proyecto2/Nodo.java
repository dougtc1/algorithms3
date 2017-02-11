import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giuli Latella & Douglas Torres
 */
public class Nodo {
    private String nombre;
    ArrayList<Arista> destinos;
    
    public Nodo(String s){
        this.nombre = s;
        destinos = new ArrayList<Arista>();
    }
    
    public Nodo(String s, ArrayList<Arista> _destinos){
        nombre = s;
        destinos = new ArrayList<Arista>(_destinos);
    }

    public String obtenerNombre() {
        return nombre;
    }

    public ArrayList<Arista> obtenerAristas(){
        return destinos;
    }
    
    public void agregarArista(Nodo destino){
        destinos.add(new Arista(destino));
    }
    
    public void agregarArista(Arista arista){
        destinos.add(arista);
    }
    
    public void agregarVariasAristas(Nodo[] nodos){
        for( Nodo n : nodos ){
            agregarArista(n);
        }
    }
    
    public void agregarVariasArista(ArrayList<Nodo> nodos){
        for( Nodo n : nodos ){
            agregarArista(n);
        }
    }
    
    public void imprimir(){
        System.out.print(toString());
    }

    @Override
    public String toString() {
        return nombre; 
    }
    
    
}
