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
@Table(name="HISTORY_RECORD")
public class TeamMemberHistoryRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HISTORY_REC_ID", nullable = false)
	private int historyRecId;
	@Column(name="YEAR", nullable = false)
	private int year;
	@Column(name="RECIPIENT_ID", nullable = false)
	private int recipientId;
}
