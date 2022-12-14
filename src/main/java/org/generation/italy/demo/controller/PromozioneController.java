package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.pojo.Promozione;
import org.generation.italy.demo.service.PizzaService;
import org.generation.italy.demo.service.PromozioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/promozione")
public class PromozioneController {
	
	@Autowired
	private PromozioneService promoServ;
	
	@Autowired
	private PizzaService pizzaServ;
	
	@GetMapping
	public String index (Model model) {
		
		List <Promozione> promozioni = promoServ.findAll();
		
		model.addAttribute("promozioni", promozioni);
		
		return "promozione-index";
	}
	
	@GetMapping("/promozione/create")
	public String getPromozioneCreate(Model model) {
		
		Promozione promozione = new Promozione();
		List<Pizza> pizze = pizzaServ.findAll();
		model.addAttribute("promozione", promozione);
		model.addAttribute("pizze", pizze);
		
		return "promozione-create";
	}
	
	@PostMapping("/promozione/create")
	public String storePromozione(@Valid Promozione promozione) {
		
		List <Pizza> pizzeInPromozione = promozione.getPizze();
		for(Pizza pizza : pizzeInPromozione) {
			pizza.setPromozione(promozione);
		}
		promoServ.save(promozione);
		
		return "redirect:/promozione";
	}
}
