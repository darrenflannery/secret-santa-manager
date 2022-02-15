package com.aylien.secretsantamanager.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aylien.secretsantamanager.domain.TeamMember;
import com.aylien.secretsantamanager.repository.TeamMemberRepository;

@Service("secretSantaService")
public class SecretSantaServiceImpl implements SecretSantaService{

	@Autowired
	private TeamMemberRepository repo;
	
	@Override
	public List<String> createList() {
		List<TeamMember> team = repo.findAll();
		
		System.out.println(createListFromIds());
		
		return null;
	}
	
	private List<Integer> createListFromIds(){
		List<Integer> field1List = (repo.findAll())
				.stream()
				.map(TeamMember -> TeamMember.getId())
				.collect(Collectors.toList());
		return field1List;
	}

}
