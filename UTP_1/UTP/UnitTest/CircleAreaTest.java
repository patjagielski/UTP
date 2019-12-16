import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class CircleAreaTest {
    private static final Double RADIUS = 10.0;
    private CircleArea circleArea = new CircleArea(RADIUS);
    private static final Double AREA = Math.pow(RADIUS,2)*Math.PI;

    @Before
    public void before(){
        Assert.assertEquals(RADIUS, circleArea.get_radius());
    }

    @Test
     public void aggregate(){
        Assert.assertEquals(RADIUS, circleArea.aggregate(null));
    }

    @Test
    public void deepClone(){
        CircleArea sq2 = circleArea.deepClone();
        Assert.assertNotEquals(sq2, circleArea);
    }


}