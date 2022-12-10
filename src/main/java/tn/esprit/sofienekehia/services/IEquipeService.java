package tn.esprit.sofienekehia.services;

import org.springframework.stereotype.Service;
import tn.esprit.sofienekehia.entities.Equipe;

import java.util.List;


public interface IEquipeService {
   public List<Equipe> getAllEquipes();

   public Equipe addEquipe(Equipe e);

   public  Equipe updateEquipe (Equipe e);

   public Equipe getEquipe (Integer idEquipe);

   public  void removeEquipe (Integer idEquipe);
   public void faireEvoluerEquipes();
}
