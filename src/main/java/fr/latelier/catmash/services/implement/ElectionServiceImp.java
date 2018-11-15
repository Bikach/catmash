package fr.latelier.catmash.services.implement;

<<<<<<< HEAD
import fr.latelier.catmash.entities.Candidate;
=======
import fr.latelier.catmash.dao.ICatRepository;
import fr.latelier.catmash.dto.CatDTO;
import fr.latelier.catmash.dto.DTOCast;
import fr.latelier.catmash.entities.Cat;
>>>>>>> master
import fr.latelier.catmash.services.IElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionServiceImp implements IElectionService {

<<<<<<< HEAD
    @Override
    public void winnerCandidateUpdate(String idWinCandidate) {

    }

    @Override
    public Candidate findNextCandidate(String idLooseCandidate, String idWinCandidate) {
        return null;
    }
=======
    private final int A_VOTE = 1;

    @Autowired
    ICatRepository catRepository;


    @Override
    public void winnerCatUpdate(String idWinCat){
        CatDTO catDTO = findACat(idWinCat);
        catDTO.setNumberVote(A_VOTE);
        Cat catWin = DTOCast.createCatEntity(catDTO);
        catRepository.save(catWin);
    }

    private CatDTO findACat(String idWinCat){
        Cat cat = null;
        Optional<Cat> catOptional = catRepository.findById(idWinCat);
        if(catOptional.isPresent())
            cat = catOptional.get();
        return DTOCast.createCatDTO(cat);
    }


    @Override
    public Cat findNextCat(String idLooseCat, String idWinCat){
     // TODO
        return null;
    }



>>>>>>> master
}
