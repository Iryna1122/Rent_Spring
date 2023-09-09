package com.example.Rent_Spring.Controllers;

import com.example.Rent_Spring.Models.Clients;
import com.example.Rent_Spring.Models.Lessor;
import com.example.Rent_Spring.Repo.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientsController {

    @Autowired
    ClientsRepository repository;

    @GetMapping("/mainClient")
    public String mainClient(Model model)
    {
        Iterable<Clients>clients = repository.findAll();
        model.addAttribute("clients",clients);

        return "client/mainClient";

    }

    @GetMapping("/addClient")
    public String addClient(Model model)
    {
        return "client/addClient";
    }

    @PostMapping("/addClient")
    public String saveLessor(@RequestParam String name, @RequestParam String lastname, Model model)
    {
        Clients client = new Clients(name,lastname);
        repository.save(client);
        return "redirect:/mainClient";
    }

    @GetMapping("/clientById/{id}")
    public String clientById(@PathVariable(value = "id") Long id, Model model)
    {
        if (!repository.existsById(id)) {
            return "redirect:/main";
        }
        Clients client = repository.findById(id).get();
        model.addAttribute("client",client);

        return "client/clientById";
    }

    @GetMapping("/editClient/{id}")
    public String editClient(@PathVariable Long id, Model model) {

        Clients client = repository.findById(id).get();
        model.addAttribute("client", client);
        return "client/editClient";
    }

    @PostMapping("/editClient/{id}")
    public String editClient(@PathVariable Long id,@RequestParam String name,
                             @RequestParam String lastname,
                             Model model)
    {
        Clients client = repository.findById(id).get();
        client.setFirstname(name);
        client.setLastname(lastname);
        repository.save(client);
        return "redirect:/mainClient";

    }

    @GetMapping("clientDelete/{id}")
    public String remove(@PathVariable(value = "id") Long id, Model model) {
        if (!repository.existsById(id)) {
            return "redirect:/mainClient";
        }
        Clients client = repository.findById(id).get();
        repository.delete(client);
        return "redirect:/mainClient";
    }
}
