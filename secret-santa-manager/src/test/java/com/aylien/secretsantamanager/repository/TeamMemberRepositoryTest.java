package com.aylien.secretsantamanager.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aylien.secretsantamanager.domain.TeamMember;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class TeamMemberRepositoryTest {

	@Autowired
	private TeamMemberRepository repo;
	private TeamMember teamMember;

	@BeforeEach
	public void setUp() {
		teamMember = new TeamMember("John","Smith");
	}

	@Test
	public void givenTeamMemberToAddShouldReturnAddedTeamMember(){
		repo.save(teamMember);
		TeamMember fetchedTeamMember = repo.findById(teamMember.getId()).get();
		assertNotNull(fetchedTeamMember.getId());
		assertEquals(teamMember, fetchedTeamMember);
	}

	@Test
	public void GivenGetAllTeamMembersShouldReturnListOfAllTeamMembers(){
		TeamMember teamMember1 = new TeamMember("John","Smith");
		TeamMember teamMember2 = new TeamMember("Joe","Bell");
		repo.save(teamMember1);
		repo.save(teamMember2);
		
		List<TeamMember> team = (List<TeamMember>) repo.findAll();

		assertTrue(team.get(0).getFirstName().length()>0);
		assertTrue(team.size()>0);
	}

	@Test
	public void givenIdTODeleteThenShouldDeleteTheTeamMember() {
		TeamMember teamMember = new TeamMember("John","Smith");
		repo.save(teamMember);
		repo.deleteById(teamMember.getId());
		Optional optional = repo.findById(teamMember.getId());
		assertEquals(Optional.empty(), optional);
	}

	@AfterEach
	public void tearDown() {
		repo.deleteAll();
		teamMember = null;
	}

}
