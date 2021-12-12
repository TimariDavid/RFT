import com.mysql.jdbc.ResultSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class App {

    private JPasswordField passwordField;
    private JTextField usernameField;
    private JButton belepesButton;
    private Db dbConnector;
    private JPanel panelBelepes;
    private static int userId;
    private JCheckBox ch_isTeacher;
    private JPasswordField isTeacherField;
    private JLabel labelForTeacher;
    private final int teacherValidator = 0000;


    public static int getUserId() {
        return userId;
    }

    private void setUserId(int userId) {
        this.userId = userId;
    }

    public App()   {
        this.dbConnector = Db.getInstance();

        belepesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(ch_isTeacher.isSelected()){
                    if(isTeacherField.getText().isEmpty()){
                        isTeacherField.setBorder(BorderFactory.createLineBorder(Color.red));
                    }else{
                        isTeacherField.setBorder(BorderFactory.createLineBorder(Color.black));
                        if(Integer.parseInt(isTeacherField.getText()) == teacherValidator){
                            String sql = "INSERT INTO users (username, password, isTeacher) VALUES ("+"'"+usernameField.getText()+"'"+", "+"'"+passwordField.getText()+"'"+", "+"'1'"+")";
                            dbConnector.sqlInsert(sql);
                        }else{
                            isTeacherField.setBorder(BorderFactory.createLineBorder(Color.red));
                        }
                    }
                }else{
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

                        ResultSet resultSet = (ResultSet) dbConnector.sqlSelect("SELECT * FROM users");

                        try{
                            int isTeacher = -1;

                            while (resultSet.next()){
                                if(resultSet.getString("username").equals(usernameGiven)){
                                    isTeacher = Integer.parseInt(resultSet.getString("isTeacher"));

                                    if(resultSet.getString("password").equals(passwordGiven)){
                                        System.out.println("Bejelentkezés sikeres");
                                        setUserId(resultSet.getInt("ID"));
                                        System.out.println(getUserId());
                                        if(isTeacher == 1){
                                            JFrame frameTanar = new JFrame("Tárgy kiírás");
                                            frameTanar.getContentPane().add(new TanarForm().getPanelTanar());
                                            frameTanar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            frameTanar.setSize(300,400);
                                            frameTanar.setLocationRelativeTo(null);
                                            panelBelepes.setVisible(false);
                                            frameTanar.setVisible(true);
                                        }else{
                                            JFrame frameHallgato = new JFrame("Tárgy felvétel");
                                            frameHallgato.getContentPane().add(new HallgatoForm().getPanelHallgato());
                                            frameHallgato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            frameHallgato.setSize(300,400);
                                            frameHallgato.setLocationRelativeTo(null);
                                            panelBelepes.setVisible(false);
                                            frameHallgato.setVisible(true);
                                        }
                                    }else{
                                        passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
                                    }
                                }else{
                                    usernameField.setBorder(BorderFactory.createLineBorder(Color.red));
                                }
                            }
                        }catch (SQLException ee){
                            ee.printStackTrace();
                        }
                    }
                }
            }
        });
        ch_isTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ch_isTeacher.isSelected()){
                    belepesButton.setText("Regisztráció");
                    isTeacherField.setVisible(true);
                    labelForTeacher.setVisible(true);
                }else{
                    belepesButton.setText("Belépés");
                    isTeacherField.setVisible(false);
                    labelForTeacher.setVisible(false);
                }
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("App");
        frame.getContentPane().add(new App().panelBelepes);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(400,300);
    }

}
