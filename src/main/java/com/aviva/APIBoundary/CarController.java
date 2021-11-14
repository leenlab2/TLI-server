package com.aviva.APIBoundary;

import com.aviva.CarRecommendations.CarRecommender;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller class that handles input-output data communication between front-end and back-end. It uses springboot to
 * handle HTTP GET/POST/PUT requests.
 */
@RestController
@CrossOrigin(origins="*")
public class CarController {
    /**
     * Responds to a GET request at the root "/". This method is mainly used for testing purposes. Returns greeting.
     */
    @GetMapping("/")
    public String index() {
        return "Greetings!";
    }

    /**
     * Returns a list of recommended cars for a certain client.
     * @param accountNumber the client's ID number
     * @return list of recommended cars, formatted as a JSON string
     */
    @PostMapping("/cars")
    public String getCars(@RequestBody String accountNumber){
        CarRecommender crInit = new CarRecommender();
        JSONObject cars = crInit.getRecommendedCars(accountNumber);
        return cars.toString();
    }
}