import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ColorChangingMouse extends Application {
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.PINK);
        
        circle.setOnMousePressed(e -> {
            circle.setFill(Color.PINK);
        });

        circle.setOnMouseReleased(e -> {
            circle.setFill(Color.WHITE);
        });

        StackPane pane = new StackPane(circle);
        Scene scene = new Scene(pane, 300, 300);

        primaryStage.setTitle("Click the circle to change its color! :D");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
