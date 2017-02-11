import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.util.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;
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
        
        boolean grafica = true;
        
        String s;
        
        if (args.length == 1) {
            
            s = args[0];
            
            
        } else if ( args.length == 2 && "-q".equals(args[0])) {
            
            s = args[1];
            
            grafica = false;
        
        } else {
            
            //System.out.println("El programa fue llamado de forma incorrecta.");
            
            s = "puntosprueba.dat";
            
            //System.exit(0);
            
        }
            
        Puntos.leerArchivo(s);
        
        cantidad = Puntos.tamano;
        
        long startTime = System.currentTimeMillis();
        
        Puntos.matrizDistancia();
        
        System.out.println(Puntos.kclusters + " - Clusters // " + cantidad + " - Cantidad  ---- PRIMERO");
        
        while(Puntos.kclusters != Puntos.arregloClusters.size() || cantidad > Puntos.kclusters) {
         
            if (Puntos.arregloClusters.size()==163) {
                System.out.println("AQUI");
            }
            
            resultado = Puntos.minimaDistancia();
         
            int cluster = resultado[0];
            int punto = resultado[1];

            //System.out.println("(" + cluster + "," + punto + ")" + " - PUNTO CON DISTANCIA MINIMA" );
            
         
            Puntos.actualizarMatriz(cluster, punto);
            
            //System.out.println(Puntos.arregloClusters.size());
            
            cantidad = cantidad -1;         

        }
        
        long endTime = System.currentTimeMillis(); 
        
        long finalTime = endTime - startTime;
        
        System.out.println ("El tiempo de corrida es: " + finalTime);
        
        System.out.println(Puntos.kclusters + " - Clusters // " + cantidad + " - Cantidad ---SEGUNDO");
    
    
        System.out.println(Puntos.arregloClusters.size());
                
    if (grafica) {
        
        
        final GraficaPuntos panel = new GraficaPuntos("k = " + Puntos.kclusters);
        
        System.out.println("PRUEBA AFUERA");
        
        panel.pack();
        panel.setVisible(true);
        RefineryUtilities.centerFrameOnScreen(panel);
        
        //GraficaPuntos.graficaPuntos(Puntos.kclusters);       
    }
        
    
    }
} 

        //System.out.println("Matriz de distancias");
        
        /*for (int i = 0; i < Puntos.tamano; i++) {
            
            
            for (int j = 0; j < Puntos.tamano; j++) {
                
                System.out.print("[");
                System.out.print(Puntos.distancias[i][j]);
                System.out.print("]");
                
            }
            
            System.out.print("\n");
        }
        */