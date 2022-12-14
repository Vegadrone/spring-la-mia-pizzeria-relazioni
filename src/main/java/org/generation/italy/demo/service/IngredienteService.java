package org.generation.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Ingrediente;
import org.generation.italy.demo.repo.IngredienteRepo;
import org.generation.italy.demo.repo.PizzaRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepo ingRep;
	
	public void save (Ingrediente ingrediente) {
		ingRep.save(ingrediente);
	}
	
	public void deleteIngredienteById(int id) {
		ingRep.deleteById(id);
	}
	
	public List<Ingrediente> findAll(){
		return ingRep.findAll();
	}
	
	public Optional<Ingrediente> findIngredienteById(int id){
		return ingRep.findById(id);
	}
	
	public void deleteById(int id) {
		ingRep.deleteById(id);
	}
	
	@Transactional
	public List<Ingrediente> findAllWPizza(){
		List<Ingrediente> ingredienti = ingRep.findAll();
		
		for(Ingrediente ingrediente : ingredienti) {
			Hibernate.initialize(ingrediente.getPizze());
		}
		
		return ingredienti;
	}
		
}
