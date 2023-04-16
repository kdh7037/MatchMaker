package gfhouse.matchmaker.domain.match;

import gfhouse.matchmaker.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_MATCH")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user2_id")
    private User user2;
/*
    @Column
    private String player1Nickname;

    @Column
    private String player2Nickname;

    @Column
    private Integer player1Score;

    @Column
    private Integer player2Score;
*/
    @Column
    private String roomNumber;

    @Column // 0:매칭 전 1:대전 중 2:대전 종료
    private Character status;
}