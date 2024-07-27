package com.techruna.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TBL_URL_MAPPING")
public class UrlMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "URL_SHORT")
	private String shortUrl;
	
	@Column(name ="URL_ORIGEN")
	private String UrlOrigen;
	
}
