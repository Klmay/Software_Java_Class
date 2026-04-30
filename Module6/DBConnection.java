package Module6;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.sql.*;

public class DBConnection extends BorderPane {
    private ComboBox<String> cboDriver = new ComboBox<>();
    private ComboBox<String> cboURL = new ComboBox<>();
    private TextField tfUsername = new TextField();
    private PasswordField pfPassword = new PasswordField();
    private Button btnConnect = new Button("Connect to Database");
    private Button btnClose = new Button("Close Dialog");
    private Label lblStatus = new Label("Sorry, no connection");
    private Connection connection;

    public DBConnection() {
        GridPane grid = new GridPane();
        grid.setHgap(5); grid.setVgap(5);
        grid.add(new Label("JDBC Driver"), 0, 0);
        grid.add(cboDriver, 1, 0);
        grid.add(new Label("Database URL"), 0, 1);
        grid.add(cboURL, 1, 1);
        grid.add(new Label("Username"), 0, 2);
        grid.add(tfUsername, 1, 2);
        grid.add(new Label("Password"), 0, 3);
        grid.add(pfPassword, 1, 3);

       
        cboDriver.getItems().add("com.mysql.jdbc.Driver");
        cboDriver.setEditable(true);
        cboURL.setEditable(true);

        HBox buttonBox = new HBox(10, btnConnect, btnClose);
        VBox bottomBox = new VBox(5, lblStatus, buttonBox);
        
        setCenter(grid);
        setBottom(bottomBox);

        btnConnect.setOnAction(e -> connect());
    }

    private void connect() {
        try {
            Class.forName(cboDriver.getValue());
            connection = DriverManager.getConnection(cboURL.getValue(), tfUsername.getText(), pfPassword.getText());
            lblStatus.setText("Connected to " + cboURL.getValue());
        } catch (Exception ex) {
            lblStatus.setText("Connection failed: " + ex.getMessage());
        }
    }

    public Connection getConnection() { return connection; }
    public Button getBtnClose() { return btnClose; }
}
