package fr.latelier.catmash.services;


import fr.latelier.catmash.Exception.CandidateException;
import fr.latelier.catmash.dao.ICandidateRepository;
import fr.latelier.catmash.dto.CandidateDTO;
import fr.latelier.catmash.dto.DTOCast;
import fr.latelier.catmash.entities.Candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ElectionServiceImp implements IElectionService {



    @Autowired
    ICandidateRepository candidateRepository;

    @Override
    public void winnerCandidateUpdate(String idWinCandidate){
        CandidateDTO candidateDTO = findACandidate(idWinCandidate);
        candidateDTO.setNumberVote(candidateDTO.getNumberVote()+1);
        Candidate candidateWin = DTOCast.transfertToCandidate(candidateDTO);
        candidateRepository.save(candidateWin);
    }

    private CandidateDTO findACandidate(String idWinCandidate){
        Optional<Candidate> candidateOptional = candidateRepository.findById(idWinCandidate);
        if(candidateOptional == null)
            throw new CandidateException(("Ce candidat n'est pas dans la base de données"));
        Candidate candidate = candidateOptional.get();
        return DTOCast.transfertToCandidateDTO(candidate);
    }

    @Override
    public Candidate findNextCandidate(String idLooseCandidate, String idWinCandidate) {
        return null;
    }


}
