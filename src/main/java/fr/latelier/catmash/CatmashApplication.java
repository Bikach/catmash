package fr.latelier.catmash;

import fr.latelier.catmash.dao.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatmashApplication implements CommandLineRunner {

    @Autowired
    ICandidateRepository catRepository;

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
//        ResponseEntity<CandidateDTO> response = restTemplate.getForEntity(
//                "https://latelier.co/data/cats.json",
//                CandidateDTO.class);
//        CandidateDTO catDTOS = response.getBody();
//        List<CandidateDTO> catDTOList = Arrays.asList(catDTOS);
//
//        System.out.println(catDTOList.size());


    }
}