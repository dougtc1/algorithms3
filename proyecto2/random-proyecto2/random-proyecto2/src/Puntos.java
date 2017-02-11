
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dougtc
 */
public class Puntos {
    
    public static ArrayList<Puntos> listaPuntos;
    
    public static int kclusters = 0;
    
    //public ArrayList<coord> linea;
    
    public String nombre;
    
    public double coordX;
            
    public double coordY;
    
    public static ArrayList<Puntos> adyacentes;
    
    public static int tamano;
    
    public static double [][] distancias;
    
    static int [] indicesMin = new int [2];
    
    public Puntos (double coordX, double coordY, int i){
        
        this.nombre = "punto N " + i;
        this.coordX = coordX;
        this.coordY = coordY;
        this.adyacentes = new ArrayList<Puntos>();
    
}
    public static void agregarPuntos (Puntos punto) {
        listaPuntos.add(punto);
        
    }
    
    public static void leerArchivo (String archivo) {
        
        try {
            
            boolean seguir = true;
            
            int i = 0;
            
            listaPuntos = new ArrayList<Puntos>();
            
            System.out.println("Se esta leyendo el archivo de entrada.");

            Scanner entrada = new Scanner(new File(archivo));

            kclusters = entrada.nextInt();

            System.out.println(kclusters);
            
            while (seguir) {
            
                if (entrada.hasNext()) {

                    double x = entrada.nextDouble();
                    double y = entrada.nextDouble();
                    
                    System.out.println(x + " " + y);
                    
                    agregarPuntos(new Puntos(x,y,i));
                    
                    //System.out.println(entrada.hasNextLine());
                    
                    i++;

                } else {

                    seguir = false;
                    }
            }
           
       } catch (FileNotFoundException ex) {
            System.err.println("No se encontro el archivo: " + archivo);
       }
        
        tamano = listaPuntos.size();
        
    }
    
    public void crearArreglos () {
        
        String cluster = "cluster";
        
        for (int i = 0; i<tamano; i++) {
            
            String arreglo = cluster + i;
            
            //int [] arreglo = new int [2];
            
        }
        
    }
    
    public static void imprimir(int i){
        System.out.println(listaPuntos.get(i).obtenerNombre());
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public static void matrizDistancia() {

        distancias = new double [tamano][tamano];
        
        //int tamano = listaPuntos.size();
        //double menorDistancia = 0.0;
        //double auxiliar = 0.0;
                
        for (int i = 0; i < tamano; i++) {
            
            for (int j = 0; j < tamano; j++) {
                
                if (i == j) {
                    distancias[i][j] = 0;
                    
                } else {
                    
                    double x1 = listaPuntos.get(i).coordX;
                    double x2 = listaPuntos.get(j).coordX;
                    double y1 = listaPuntos.get(i).coordY;
                    double y2 = listaPuntos.get(j).coordY;
                    
                    double difX = Math.pow((x2-x1),2);
                    double difY = Math.pow((y2-y1),2);
                    
                    double d = Math.sqrt(difX + difY);
                    
                    System.out.println(d + " - Posiciones: " + i +"," + j);
                    
                    distancias[i][j] = d;                    
                }
                
            }
            
        }
    }
    
    public static int [] minimaDistancia(){
        
        int minX;
        int minY;
        double menorDistancia = 0.0;
        double auxiliar;
        
        for (int i = 0; i < tamano; i++) {
            
            for (int j = 0; j < i; j++) {
                
                if (distancias[i][j] > 0) {
                
                    auxiliar = distancias[i][j];

                    if (menorDistancia == 0.0) {

                        menorDistancia = auxiliar;

                    } else if (auxiliar < menorDistancia ){

                        menorDistancia = auxiliar;

                        minX = i;
                        minY = j;

                        indicesMin[0] = minX;
                        indicesMin[1] = minY;

                    }                
                }
            }
        }
        
        return indicesMin;
    }
    
    public static void actualizarMatriz (int X, int Y){
        
        for (int i = 0; i < tamano; i++) {
            
            distancias[i][X] = Math.min(distancias[i][X], distancias[i][Y]);
            distancias[X][i] = Math.min(distancias[X][i], distancias[Y][i]);
        }
        
        for (int i = 0; i < tamano; i++) {
            
            for (int j = Y; j < tamano-1; j++) {
                
                if (i==X) {
                    distancias[i][j] = -1;
                    distancias[j][i] = -1;
                }
            }
        
        }
    
    }
}