package fr.latelier.catmash.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Candidate implements Serializable {

    @Id
    @Column(name = "cat_id")
    private String id;
    @Column(name = "picture_path")
    private String url;
    @Column(name = "number_vote")
    private int numberVote;


    public Candidate() {
    }

    public Candidate(String id, String url, int numberVote) {
        this.id = id;
        this.url = url;
        this.numberVote = numberVote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumberVote() {
        return numberVote;
    }

    public void setNumberVote(int numberVote) {
        this.numberVote += numberVote;
    }
}
