import org.junit.Test;

import static org.junit.Assert.assertThat;

public class MoreRandomTest {
    @Test
    public void testStringEquality() {
        String a = "rainforest";
        String b = "forest";
        // deliberate failure
        assertThat(a, org.hamcrest.CoreMatchers.equalTo(b));
    }
}
