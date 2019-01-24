package org.singhindustry.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity{
	
	@OneToOne(mappedBy="employee")
	private Monthly_staff monthly_staff;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employee")
	private Set<Kharcha> kharcha =new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employee")
	private Set<Attendence> attendence =new HashSet<>();

	@NotEmpty
	@Valid
	private String name;
	
	@NotEmpty
	private String status;
	
	@NotEmpty
	private String join_date;
	
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
	

}
