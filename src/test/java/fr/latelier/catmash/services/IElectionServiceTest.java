package fr.latelier.catmash.services;

import fr.latelier.catmash.dao.ICandidateRepository;
import fr.latelier.catmash.dto.CandidateDTO;
import fr.latelier.catmash.entities.Candidate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class IElectionServiceTest {

    private final String EXISTING_ID = "tt";

    @Mock
    private ICandidateRepository candidateRepository;

    @InjectMocks
    private ElectionServiceImp electionServiceImp;


    @Test
    public void shouldAddOneVoteToTheSelectedCandidate(){
        electionServiceImp.winnerCandidateUpdate(EXISTING_ID);
        Optional<Candidate> candidateOp = candidateRepository.findById(EXISTING_ID);
        Candidate candidate = candidateOp.get();
        assertEquals(33, candidate.getNumberVote());
    }





}