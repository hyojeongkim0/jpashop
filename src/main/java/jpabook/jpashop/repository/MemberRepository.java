package jpabook.jpashop.repository;

import java.lang.reflect.Member;
import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(jpabook.jpashop.domain.Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("selete m from Memeber m", Member.class)
                 .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Memeber m where m.name = :name", Member.class)
                 .setParameter("name", name)
                 .getResultList();
    }
}