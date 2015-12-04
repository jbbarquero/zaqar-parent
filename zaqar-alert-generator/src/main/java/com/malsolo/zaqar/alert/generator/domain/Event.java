package com.malsolo.zaqar.alert.generator.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private Long idKind;
	
	@ManyToOne
	@JoinColumn(name = "ALERT_ID")
	@NotNull
	private Alert alert;

	@NotNull
	@Size(max = 50)
	private String code;
	
	@Size(max = 250)
	private String data;
	
	@NotNull
	private Date creationDate;
	
	private Date requestDate;
	
	private Date processDate;
	
	private Integer status;

}
