package gfhouse.matchmaker.domain.diary;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tb_diary_hates")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryHates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long diaryId;

    private Long userId;

    @Builder
    public DiaryHates(Long diaryId, Long userId) {
        this.diaryId = diaryId;
        this.userId = userId;
    }
}
