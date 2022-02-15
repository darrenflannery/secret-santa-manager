package com.aylien.secretsantamanager.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecretSantaResult {
	private int year;
	private List<String> santas;
	
	public SecretSantaResult(int year) {
		this.year = year;
	}
	
	
}
