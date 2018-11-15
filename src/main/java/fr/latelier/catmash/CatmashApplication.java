package fr.latelier.catmash;

import fr.latelier.catmash.Exception.CandidateException;
import fr.latelier.catmash.dao.ICandidateRepository;
import fr.latelier.catmash.dto.CandidateDTO;
import fr.latelier.catmash.dto.DTOCast;
import fr.latelier.catmash.entities.Candidate;
import fr.latelier.catmash.services.ElectionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CatmashApplication implements CommandLineRunner {

    @Autowired
    ICandidateRepository candidateRepository;

    @Autowired
    ElectionServiceImp electionServiceImp;

    public static void main(String[] args) {
        SpringApplication.run(CatmashApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

/*
        List<Candidate> candidateList = new ArrayList<>();

        Candidate c = new Candidate("MTgwODA3MA", "http://24.media.tumblr.com/tumblr_m82woaL5AD1rro1o5o1_1280.jpg", 1548);
        candidateList.add(c);
        Candidate c2 = new Candidate("tt", "http://24.media.tumblr.com/tumblr_m29a9d62C81r2rj8po1_500.jpg", 2154);
        candidateList.add(c2);
        Candidate c3 = new Candidate("bmp", "http://25.media.tumblr.com/tumblr_m4bgd9OXmw1qioo2oo1_500.jpg", 32);
        candidateList.add(c3);
        Candidate c4 = new Candidate("c8a", "http://24.media.tumblr.com/tumblr_lzxok2e2kX1qgjltdo1_1280.jpg", 5);
        candidateList.add(c4);
        Candidate c5 = new Candidate("3kj", "http://25.media.tumblr.com/tumblr_m33r7lpy361qzi9p6o1_500.jpg", 10000);
        candidateList.add(c5);

        candidateRepository.saveAll(candidateList);
*/



    }

}