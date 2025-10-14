import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Stack;

import static javafx.application.Application.launch;

public class TheFinalDinner extends Application implements AppScene{
    @Override
    public Scene getScene(EventHandler<ActionEvent> goBack) {
        Label titleText = new Label("The Final Dinner");
        titleText.setFont(Font.font("Georgia",30));
        titleText.setStyle("-fx-font-weight:bold; -fx-text-fill: #FFFFFF;" +
                "-fx-background-color:#383288ff;"); //nts fix border color
        titleText.setLayoutX(725);

        Rectangle txtRectangle = new Rectangle(10, 10, 600, 300);
        txtRectangle.setFill(Color.hsb(244,0.727,0.173));
        txtRectangle.setStyle("-fx-stroke: #4D1005; -fx-stroke-width: 1");

        Text spookyTxt = new Text("The air feels stale. Between the spotlights of the moon, you can " +
                "see spiders crawling across the walls. You sit down to take a meal, and there is already " +
                "a platter in front of you.");
        spookyTxt.setWrappingWidth(550);
        spookyTxt.setFont(Font.font("Georgia", 27));
        spookyTxt.setStyle("-fx-fill: #faf7ff");
        spookyTxt.setLayoutX(17);
        spookyTxt.setLayoutY(37);

        Pane bgText = new Pane(txtRectangle, spookyTxt);

        Rectangle tableHead = new Rectangle(-670,360,400,20);
        tableHead.setFill(Color.SIENNA);
        tableHead.setStroke(Color.SADDLEBROWN);
        tableHead.setStrokeWidth(2);

        Rectangle tableLeg1 = new Rectangle(-680,380, 16,200);
        tableLeg1.setFill(Color.SIENNA);
        tableLeg1.setStroke(Color.SADDLEBROWN);
        tableLeg1.setStrokeWidth(2);

        Rectangle tableLeg2 = new Rectangle(-353, 380, 16, 200);
        tableLeg2.setFill(Color.SIENNA);
        tableLeg2.setStroke(Color.SADDLEBROWN);
        tableLeg2.setStrokeWidth(2);

        Pane table = new Pane(tableHead,tableLeg1,tableLeg2);
        tableHead.setLayoutX(0);
        tableHead.setLayoutX(700);
        tableLeg1.setLayoutX(50);
        tableLeg1.setLayoutX(740);
        tableLeg2.setLayoutX(160);
        tableLeg2.setLayoutX(740);
        table.setLayoutY(175);

        Button eatBtn = new Button("Enjoy your meal");
        eatBtn.setStyle("-fx-background-color: #c49e9eff;-fx-text-fill: #682020; " +
                "-fx-font-size: 26px; -fx-border radius: 8px;-fx-font-weight: bold;" +
                "-fx-border-color:#460e0e; -fx-font-family:Georgia;");
        eatBtn.setLayoutX(20);
        eatBtn.setLayoutY(325);
        Pane eat = new Pane(eatBtn);


        Button openNote = new Button("Read the message");
        openNote.setStyle("-fx-background-color:#cec7c7ff;-fx-text-fill:#291313;" +
                "-fx-font-size: 26px; " + "-fx-border radius: 8px;-fx-font-family:Georgia;");
        openNote.setLayoutX(20);
        openNote.setLayoutY(325);
        openNote.setVisible(false);

        Text headTxt = new Text("You lift the serving dish to find a severed head and" +
                " something engraved in the plate");
        headTxt.setWrappingWidth(550);
        headTxt.setFont(Font.font("Georgia", 27));
        headTxt.setStyle("-fx-fill: #faf7ff");
        headTxt.setLayoutX(17);
        headTxt.setLayoutY(37);
        headTxt.setVisible(false);

        Text noteTxt = new Text("Don't trust the voices.");
        noteTxt.setWrappingWidth(550);
        noteTxt.setFont(Font.font("Georgia", 27));
        noteTxt.setStyle("-fx-fill: #b61d1d");
        noteTxt.setLayoutX(17);
        noteTxt.setLayoutY(37);
        noteTxt.setVisible(false);

        Button homeBtn = new Button("Home");
        homeBtn.setStyle("-fx-background-color:#000000ff;-fx-text-fill:#ffffff;" +
                "-fx-font-size: 18px; " + "-fx-border radius: 8px;-fx-font-family:Georgia;");
        homeBtn.setLayoutX(915);
        homeBtn.setLayoutY(650);
        homeBtn.setVisible(true);

        eatBtn.setOnAction(e -> {
            spookyTxt.setVisible(false);
            headTxt.setVisible(true);
            eatBtn.setVisible(false);
            openNote.setVisible(true);
        });

        openNote.setOnAction(e -> {
            spookyTxt.setVisible(false);
            headTxt.setVisible(false);
            eatBtn.setVisible(false);
            openNote.setVisible(false);
            noteTxt.setVisible(true);
        });




        Pane layout = new Pane(titleText,bgText, table, eat, openNote, headTxt,noteTxt,homeBtn);
        layout.setBackground(Background.fill(Color.hsb(244,0.632,0.535)));


        Scene displayScene = new Scene(layout, 1000, 700);
        return displayScene;
    }

    public void start(Stage primaryStage) throws Exception{
        Scene scene = getScene(null);
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Final Dinner");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
