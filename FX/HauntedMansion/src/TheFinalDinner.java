import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TheFinalDinner extends HauntedScene{

    public TheFinalDinner(SceneSetter sceneSetter) {
        super(sceneSetter);
    }

    public Text makeText(String message, int wrapping, String font, int size, String style, int xLayout, int yLayout,
                         boolean isVisible){
        Text newText = new Text(message);
        newText.setWrappingWidth(wrapping);
        newText.setFont(Font.font(font, size));
        newText.setStyle(style);
        newText.setLayoutX(xLayout);
        newText.setLayoutY(yLayout);
        newText.setVisible(isVisible);
        return newText;
    }

    public Rectangle makeRectangle(int xPos, int yPos, int width, int height,
                                   Color fillColor, Color borderColor, int strokeWidth, boolean isVisible){
        Rectangle newRectangle = new Rectangle(xPos, yPos, width, height);
        newRectangle.setFill(fillColor);
        newRectangle.setStroke(borderColor);
        newRectangle.setStrokeWidth(strokeWidth);
        newRectangle.setVisible(isVisible);
        return newRectangle;
    }

    public Rectangle makeRectangle(int xPos, int yPos, int width, int height, int hue, double saturation,
                                   double brightness, String style, boolean isVisible){
        Rectangle bgRectangle = new Rectangle(xPos, yPos, width, height);
        bgRectangle.setFill(Color.hsb(hue,saturation,brightness));
        bgRectangle.setStyle(style);
        bgRectangle.setVisible(isVisible);
        return bgRectangle;
    }

    public Label makeLabel(String name, String font, int size, String style, int xLayout, boolean isVisible){
        Label newLabel = new Label(name);
        newLabel.setFont(Font.font(font,size));
        newLabel.setStyle(style); //nts fix border color
        newLabel.setLayoutX(xLayout);
        newLabel.setVisible(isVisible);
        return newLabel;
    }

    public Button makeButton(String text, String style, int xLayout, int yLayout, boolean isVisible){
        Button newButton = new Button(text);
        newButton.setStyle(style);
        newButton.setLayoutX(xLayout);
        newButton.setLayoutY(yLayout);
        newButton.setVisible(isVisible);
        return newButton;
    }

    public static void setVisibility(boolean visibility, Node... nodes) {
        for(Node n : nodes) {
            n.setVisible(visibility);
        }
    }

    public static void setGroupLayout(Node node, Rectangle rect1, int xPos1, Rectangle rect2, int xPos2,
                                      Rectangle rect3, int xPos3, int yLayout){
        rect1.setLayoutX(xPos1);
        rect2.setLayoutX(xPos2);
        rect3.setLayoutX(xPos3);
        node.setLayoutY(yLayout);
    }

    String introParagraph = "The air feels stale. Between the spotlights of the moon, you can " +
            "see spiders crawling across the walls. You sit down to take a meal, and there is already " +
            "a platter in front of you.";

    String eatButtonStyle = "-fx-background-color:#c49e9eff;-fx-text-fill: #682020;-fx-font-size: 26px;" +
            " -fx-border radius: 8px;-fx-font-weight: bold;-fx-border-color:#460e0e; -fx-font-family:Georgia;";

    String openNoteBtnStyle = "-fx-background-color:#cec7c7ff;-fx-text-fill:#291313;" +
            "-fx-font-size: 26px; " + "-fx-border radius: 8px;-fx-font-family:Georgia;";

    String homeBtnStyle = "-fx-background-color:#000000ff;-fx-text-fill:#ffffff;" +
            "-fx-font-size: 18px; " + "-fx-border radius: 8px;-fx-font-family:Georgia;";


    @Override
    public Scene getScene() {
        Label titleText = makeLabel("The Final Dinner", "Georgia", 30,
                "-fx-font-weight:bold; -fx-text-fill: #FFFFFF; -fx-background-color:#383288ff;",
                725, true);
        Rectangle txtRectangle = makeRectangle(10,10,600,300,244,
                0.727,0.173, "-fx-stroke: #4D1005; -fx-stroke-width: 1", true);
        Text spookyTxt = makeText(introParagraph, 550, "Georgia", 27,
                "-fx-fill: #faf7ff", 17, 37, true);
        Pane bgText = new Pane(txtRectangle, spookyTxt);

        Rectangle tableHead = makeRectangle(-670, 360, 400, 28, Color.SIENNA,
                Color.SADDLEBROWN, 2, true);
        Rectangle tableLeg1 = makeRectangle(-680, 387, 16, 200, Color.SIENNA,
                Color.SADDLEBROWN, 2, true);
        Rectangle tableLeg2 = makeRectangle(-353, 387, 16, 200, Color.SIENNA,
                Color.SADDLEBROWN, 2, true);
        Pane table = new Pane(tableHead,tableLeg1,tableLeg2);
        setGroupLayout(table,tableHead,700,tableLeg1,740,tableLeg2,740,175);

        Text headTxt = makeText("You lift the serving dish to find a severed head and" +
                " something engraved in the plate", 550, "Georgia", 27, "-fx-fill: #faf7ff",
                17, 37, false);
        //Text noteTxt = makeText("Don't trust the voices.", 550, "monospace", 27,"-fx-fill: #b61d1d", 17, 37, false);

        Button homeBtn = makeButton("Home", homeBtnStyle, 915, 650, true);
        Button openNote = makeButton("Read the message", openNoteBtnStyle, 20, 325, false);
        Button eatBtn = makeButton("Enjoy your meal", eatButtonStyle, 20, 325, true);
        Pane eat = new Pane(eatBtn);

        homeBtn.setOnAction(e -> {
            setVisibility(true, spookyTxt,headTxt,eatBtn);
            setVisibility(false, headTxt,openNote);
            sceneSetter.goHome();
        });

        openNote.setOnAction(e -> {
            setVisibility(false, spookyTxt,headTxt,eatBtn,openNote);
            setVisibility(false);
            sceneSetter.goTo(letterScene());
            //sceneSetter.goHome();
        });

        eatBtn.setOnAction( e-> {
            setVisibility(false, spookyTxt, eatBtn);
            setVisibility(true, headTxt, openNote);
        });

        Pane layout = new Pane(titleText,bgText, table, eat, openNote, headTxt,homeBtn);
        layout.setBackground(Background.fill(Color.hsb(244,0.632,0.535)));
        Scene displayScene = new Scene(layout, 1000, 700);
        return displayScene;
    }

    public Scene letterScene(){
        Rectangle letter = makeRectangle(300,30,400,600,45,
                0.11,1.0,"-fx-stroke: #2e2601; -fx-stroke-width: 2",true);
        Text letterText = makeText("Don't trust the voices.", 550, "monospace", 27,
                "-fx-fill: #b61d1d", 315, 77, true);
        Button homeBtn = makeButton("Home", homeBtnStyle, 915, 650, true);

        homeBtn.setOnAction(e -> {
            sceneSetter.goHome();
        });

        Pane secondLayout = new Pane(letter, letterText, homeBtn);
        secondLayout.setBackground(Background.fill(Color.hsb(2,0.99,0.2)));
        return new Scene(secondLayout,1000,700);
    }
}
