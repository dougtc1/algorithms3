/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dougtc
 */
public class Main {
    
     public static void main(String[] args) {
         
        int [] resultado = new int [2];
        
        int cantidad;
         
        String s = args[0];
        Puntos.leerArchivo(s);
        
        cantidad = Puntos.tamano;
        
        Puntos.matrizDistancia();
        
        System.out.println(Puntos.kclusters + " - Clusters // " + cantidad + " - Cantidad");
         
        while(Puntos.kclusters != cantidad) {
         
            resultado = Puntos.minimaDistancia();
         
            int indX = resultado[0];
            int indY = resultado[1];

            System.out.println("(" + indX + "," + indY + ")" + " - PUNTO CON DISTANCIA MINIMA" );
            
         
            Puntos.actualizarMatriz(indX, indY);
            
            cantidad--;         

        }
        
        System.out.println("Matriz de distancias");
        
        for (int i = 0; i < Puntos.tamano; i++) {
            
            
            for (int j = 0; j < Puntos.tamano; j++) {
                
                System.out.print("[");
                System.out.print(Puntos.distancias[i][j]);
                System.out.print("]");
                
            }
            
            System.out.print("\n");
        }
        
        System.out.println(Puntos.kclusters + " - Clusters // " + cantidad + " - Cantidad");
    
    }
}

// Cambie el archivo para el de ocho puntos (el que esta en el enunciado)
// NOTAS:

// Esta dejando solo una linea en blanco (la del septimo punto)
// 1er Cluster: Puntos 0,1,4,7
// 2do Cluster: Punto 2
// 3er Cluster: Punto 3

// Borre una parte del actualizar matriz que tengo que recuperar del documento en el dropbox

// Falta es guardar los clusters en lugares donde los pueda imprimir con el freechart 