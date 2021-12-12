import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TanarTest {
    @Test
    @DisplayName("ActionListener test")
    void testActionListener(){
        //given
        TanarForm tanarForm = new TanarForm();
        Db connector = Db.getInstance();

        //when-then
        assertDoesNotThrow(() -> tanarForm.getButtonFeltolt().doClick());
    }
}
