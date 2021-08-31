package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();
            //

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("m2 = " + refMember.getClass());

            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("reference" + findMember.getClass());

            System.out.println("refMember == findMember " + (refMember == findMember));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();  // 앞쪽에 커밋 전에 하면 영속성 없어짐
        }

        emf.close();
    }

    private static void printMember(Member member) {
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
}
