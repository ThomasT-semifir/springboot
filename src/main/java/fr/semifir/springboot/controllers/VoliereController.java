package fr.semifir.springboot.controllers;

import fr.semifir.springboot.models.Oiseau;
import fr.semifir.springboot.models.Poisson;
import fr.semifir.springboot.models.Oiseau;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("voliere")
public class VoliereController {

    public static List<Oiseau> listeOiseau = new ArrayList<>();

    @GetMapping
    public List<Oiseau> getAll() {
        return listeOiseau;
    }

    @PostMapping
    public Oiseau save(@RequestBody Oiseau oiseau){
        listeOiseau.add(oiseau);
        return oiseau;
    }

    @GetMapping("{nom}")
    public Optional<Oiseau> findByNom(@PathVariable String nom) {
        Optional<Oiseau> oiseau = listeOiseau.stream()
                .filter(p -> nom.equals(p.getNom()))
                .findFirst();
        return oiseau;
    }

    @GetMapping("{nom}/nourrir")
    public String nourrirOiseau(@PathVariable String nom, @RequestParam String nourriture) {
        Oiseau oiseau = listeOiseau.stream()
                .filter(p -> nom.equals(p.getNom()))
                .findFirst()
                .orElse(new Oiseau("sale piaf", "rouge"));
        return oiseau.manger(nourriture);
    }

    @DeleteMapping("{nom}")
    public String deletePoisson(@PathVariable String nom){
        Oiseau oiseau = listeOiseau.stream()
                .filter(p -> nom.equals(p.getNom()))
                .findFirst()
                .orElse(null);
        listeOiseau.remove(oiseau);
        return "on enlève " + oiseau.getNom()+ " parce qu'il a foncé un peu trop vite dans la vitre";
    }
}
