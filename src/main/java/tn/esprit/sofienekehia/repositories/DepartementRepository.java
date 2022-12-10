package tn.esprit.sofienekehia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.sofienekehia.entities.Departement;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
/*@Query("select d from Departement d,Universite u where u.idUniv=:idUniv ")
        public List<Departement> retrieveDepartementsByUniversite(@Param("idUniv") Integer idUniv);*/

}
