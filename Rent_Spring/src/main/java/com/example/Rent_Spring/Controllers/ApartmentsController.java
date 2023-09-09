package com.example.Rent_Spring.Controllers;

import com.example.Rent_Spring.Models.Apartments;
import com.example.Rent_Spring.Models.Clients;
import com.example.Rent_Spring.Models.Lessor;
import com.example.Rent_Spring.Repo.ApartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApartmentsController {

    @Autowired
    ApartmentsRepository repository;

    @GetMapping("mainApartment")
    public String mainApartment(Model model)
    {
        Iterable<Apartments>apartments = repository.findAll();
        model.addAttribute("apartments", apartments);

        return "apartment/mainApartment";

    }

    @GetMapping("/addApartment")
    public String addApartment(Model model)
    {
        return "apartment/addApartment";
    }

    @PostMapping("/addApartment")
    public String saveApartment(@RequestParam String address, @RequestParam int number, Model model)
    {
        Apartments apartment = new Apartments(address,number);
        repository.save(apartment);
        return "redirect:/mainApartment";
    }


    @GetMapping("/apartmentById/{id}")
    public String apartmentById(@PathVariable(value = "id") Long id, Model model) {
        if (!repository.existsById(id)) {
            return "redirect:/main";
        }
        Apartments apartment = repository.findById(id).get();
        model.addAttribute("apartment", apartment);
        return "apartment/apartmentById";
    }


    @GetMapping("/editApartment/{id}")
    public String editApartment(@PathVariable Long id, Model model) {

       Apartments apartment = repository.findById(id).get();
        model.addAttribute("apartment", apartment);
        return "apartment/editApartment";
    }

    @PostMapping("editApartment/{id}")
    public String editClient(@PathVariable Long id,@RequestParam String address,
                             @RequestParam int number,
                             Model model)
    {
        Apartments apartment = repository.findById(id).get();
        apartment.setAddress(address);
        apartment.setNumberOfRooms(number);
        repository.save(apartment);
        return "redirect:/mainApartment";

    }

    @GetMapping("/apartmentDelete/{id}")
    public String remove(@PathVariable(value = "id") Long id, Model model) {
        if (!repository.existsById(id)) {
            return "redirect:/mainApartment";
        }
        Apartments apartment = repository.findById(id).get();
        repository.delete(apartment);
        return "redirect:/mainApartment";
    }


}
