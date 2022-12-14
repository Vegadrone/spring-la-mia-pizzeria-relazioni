package org.generation.italy.demo.pojo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Devi inserire il nome dell'ingrediente")
	@NotBlank(message = "Non può essere vuoto")
	private String nome;
	
	@ManyToMany(mappedBy = "ingredienti", cascade = CascadeType.REMOVE)
	private List<Pizza> pizze;
	
	public Ingrediente() {}
	public Ingrediente(String nome) {
		setNome(nome);
	}
	
	public Ingrediente(String nome, List <Pizza> pizze) {
		this(nome);
		setPizze(pizze);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Pizza> getPizze() {
		return pizze;
	}
	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}
	@Override
	public String toString() {
	
		return "(" + getId() + ")" + " - " + getNome();
	}
}
