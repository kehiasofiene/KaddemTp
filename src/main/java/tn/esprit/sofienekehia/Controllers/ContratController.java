package tn.esprit.sofienekehia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sofienekehia.entities.Contrat;

import tn.esprit.sofienekehia.services.IContratService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    IContratService iContratService;
    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat ce) {
        return  iContratService.addContrat(ce);
    }

    @PutMapping("/update")
    public Contrat UpdateContrat(@RequestBody Contrat ce) {
        return iContratService.updateContrat(ce);
    }

    @GetMapping("/AllContrat")
    public List<Contrat> getAll() {
        List<Contrat> contrat = iContratService.getAllContrats();
        return contrat;
    }

    @DeleteMapping("/removeContrat/{id}")
    public String removeContrat(@PathVariable Integer id) {
        iContratService.removeContrat(id);
        return "Removed";
    }

    @GetMapping("{id}")
    public String getOne(@PathVariable Integer id) {
        Contrat contrat =  iContratService.retrieveContrat(id);
        if (null != contrat) {
            return "hello" +contrat.getSpecialite();
        } else {
            return "not exists";
        }
    }
    @PostMapping ("affect/{nomE}/{prenomE}")
    public  ResponseEntity affectContratToEtudiant(@RequestBody Contrat ce,@PathVariable String nomE,@PathVariable String prenomE)
    {
         iContratService.affectContratToEtudiant(ce, nomE, prenomE);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("{startDate}/{endDate}")
    Integer nbContratsValides(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate){
        return iContratService.nbContratsValides(startDate, endDate);
    }
    @GetMapping("retrieve/contrat")
    public void retrieveAndUpdateStatusContrat(){
         iContratService.retrieveAndUpdateStatusContrat();
    }
}
