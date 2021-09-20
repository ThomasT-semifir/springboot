package fr.semifir.springboot.controllers;

import fr.semifir.springboot.models.Poisson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aquarium")
public class AquariumController {

    public static List<Poisson> listePoissons = new ArrayList<>();

    @GetMapping
    public List<Poisson> getAll() {
        return listePoissons;
    }

    @PostMapping
    public Poisson save(@RequestBody Poisson poisson){
        listePoissons.add(poisson);
        return poisson;
    }

    @GetMapping("{nom}")
    public Optional<Poisson> findByNom(@PathVariable String nom) {
        Optional<Poisson> poisson = listePoissons.stream()
                .filter(p -> nom.equals(p.getNom()))
                .findFirst();
        return poisson;
    }

    @GetMapping("{nom}/nourrir")
    public String nourrirPoisson(@PathVariable String nom, @RequestParam String nourriture) {
        Poisson poisson = listePoissons.stream()
                .filter(p -> nom.equals(p.getNom()))
                .findFirst()
                .orElse(new Poisson("sharky", "requin"));
        return poisson.manger(nourriture);
    }

    @DeleteMapping("{nom}")
    public String deletePoisson(@PathVariable String nom){
        Poisson poisson = listePoissons.stream()
                .filter(p -> nom.equals(p.getNom()))
                .findFirst()
                .orElse(null);
        listePoissons.remove(poisson);
        return "on enlève " + poisson.getNom()+ " parce qu'il flotte le ventre à l'air depuis 2 heures";
    }
}
