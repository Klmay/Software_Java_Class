package Module6;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;

public class ConnectingDatabase extends Application {
    private Connection connection;
    private Label lblStatus = new Label("Batch Update's Current Status:");
    private TextArea taResult = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        Button btnConnectDB = new Button("Connect to Database");
        Button btnBatch = new Button("Batch Update");
        Button btnNonBatch = new Button("Non-Batch Update");

        HBox topPane = new HBox(20, lblStatus, btnConnectDB);
        HBox bottomPane = new HBox(10, btnBatch, btnNonBatch);
        
        BorderPane mainPane = new BorderPane();
        mainPane.setTop(topPane);
        mainPane.setCenter(taResult);
        mainPane.setBottom(bottomPane);

        btnConnectDB.setOnAction(e -> {
            Stage dialog = new Stage();
            DBConnection connPane = new DBConnection();
            connPane.getBtnClose().setOnAction(ev -> {
                this.connection = connPane.getConnection();
                dialog.close();
            });

            dialog.setScene(new Scene(connPane, 450, 250));
            dialog.setTitle("Connect to DB");
            dialog.show();
        });

        btnBatch.setOnAction(e -> runUpdate(true));
        btnNonBatch.setOnAction(e -> runUpdate(false));

        primaryStage.setScene(new Scene(mainPane, 500, 350));
        primaryStage.setTitle("ConnectingDatabase - school");
        primaryStage.show();
    }

    private void runUpdate(boolean useBatch) {
        if (connection == null) {
            taResult.appendText("You need to connect to a database first.\n");
            return;
        }

        String sql = "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < 1000; i++) {
                pstmt.setDouble(1, Math.random());
                pstmt.setDouble(2, Math.random());
                pstmt.setDouble(3, Math.random());
                
                if (useBatch) {
                    pstmt.addBatch();
                } else {
                    pstmt.executeUpdate();
                }
            }

            if (useBatch) pstmt.executeBatch();
            
            long endTime = System.currentTimeMillis();
            String type = useBatch ? "Batch" : "Non-Batch";
            
            taResult.appendText(type + " update completed\n");
            taResult.appendText("The elapsed time is " + (endTime - startTime) + "\n\n");
            lblStatus.setText(type + " update succeeded");

        } catch (SQLException ex) {
            taResult.appendText("Error: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
