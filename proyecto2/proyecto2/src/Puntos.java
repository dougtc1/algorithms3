import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    public ArrayList<Puntos> adyacentes;
    
    public static ArrayList<Puntos> arregloClusters;
    
    public static int tamano;
    
    public static double [][] distancias;
    
    public static int [] indicesMin;

    
    public Puntos (double coordX, double coordY, int i){
        
        this.nombre = "punto N " + i;
        this.coordX = coordX;
        this.coordY = coordY;
        adyacentes = new ArrayList<Puntos>();
    
}
    public static void agregarPuntos (Puntos punto) {
        listaPuntos.add(punto);
        //arregloClusters.add(punto);
        
    }
    
    public static void leerArchivo (String archivo) {
        
        try {
        
            arregloClusters = new ArrayList<Puntos>();
            
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
                    
                    //System.out.println(x + " " + y);
                    
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
                    distancias[i][j] = 0.0;
                    
                } else {
                    
                    double x1 = listaPuntos.get(i).coordX;
                    double x2 = listaPuntos.get(j).coordX;
                    double y1 = listaPuntos.get(i).coordY;
                    double y2 = listaPuntos.get(j).coordY;
                    
                    double difX = Math.pow((x2-x1),2);
                    double difY = Math.pow((y2-y1),2);
                    
                    double d = Math.sqrt(difX + difY);
                    
                    //System.out.println(d + " - Posiciones: " + i +"," + j);
                    
                    distancias[i][j] = d;
                    distancias[j][i] = d;
                }
                
            }
            
        }
       
    }
    
    public static int [] minimaDistancia(){
        
        int cluster = 0;
        int punto = 0;
        double menorDistancia = 0.0;
        double auxiliar;
        indicesMin = new int [2];
        
        for (int i = 0; i < tamano; i++) {
            
            for (int j = 0; j < tamano; j++) {
                
                if ( i !=j ) {
                
                    if (distancias[i][j] > 0.0) {

                        auxiliar = distancias[i][j];

                        if (menorDistancia == 0.0) {

                            menorDistancia = auxiliar;

                            cluster = Math.min(i,j);
                            punto = Math.max(i, j);

                        } else if (auxiliar < menorDistancia ){

                            menorDistancia = auxiliar;

                            cluster = Math.min(i,j);
                            punto = Math.max(i, j);

                        }

                    }
                }
                
            }
        
        }
        
        indicesMin[0] = cluster;
        indicesMin[1] = punto;
        
        return indicesMin;
    }
    
    public static void actualizarMatriz (int cluster, int punto){
        
        Puntos puntoAgregar;
        Puntos clusterAgregar;
        //double[][] matrizNueva = matriz;
        
        puntoAgregar = listaPuntos.get(punto);
            
        clusterAgregar = listaPuntos.get(cluster);
        
        for (int i = 0; i < tamano; i++) {
                
            if (i != cluster && distancias[i][punto] >= 0.0) {
                
                distancias[i][cluster] = Math.min(distancias[i][cluster], distancias[i][punto]);
                distancias[cluster][i] = Math.min(distancias[cluster][i], distancias[punto][i]);

                distancias[punto][i] = 0.0;
                distancias[i][punto] = 0.0;
            }
        }

        
        if (puntoAgregar.adyacentes.size() > 0) {
            
            if (clusterAgregar.adyacentes.size() > 0) {
                
                arregloClusters.remove(clusterAgregar);
                
                arregloClusters.remove(puntoAgregar);
                
                for (int i = 0; i < puntoAgregar.adyacentes.size(); i++) {
                    
                    Puntos puntoAuxiliar = puntoAgregar.adyacentes.get(i);
                    
                    clusterAgregar.adyacentes.add(puntoAuxiliar);
                          
                }
                
                puntoAgregar.adyacentes.removeAll(listaPuntos);
                
                clusterAgregar.adyacentes.add(puntoAgregar);
                
                arregloClusters.add(clusterAgregar);
                
            } else {
                
                arregloClusters.remove(puntoAgregar);
                
                for (int i = 0; i < puntoAgregar.adyacentes.size(); i++) {
                    
                    Puntos puntoAuxiliar = puntoAgregar.adyacentes.get(i);
                    
                    clusterAgregar.adyacentes.add(puntoAuxiliar);
                }
                
                puntoAgregar.adyacentes.removeAll(listaPuntos);
                
                arregloClusters.add(clusterAgregar);
            
            }
        
        } else {
            
            if (clusterAgregar.adyacentes.size() > 0) {
                
                arregloClusters.remove(clusterAgregar);
                
                clusterAgregar.adyacentes.add(puntoAgregar);
                
                arregloClusters.add(clusterAgregar);
                
            } else {
                
                clusterAgregar.adyacentes.add(puntoAgregar);
                
                arregloClusters.add(clusterAgregar);
                
                
            }
        }
    }
}

