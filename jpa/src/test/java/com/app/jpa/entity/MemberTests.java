package com.app.jpa.entity;

import com.app.jpa.domain.entity.Member;
import com.app.jpa.domain.type.MemberType;
import com.app.jpa.repository.MemberDAO;
import com.app.jpa.repository.MemberRepository;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MemberTests {

//    @PersistenceUnit
//    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void memberTest(){
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        transaction.begin();

        Member memberA = Member.builder()
                .memberEmail("tedhan1204@gmail.com")
                .memberPassword("1234")
                .memberAge(20)
                .memberName("한동석")
                .build();

        Member memberB = Member.builder()
                .memberEmail("hgd1234@naver.com")
                .memberPassword("9999")
                .memberAge(50)
                .memberName("홍길동")
                .memberType(MemberType.ADMIN)
                .build();

        entityManager.persist(memberA);
        entityManager.persist(memberB);

//        entityManager.clear();

        Member memberX = entityManager.find(Member.class, 1L);
        log.info("member: {}", memberX);

        Member memberY = entityManager.find(Member.class, 1L);
        log.info("member: {}", memberY);

        assertThat(memberX).isEqualTo(memberY);

//        transaction.commit();
//        entityManager.close();
        
//        영속 상태: 1차 캐시에 등록된 상태
//        준영속 상태: detached instance이며, detached()를 사용하여 1차 캐시로부터 분리된 상태
//        비영속 상태: 1차 캐시에 등록되지 않은 상태
//        삭제 상태: remove()를 사용하여 1차 캐시로부터 삭제된 상태
    }

    @Test
    @Transactional
    @Rollback(false)
    public void memberDAOTest(){
        Member memberA = Member.builder()
                .memberEmail("tedhan1204@gmail.com")
                .memberPassword("1234")
                .memberAge(20)
                .memberName("한동석")
                .build();

        Member member = memberDAO.save(memberA);
        member.setMemberName("이순신");
        Optional<Member> foundMember = memberDAO.findById(1L);
        log.info("member: {}", foundMember.get());
        memberDAO.delete(foundMember.get());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void memberRepositoryTest() {
        Member memberA = Member.builder()
                .memberEmail("tedhan1204@gmail.com")
                .memberPassword("1234")
                .memberAge(20)
                .memberName("한동석")
                .build();

        Member member = memberRepository.save(memberA);
        member.setMemberName("이순신");
        Optional<Member> foundMember = memberRepository.findById(1L);
        log.info("member: {}", foundMember.get());
        memberRepository.delete(foundMember.get());
    }
}
