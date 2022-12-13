package org.generation.italy.demo.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "devi inserire un nome")
	@Size(min=5, max= 20, message = "il nome deve essere di minimo 5 massimo 20 caratteri")
	private String nome;
	
	@NotNull(message = "devi inserire una descrizione")
	@Lob
	private String descrizione;
	
	@NotNull(message = "il prezzo non può essere vuoto")
	@Min(value = 0)
	private int prezzo;
	
	@ManyToOne
	@JoinColumn(name="promotion_id", nullable=true)
	private Promozione promozione;
	
	public Pizza() {};
	public Pizza(String nome, String descrizione, int prezzo, Promozione promozione) {
		setNome(nome);
		setDescrizione(descrizione);
		setId(prezzo);
		setPromozione(promozione);
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	public Promozione getPromozione() {
		return promozione;
	}
	public void setPromozione(Promozione promozione) {
		this.promozione = promozione;
	}
	
	@Override
	public String toString() {
		
		return "Nome: " + getNome() +
				"\nDescrizione: " + getDescrizione() +
				"\nPrezzo: " + getPrezzo();
	}
				
}

