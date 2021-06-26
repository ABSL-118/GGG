package CAADAA;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

public class CAADAA_Main {
    public class FXMain extends Application {
    
    ArrayList<Integer> comparisons = new ArrayList<>();
    static ArrayList<Integer> trans1 = new ArrayList<>();
    static ArrayList<Integer> trans2 = new ArrayList<>();
    static ArrayList<Integer> trans3 = new ArrayList<>();
    static ArrayList<Integer> lengths1 = new ArrayList<>();
    static ArrayList<Integer> lengths2 = new ArrayList<>();
    static ArrayList<Integer> lengths3 = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("LineChart Experiments");

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Number of Letters");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Transformations");

        LineChart lineChart = new LineChart(xAxis, yAxis);
        
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Sentences");
        
        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("Words");
        
        XYChart.Series dataSeries3 = new XYChart.Series();
        dataSeries3.setName("Phrases");
        
        for (int i = 0; i < lengths1.size(); i++) {

            dataSeries1.getData().add(new XYChart.Data(lengths1.get(i), trans1.get(i) ));
            
        }        
        for (int i = 0; i < lengths2.size(); i++) {

            dataSeries2.getData().add(new XYChart.Data(lengths2.get(i), trans2.get(i) ));
            
        }
        for (int i = 0; i < lengths3.size(); i++) {

            dataSeries3.getData().add(new XYChart.Data(lengths3.get(i), trans3.get(i) ));
            
        }        
        

        lineChart.getData().add(dataSeries1);
        lineChart.getData().add(dataSeries2);
        lineChart.getData().add(dataSeries3);

        VBox vbox = new VBox(lineChart);

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(1200);

        primaryStage.show();
    }
        
    public static void main(String[] args) {
        CAADAA a = new CAADAA();
        CAADAA b = new CAADAA();
        CAADAA c = new CAADAA();
        
        a.printCipher("ALLEN BRYANT LINESES", 2);
        a.printCipher("Not only the years we've been at war", 2);
        a.printCipher("Blood alone moves the wheels of history.", 2);
        a.printCipher("How long we have been striving for greatness?", 2);
        a.printCipher("Some people will tell you salesman is a badword", 2);
        a.printCipher("It has been a lifetime struggle A never-ending fight", 2);
        a.printCipher("No revolution is worth anything unless it can defend itself!", 2);
        a.printCipher("I say to you, and you will understand, that it is a privilege to fight!.", 2);
        a.printCipher("Have you ever asked yourselves in an hour of meditation, which everyone finds during the the.", 2);
        a.printCipher("the war of work but for the moment as a child when we realized that the world could be counquered.", 2);
        a.printCipher("They'll conjure up images of used car dealers and door to door chariatans. This is our duty: to change their perception", 2);
        a.printCipher("We are warriors! Salesmen of north-eastern Pennsylvania, I ask you once more: Rise and be worthy of this historical hour", 2);
        a.printCipher("We must never acquiesce, for it is together, TOGETHER, THAT WE WILL PREVAIL! We must never cede control of the motherland! For it is together we prevail!", 2);

        lengths1 = a.getLengths();
        trans1 = a.getTrans();
        
        b.printCipher("Amok", 2);
        b.printCipher("Wings", 2);
        b.printCipher("Three", 2);
        b.printCipher("Peril", 2);
        b.printCipher("Orator", 2);
        b.printCipher("Epitaph", 2);
        b.printCipher("Misnomer", 2);
        b.printCipher("Verboten", 2);
        b.printCipher("Oblivious", 2);
        b.printCipher("Ephemeral", 2);
        b.printCipher("Periphery", 2);
        b.printCipher("Remembered", 2);
        b.printCipher("Monotheism", 2);
        b.printCipher("Mellifluous", 2);
        b.printCipher("Onomatopoeia", 2);
        

        lengths2 = b.getLengths();
        trans2 = b.getTrans();

        
        c.printCipher("He who has a why", 2);
        c.printCipher("All the time huehue", 2);
        c.printCipher("To live can bear almost any how", 2);
        c.printCipher("Some people can read war and peace", 2);
        c.printCipher("Pleasant to hear that, sir or maam", 2);
        c.printCipher("Some people can read war and peace", 2);
        c.printCipher("It is not all things to all people", 2);
        c.printCipher("You do with the hands you're dealth", 2);
        c.printCipher("We do not get to choose how we start", 2);
        c.printCipher("in this life, Realn greatness is what", 2);
        c.printCipher("The truth is a matter of circumstance", 2);
        c.printCipher("And unlock the secrets of the universe", 2);
        c.printCipher("And come ayaw thinking it is a simple adventure", 2);
        c.printCipher("A man does not have wings, so he finds a way to fly", 2);
        c.printCipher("Story. Others can read the ingredients on a chewing gum wrapper", 2);
        c.printCipher("Everytime someone steps up and says who they are, the world becomes, more interesting place", 2);
        
        lengths3 = c.getLengths();
        trans3 = c.getTrans();

        launch(args);
    }
}
