package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    private Garage garage;
    private Car audi;
    private Car bmw;
    private Car mercedes;

    @Before
    public void setUp(){
        this.garage=new Garage();
        audi=new Car("Audi", 300, 29000);
        bmw=new Car("BMW", 280, 35000);
        mercedes=new Car("Mercedes", 350, 40000);
    }

    @Test
    public void testAddCar(){
        garage.addCar(audi);
        Assert.assertEquals(1, garage.getCount());
        garage.addCar(bmw);
        Assert.assertEquals(2, garage.getCount());
        garage.addCar(mercedes);
        Assert.assertEquals(3, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarShouldFailIfAddNull(){
        Garage garage=new Garage();
        garage.addCar(null);
    }

    @Test
    public void testGetTheMostExpensiveCar(){
        garage.addCar(audi);
        garage.addCar(bmw);
        garage.addCar(mercedes);
        Car mostExpensiveCar=garage.getTheMostExpensiveCar();
        Assert.assertEquals(mercedes.getBrand(), mostExpensiveCar.getBrand());
    }

    @Test
    public void testFindAllCarsByBrand(){
        garage.addCar(audi);
        garage.addCar(bmw);
        garage.addCar(mercedes);
        garage.addCar(mercedes);
        List<Car> cars=garage.findAllCarsByBrand(mercedes.getBrand());
        Assert.assertEquals(2, cars.size());
    }

    @Test
    public void testGetCarsSuccessfully(){
        garage.addCar(mercedes);
        List<Car> carInGarage=garage.getCars();
        Assert.assertEquals(1, garage.getCount());
        Assert.assertEquals(mercedes.getBrand(), carInGarage.get(0).getBrand());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        garage.addCar(audi);
        garage.addCar(bmw);
        garage.addCar(mercedes);

        List<Car> carsWithSpeedAboveValue=garage.findAllCarsWithMaxSpeedAbove(290);
        Assert.assertEquals(mercedes.getBrand(), carsWithSpeedAboveValue.get(1).getBrand());
    }
}