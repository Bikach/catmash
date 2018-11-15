package fr.latelier.catmash.dto;

<<<<<<< HEAD
import fr.latelier.catmash.entities.Candidate;

public class DTOCast {


    public static Candidate transfertToCandidate(CandidateDTO candidateDTO){
        return new Candidate(candidateDTO.getId(), candidateDTO.getUrl(), candidateDTO.getNumberVote());
    }

    public static CandidateDTO transfertToCandidateDTOD(Candidate candidate){
        return new CandidateDTO(candidate.getId(), candidate.getUrl(), candidate.getNumberVote());
    }

=======
import fr.latelier.catmash.entities.Cat;

import java.util.ArrayList;
import java.util.List;

public class DTOCast {

    public static Cat createCatEntity(CatDTO catDTO) {
        return new Cat(catDTO.getId(),catDTO.getUrl(),catDTO.getNumberVote());
    }

    public static CatDTO createCatDTO(Cat cat) {
        return new CatDTO(cat.getId(), cat.getUrl(), cat.getNumberVote());
    }

    public static List<Cat> createCatList(List<CatDTO> catDTOList){
        List<Cat> catList = new ArrayList<>();

        for (int i = 0; i < catDTOList.size(); i++){
            Cat cat = createCatEntity(catDTOList.get(0));
            catList.add(cat);
        }
        return catList;
    }

    public static List<CatDTO> createCatDTOList(List<Cat> catList){
        List<CatDTO> catDTOList = new ArrayList<>();

        for (int i = 0; i < catList.size(); i++){
            CatDTO catDTO = createCatDTO(catList.get(0));
            catDTOList.add(catDTO);
        }
        return catDTOList;
    }
>>>>>>> master
}
