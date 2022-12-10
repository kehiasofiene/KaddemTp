package tn.esprit.sofienekehia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.sofienekehia.entities.Equipe;
import tn.esprit.sofienekehia.entities.Etudiant;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
    List<Equipe> findEquipeByEtud1Contains(Etudiant e);
}
