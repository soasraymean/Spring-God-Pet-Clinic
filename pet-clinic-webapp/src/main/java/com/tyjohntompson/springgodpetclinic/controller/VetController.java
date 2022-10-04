package com.tyjohntompson.springgodpetclinic.controller;

import com.tyjohntompson.springgodpetclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "vets/vets", "vets/vets.html"})
    public String getVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/vets";
    }

}
