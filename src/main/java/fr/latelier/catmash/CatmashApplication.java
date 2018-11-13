package fr.latelier.catmash;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import fr.latelier.catmash.dao.ICatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class CatmashApplication implements CommandLineRunner {

    @Autowired
    ICatRepository catRepository;

    public static void main(String[] args) {
        SpringApplication.run(CatmashApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception, ClientProtocolException {
        HttpClient client = new DefaultHttpClient();

        HttpGet request = new HttpGet('http://restUrl');

        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));

        String line = '';

        while ((line = rd.readLine()) != null) {

            System.out.println(line);

        }

    }

    }
}
