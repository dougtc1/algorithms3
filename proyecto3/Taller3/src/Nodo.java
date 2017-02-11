import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Douglas Torres
 * Carnet: 11-11027
 */
public class Nodo {
    
    private String nombre;
    ArrayList<Arista> DestinosYPesos;
    public double key;
    public Nodo padre;
    
    public Nodo(String s){
        this.nombre = s;
        //this.DestinosYPesos = new ArrayList<Arista>();
        //this.key = inf;
        //this.padre = null;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public ArrayList<Arista> obtenerAristas(){
        return this.DestinosYPesos;
    }
    
    public void agregarArista(Nodo destino, double peso){
        this.DestinosYPesos.add(new Arista(destino,peso));
        
    }
    
    @Override
    public String toString() {
        return this.nombre; 
    }
    
}