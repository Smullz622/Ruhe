/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author apl5638
 */
public class MoodMainUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private PieChart pieChart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> pieChartData
                =FXCollections.observableArrayList(
                new PieChart.Data("Happy", 1),
                new PieChart.Data("Sad", 2),
                new PieChart.Data("Angry", 3),
                new PieChart.Data("Annoyed", 4));
        
        pieChart.setData(pieChartData);
        pieChart.setStartAngle(90);
    }    
    
}
