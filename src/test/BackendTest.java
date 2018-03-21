import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BackendTest {

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "JUnit" })
    void main() {
    }
}