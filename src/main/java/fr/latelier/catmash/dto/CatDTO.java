package fr.latelier.catmash.dto;


public class CatDTO {

    private String id;
    private String url;
    private int numberVote;

    public CatDTO() {
    }

    public CatDTO(String id, String url, int numberVote) {
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
