package com.cookingpage.domain.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class Role {
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	public Integer getId() {
		return id;
	}

	public Role(String name) {
		this.name = name;
	}
	// remaining getters and setters
}
/*
@Entity
public class Role {

	@Id
	private int roleId;
	private String name;

	@OneToMany(mappedBy = "role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<UserRole> userRoles = new HashSet<>();

}
*/
