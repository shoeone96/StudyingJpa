package hellojpa;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    private Team team;
    // 이 상태에서는 둘 다 연관관계의 주인인 된 상태(서로 FK를 가지고 있는)
    // insertable, updatable flase를 넣어서 읽기 전용상타로 만든다.

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
