package org.generation.italy.demo.service;

import java.util.List;

import org.generation.italy.demo.pojo.Promozione;
import org.generation.italy.demo.repo.PromozioneRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PromozioneService {
	@Autowired
	private PromozioneRepo promoRep;
	
	public void save(Promozione promozione) {
		promoRep.save(promozione);
	}
	
	public void deletePromozioneById(int id) {
		promoRep.deleteById(id);
	}
	
	public Promozione findById(int id) {
		return promoRep.findById(id).get();
	}
	
	public List<Promozione> findAll(){
		return promoRep.findAll();
	}
	
	@Transactional
	public List<Promozione> findAllWPizza() {
		List<Promozione> promozioni = promoRep.findAll();
		
		for (Promozione promozione : promozioni) {
			Hibernate.initialize(promozione.getPizze());
		}
		
		return promozioni;
	}	
	
}
