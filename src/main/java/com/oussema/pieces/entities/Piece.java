package com.oussema.pieces.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Piece {	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPiece;
	
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomPiece;
	
	@Min(value = 10)
    @Max(value = 10000)
	private Double prixPiece;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@NotNull
	private String model ;
	
	
	@ManyToOne
	
	private Nature nature;



	public Piece() {
		super();
	}
	
	
	public Piece(String nomPiece, Double prixPiece, Date dateCreation,String model) {
		super();
		this.nomPiece = nomPiece;
		this.prixPiece = prixPiece;
		this.dateCreation = dateCreation;
		this.model=model;
	}


	
	public Long getIdPiece() {
		return idPiece;
	}


	public void setIdPiece(Long idPiece) {
		this.idPiece = idPiece;
	}


	public String getNomPiece() {
		return nomPiece;
	}


	public void setNomPiece(String nomPiece) {
		this.nomPiece = nomPiece;
	}


	public Double getPrixPiece() {
		return prixPiece;
	}


	public void setPrixPiece(Double prixPiece) {
		this.prixPiece = prixPiece;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	




	public Nature getNature() {
		return nature;
	}


	public void setNature(Nature nature) {
		this.nature = nature;
	}


	@Override
	public String toString() {
		return "Piece [idPiece=" + idPiece + ", nomPiece=" + nomPiece + ", prixPiece=" + prixPiece + ", dateCreation="
				+ dateCreation + ", model=" + model + "]";
	}


	
	
	

}
