import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiamondTest {

    @Test
    public void shouldReturnForA() throws Exception {
        String result = new Diamond().buildFor("A");

        assertThat(result).isEqualTo("A\n");
    }

    @Test
    public void shouldReturnForB() throws Exception {
        String result = new Diamond().buildFor("B");

        assertThat(result).isEqualTo(" A\nB B\n A\n");
    }

    @Test
    public void shouldReturnForC() throws Exception {
        String result = new Diamond().buildFor("C");

        assertThat(result).isEqualTo("  A\n B B\nC   C\n B B\n  A\n");
    }

    @Test
    public void shouldReturnForD() throws Exception {
        String result = new Diamond().buildFor("D");

        assertThat(result).isEqualTo("   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A\n");
        System.out.println(new Diamond().buildFor("E"));
        System.out.println(new Diamond().buildFor("F"));
        System.out.println(new Diamond().buildFor("Z"));
    }

}
