package com.example.try1.Login;



import com.example.try1.oop.Day_Information;
import com.example.try1.oop.Post;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.io.Serializable;
import java.util.ArrayList;

public class PostAnalyze implements Serializable {

    public LineChart Chart;
    public AnchorPane Anchorpane;
    public javafx.scene.control.Button Button;

    private Home home;


    public void postanalyze(Home home , Post post , boolean Dark_Mod){

        this.home =home;


        if (Dark_Mod) {
            Anchorpane.setStyle("-fx-background-color: #1A1A1D;");
            Button.setStyle("-fx-background-color: #6F2232;");
            Button.setTextFill(Paint.valueOf("WHITE"));
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #ffffff;");
        }

        ArrayList<Day_Information> day_informations = post.getDay_informations();
        XYChart.Series series = new XYChart.Series<>();
        XYChart.Series series1 = new XYChart.Series<>();

        for (Day_Information day_information : day_informations) {
            series.getData().add(new XYChart.Data(String.valueOf(day_information.getLocalDate()), day_information.getViews()));
            series1.getData().add(new XYChart.Data(String.valueOf(day_information.getLocalDate()), day_information.getLikes()));
        }

        Chart.getData().add(series);
        Chart.getData().add(series1);

    }

    public void Back(MouseEvent mouseEvent) {
        home.back();
    }

}
