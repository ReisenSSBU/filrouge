package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Theme {
	@Id@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idTheme;
	
	private String nomTheme;
	
	@ManyToMany(mappedBy="theme")
	private Set<Formation> formation=new HashSet<>();

	
	// Un theme peut posseder des sousthemes --relation onetomany-- notion de reflexivité
	@OneToMany ( cascade=CascadeType.PERSIST)
	private Set<Theme> sousthemes=new HashSet<>();
	
	public Theme(String nomTheme) {
		super();
		this.nomTheme = nomTheme;
	}
	
	public Theme() {}

	public long getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(long idTheme) {
		this.idTheme = idTheme;
	}

	public String getNomTheme() {
		return nomTheme;
	}

	public void setNomTheme(String nomTheme) {
		this.nomTheme = nomTheme;
	}

	public Set<Formation> getFormation() {
		return formation;
	}

	public void setFormation(Set<Formation> formation) {
		this.formation = formation;
	}

	public Set<Theme> getSousthemes() {
		return sousthemes;
	}

	public void setSousthemes(Set<Theme> sousthemes) {
		this.sousthemes = sousthemes;
	}
	
	

}
