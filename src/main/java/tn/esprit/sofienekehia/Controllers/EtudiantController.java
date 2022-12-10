package tn.esprit.sofienekehia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sofienekehia.entities.Departement;
import tn.esprit.sofienekehia.entities.Etudiant;
import tn.esprit.sofienekehia.repositories.DepartementRepository;
import tn.esprit.sofienekehia.repositories.EtudiantRepository;
import tn.esprit.sofienekehia.services.IEtudiantService;
import tn.esprit.sofienekehia.services.IEtudiantServiceImp;

import java.util.List;

@RestController
@RequestMapping("/student")
public class EtudiantController {
    @Autowired//injecte moi un bin qui implemente l'interface EtudiantService
 IEtudiantService iEtudiantService;
   @Autowired
    EtudiantRepository etudiantRepository;
   @Autowired
    DepartementRepository departementRepository;

    @GetMapping("/sofiene15/{classname}")
    public String SayHello(@PathVariable String classname) {
        return "hello " + classname;
    }

     @PostMapping("/add")
     public Etudiant addEtudiant(@RequestBody Etudiant e) {
                   return iEtudiantService.addEtudiant(e);
    }

    @PutMapping ("/update")
               public Etudiant UpdateEtudiant(@RequestBody Etudiant e) {
          return iEtudiantService.updateEtudiant(e);
        }

    @GetMapping("/AllEtudiant")
    public List <Etudiant> getAll() {
        List<Etudiant> etudiants = iEtudiantService.getAllEtudiants();
        return etudiants;
    }

    @DeleteMapping("/removeEtudiant/{id}")
        public String removeEtudiant(@PathVariable Integer id) {
            iEtudiantService.removeEtudiant(id);
            return "Removed";
    }

    @GetMapping("{id}")
    public Etudiant getOne(@PathVariable Integer id) {
       return iEtudiantService.getById(id);
        }

    @GetMapping("{departementId}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable Integer departementId){
        List<Etudiant>et=iEtudiantService.getEtudiantsByDepartement(departementId);
        return et;
    }

    @GetMapping("/assign/{etudiantId}/{departementId}")
    public ResponseEntity assignEtudiantToDepartement(@PathVariable int etudiantId, @PathVariable int departementId){
        iEtudiantService.assignEtudiantToDepartement(etudiantId,departementId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping  ("assign/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e, @PathVariable Integer idContrat, @PathVariable Integer idEquipe){
        return iEtudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }

        }


