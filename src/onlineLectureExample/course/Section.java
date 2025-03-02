package onlineLectureExample.course;

import java.util.List;

public class Section {
    private String name;
    private int sectionNum;
    private List<Lecture> lectures;

    //when it is constructed it should contain at least one lecture
    public Section(String name, int sectionNum, List<Lecture> lectures) {
        this.name = name;
        this.sectionNum = sectionNum;
        if (lectures.isEmpty()) {
            throw new IllegalStateException("적어도 1개의 강의가 포함되어야 합니다");
        }
        this.lectures = lectures;
    }
}
