package onlineLectureExample.course;

import java.time.Duration;

public class Lecture {

    private Long id;
    private String name;
    private Duration length;
    private String attachment;

    public static Lecture of(Long id, String name, Duration length, String attachment) {
        Lecture lecture = new Lecture();
        lecture.id = id;
        lecture.name = name;
        lecture.length = length;
        lecture.attachment = attachment;
        return lecture;
    }
}
