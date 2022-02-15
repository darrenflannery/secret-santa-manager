package com.aylien.secretsantamanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TEAM_MEMBER")
public class TeamMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	@Column(name="FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name="LAST_NAME", nullable = false)
	private String lastName;
	@Column(name="RECIPIENT_ID", nullable = true)
	private Integer recipientId;

	public TeamMember(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

