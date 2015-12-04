package com.malsolo.zaqar.alert.generator.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Alert {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "KIND_ID", nullable = false)
	@NotNull
	private Kind kind;

	@OneToMany(mappedBy = "alert")
	@NotNull
	private Set<Event> events;

	@NotNull
	private Date creationDate;
	
	@Size(max = 250)
	private String message;

}
