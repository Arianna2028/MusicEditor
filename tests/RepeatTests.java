import cs3500.music.model.Repeat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests regarding {@link cs3500.music.model.Repeat}s.
 */
public class RepeatTests {
    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorDefault() {
        new Repeat();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorNegative1() {
        new Repeat(0, 4, -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorNegative2() {
        new Repeat(-1, 4, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorNegative3() {
        new Repeat(1, -4, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorOneBeat1() {
        new Repeat(1, 1, 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorOneBeat2() {
        new Repeat(4, 4, 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorOrder() {
        new Repeat(8, 4, 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorMidMeasure1() {
        new Repeat(2, 4, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorMidMeasure2() {
        new Repeat(4, 7, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorMidMeasure3() {
        new Repeat(5, 9, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatConstructorCount() {
        new Repeat(2, 4, -4);
    }

    @Test
    public void testGetStart() {
        Repeat r = new Repeat(4, 8, 1);
        assertEquals(4, r.getStart());

        r = new Repeat(8, 16, 3);
        assertEquals(8, r.getStart());
    }

    @Test
    public void testGetEnd() {
        Repeat r = new Repeat(4, 8, 1);
        assertEquals(8, r.getEnd());

        r = new Repeat(8, 16, 3);
        assertEquals(16, r.getEnd());
    }

    @Test
    public void testGetCount() {
        Repeat r = new Repeat(4, 8, 1);
        assertEquals(1, r.getCount());

        r = new Repeat(8, 16, 3);
        assertEquals(3, r.getCount());
    }

    @Test
    public void testDecreaseRepeats() {
        Repeat r = new Repeat(8, 16, 3);
        assertEquals(3, r.getCount());
        r.decreaseRepeats();
        assertEquals(2, r.getCount());
        r.decreaseRepeats();
        assertEquals(1, r.getCount());
        r.decreaseRepeats();
        assertEquals(0, r.getCount());
        r.decreaseRepeats();
        assertEquals(0, r.getCount());
    }

    @Test
    public void testResetCount() {
        Repeat r = new Repeat(8, 16, 3);
        assertEquals(3, r.getCount());
        r.decreaseRepeats();
        r.decreaseRepeats();
        r.decreaseRepeats();
        assertEquals(0, r.getCount());
        r.resetCount();
        assertEquals(3, r.getCount());

        r.decreaseRepeats();
        r.decreaseRepeats();
        assertEquals(1, r.getCount());
        r.resetCount();
        assertEquals(3, r.getCount());
    }
}
