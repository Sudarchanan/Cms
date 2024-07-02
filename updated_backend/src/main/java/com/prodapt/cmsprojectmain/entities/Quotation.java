package com.prodapt.cmsprojectmain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "quotation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Quotation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String customerName;
	private Double totalAmount;
	private Double discount;
	private Integer quantity;

}