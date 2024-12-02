package com.app.jpa.repository;

import com.app.jpa.domain.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    등록
    public Member save(Member member) {
        entityManager.persist(member);
        entityManager.flush();
        entityManager.clear();
        return member;
    };

//    PK로 조회
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

//    삭제
    public void delete(Member member) {
        entityManager.remove(member);
    }

//    로그인
    public Optional<Member> findByMemberEmailAndMemberPassword(Member member){
//        JPQL
        String query = "select m from Member m where m.memberEmail = :memberEmail and m.memberPassword = :memberPassword";
        return Optional.ofNullable(entityManager.createQuery(query, Member.class)
                .setParameter("memberEmail", member.getMemberEmail())
                .setParameter("memberPassword", member.getMemberPassword())
                .getSingleResult());
    }
}














