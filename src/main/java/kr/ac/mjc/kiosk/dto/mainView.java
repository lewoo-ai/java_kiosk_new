package kr.ac.mjc.kiosk.dto;

import lombok.Getter;

@Getter
public class mainView {
    private final Long id;
    private final String title;

    private  final String content;

    public mainViewResponse(Cafe cafe) {
        this.id =cafe.getId();
        this.title =cafe.getTitle();
        this.content =cafe.getContent();
    }
}
