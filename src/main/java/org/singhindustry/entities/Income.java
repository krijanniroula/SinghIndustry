package org.singhindustry.entities;

import java.time.LocalDateTime;

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
public class Income {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String date;
	@NotEmpty
	private String party;
	@NotNull
	private Integer amount;
	@NotNull
	private Integer total_amount;
	@NotNull
	private Integer remaining;
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
	
}
