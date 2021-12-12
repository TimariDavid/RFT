import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        hallgatoForm.getSubjectsList();

        //when-then
        assertDoesNotThrow(() -> hallgatoForm.getButtonFelvesz().doClick());
    }
}
