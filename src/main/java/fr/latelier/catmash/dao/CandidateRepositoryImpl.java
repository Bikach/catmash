package fr.latelier.catmash.dao;

import fr.latelier.catmash.Exception.CandidateException;
import fr.latelier.catmash.dto.CandidateDTO;
import fr.latelier.catmash.dto.DTOCast;
import fr.latelier.catmash.entities.Candidate;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CandidateRepositoryImpl implements CandidateRepository {


    private JPACandidateRepository jpaRepository;

    public CandidateRepositoryImpl(JPACandidateRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void saveCandidate(CandidateDTO candidateDTO) {
        jpaRepository.save(DTOCast.transfertToCandidate(candidateDTO));
    }

    @Override
    public CandidateDTO findACandidateById(String candidateId) {
        Optional<Candidate> candidateOptional = jpaRepository.findById(candidateId);
        if(!candidateOptional.isPresent())
            throw new CandidateException(("Ce candidat n'est pas dans la base de données"));
        Candidate candidate = candidateOptional.get();
        return DTOCast.transfertToCandidateDTO(candidate);
    }

    @Override
    public List<CandidateDTO> findAllCandidatesDTO() {
        return DTOCast.transfertToCandidateDTOList(jpaRepository.findAll());
    }



}

