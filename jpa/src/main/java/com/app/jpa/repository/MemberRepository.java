package com.app.jpa.repository;

import com.app.jpa.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findByMemberEmailAndMemberPassword(String memberEmail, String memberPassword);
}
