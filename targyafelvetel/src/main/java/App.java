import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    private JPasswordField passwordField;
    private JTextField textField;
    private JButton belepesButton;
    private JPanel panelBelepes;

    public App() {
        belepesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/rft";
        String username = "rftuser";
        String password = "rklBLpiccvBpYeDn";

        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        JFrame frame = new JFrame("App");
        frame.getContentPane().add(new App().panelBelepes);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
