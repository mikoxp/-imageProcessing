package gui.histogram;


import histogram.Histogram;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *@author moles
 */
public class HistogramController implements Initializable {
    private Histogram histogram;
    @FXML
    private BarChart<String,Integer> red;

    @FXML
    private BarChart<String,Integer> green;

    @FXML
    private BarChart<String,Integer> blue;

    public HistogramController() {

    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        setChart();
        BufferedImage bufferedImage=HistogramGui.getBufferedImage();
        histogram=new Histogram(bufferedImage);
        redChartData();
        greenChartData();
        blueChartData();
    }

    /**
     * set axis name
     */
    private void setChart(){
        Axis<String> xAxis = red.getXAxis();
        Axis<Integer> yAxis = red.getYAxis();
        Axis<String> xAxis1 = green.getXAxis();
        Axis<Integer> yAxis2 = green.getYAxis();
        Axis<String> xAxis2 = blue.getXAxis();
        Axis<Integer> yAxis1 = blue.getYAxis();
        xAxis.setLabel("Value");
        xAxis1.setLabel("Value");
        xAxis2.setLabel("Value");
        yAxis.setLabel("Number of value");
        yAxis1.setLabel("Number of value");
        yAxis2.setLabel("Number of value");
    }

    /**
     * set red chart data
     */
    @FXML
    private void redChartData(){
        XYChart.Series<String,Integer> series1=new XYChart.Series<String,Integer>();
        XYChart.Series<String,Integer> series2=new XYChart.Series<String,Integer>();
        XYChart.Series<String,Integer> series3=new XYChart.Series<String,Integer>();
        int[] data=histogram.getRedHistogram();
        String x;
        for(int i=0;i<255;i++){
            x=""+(i+1);
            series1.getData().add(new XYChart.Data<String,Integer>(x, data[i]));
        }
        red.getData().add(series1);
    }

    /**
     * set blue chart data
     */
    @FXML
    private void blueChartData(){
        XYChart.Series<String,Integer> series1=new XYChart.Series<String,Integer>();
        XYChart.Series<String,Integer> series2=new XYChart.Series<String,Integer>();
        XYChart.Series<String,Integer> series3=new XYChart.Series<String,Integer>();
        int[] data=histogram.getBlueHistogram();
        String x;
        for(int i=0;i<255;i++){
            x=""+(i+1);
            series3.getData().add(new XYChart.Data<String,Integer>(x, data[i]));
        }
        blue.getData().addAll(series1,series2,series3);
    }

    /**
     * set green chart data
     */
    @FXML
    private void greenChartData(){
        XYChart.Series<String,Integer> series1=new XYChart.Series<String,Integer>();
        XYChart.Series<String,Integer> series2=new XYChart.Series<String,Integer>();
        XYChart.Series<String,Integer> series3=new XYChart.Series<String,Integer>();
        int[] data=histogram.getGreenHistogram();
        String x;
        for(int i=0;i<255;i++){
            x=""+(i+1);
            series2.getData().add(new XYChart.Data<String,Integer>(x, data[i]));
        }
        green.getData().addAll(series1,series2,series3);
    }


}
