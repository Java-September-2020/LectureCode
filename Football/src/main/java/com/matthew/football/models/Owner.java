package com.matthew.football.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="owners")
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private Long netWorth;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="likes",
		joinColumns = @JoinColumn(name="owner_id"),
		inverseJoinColumns = @JoinColumn(name="team_id")
		)
	private List<Team> likedTeams;
	
	
	public Owner() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getNetWorth() {
		return netWorth;
	}
	public void setNetWorth(Long netWorth) {
		this.netWorth = netWorth;
	}
	public List<Team> getLikedTeams() {
		return likedTeams;
	}
	public void setLikedTeams(List<Team> likedTeams) {
		this.likedTeams = likedTeams;
	}
	
	
	
}
