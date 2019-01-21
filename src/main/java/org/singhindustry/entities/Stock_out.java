package org.singhindustry.entities;

import java.time.LocalDateTime;

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
public class Stock_out {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String date;
	@NotEmpty
	private String product;
	@NotEmpty
	private String party;
	@NotNull
	private Integer rate;
	@NotNull
	private Integer quantity;
	@NotEmpty
	private String unit;
	@NotNull
	private Integer total;
	@NotNull
	private Integer delivered;
	@NotNull
	private Integer remaining;
	
	@CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
	
}
