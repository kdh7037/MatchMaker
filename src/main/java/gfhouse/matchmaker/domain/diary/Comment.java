package gfhouse.matchmaker.domain.diary;

import gfhouse.matchmaker.domain.base.EntityAudit;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "TB_COMMENT")
public class Comment extends EntityAudit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String author;
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @Builder
    public Comment(Long userId, String author, String contents) {
        this.userId = userId;
        this.author = author;
        this.contents = contents;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }
}
