package org.generation.italy.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.generation.italy.demo.pojo.Ingrediente;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.pojo.Promozione;
import org.generation.italy.demo.service.IngredienteService;
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
	
	@Autowired
	IngredienteService ingServ;

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
		
		Ingrediente i1 = new Ingrediente("Pomodoro");
		Ingrediente i2 = new Ingrediente("Mozzarella");
		Ingrediente i3 = new Ingrediente("Acciughe");
		Ingrediente i4 = new Ingrediente("Basilico");
		Ingrediente i5 = new Ingrediente("Gorgonzola");
		Ingrediente i6 = new Ingrediente("Prosciutto Cotto");
		Ingrediente i7 = new Ingrediente("Prosciutto Crudo");
		Ingrediente i8 = new Ingrediente("Funghi");
		Ingrediente i9 = new Ingrediente("Carciofi");
		Ingrediente i10 = new Ingrediente("Olive");
		
		List<Ingrediente> ingredienti1 = new ArrayList<>();
		ingredienti1.add(i1);
		ingredienti1.add(i2);
		
		List<Ingrediente> ingredienti2 = new ArrayList<>();
		ingredienti2.add(i1);
		ingredienti2.add(i2);
		ingredienti2.add(i8);
		ingredienti2.add(i9);
		ingredienti2.add(i10);
		
		List<Ingrediente> ingredienti3 = new ArrayList<>();
		ingredienti3.add(i1);
		ingredienti3.add(i2);
		ingredienti3.add(i3);
		
		ingServ.save(i1);
		ingServ.save(i2);
		ingServ.save(i3);
		ingServ.save(i4);
		ingServ.save(i5);
		ingServ.save(i6);
		ingServ.save(i7);
		ingServ.save(i8);
		ingServ.save(i9);
		ingServ.save(i10);
		
		Pizza p1 = new Pizza("Pizza Marghertita", "La pizza più buona la mondo", 4, pr1, ingredienti1);
		Pizza p2 = new Pizza("Pizza Capricciosa", "La pizza più gustosa", 8, pr1, ingredienti2);
		Pizza p3 = new Pizza("Pizza Diavola", "La pizza più piccante", 7, pr2);
		Pizza p4 = new Pizza("Pizza Bufalina", "La pizza con la migliore, mozzarella di bufala", 10, pr3);
		Pizza p5 = new Pizza("Pizza Biancaneve", "La pizza bianca con base di mozzarella e fior di latte", 4, pr3);
		Pizza p6 = new Pizza("Pizza Marinara", "La pizza con le acciughe", 5, null, ingredienti3);
		
		pizzaServ.save(p1);
		pizzaServ.save(p2);
		pizzaServ.save(p3);
		pizzaServ.save(p4);
		pizzaServ.save(p5);
		pizzaServ.save(p6);
		
		//----------DELETE-------------
		//promoServ.deletePromozioneById(1);
		//pizzaServ.deleteById(1);
		

//		List<Pizza> pizze = pizzaServ.findAll();
//		for (Pizza pizza : pizze) {
//			System.err.println(pizza + "\n\t" + pizza.getPromozione() +"\n");
//		}
//		
//
//		List<Promozione> promozioni = promoServ.findAllWPizza();
//		for(Promozione promozione : promozioni) {
//			System.err.println(promozione);
//			for(Pizza pizza : promozione.getPizze()) {
//				System.err.println("\t" + pizza);
//			}
//		}
		
		System.err.println("---------------------------");
		List<Pizza> pizze = pizzaServ.findAllWIngrediente();
		for (Pizza pizza : pizze) {
			System.err.println(pizza + "\n\t" + pizza.getIngredienti());
		}
		
		System.err.println("---------------------------");
		List<Ingrediente> ingredienti = ingServ.findAllWPizza();
		for (Ingrediente ingrediente : ingredienti) {
			System.err.println(ingrediente +  "\n\t" + ingrediente.getPizze());
		}
		
	}

}
