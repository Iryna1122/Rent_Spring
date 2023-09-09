package com.example.Rent_Spring.Controllers;

import com.example.Rent_Spring.Models.ApartmentRental;
import com.example.Rent_Spring.Models.Apartments;
import com.example.Rent_Spring.Models.Clients;
import com.example.Rent_Spring.Repo.ApartmentRentalRepository;
import com.example.Rent_Spring.Repo.ApartmentsRepository;
import com.example.Rent_Spring.Repo.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApartmentRentalController {

    @Autowired
    ApartmentRentalRepository repository;
    @Autowired
    ClientsRepository clientsRepository;

    @Autowired
    ApartmentsRepository apartmentsRepository;

    @GetMapping("/rentApartment")
    public String rentApartment(Model model) {

        Iterable<Clients> clients = clientsRepository.findAll();
        Iterable<Apartments>apartments = apartmentsRepository.findAll();
        model.addAttribute("apartmentRental", new ApartmentRental());
        model.addAttribute("clients",clients);
        model.addAttribute("apartments", apartments);
        return "rent/rentApartment";
    }


}
