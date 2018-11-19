package fr.latelier.catmash.dao;

import fr.latelier.catmash.Exception.CandidateException;
import fr.latelier.catmash.dto.CandidateDTO;
import fr.latelier.catmash.dto.DTOCast;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return jpaRepository.findById(candidateId)
                .map(DTOCast::transfertToCandidateDTO)
                .orElseThrow(() -> new CandidateException(("Ce candidat n'est pas dans la base de données")));
    }

    @Override
    public List<CandidateDTO> findAllCandidatesDTO() {
        return DTOCast.transfertToCandidateDTOList(jpaRepository.findAll());
    }



}

