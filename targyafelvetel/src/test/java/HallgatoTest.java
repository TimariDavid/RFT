import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HallgatoTest {

    @Test
    @DisplayName("ActionListener test")
    void testActionListenerButtonReload(){
        //given
        HallgatoForm hallgatoForm = new HallgatoForm();
        Db connector = Db.getInstance();

        //when-then
        assertDoesNotThrow(() -> hallgatoForm.getButtonReload().doClick());
    }

    @Test
    @DisplayName("ActionListener test")
    void testActionListenerButtonFelvesz(){
        //given
        HallgatoForm hallgatoForm = new HallgatoForm();
        Db connector = Db.getInstance();
        hallgatoForm.getButtonReload().doClick();
        DefaultListModel model = new DefaultListModel();
        hallgatoForm.getSubjectsList().setModel(model);
        model.addElement("Alma");
        model.addElement("Barack");
        model.addElement("Körte");

        hallgatoForm.getSubjectsList().setSelectedIndex(0);

        //when-then
        assertDoesNotThrow(() -> hallgatoForm.getButtonFelvesz().doClick());
    }
}
