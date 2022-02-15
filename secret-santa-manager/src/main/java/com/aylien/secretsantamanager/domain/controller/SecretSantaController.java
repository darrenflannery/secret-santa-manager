package com.aylien.secretsantamanager.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aylien.secretsantamanager.domain.TeamMember;
import com.aylien.secretsantamanager.repository.TeamMemberRepository;


@RestController
@RequestMapping("/secretsanta")
public class SecretSantaController {
	

	@Autowired
	private TeamMemberRepository repo;
	
	@PostMapping("/save")
	public String saveTeammate(@RequestBody TeamMember teamMember) {
		repo.save(teamMember);
		return "Team Member saved";
	}
}
