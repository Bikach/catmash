package fr.latelier.catmash.services;

import fr.latelier.catmash.entities.Cat;;

public interface IElectionService {

    void winnerCatUpdate(String idWinCat);

    Cat findNextCat(String idLooseCat, String idWinCat);

}
