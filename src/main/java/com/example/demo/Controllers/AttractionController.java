package com.example.demo.Controllers;

import com.example.demo.Models.Attraction;
import com.example.demo.Services.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/example")
public class AttractionController {
  
  private AttractionService attractionService;
  
  @Autowired
  public AttractionController(AttractionService attractionService) {
    this.attractionService = attractionService;
  }
  
  @GetMapping("/")
  String main(Model model, @ModelAttribute(value = "attractionToEdit") Attraction attraction) {
 /*   if (attraction != null) {
      attractionService.save(attraction);
      model.addAttribute("attractionToEdit", attraction);
    }*/
    model.addAttribute("attractions", attractionService.findAll());
    //model.addAttribute("user", applicationUser);
    return "main";
    
  }
  
  @PostMapping("/edit/{id}")
  public String saveEditedAttraction(@ModelAttribute Attraction attraction, @PathVariable long id) {
    this.attractionService.save(attraction);
    return "redirect:/";
  }
  
  @PostMapping("/")
  String mainPost(Model model, @ModelAttribute(value = "attractionToEdit") Attraction attractionToEdit) throws Exception {
    if (attractionToEdit != null) {
      model.addAttribute("attractionToEdit", attractionToEdit);
      attractionService.save(attractionService.findById(attractionToEdit.getId()).orElseThrow(Exception::new));
    }
    return "redirect:/";
  }
  
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Long id, RedirectAttributes attributes) {
    if (attractionService.findById(id).isPresent()) {
      attributes.addFlashAttribute("attractionToEdit", attractionService.findById(id));
    }
    return "redirect:/";
  }
  
  @PostMapping("/add")
  String add(@ModelAttribute Attraction attraction) {
    attractionService.save(attraction);
    return "redirect:/";
  }
  
  @PostMapping("/add2")
  String add2(@RequestParam String name,
              @RequestParam Double latitude,
              @RequestParam String city,
              Model model) {
    attractionService.save(new Attraction(name, latitude, city));
    return "redirect:/";
  }
  
  /*@PostMapping("notworkingadd")
  String add3(@RequestBody Attraction attraction) {
    attractionService.save(attraction);
    return "redirect:/";
  } NOT WORKING*/
  
  @GetMapping("/upvote/{id}")
  String upvote(@PathVariable Long id) throws Exception {
    //attractionService.findById(id).get().setVotes(attractionService.findById(id).get().getVotes() + 1);
    attractionService.findById(id).ifPresent(a -> a.setVotes(a.getVotes() + 1));
    attractionService.save(attractionService
        .findById(id)
        .orElseThrow(() -> new NullPointerException()));
    return "redirect:/";
  }
  
  @GetMapping("/downvote/{id}")
  String downvote(@PathVariable Long id) {
    //attractionService.findById(id).get().setVotes(attractionService.findById(id).get().getVotes() - 1);
    attractionService.findById(id)
        .ifPresent(a -> a.setVotes(a.getVotes() - 1));
    attractionService.save(
        attractionService
            .findById(id)
            .orElseThrow(NullPointerException::new));
    return "redirect:/";
    
  }
  
  @DeleteMapping("/delete/{id}")
  String delete(@ModelAttribute Attraction attraction) {
    attractionService.delete(attraction);
    return "redirect:/";
  }
}