package onlineLectureExample.course;

import onlineLectureExample.user.Instructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private Instructor instructor;
    private List<Section> sections;
    private Category category;
    private Difficulty level;

    private LocalDate postTime;
    private CourseStatus courseStatus;

    //make your course exposed to the students
    public void post() {
        if (sections.isEmpty()) {
            throw new IllegalStateException("섹션이 최소 한개 있어야 게시 가능합니다");
        }
        courseStatus = CourseStatus.PUBLISHED;
        postTime = LocalDate.now();
    }

    //you can update course until postTime + 10 days
    public void update() {
        if (postTime.plusDays(10).isAfter(LocalDate.now())) {
            throw new IllegalStateException("게시 후 10일이 지나 수정이 불가능합니다");
        }
    }

    //constructor
    public Course(String name, Instructor instructor, Category category, Difficulty level) {
        this.name = name;
        this.instructor = instructor;
        this.sections = new ArrayList<>();
        this.category = category;
        this.level = level;

        courseStatus = CourseStatus.DRAFT;
        postTime = null;
    }

}
