package onlineLectureExample.user;

import onlineLectureExample.course.Category;
import onlineLectureExample.course.Course;
import onlineLectureExample.course.Difficulty;
import onlineLectureExample.payment.Money;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {

    private List<Course> courseList;

    public Instructor(Long id, String name) {
        super(id, name);
        courseList = new ArrayList<>();
    }

    public Course registerCourse(String name, Category category, Difficulty level, Money price) {
        Course course = new Course(name, this, category, level, price);
        courseList.add(course);
        return course;
    }

}
