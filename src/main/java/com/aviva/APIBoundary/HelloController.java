package com.aviva.APIBoundary;

import com.aviva.CarRecommendations.CarRecommender;
import com.aviva.DataAccess.AccountHolderDataInterface;
import com.aviva.DataAccess.CSVAccountHolderData;
import com.aviva.Entities.AccountHolder;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins="*")
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/cars")
    public String getCars(@RequestBody String clientID) throws IOException, InterruptedException, ClassNotFoundException {
        AccountHolderDataInterface accountData = new CSVAccountHolderData();
        AccountHolder user = accountData.getClientByID(clientID);
        JSONObject cars = CarRecommender.getRecommendedCars(user);
        System.out.println(cars);
        return cars.toString();
    }
}