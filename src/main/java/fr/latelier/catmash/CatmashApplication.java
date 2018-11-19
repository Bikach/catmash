package fr.latelier.catmash;

import fr.latelier.catmash.dto.CandidateDTO;
import fr.latelier.catmash.dto.DTOCast;
import fr.latelier.catmash.services.CollectionsHandlingService;
import fr.latelier.catmash.services.ElectionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


@SpringBootApplication
public class CatmashApplication implements CommandLineRunner {

    public static List<CandidateDTO> candidatsAlreadyPresentedList;

    public static void main(String[] args) {  SpringApplication.run(CatmashApplication.class, args); }

    @Override
    public void run(String... args) throws Exception {

        candidatsAlreadyPresentedList = new ArrayList<>();

    }


}