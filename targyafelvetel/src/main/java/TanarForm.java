import javax.swing.*;

public class TanarForm {
    private JPanel panelTanar;
    private JTextField targynevField;
    private JTextField idoField;
    private JButton buttonFeltolt;

    public TanarForm() {
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
}
