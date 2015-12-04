package com.malsolo.zaqar.alert.generator.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Kind {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max = 50)
	private String name;

	@NotNull
	@Size(max = 150)
	private String description;
	
	@NotNull
	private Boolean active;
	
	@NotNull
	@Min(0)
	private Integer additionalEvents;
	
	@NotNull
	@Min(0)
	private Long additionalEventsTimeBefore;

}
