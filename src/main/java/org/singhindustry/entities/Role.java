package org.singhindustry.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	

    @Id
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
    public Role(String name) {
        this.name = name;
    }

}
