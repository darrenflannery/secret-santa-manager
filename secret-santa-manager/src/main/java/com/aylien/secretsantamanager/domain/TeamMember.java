package com.aylien.secretsantamanager.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@OneToMany(
			targetEntity = TeamMemberHistoryRecord.class,
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	@JoinColumn(name="TEAM_MEMBER_ID", referencedColumnName = "id")
	private List<TeamMemberHistoryRecord> historyRecords;
	
	public TeamMember(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

