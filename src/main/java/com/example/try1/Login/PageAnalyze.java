package com.example.try1.Login;

import com.example.try1.oop.Day_Information;
import com.example.try1.oop.User;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class PageAnalyze {

    public LineChart Chart;
    private Home home;
    private User user;


    public void pageanalyze(Home home , User user){

        this.home =home;
        this.user =user;

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
