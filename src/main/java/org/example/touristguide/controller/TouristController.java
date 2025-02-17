package org.example.touristguide.controller;

import org.example.touristguide.model.City;
import org.example.touristguide.model.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.touristguide.model.TouristAttraction;
import org.example.touristguide.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public String getAttractions(Model model) {
        model.addAttribute("attractions", touristService.getAttractions()); //Fetch all attractions
        return "attraction-list"; //Display attraction list
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionsByName(@PathVariable String name) {
        TouristAttraction attraction = touristService.getAttractionByName(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @GetMapping("/add")
    public String addAttraction(Model model){
        TouristAttraction touristAttraction = new TouristAttraction();
        model.addAttribute("addAttraction",model);
        model.addAttribute("cities", City.values());
        model.addAttribute("tags", Tags.values());
        return "attraction-form";
    }

    @PostMapping("/add/save")
    public String saveAttraction(Model model, @ModelAttribute("add") TouristAttraction touristAttraction){
        model.addAttribute("addAttraction", touristAttraction);
        return "succesAdd";
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction updateAttraction = touristService.updateAttraction(attraction);
        return new ResponseEntity<>(updateAttraction, HttpStatus.OK);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
        TouristAttraction deleteAttraction = touristService.deleteAttraction(name);
        return new ResponseEntity<>(deleteAttraction, HttpStatus.OK);
    }


}
