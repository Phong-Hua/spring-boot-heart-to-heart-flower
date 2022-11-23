package com.udacity.hearttoheartflowers.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "delivery")
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Getter @Setter Long id;
	
	@Column(name = "recipient_name")
	@Nationalized	// support international language character
	private @Getter @Setter String recipientName;
	
	@Column(name = "address_full", length = 500)
	private @Getter @Setter String address;
	
	@Column(name = "delivery_date_time")
	private @Getter @Setter LocalDateTime deliveryDateTime;
	
	@Column(name = "completed")
	@Type(type = "yes_no")	// we want completed displayed as yes_no in db
	private @Getter @Setter boolean completed;

	public Delivery(String recipientName, String address, LocalDateTime deliveryDateTime, boolean completed) {
		this.recipientName = recipientName;
		this.address = address;
		this.deliveryDateTime = deliveryDateTime;
		this.completed = completed;
	}
}
