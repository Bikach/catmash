package fr.latelier.catmash.dto;


import org.hibernate.validator.constraints.URL;

public class CandidateDTO {

    private String id;
    @URL
    private String url;
    private int numberVote;

    public CandidateDTO() {
    }

    public CandidateDTO(String id, String url, int numberVote) {
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
        this.numberVote = numberVote;
    }
}
