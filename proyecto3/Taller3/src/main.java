/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Douglas Torres
 * Carnet: 11-11027
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        for (int i=0; i<1;i++){
            
            String nombreGrafo = "grafo" + i;
            
            long startTime = System.currentTimeMillis();
            
            /** El programa da problemas para leer el archivo aun cuando esta igual
            que en el programa del Taller1 que si leia bien los archivos
            Se probo incluso el colocar la ruta directa, pero sin ningun resultado.
           
            Ante dicha falla no se pudo verificar la correctitud del programa, 
            * mas alla de la verificacion del codigo de Prim. Espero poder
            * solventar dicha falla en una proxima consulta  **/
       
            Grafo grafo = new Grafo(nombreGrafo);
            
            grafo.FloydWarshall();
             
            long endTime = System.currentTimeMillis(); 
            
            long finalTime = endTime - startTime;
            
            System.out.println ("El tiempo de corrida para el " + nombreGrafo + " es " + finalTime);
            
    }
}
}