package com.aylien.secretsantamanager.domain.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/getall")
	public List<TeamMember> findAll() {
		return repo.findAll();
	}

	@RequestMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id) {
		try {
			String fullName = repo.getById(id).getFirstName() + " " + repo.getById(id).getLastName();
			repo.deleteById(id);
			return fullName + " deleted";
		}catch (EntityNotFoundException e){
			return "User not found";
		}
	}
	
}
