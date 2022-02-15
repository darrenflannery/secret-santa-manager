package com.aylien.secretsantamanager.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aylien.secretsantamanager.domain.TeamMember;

@ExtendWith(SpringExtension.class)
@DataJpaTest
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

	@AfterEach
	public void tearDown() {
		repo.deleteAll();
		teamMember = null;
	}

}
