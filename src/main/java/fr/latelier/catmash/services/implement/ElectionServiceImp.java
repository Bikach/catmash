package fr.latelier.catmash.services.implement;

import fr.latelier.catmash.dao.ICatRepository;
import fr.latelier.catmash.dto.CatDTO;
import fr.latelier.catmash.dto.DTOCast;
import fr.latelier.catmash.entities.Cat;
import fr.latelier.catmash.services.IElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionServiceImp implements IElectionService {

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



}
