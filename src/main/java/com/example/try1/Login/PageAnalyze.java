package com.example.try1.Login;

import com.example.try1.oop.Day_Information;
import com.example.try1.oop.User;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;
import java.util.ArrayList;

public class PageAnalyze implements Serializable {

    public LineChart Chart;
    public AnchorPane Anchorpane;

    private Home home;



    public void pageanalyze(Home home , User user , boolean Dark_Mod){

        this.home =home;


        if (Dark_Mod) {
            Anchorpane.setStyle("-fx-background-color: #767676;");
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #ffffff;");
        }

        ArrayList<Day_Information> day_informations = user.getDay_informations();
        XYChart.Series series = new XYChart.Series<>();
        for (Day_Information day_information : day_informations) {
            series.getData().add(new XYChart.Data(String.valueOf(day_information.getLocalDate()), day_information.getViews()));
        }
        Chart.getData().add(series);

    }

    public void Back(MouseEvent mouseEvent) {
        home.back();
    }

}
