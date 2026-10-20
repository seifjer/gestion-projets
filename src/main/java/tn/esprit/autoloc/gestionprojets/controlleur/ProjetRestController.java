package tn.esprit.autoloc.gestionprojets.controlleur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.gestionprojets.entities.Projet;
import tn.esprit.autoloc.gestionprojets.services.IProjetService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetRestController {

    IProjetService projetService;

    // http://localhost:8089/gestionprojets/projet/retrieve-all-projets
    @GetMapping("/retrieve-all-projets")
    public List<Projet> getProjets() {
        return projetService.retrieveAllProjets();
    }

    // http://localhost:8089/gestionprojets/projet/retrieve-projet/1
    @GetMapping("/retrieve-projet/{projet-id}")
    public Projet retrieveProjet(@PathVariable("projet-id") Long projetId) {
        return projetService.retrieveProjet(projetId);
    }

    // http://localhost:8089/gestionprojets/projet/add-projet
    @PostMapping("/add-projet")
    public Projet addProjet(@RequestBody Projet projet) {
        return projetService.addProjet(projet);
    }

    // http://localhost:8089/gestionprojets/projet/remove-projet/1
    @DeleteMapping("/remove-projet/{projet-id}")
    public void removeProjet(@PathVariable("projet-id") Long projetId) {
        projetService.removeProjet(projetId);
    }

    // http://localhost:8089/gestionprojets/projet/modify-projet
    @PutMapping("/modify-projet")
    public Projet modifyProjet(@RequestBody Projet projet) {
        return projetService.modifyProjet(projet);
    }
}