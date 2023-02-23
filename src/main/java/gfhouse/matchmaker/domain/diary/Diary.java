package gfhouse.matchmaker.domain.diary;

import gfhouse.matchmaker.domain.base.EntityAudit;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "TB_DIARY")
public class Diary extends EntityAudit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String contents;
    private Long likes;
    private Long hates;

    @OneToMany(mappedBy = "diary", cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Comment> comments = Collections.emptyList();

    @Builder
    public Diary(String title, String author, String contents) {
        this.title = title;
        this.author = author;
        this.contents = contents;
        this.likes = 0L;
        this.hates = 0L;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        comment.setDiary(this);
    }
}
