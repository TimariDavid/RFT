import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TanarForm {
    private JPanel panelTanar;
    private JTextField targynevField;
    private JTextField idoField;
    private JButton buttonFeltolt;
    private Db dbConnector;

    public TanarForm() {
        buttonFeltolt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String subjectName = targynevField.getText();
                String whatTime = idoField.getText();

                //String sql = "INSERT INTO subjects (name, what_time) VALUES ("+"'"+subjectName+"'"+", "+"'"+whataTime+"'"+")";
                String sql = "INSERT INTO subjects (name, what_time) VALUES ('Teszt', 'Teszt')";
                System.out.println(sql);
                dbConnector.uploadSubjects(sql);
            }
        });
    }

    public JPanel getPanelTanar() {
        return panelTanar;
    }

    public void setPanelTanar(JPanel panelTanar) {
        this.panelTanar = panelTanar;
    }

    public JTextField getTargynevField() {
        return targynevField;
    }

    public void setTargynevField(JTextField targynevField) {
        this.targynevField = targynevField;
    }

    public JTextField getIdoField() {
        return idoField;
    }

    public void setIdoField(JTextField idoField) {
        this.idoField = idoField;
    }

    public JButton getButtonFeltolt() {
        return buttonFeltolt;
    }

    public void setButtonFeltolt(JButton buttonFeltolt) {
        this.buttonFeltolt = buttonFeltolt;
    }

    public Db getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(Db dbConnector) {
        this.dbConnector = dbConnector;
    }
}
