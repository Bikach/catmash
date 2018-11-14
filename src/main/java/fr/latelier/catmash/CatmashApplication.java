package fr.latelier.catmash;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.latelier.catmash.dao.ICatRepository;
import fr.latelier.catmash.dto.CatDTO;
import fr.latelier.catmash.entities.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

@SpringBootApplication
public class CatmashApplication implements CommandLineRunner {

    @Autowired
    ICatRepository catRepository;

    public static void main(String[] args) {
        SpringApplication.run(CatmashApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        URL url = new URL("https://latelier.co/data/cats.json");
//        try (InputStream inputStream = url.openStream();
//             JsonReader jsonReader = Json.createReader(inputStream)) {
//
//            JsonObject jsonObject = jsonReader.readObject();
//            JsonArray jsonArray = jsonObject.getJsonArray("images");
//
//            System.out.println(jsonArray);
//
//        }
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<CatDTO> response = restTemplate.getForEntity(
//                "https://latelier.co/data/cats.json",
//                CatDTO.class);
//        CatDTO catDTOS = response.getBody();
//        List<CatDTO> catDTOList = Arrays.asList(catDTOS);
//
//        System.out.println(catDTOList.size());


    }
}