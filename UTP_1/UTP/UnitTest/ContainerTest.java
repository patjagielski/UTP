import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ContainerTest {
    private String _zooBronx1 = "Jackal";
    private String _zooBronx2 = "Moose";
    private String _zooBronx3 = "Penguin";
    private String _zooBronx4 = "Bear";
    private String _zooBronx5 = "Seal";

    private static final CircleArea[] _area = new CircleArea[]{new CircleArea(10.0), new CircleArea(2.0)};
    private static final Horses[] _horse = new Horses[]{new Horses(50), new Horses(50)};
    private static final Zoo[] _zooBronx = new Zoo[]{new Zoo(new String[]{"Jackal", "Moose"}), new Zoo(new String[]{"Penguin", "Bear"}), new Zoo(new String[]{"Seal"})};

    private static Container<CircleArea, Double> _circleAreaContainer;
    private static Container<Horses, Integer> _horsesContainer;
    Container<Zoo, String[]> _zooContainer = new Container<>(_zooBronx);

    @BeforeEach
    public void before(){
        _circleAreaContainer = new Container<>(_area);
        _horsesContainer = new Container<>(_horse);
        _zooContainer = new Container<>(_zooBronx);
    }
    @Test
    public void aggregate(){
        Double area = Math.pow(10.0, 2)*Math.PI;
        Integer totalHorses = 100;
        String[] zooTotal = {_zooBronx5, _zooBronx3, _zooBronx4, _zooBronx1, _zooBronx2};
        assertArrayEquals(_area, _circleAreaContainer.element().toArray());
        assertArrayEquals(_horse, _horsesContainer.element().toArray());

        assertEquals(area, _circleAreaContainer.aggregateAllElements());
        assertEquals(totalHorses, _horsesContainer.aggregateAllElements());
        assertArrayEquals(zooTotal, _zooContainer.aggregateAllElements());
    }

    @Test
    public void cloneElements(){
        CircleArea areaClone = _circleAreaContainer.cloneElementAtIndex(100);
        Horses horseClone = _horsesContainer.cloneElementAtIndex(0);
        Zoo _zooSanDiego = _zooContainer.cloneElementAtIndex(0);

        assertNotSame(_circleAreaContainer.element().get(0), areaClone);
        assertNotSame(_horsesContainer.element().get(0), horseClone);
        assertNotSame(_zooContainer.element().get(0), _zooSanDiego);
    }

}