package com.example.try1.Login;



import com.example.try1.oop.Day_Information;
import com.example.try1.oop.Post;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class PostAnalyze {

    public LineChart Chart;
    private Home home;
    private Post post;

    public void postanalyze(Home home , Post post){

        this.home =home;
        this.post =post;

        ArrayList<Day_Information> day_informations = post.getDay_informations();
        XYChart.Series series = new XYChart.Series<>();
        for (Day_Information day_information : day_informations) {
            series.getData().add(new XYChart.Data(String.valueOf(day_information.getLocalDate()), day_information.getViews()));
        }
        Chart.getData().add(series);
        XYChart.Series series1 = new XYChart.Series<>();
        for (Day_Information day_information : day_informations) {
            series1.getData().add(new XYChart.Data(String.valueOf(day_information.getLocalDate()), day_information.getLikes()));
        }
        Chart.getData().add(series1);

    }

    public void Back(MouseEvent mouseEvent) {
        home.back();
    }

}
