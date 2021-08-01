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

            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            // entity 만
            em.detach(member);
            // 영속성 컨텍스트 초기화(1차 캐시까지 다 지워서 find 내용도 없어짐, 뒤에 같은 내용 다시 찾으면 1차 캐시에 없어 다시 db에서 쿼리로 찾아와야 함)
            em.clear();

            System.out.println("===============");

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();  // 앞쪽에 커밋 전에 하면 영속성 없어짐
        }

        emf.close();
    }
}
