package tn.esprit.sofienekehia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.sofienekehia.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
 @Query("select c.montantContrat from Contrat c where (c.dateDebut=:startDate) and (c.dateFin=:endDate) and (c.dateDebut between :startDate and :endDate) and (c.dateFin between :startDate and :endDate)")
   public float getChiffreAffaireEntreDeuxDate(@Param("startDate") Date startDate,@Param("endDate") Date endDate);

 @Query("select count(c) from Contrat c where c.archive=false and c.dateDebut=:startDate and c.dateFin=:endDate and (c.dateDebut between :startDate and :endDate) and (c.dateFin between :startDate and :endDate)")
    Integer nbContratsValides(@Param("startDate") Date startDate,@Param("endDate") Date endDate);


int countByArchiveIsFalseAndEtud1NomEAndEtud1PrenomE(String NomE,String PrenomE);
List<Contrat> findContratsByArchiveIsFalse();
List<Contrat>findContratsByArchiveIsFalseAndDateFin(Date enddate);
}

