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
    private Db dbConnector;

    public HallgatoForm() {
        this.dbConnector = Db.getInstance();
        Map<Integer,String> targyak = new HashMap<Integer,String>();

        subjectsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        subjectsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        subjectsList.setVisibleRowCount(-1);



        buttonReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!targyak.isEmpty()){
                    targyak.clear();
                }

                ResultSet resultSet = (ResultSet) dbConnector.sqlSelect("SELECT * FROM subjects");
                DefaultListModel model = new DefaultListModel();

                try{
                    while (resultSet.next()){
                        targyak.put(resultSet.getInt("ID"),resultSet.getString("name"));
                        String tmp = resultSet.getString("name");
                        model.addElement(tmp);
                    }
                }catch (SQLException h){
                    h.printStackTrace();
                }
                subjectsList = new JList(model);
                subjectsList.setVisible(true);
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
