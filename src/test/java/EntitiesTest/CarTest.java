package EntitiesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aviva.Entities.Car;
import org.json.JSONObject;


public class CarTest {
    Car carToTest;

    @BeforeEach
    public void setup(){
        carToTest = new Car("Lamborghini", "Aventador", 2021, 400000F);
        carToTest.setImage("https://www.topgear.com/sites/default/files/cars-car/image/2017/01/aventador-s_green_050" +
                ".jpg");
    }

    @Test
    public void testGetMake() {
        assertEquals("Lamborghini", carToTest.getMake());
    }

    @Test
    public void testGetModel() {
        assertEquals("Aventador", carToTest.getModel());
    }

    @Test
    public void testGetYear() {
        assertEquals(2021, carToTest.getYear());
    }

    @Test
    public void testGetPrice() {
        assertEquals(400000F, carToTest.getPrice());
    }

    @Test
    public void testGetImage() {
        assertEquals("https://www.topgear.com/sites/default/files/cars-car/" +
                "image/2017/01/aventador-s_green_050.jpg", carToTest.getImage());
    }

    @Test
    public void testSetImage() {
        carToTest.setImage("newTestString");
        assertEquals("newTestString", carToTest.getImage());
    }

    @Test
    public void testToJSON() {
        JSONObject jsonEquiv = new JSONObject();
        jsonEquiv.put("make", "Lamborghini");
        jsonEquiv.put("model", "Aventador");
        jsonEquiv.put("year", 2021);
        jsonEquiv.put("price", 400000F);
        jsonEquiv.put("image", "https://www.topgear.com/sites/default/files/cars-car/image/2017/01/" +
                "aventador-s_green_050.jpg");
        assertEquals(jsonEquiv.getString("make"), carToTest.toJSON().getString("make"));
        assertEquals(jsonEquiv.getString("model"), carToTest.toJSON().getString("model"));
        assertEquals(jsonEquiv.getInt("year"), carToTest.toJSON().getInt("year"));
        assertEquals(jsonEquiv.getFloat("price"), carToTest.toJSON().getFloat("price"));
        assertEquals(jsonEquiv.getString("image"), carToTest.toJSON().getString("image"));
    }
}
