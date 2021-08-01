package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            // 영속성 컨텍스트에 계속 쌓이는 단계
            em.persist(member1);
            em.persist(member2);
            System.out.println("==============");

            // 실제 db로 넘어가는 단계
           tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
