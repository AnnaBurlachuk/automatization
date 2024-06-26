import com.example.Calculator;
import com.example.Phone;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class JUnitTest {

    @ParameterizedTest
    @ValueSource(ints = {345, 234, 645})
    public void checkAddFunction(int number) {
        assertEquals(Math.addExact(number, 345), Calculator.add(number, 345));
    }

    @Test
    public void createPhone() throws IllegalAccessException {
        String phoneStr = "0672339843";
        assumeTrue(phoneStr != null, "Phone is null");
        Phone phone = new Phone(phoneStr);
    }
}
