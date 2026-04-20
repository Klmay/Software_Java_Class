import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FourImages extends Application {
     @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        ImageView iv1 = new ImageView(new Image("file:images/tulips.jpg"));
        ImageView iv2 = new ImageView(new Image("file:images/lily.jpg"));
        ImageView iv3 = new ImageView(new Image("file:images/daisy.jpg"));
        ImageView iv4 = new ImageView(new Image("file:images/cherry.jpg"));

        iv1.setFitWidth(200); iv1.setPreserveRatio(true);
        iv2.setFitWidth(200); iv2.setPreserveRatio(true);
        iv3.setFitWidth(200); iv3.setPreserveRatio(true);
        iv4.setFitWidth(200); iv4.setPreserveRatio(true);

        pane.add(iv1, 0, 0);
        pane.add(iv2, 1, 0);
        pane.add(iv3, 0, 1);
        pane.add(iv4, 1, 1);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("FLOWERS! :D");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
