package fr.semifir.springboot.controllers;

import fr.semifir.springboot.models.Poisson;
import fr.semifir.springboot.models.Singe;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cage-singes")
public class CageSingesController {

    public static List<Singe> listeSinge = new ArrayList<>();

    @GetMapping
    public List<Singe> getAll() {
        return listeSinge;
    }

    @PostMapping
    public Singe save(@RequestBody Singe singe){
        listeSinge.add(singe);
        return singe;
    }

    @GetMapping("{nom}")
    public Optional<Singe> findByNom(@PathVariable String nom) {
        Optional<Singe> singe = listeSinge.stream()
                .filter(p -> nom.equals(p.getNom()))
                .findFirst();
        return singe;
    }

    @GetMapping("{nom}/nourrir")
    public String nourrirSinge(@PathVariable String nom, @RequestParam String nourriture) {
        Singe singe = listeSinge.stream()
                .filter(p -> nom.equals(p.getNom()))
                .findFirst()
                .orElse(new Singe("glouton", 1.2));
        return singe.manger(nourriture);
    }

    @DeleteMapping("{nom}")
    public String deletePoisson(@PathVariable String nom){
        Singe singe = listeSinge.stream()
                .filter(p -> nom.equals(p.getNom()))
                .findFirst()
                .orElse(null);
        listeSinge.remove(singe);
        return "on enlève " + singe.getNom()+ " parce qu'il ne bouge plus depuis 2 jours";
    }
}
