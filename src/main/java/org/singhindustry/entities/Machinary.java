package org.singhindustry.entities;

import java.time.LocalDateTime;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Machinary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Date date;
	@NotEmpty
	private String name;
	@NotNull
	private Integer rate;
	@NotEmpty
	private String type;
	@NotNull
	private Integer quantity;
	@NotEmpty
	private String unit;
	@NotNull
	private Integer total;
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime created_at;

	@UpdateTimestamp
	private LocalDateTime updated_at;

}
