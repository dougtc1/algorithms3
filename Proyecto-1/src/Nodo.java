import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Descripcion:  Clase que representa los nodos 
 *
 * @author Giuli Latella 08-10596
 * @author Douglas Torres 11-11027
 *
 * @version: 03/01/2015
 *
 */

public class Nodo {
    
    //Campos de la clase
    public int numerohijos;
    
    private String nombre;
    
    public int numerodfs;
    
    public int nivel;
    
    public int low;
    
    ArrayList<Arista> destinos;
    
    /**
     *
     * Constructor de la clase Nodo. Genera un objeto nodo y establece los 
     * atributos de la estructura. Inicializacion.
     * @param s define el nombre del nodo.
     * 
     */
    public Nodo(String s){
        this.nombre = s;
        this.numerodfs = -1;
        this.low = -1;
        this.nivel = 0;
        this.numerohijos = 0;
        destinos = new ArrayList<Arista>();
    }

     /**
     * 
     * Método que se utiliza para obtener el nombre del nodo. 
     * @return Retorna el nombre del nodo.
     * 
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * 
     * Método que se utiliza para obtener el destino. 
     * @return Retorna el nombre del nodo.
     * 
     */
    public ArrayList<Arista> obtenerAristas(){
        return destinos;
    }
    
    /**
     * 
     * Método que se utiliza para agregar la arista. 
     * @param Nodo destino.
     * 
     */
    public void agregarArista(Nodo destino){
        destinos.add(new Arista(destino));
    }
    
    /**
     * 
     * Sobreescritura del método toString para adaptarlo. 
     * @return el nombre.
     * 
     */
    @Override
    public String toString() {
        return nombre; 
    }
    
}