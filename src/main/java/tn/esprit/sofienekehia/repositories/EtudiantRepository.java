package tn.esprit.sofienekehia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.sofienekehia.entities.Equipe;
import tn.esprit.sofienekehia.entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
 //@Query("select e from Etudiant e where e.dept.idDepart=: idDepartement")
// List<Etudiant> getEtudiantsByDepartement(@Param("idDepartement") int idDepartement);
 List<Etudiant> findByDept_IdDepart(int idDepart);

// @Query("select e from Etudiant e where e.nomE=:NomE and e.prenomE=:PrenomE ")
 Etudiant findByNomEAndPrenomE(String NomE, String PrenomE);
 List<Etudiant> findByEquipe(Equipe e);
}
