package gfhouse.matchmaker.view;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageView<T> {
    private List<T> contents;
    private Integer page;
    private Integer size;
    private Long total;
    private Boolean isLast;

    public static <T> PageView<T> of(Page<T> page) {
        PageView<T> view = new PageView<>();
        view.setContents(page.getContent());
        view.setPage(page.getNumber());
        view.setSize(page.getSize());
        view.setTotal(page.getTotalElements());
        view.setIsLast(page.isLast());

        return view;
    }
}
