package org.singhindustry.entities;

import java.time.LocalDateTime;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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
public class Karigar_record extends BaseEntity{
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employee employee;
	
	
	private Date date;
	
	@NotEmpty
	private String type;
	
	@NotNull
	private Integer rate;
	
	@NotNull
	private Integer submitted;
	
	@NotNull
	private Integer total;
	
	
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
	
	
}
