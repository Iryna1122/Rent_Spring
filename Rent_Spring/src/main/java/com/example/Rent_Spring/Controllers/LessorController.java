package com.example.Rent_Spring.Controllers;

import com.example.Rent_Spring.Models.Lessor;
import com.example.Rent_Spring.Repo.LessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LessorController {

    @Autowired
    private LessorRepository repository;


    @GetMapping("/")
    public String main( Model model) {

        return "main";
    }

    @GetMapping("/mainLessor")
    public String mainLessor(Model model)
    {
        Iterable<Lessor>lessors = repository.findAll();
        model.addAttribute("lessors", lessors);
        return "lessor/mainLessor";
    }


    @GetMapping("/addLessor")
    public String addLessor(Model model)
    {
        return "lessor/addLessor";
    }

    @PostMapping("/addLessor")
    public String saveLessor(@RequestParam String name, @RequestParam String lastname, Model model)
    {
        Lessor lessor = new Lessor(name,lastname);
        repository.save(lessor);
        return "redirect:/mainLessor";
    }

    @GetMapping("/lessorById/{id}")
    public String lessorById(@PathVariable(value = "id") Long id, Model model) {
        if (!repository.existsById(id)) {
            return "redirect:/main";
        }
        Lessor lessor = repository.findById(id).get();
        model.addAttribute("lessor", lessor);
        return "lessor/lessorById";
    }


    @GetMapping("/editLessor/{id}")
    public String editLessor(@PathVariable Long id, Model model) {

        Lessor lessor = repository.findById(id).get();
        model.addAttribute("lessor", lessor);
        return "lessor/editLessor";
    }

    @PostMapping("/editLessor/{id}")
    public String editLessor(@PathVariable Long id,@RequestParam String name,
                               @RequestParam String lastname,
                               Model model)
    {
        Lessor lessor = repository.findById(id).get();
        lessor.setFirstname(name);
        lessor.setLastname(lastname);
        repository.save(lessor);
        return "redirect:/mainLessor";

    }

    @GetMapping("lessorDelete/{id}")
    public String remove(@PathVariable(value = "id") Long id, Model model) {
        if (!repository.existsById(id)) {
            return "redirect:/mainLessor";
        }
        Lessor lessor = repository.findById(id).get();
        repository.delete(lessor);
        return "redirect:/mainLessor";
    }

}
