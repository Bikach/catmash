package fr.latelier.catmash.entities;

public class Cat {

    private String id;
    private String pathPicture;
    private int numberVote;

    public Cat() { }

    public Cat(String id, String pathPicture, int numberVote){
        this.id = id;
        this.pathPicture = pathPicture;
        this.numberVote = numberVote;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPathPicture() {
        return pathPicture;
    }

    public void setPathPicture(String pathPicture) {
        this.pathPicture = pathPicture;
    }

    public int getNumberVote() {
        return numberVote;
    }

    public void setNumberVote(int numberVote) {
        this.numberVote = numberVote;
    }
}
