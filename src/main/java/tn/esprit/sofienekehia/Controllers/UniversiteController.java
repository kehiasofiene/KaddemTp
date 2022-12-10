package tn.esprit.sofienekehia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sofienekehia.entities.Departement;
import tn.esprit.sofienekehia.entities.Etudiant;
import tn.esprit.sofienekehia.entities.Universite;
import tn.esprit.sofienekehia.repositories.DepartementRepository;
import tn.esprit.sofienekehia.repositories.EtudiantRepository;
import tn.esprit.sofienekehia.repositories.UniversiteRepository;
import tn.esprit.sofienekehia.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteController {
    @Autowired
    private IUniversiteService iUniversiteService;


    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite u) {
        return iUniversiteService.addUniversite(u);
    }

    @PutMapping("/update")
    public Universite UpdateUniversite(@RequestBody Universite u) {
        return iUniversiteService.updateUniversite(u);
    }

    @GetMapping("/AllUniversites")
    public List<Universite> getAll() {
       return  iUniversiteService.getAllUniversites();
    }

    @DeleteMapping("/removeUniversite/{id}")
    public String removeUniversite(@PathVariable Integer id) {
        iUniversiteService.removeUniversite(id);
        return "Removed";
    }

    @GetMapping("{id}")
    public String getOne(@PathVariable Integer id) {
        Universite Univ =  iUniversiteService.getUniversite(id);
        if (null != Univ) {
            return "hello" +Univ.getIdUniv();
        } else {
            return "not exists";
        }
    }
    @PostMapping("assign/{idUniversite}/{idDepartement}")
    public ResponseEntity assignUniversiteToDepartement(@PathVariable Integer idUniversite,@PathVariable Integer idDepartement){
         iUniversiteService.assignUniversiteToDepartement(idUniversite,idDepartement);
         return  new ResponseEntity(HttpStatus.OK);
    }
}
