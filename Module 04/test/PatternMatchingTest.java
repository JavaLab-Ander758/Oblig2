import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PatternMatchingTest {
    PatternMatching patternMatching = new PatternMatching();

    @Test
    public void test_something(){

        assertThat(patternMatching.matching("Dette er en test", "test"), is("Lol"));
    }

}