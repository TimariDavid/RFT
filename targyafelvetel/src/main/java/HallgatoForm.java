import javax.swing.*;

public class HallgatoForm {
    private JList subjectsList;
    private JButton buttonFelvesz;
    private JPanel panelHallgato;

    public HallgatoForm() {
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
}
