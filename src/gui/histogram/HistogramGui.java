package gui.chart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;

/**
 *
 * @author moles
 */
public class HistogramGui extends Application {
    private static BufferedImage bufferedImage;


    public HistogramGui() {

    }

    /**
     *
     * @param primaryStage primary stage is main scene(grafic_
     * @throws Exception wrong configuration
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("window.fxml"));
        loader.setController(new Controller());
        Parent root = loader.load();
        Scene scene=new Scene(root);
        scene.getStylesheets().add("gui/chart/style.css");
        primaryStage.setTitle("ChartBar");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
    public void showHistogram(){
        launch(null);
    }

    public static BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public static void setBufferedImage(BufferedImage bufferedImage) {
        HistogramGui.bufferedImage = bufferedImage;
    }
}
