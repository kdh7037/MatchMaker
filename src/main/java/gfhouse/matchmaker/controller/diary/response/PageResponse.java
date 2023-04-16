package gfhouse.matchmaker.controller.diary.response;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageResponse<T> {
    private List<T> contents;
    private Integer page;
    private Integer size;
    private Long total;
    private Boolean isLast;

    public static <T> PageResponse<T> of(Page<T> page) {
        PageResponse<T> view = new PageResponse<>();
        view.setContents(page.getContent());
        view.setPage(page.getNumber());
        view.setSize(page.getSize());
        view.setTotal(page.getTotalElements());
        view.setIsLast(page.isLast());

        return view;
    }
}
