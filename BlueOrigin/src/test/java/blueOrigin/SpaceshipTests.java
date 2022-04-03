package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Spaceship spaceship;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("Dobri", 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNameIsNull() {
        Spaceship spaceship = new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNameIsTrim() {
        Spaceship spaceship = new Spaceship(" ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacitShuoldyFailWhenBellowZeroCapacity() {
        Spaceship spaceship = new Spaceship("name", -1);
    }

    @Test
    public void testGetAstronautsShouldReturnTwoWhenAddedTwo() {
        Astronaut astronaut = new Astronaut("Dobri", 100);
        Astronaut astronaut1 = new Astronaut("Miro", 100);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
        Assert.assertEquals(2, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfFailWhenAstronautExists() {
        Astronaut astronaut = new Astronaut("Dobri", 100);
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test
    public void testWhenSpaceshipIsEmpty() {
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautsShouldFailWhenSpaceshipIsFull() {
        Spaceship spaceship = new Spaceship("Spaceship", 1);
        Astronaut astronaut = new Astronaut("Dobri", 100);
        Astronaut astronaut1 = new Astronaut("Miro", 100);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }


    @Test
    public void testGetName() {
        Assert.assertEquals("Dobri", spaceship.getName());
    }

    @Test
    public void testIfRemove(){
        Astronaut astronaut = new Astronaut("Dobri", 100);
        Astronaut astronaut1 = new Astronaut("Miro", 100);
        spaceship.add(astronaut);
        spaceship.add(astronaut1);
        spaceship.remove(astronaut.getName());
        spaceship.remove(astronaut1.getName());
    }


    @Test
    public void testRemoveAstronautShouldReturnTrueWhenSuchAdded(){
        Astronaut astronaut = new Astronaut("Dobri", 100);
        spaceship.add(astronaut);
        Assert.assertTrue(spaceship.remove(astronaut.getName()));
    }

    @Test
    public void testRemoveAstronautShouldReturnFalseWhenSuchAdded(){
        Astronaut astronaut = new Astronaut("Dobri", 100);
        spaceship.add(astronaut);
        Assert.assertFalse(spaceship.remove("other_name"));
    }
}
