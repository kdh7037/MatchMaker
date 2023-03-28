package gfhouse.matchmaker.domain.diary;

import gfhouse.matchmaker.domain.base.EntityAudit;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryLikes extends EntityAudit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long diaryId;

    private Long userId;

    @Builder
    public DiaryLikes(Long diaryId, Long userId) {
        this.diaryId = diaryId;
        this.userId = userId;
    }
}
