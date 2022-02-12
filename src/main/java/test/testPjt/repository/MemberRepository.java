package test.testPjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.testPjt.domain.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsername(String username);
}


//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Repository;
//import test.testPjt.domain.Member;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class MemberRepository {
//
//    private final EntityManager em;
//
//    public void save(Member member) {
//        em.persist(member);
//    }
//
//    public Member findById(Long id) {
//        return em.find(Member.class, id);
//    }
//
//    public List<Member> findAll(){
//        return em.createQuery("select m from Member m", Member.class)
//                .getResultList();
//    }
//
//    public List<Member> findByName(String name) {
//        return em.createQuery("select m form Member where m.name = :name", Member.class)
//                .setParameter("name", name)
//                .getResultList();
//    }
//}
//
