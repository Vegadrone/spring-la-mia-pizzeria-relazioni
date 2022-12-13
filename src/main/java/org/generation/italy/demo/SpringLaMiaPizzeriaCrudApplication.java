package org.generation.italy.demo;

import java.time.LocalDate;
import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.pojo.Promozione;
import org.generation.italy.demo.service.PizzaService;
import org.generation.italy.demo.service.PromozioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	PizzaService pizzaServ;
	
	@Autowired
	PromozioneService promoServ;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		
		Promozione pr1 = new Promozione(LocalDate.parse("2022-12-12"), LocalDate.parse("2023-02-02"), "PizzaPromo1");
		Promozione pr2 = new Promozione(LocalDate.parse("2022-12-12"), LocalDate.parse("2023-03-02"), "PizzaPromo2");
		Promozione pr3 = new Promozione(LocalDate.parse("2022-12-12"), LocalDate.parse("2023-10-02"), "PizzaPromo3");
		
		promoServ.save(pr1);
		promoServ.save(pr2);
		promoServ.save(pr3);
		
		Pizza p1 = new Pizza("Pizza Marghertita", "La pizza più buona la mondo", 4, pr1);
		Pizza p2 = new Pizza("Pizza Capricciosa", "La pizza più gustosa", 8, pr1);
		Pizza p3 = new Pizza("Pizza Diavola", "La pizza più piccante", 7, pr2);
		Pizza p4 = new Pizza("Pizza Bufalina", "La pizza con la migliore, mozzarella di bufala", 10, pr3);
		Pizza p5 = new Pizza("Pizza Biancaneve", "La pizza bianca con base di mozzarella e fior di latte", 4, pr3);
		Pizza p6 = new Pizza("Pizza Marinara", "La pizza con le acciughe", 5, null);
		
		pizzaServ.save(p1);
		pizzaServ.save(p2);
		pizzaServ.save(p3);
		pizzaServ.save(p4);
		pizzaServ.save(p5);
		pizzaServ.save(p6);
		
		//----------DELETE-------------
		//promoServ.deletePromozioneById(1);
		//pizzaServ.deleteById(1);
		

		List<Pizza> pizze = pizzaServ.findAll();
		for (Pizza pizza : pizze) {
			System.err.println(pizza + "\n\t" + pizza.getPromozione() +"\n");
		}
		

		List<Promozione> promozioni = promoServ.findAllWPizza();
		for(Promozione promozione : promozioni) {
			System.err.println(promozione);
			for(Pizza pizza : promozione.getPizze()) {
				System.err.println("\t" + pizza);
			}
		}
		
	}

}
