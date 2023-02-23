package gfhouse.matchmaker.domain;

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

    @ManyToOne
    @JoinColumn
    private User user;

    @Column
    private String player1Nickname;

    @Column
    private String player2Nickname;

    @Column
    private Integer player1Score;

    @Column
    private Integer player2Score;

    @Column
    private String roomNumber;

    @Column
    private Short status;
}