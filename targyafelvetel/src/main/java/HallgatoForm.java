import com.mysql.jdbc.ResultSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HallgatoForm {
    private JList subjectsList;
    private JButton buttonFelvesz;
    private JPanel panelHallgato;
    private JButton buttonReload;
    private JLabel labelInfo;
    private Db dbConnector;

    public HallgatoForm() {
        this.dbConnector = Db.getInstance();
        HashMap<Integer,String> targyak = new HashMap<Integer,String>();

        subjectsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        subjectsList.setLayoutOrientation(JList.VERTICAL_WRAP);
        subjectsList.setVisibleRowCount(-1);



        buttonReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!targyak.isEmpty()){
                    targyak.clear();
                }

                ResultSet resultSet = (ResultSet) dbConnector.sqlSelect("SELECT * FROM subjects");
                DefaultListModel model = new DefaultListModel();
                subjectsList.setModel(model);

                try{
                    while (resultSet.next()){
                        targyak.put(resultSet.getInt("ID"),resultSet.getString("name"));
                        model.addElement(resultSet.getString("name"));
                    }
                }catch (SQLException h){
                    h.printStackTrace();
                }
            }
        });
        buttonFelvesz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String subjectName = subjectsList.getSelectedValue().toString();

                App hallgato = new App();
                System.out.println(hallgato.getUserId());

                for (Map.Entry<Integer, String> entry : targyak.entrySet()) {
                    if(entry.getValue().equals(subjectName)){
                        String sql = "INSERT INTO connector (user_id, subject_id) VALUES ("+"'"+hallgato.getUserId()+"'"+", "+"'"+entry.getKey()+"'"+")";
                        dbConnector.sqlInsert(sql);
                    }
                }
            }
        });
        subjectsList.getSelectionModel().addListSelectionListener(e -> {
            String targy = subjectsList.getSelectedValue().toString();
            for (Map.Entry<Integer, String> entry : targyak.entrySet()){
                if(entry.getValue().equals(targy)){
                    int sqlId = entry.getKey();
                    ResultSet resultSet = (ResultSet) dbConnector.sqlSelect("SELECT what_time FROM subjects WHERE ID = "+sqlId+";");
                    try {
                        String sad = resultSet.getString("what_time");
                        System.out.println(sad);
                        //labelInfo.setText(resultSet.getString("what_time"));
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public JList getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(JList subjectsList) {
        this.subjectsList = subjectsList;
    }

    public JButton getButtonFelvesz() {
        return buttonFelvesz;
    }

    public void setButtonFelvesz(JButton buttonFelvesz) {
        this.buttonFelvesz = buttonFelvesz;
    }

    public JPanel getPanelHallgato() {
        return panelHallgato;
    }

    public void setPanelHallgato(JPanel panelHallgato) {
        this.panelHallgato = panelHallgato;
    }

    public Db getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(Db dbConnector) {
        this.dbConnector = dbConnector;
    }

}
