package com.aylien.secretsantamanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aylien.secretsantamanager.domain.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {

}
