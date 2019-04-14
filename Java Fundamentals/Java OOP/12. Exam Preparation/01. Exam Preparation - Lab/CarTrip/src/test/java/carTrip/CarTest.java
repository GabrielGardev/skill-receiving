package carTrip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private static final String MODEL = "BMW";
    private static final double TANK_CAPACITY = 50;
    private static final double FUEL_AMOUNT = 14.50;
    private static final double FUEL_CONSUMPTION = 2;

    private Car car;

    @Before
    public void setUp(){
        this.car = new Car(MODEL, TANK_CAPACITY, FUEL_AMOUNT, FUEL_CONSUMPTION);
    }

    @Test
    public void getModelShouldReturnModel(){
        Assert.assertEquals(MODEL, this.car.getModel());
    }

    @Test
    public void setModelShouldSetGivenModel(){
        String model = "Sangyongg";
        this.car.setModel(model);

        Assert.assertEquals(model, this.car.getModel());
    }
    @Test(expected = IllegalArgumentException.class)
    public void setModelShouldThrowExceptionIfModelIsNull(){
        this.car.setModel(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setModelShouldThrowExceptionIfModelIsEmpty(){
        this.car.setModel("");
    }
    @Test
    public void getTankCapacityShouldReturnCapacity(){
        Assert.assertEquals(TANK_CAPACITY, this.car.getTankCapacity(), 0.0);
    }
    @Test
    public void setTankCapacityShouldSetGivenCapacity(){
        double newTankCapacity = 60.2;
        this.car.setTankCapacity(newTankCapacity);

        Assert.assertEquals(newTankCapacity, this.car.getTankCapacity(), 0.0);
    }
    @Test
    public void getFuelAmountShouldReturnAmount(){
        Assert.assertEquals(FUEL_AMOUNT, this.car.getFuelAmount(), 0.0);
    }
    @Test
    public void setFuelAmountShouldSetGivenAmount(){
        double newAmount = 17.4;
        this.car.setFuelAmount(newAmount);

        Assert.assertEquals(newAmount, this.car.getFuelAmount(), 0.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setFuelAmountShouldThrowExceptionIfFuelAmountIsMoreThenCapacity(){
        this.car.setFuelAmount(TANK_CAPACITY + 1);
    }
    @Test
    public void getFuelConsumptionPerKmShouldReturnConsumption(){
        Assert.assertEquals(FUEL_CONSUMPTION, this.car.getFuelConsumptionPerKm(), 0.0);
    }
    @Test
    public void setFuelConsumptionPerKmShouldSetGivenFuelConsumption(){
        double newFuelConsumption = 15.6;
        this.car.setFuelConsumptionPerKm(newFuelConsumption);

        Assert.assertEquals(newFuelConsumption, this.car.getFuelConsumptionPerKm(), 0.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionPerKmShouldThrowExceptionIfGivenConsumptionIsNegative(){
        this.car.setFuelConsumptionPerKm(-1);
    }
    @Test
    public void driveShouldReturnMessage(){
        String messageExpected = "Have a nice trip";
        double distance = 1;

        Assert.assertEquals(messageExpected, this.car.drive(distance));
    }
    @Test(expected = IllegalStateException.class)
    public void driveShouldThrowExceptionIfFuelAmountIsNotEnough(){
        double incorrectDistance = 8;
        this.car.drive(incorrectDistance);
    }
    @Test
    public void driveShouldReduceFuelByTripConsumption(){
        double distance = 2;
        double tripConsumption = distance * this.car.getFuelConsumptionPerKm();
        double expected = this.car.getFuelAmount() - tripConsumption;

        this.car.drive(distance);

        Assert.assertEquals(expected, this.car.getFuelAmount(), 0.0);
    }

    @Test(expected = IllegalStateException.class)
    public void refuelShouldThrowExceptionIfTotalFuelAmountIsMoreThenCapacity(){
        this.car.refuel(500);
    }
    @Test
    public void refuelShouldIncreaseFuelAmount(){
        double refuelGas = 5;

        this.car.refuel(refuelGas);

        Assert.assertEquals(FUEL_AMOUNT + 5, this.car.getFuelAmount(), 0.0);
    }
}