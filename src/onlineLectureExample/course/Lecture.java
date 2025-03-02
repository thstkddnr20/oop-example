package onlineLectureExample.course;

import java.time.Duration;

public class Lecture {
    private String name;
    private Duration length;
    private String attachment;

    public Lecture(String name, Duration length, String attachment) {
        this.name = name;
        this.length = length;
        this.attachment = attachment;
    }
}
