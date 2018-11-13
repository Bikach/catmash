package fr.latelier.catmash.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat implements Serializable {

    @Id
    @Column(name = "cat_id")
    private String id;
    @Column(name = "path_picture")
    private String pathPicture;
    @Column(name = "number_vote")
    private int numberVote;


}
