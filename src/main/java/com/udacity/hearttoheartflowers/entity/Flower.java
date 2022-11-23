package com.udacity.hearttoheartflowers.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "plant")
@ToString			// have toString method
@NoArgsConstructor	// default constructor
@EqualsAndHashCode	// equal and hashcode method
public class Flower {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Getter @Setter Long id;
	
	@Column(name = "name")
	@Nationalized	// support international language character
	private @Getter @Setter String name;
	
	@Column(name = "color")
	private @Getter @Setter String color;
	
	@Column(name = "price", precision = 12, scale = 4)	// decimal with 12 precision and 4 decimal places
	private @Getter @Setter BigDecimal price;

	public Flower(String name, String color, BigDecimal price) {
		this.name = name;
		this.color = color;
		this.price = price;
	}
}
