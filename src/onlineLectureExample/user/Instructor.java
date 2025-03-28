package onlineLectureExample.user;

import onlineLectureExample.course.*;
import onlineLectureExample.payment.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {

    private List<Course> courseList;

    public Instructor(Long id, String name) {
        super(id, name);
        courseList = new ArrayList<>();
    }

    public List<Course> getPostedCourses() {
        return courseList.stream().filter(c -> c.getCourseStatus() == CourseStatus.PUBLISHED).toList();
    }

    public Course makeCourse(String name, Category category, Difficulty level, Money price) {
        Course course = new Course(name, this, category, level, price);
        courseList.add(course);
        return course;
    }

    public Section makeSection(Long id, Course course, String name, int sectionNum, List<Lecture> lectures) {
        return Section.of(course, id, name, sectionNum, lectures);
    }

    public Lecture makeLecture(Long id, String name, Duration duration, String attachment) {
        return Lecture.of(id, name, duration, attachment);
    }

}
