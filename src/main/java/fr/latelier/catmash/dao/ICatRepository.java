package fr.latelier.catmash.dao;

import fr.latelier.catmash.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatRepository extends JpaRepository<Cat, String> {
}
