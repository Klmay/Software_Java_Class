import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorScrolls extends Application {
    private Text text = new Text("Look at all these colors!");
    private ScrollBar sbRed = new ScrollBar();
    private ScrollBar sbGreen = new ScrollBar();
    private ScrollBar sbBlue = new ScrollBar();
    private ScrollBar sbOpacity = new ScrollBar();

    @Override
    public void start(Stage primaryStage) {
        text.setFont(Font.font(30));
        sbRed.setMax(1);
        sbGreen.setMax(1);
        sbBlue.setMax(1);
        sbOpacity.setMax(1);
        sbOpacity.setValue(1);
        sbRed.valueProperty().addListener(ov -> updateColor());
        sbGreen.valueProperty().addListener(ov -> updateColor());
        sbBlue.valueProperty().addListener(ov -> updateColor());
        sbOpacity.valueProperty().addListener(ov -> updateColor());

        GridPane paneForBars = new GridPane();
        paneForBars.setAlignment(Pos.CENTER);
        paneForBars.setHgap(10);
        paneForBars.setVgap(10);
        paneForBars.add(new Label("Red"), 0, 0);
        paneForBars.add(sbRed, 1, 0);
        paneForBars.add(new Label("Green"), 0, 1);
        paneForBars.add(sbGreen, 1, 1);
        paneForBars.add(new Label("Blue"), 0, 2);
        paneForBars.add(sbBlue, 1, 2);
        paneForBars.add(new Label("Opacity"), 0, 3);
        paneForBars.add(sbOpacity, 1, 3);

        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(text);
        mainPane.setBottom(paneForBars);

        Scene scene = new Scene(mainPane, 400, 250);
        primaryStage.setTitle("Color Scrolls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateColor() {
        text.setFill(new Color(sbRed.getValue(), sbGreen.getValue(), sbBlue.getValue(), sbOpacity.getValue()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}