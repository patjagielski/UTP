import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class HorsesTest {

    private static final Integer _horse = 10;
    private static final Integer TOTAL = 20;
    private Horses _stable = new Horses(_horse);

    @Before
    public void before(){
        Assert.assertEquals(_horse, _stable.get_horse());
    }

    @Test
    public void aggregate(){
        Assert.assertEquals(TOTAL, _stable.aggregate(10));
    }

    @Test
    public void deepClone(){
        Horses a2 = _stable.deepClone();
        Assert.assertNotEquals(a2, _stable);
    }
}