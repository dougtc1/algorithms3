import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.util.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;
import org.jfree.chart.renderer.xy.XYDotRenderer;


/**
 *
 * @author dougtc
 */
public class GraficaPuntos extends ApplicationFrame {
    
    JPanel cuadro;
    
    public GraficaPuntos(String s) {
       
        
        super(s);
        
        System.out.println("PRUEBA1");

        final XYDataset dataset = SetPuntos();
        
        System.out.println("PRUEBA2");
        
        final JFreeChart chart = crearPanel(dataset);
        
        System.out.println("PRUEBA3");
        cuadro = new JPanel();
        getContentPane().add(cuadro);
        
        System.out.println("PRUEBA4");
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(780, 420));
        cuadro.add(chartPanel);
        
        System.out.println("PRUEBA5");
        
        
        
        
        
    }
    
    public static XYDataset SetPuntos() {
        
        XYSeriesCollection resultado = new XYSeriesCollection();
    
        for (int i = 0; i < Puntos.arregloClusters.size(); i++) {
                        
            XYSeries serieDePuntos = new XYSeries("Puntos" + i);
            
            Puntos puntoAuxiliar = Puntos.arregloClusters.get(i);
            
            double ordenada = puntoAuxiliar.coordX;
            
            double abcisa = puntoAuxiliar.coordY;
            
            serieDePuntos.add(ordenada, abcisa);
        
            for (int j = 0; j < puntoAuxiliar.adyacentes.size(); j++) {
                
                Puntos puntoAuxiliar2 = puntoAuxiliar.adyacentes.get(j);
                
                double ordenada2 = puntoAuxiliar2.coordX;
            
                double abcisa2 = puntoAuxiliar2.coordY;
                
                serieDePuntos.add(ordenada2, abcisa2);
            
            }
            
            resultado.addSeries(serieDePuntos);
                
            //IMPRIMIR
        
        }
        
    return resultado;
    
    }
        
    
    public static JFreeChart crearPanel(XYDataset dataset) {
        
        
        final JFreeChart chart = ChartFactory.createScatterPlot(
            "K = " + Puntos.kclusters,      // chart title
            "X",                      // x axis label
            "Y",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );
        
        return chart;
        
    }
        
        
        
        

       /* JFreeChart jfreechart = ChartFactory.createScatterPlot("k = " + Puntos.kclusters,
            "X", "Y", SetPuntos(), PlotOrientation.VERTICAL, true, true, false);
        
        Shape cross = ShapeUtilities.createDiagonalCross(1, 3);
        XYDotRenderer circulos = new XYDotRenderer();

        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setBaseShape(cross);
        renderer.setBasePaint(Color.red);
        //changing the Renderer to XYDotRenderer
        //xyPlot.setRenderer(new XYDotRenderer());
        xyPlot.setRenderer(circulos);
        circulos.setSeriesShape(0, cross);
        

        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);

        return new ChartPanel(jfreechart); 
        
        JFreeChart jfreechart = ChartFactory.createScatterPlot("k = " + Puntos.kclusters,
            "X", "Y", SetPuntos(), PlotOrientation.VERTICAL, true, true, false);
        Shape cross = ShapeUtilities.createDiagonalCross(3, 1);

        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setBaseShape(cross);
        renderer.setBasePaint(Color.red);
        //changing the Renderer to XYDotRenderer
        //xyPlot.setRenderer(new XYDotRenderer());
        XYDotRenderer xydotrenderer = new XYDotRenderer();
        xyPlot.setRenderer(xydotrenderer);
        xydotrenderer.setSeriesShape(0, cross);

        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);

        return new ChartPanel(jfreechart);
               */
    }        