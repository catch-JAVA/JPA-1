package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    // 엔티티 매니저에 스프링이 빈을 넣어줌
    private final EntityManager em;

    // persist 하면
    // 영속성 Context에 회원을 넣어줌
    public void save(Member member){
        em.persist(member);
    }

    // 하나만 조회
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    // 전체 조회 - JPQL
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
