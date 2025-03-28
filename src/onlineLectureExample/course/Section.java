package onlineLectureExample.course;

import java.util.List;

//한 섹션에는 최소 1개 이상의 강의 영상이 포함되어야 함.
public class Section {

    private Long id;
    private String name;
    private int sectionNum;
    private List<Lecture> lectures;

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

    public int getSectionNum() {
        return sectionNum;
    }

    //when it is constructed it should contain at least one lecture
    //course를 집어 넣어 코스에 해당 섹션 번호가 있는지 검증
    public static Section of(Course course, Long id, String name, int sectionNum, List<Lecture> lectures) {
        course.validSectionNumber(sectionNum);

        Section section = new Section();
        section.id = id;
        section.name = name;
        section.sectionNum = sectionNum;
        if (lectures.isEmpty()) {
            throw new IllegalStateException("적어도 1개의 강의가 포함되어야 합니다");
        }
        section.lectures = lectures;
        return section;
    }
}
