package com.oussema.pieces.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Nature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNat;
	private String nomNat;
	private String descriptionNat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "nature")
	private List<Piece> pieces;

	public Long getIdNat() {
		return idNat;
	}

	public void setIdNat(Long idNat) {
		this.idNat = idNat;
	}

	public String getNomNat() {
		return nomNat;
	}

	public void setNomNat(String nomNat) {
		this.nomNat = nomNat;
	}

	public String getDescriptionNat() {
		return descriptionNat;
	}

	public void setDescriptionNat(String descriptionNat) {
		this.descriptionNat = descriptionNat;
	}
	
	
	
}
