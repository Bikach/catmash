package fr.latelier.catmash.services;

import fr.latelier.catmash.Exception.CandidateException;
import fr.latelier.catmash.dao.CandidateRepository;
import fr.latelier.catmash.dto.CandidateDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;


@RunWith(MockitoJUnitRunner.class)
public class IElectionServiceTest {

    private final String EXISTING_ID = "tt";

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private ElectionServiceImpl electionServiceImp;


    @Test
    public void shouldAddOneVoteToTheSelectedCandidate(){
        doNothing().when(electionServiceImp).winnerCandidateUpdate(EXISTING_ID);
        CandidateDTO candidateDTO = candidateRepository.findACandidateById(EXISTING_ID);
        assertEquals(33, candidateDTO.getNumberVote());
    }


    @Test
    public void shouldReturnCandidateExceptionWhenTheIdDoesNotExist(){
        doThrow(new CandidateException())
                .when(electionServiceImp)
                .winnerCandidateUpdate("bmp");

    }



}