/*
        if (!arregloClusters.contains(clusterAgregado)) {
            
            if (arregloClusters.contains(puntoAgregar)) {
                
                for (int i = 0; i < puntoAgregar.adyacentes.size(); i++) {

                    Puntos puntoCambioCluster = puntoAgregar.adyacentes.get(i);

                    clusterAgregado.adyacentes.add(puntoCambioCluster);
                    
                }
                
                //puntoAgregar.adyacentes.removeAll(listaPuntos);
                
                clusterAgregado.adyacentes.add(puntoAgregar);
                
                arregloClusters.remove(puntoAgregar);
                
                arregloClusters.add(clusterAgregado);
                
            } else {
            
                
                clusterAgregado.adyacentes.add(puntoAgregar);
                arregloClusters.add(clusterAgregado);
                
            }
                        
        } else {
            
            if (arregloClusters.contains(puntoAgregar)) {
                
                arregloClusters.remove(clusterAgregado);
                
                //System.out.println(clusterAgregado.adyacentes.size() + " Tamano");

                for (int i = 0; i < puntoAgregar.adyacentes.size(); i++) {

                    Puntos puntoCambioCluster = puntoAgregar.adyacentes.get(i);

                    clusterAgregado.adyacentes.add(puntoCambioCluster);
                }
                
                puntoAgregar.adyacentes.removeAll(listaPuntos);
                
                clusterAgregado.adyacentes.add(puntoAgregar);
                
                arregloClusters.remove(puntoAgregar);
                
                arregloClusters.add(clusterAgregado);

            } else {
                
                arregloClusters.remove(clusterAgregado);
               
                clusterAgregado.adyacentes.add(puntoAgregar);
                
                arregloClusters.add(clusterAgregado);
                
                }

            }
           
        }
            
        //System.out.println(clusterAgregado.adyacentes.toString());
        
        //System.out.println(arregloClusters.toString() + "");
    
    @Override
    
    public String toString() {
        return nombre; 
    }
}

               
        
        //System.out.println(arregloClusters.isEmpty());
        
        /*
        
        if (puntoAgregar.nombre == "punto N 2624"){
            System.out.println (clusterAgregado.nombre + " clusterAgregado");
            System.out.println (puntoAgregar.nombre + " puntoAgregar");
            System.out.println (arregloClusters.contains(clusterAgregado) + " Contiene a clusterAgregado?");
            System.out.println (arregloClusters.contains(puntoAgregar)  + " Contiene a puntoAgregar?");
        }
        
        if (arregloClusters.size() == 163) {
            System.out.println (clusterAgregado.nombre + " clusterAgregado");
            System.out.println (puntoAgregar.nombre + " puntoAgregar");
            System.out.println (arregloClusters.contains(clusterAgregado) + " Contiene a clusterAgregado?");
            System.out.println (arregloClusters.contains(puntoAgregar)  + " Contiene a puntoAgregar?");
            System.out.print("Segunda");
            //System.exit(0);
        } 
        /*
            
            for (int i = 0; i < distancias.length; i++) {
                
                for (int j = 0; j < distancias.length;j++) {
                    
                    System.out.print("[");
                    System.out.print(distancias[i][j]);
                    System.out.print("]");
                    
                }
                
                System.out.println();
            }
        
            
            System.exit(0);
            */
        

/*if (arregloClusters.size() == 163) {
                    //System.out.println(distancias[i][cluster] + " " + distancias[i][punto] + " PRE");
                    //System.out.println (puntoAgregar.nombre + " puntoAgregar");
                    System.out.println (i + " I que se queda pegado");
                } */

/* if (arregloClusters.size() == 163) {
            
            System.out.println("reinicio");
        
            System.out.println(arregloClusters.contains(clusterAgregado) + " Condicion1");

            System.out.println(arregloClusters.contains(puntoAgregar) + " Condicion2");
        
        } 
        */