import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZooTest {

    private static final String[] ANIMALS = {"horse", "donkey", "elephant"};
    private Zoo _types_animals;

    @BeforeEach
    public void before(){
        _types_animals = new Zoo(ANIMALS);
        Assert.assertArrayEquals(ANIMALS,_types_animals.get_types_animals());
    }

    @Test
    public void aggregate(){
        Assert.assertArrayEquals(ANIMALS, _types_animals.aggregate(null));
        String[] moreANIMALS = {"penguin", "seal"};
        String [] finalANIMALS = new String[ANIMALS.length+moreANIMALS.length];
        for(int i = 0; i<finalANIMALS.length; i++) {
            if (i < ANIMALS.length) {
                finalANIMALS[i] = ANIMALS[i];
            } else {
                finalANIMALS[i] = moreANIMALS[i - ANIMALS.length];
            }
        }
        Assert.assertArrayEquals(finalANIMALS, _types_animals.aggregate(moreANIMALS));
    }

    @Test
    public void deepClone(){
        Zoo animal1 = _types_animals.deepClone();
        Assert.assertNotEquals(animal1, _types_animals);

    }
}