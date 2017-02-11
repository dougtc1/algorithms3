import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Douglas Torres
 * Carnet: 11-11027
 */
public class Grafo {
    
    
    public ArrayList<Nodo> estructura;
    
    public TreeMap<String, Integer> obtenerPosicionDeNodo;
    
    public int i;

    public double [][] matriz;
    
    public ArrayList<double[][]> listaMatrices = new ArrayList<double[][]>();
    
    public double inf = Double.POSITIVE_INFINITY;
    
    public Nodo getNode(int position){
        return this.estructura.get(position);
    }
    
    public Grafo(String archivo){
        
        try {
        
        this.estructura = new ArrayList<Nodo>();

        this.obtenerPosicionDeNodo = new TreeMap<String, Integer>();
        
        this.i = 0;

        Scanner sc = new Scanner(new File(archivo));
            
            while (sc.hasNext("v")) {
                String pasar = sc.next();
                String nombreActual = sc.next();
                agregarNodo(new Nodo(nombreActual));
                this.obtenerPosicionDeNodo.put(nombreActual, i);
                i ++;
            }
            
            this.matriz = this.crearMatriz();
            
            while (sc.hasNext("e")) {
                String pasar2 = sc.next();
                String nombreOrigen = sc.next();
                String nombreDestino = sc.next();
                String pesoAristaS = sc.next();
                
                double pesoArista = Double.parseDouble(pesoAristaS);
                
                //System.out.println(pesoArista);
                
                int origen = this.obtenerPosicionDeNodo.get(nombreOrigen);
                int destino = this.obtenerPosicionDeNodo.get(nombreDestino);
                
                this.matriz[origen][destino] = pesoArista;
                
                
                //Nodo nodoPadre = this.estructura.get(positionOrigen);
                
                //Nodo nodoHijo = this.estructura.get(positionDestino);
                
                //nodoPadre.agregarArista(nodoHijo,pesoArista);
                
                //System.out.println(nodoPadre.DestinosYPesos);
                
                //nodoHijo.agregarArista(nodoPadre,pesoArista);
                                   
            }
        } catch (FileNotFoundException ex) {
            System.err.println("No se encontro el archivo: " + archivo);
        }
    }
    
    public void agregarNodo(Nodo nodo){
        this.estructura.add(nodo);
    }
    
    public ArrayList<Nodo> obtenerNodos(){
        return this.estructura;
    }
    
    
     public double [][] crearMatriz(){
        
        
         double [][] matrizI = new double[this.estructura.size()][this.estructura.size()];
                
        for (int i = 0; i < this.estructura.size(); i++) {
            
            this.listaMatrices.add(matrizI);
            
            for (int j = 0; j < this.estructura.size(); j++) {
                
                if (i == j){
                    
                    matrizI[i][j] = 0.0;
                
                } else {
                
                matrizI[i][j] = this.inf;
                
            }
            
        }
        }   
        return matrizI;
    }
    
        public double[][] FloydWarshall(){
                      
            int n = this.estructura.size();
           
            for (int k = 1; k < n; k++) {
            
                for (int i = 0; i < n; i++) {
                    
                    for (int j = 0; j < n; j++) {
                        
                        this.matriz[i][j] = Math.min(this.matriz[i][j],(this.matriz[i][k] + this.matriz[k][j]));
                        
                    }
                }
            }
            
            this.matriz = this.listaMatrices.get(n-1); 
                    
            return this.matriz;
}
}