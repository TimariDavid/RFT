import com.mysql.jdbc.ResultSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    private JPasswordField passwordField;
    private JTextField usernameField;
    private JButton belepesButton;
    private Db dbcontroller;
    private JPanel panelBelepes;

    public App()   {
        this.dbcontroller = new Db();
        this.dbcontroller.connectDatabase();

        belepesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()){
                    if(usernameField.getText().isEmpty()){
                        usernameField.setBorder(BorderFactory.createLineBorder(Color.red));
                    }else{
                        usernameField.setBorder(BorderFactory.createLineBorder(Color.black));
                    }
                    if(passwordField.getText().isEmpty()){
                        passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
                    }else{
                        passwordField.setBorder(BorderFactory.createLineBorder(Color.black));
                    }
                }else{
                    String usernameGiven = usernameField.getText();
                    String passwordGiven = passwordField.getText();

                     ResultSet resultSet = (ResultSet) dbcontroller.sqlSelect("SELECT * FROM users");

                    try{
                        int isTeacher = -1;

                        while (resultSet.next()){
                            if(resultSet.getString("username").equals(usernameGiven)){
                                isTeacher = Integer.parseInt(resultSet.getString("isTeacher"));

                                if(resultSet.getString("password").equals(passwordGiven)){
                                    System.out.println("Bejelentkezés sikeres");
                                    if(isTeacher == 1){
                                        JFrame frame = new JFrame("Tárgy kiírás");
                                        frame.getContentPane().add(new TanarForm().getPanelTanar());
                                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        frame.pack();
                                        frame.setLocationRelativeTo(null);
                                        frame.setVisible(true);
                                    }else{
                                        JFrame frame = new JFrame("Tárgy felvétel");
                                        frame.getContentPane().add(new HallgatoForm().getPanelHallgato());
                                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        frame.pack();
                                        frame.setLocationRelativeTo(null);
                                        frame.setVisible(true);
                                    }
                                }else{
                                    System.out.println("Hibás a jelszó");
                                }
                            }else{
                                System.out.println("Hibás a felhasználónév");
                            }
                        }
                    }catch (SQLException ee){
                        ee.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("App");
        frame.getContentPane().add(new App().panelBelepes);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
