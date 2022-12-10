package tn.esprit.sofienekehia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sofienekehia.entities.Equipe;
import tn.esprit.sofienekehia.entities.Etudiant;
import tn.esprit.sofienekehia.services.IEquipeService;

import java.util.List;

@RestController
@RequestMapping("/Equipe")
public class EquipeController {
    @Autowired
    IEquipeService iEquipeService;

    @GetMapping("/AllEquipe")
    public List<Equipe> getAll() {
        List<Equipe> equipe = iEquipeService.getAllEquipes();
        return equipe;
    }
    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe eq) {
        return iEquipeService.addEquipe(eq);
    }

    @PutMapping ("/update")
    public Equipe UpdateEquipe(@RequestBody Equipe eq) {
        return iEquipeService.updateEquipe(eq);
    }

    @DeleteMapping("/removeEquipe/{id}")
    public String removeEquipe(@PathVariable Integer id) {
        iEquipeService.removeEquipe(id);
        return "Removed";
    }

    @GetMapping("{id}")
    public String getOne(@PathVariable Integer id) {
        Equipe equipe =  iEquipeService.getEquipe(id);
        if (null != equipe) {
            return "hello" +equipe.getNiveau();
        } else {
            return "not exists";
        }
    }
    @PutMapping("/evoluerequipe")
    public void EvoluerEquipe(){
        iEquipeService.faireEvoluerEquipes();
    }
}
