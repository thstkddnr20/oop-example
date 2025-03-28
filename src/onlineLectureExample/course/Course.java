package onlineLectureExample.course;

import onlineLectureExample.Subscription;
import onlineLectureExample.payment.Money;
import onlineLectureExample.user.Instructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {

    private CourseStatus courseStatus;

    private String name;
    private Instructor instructor;
    private List<Section> sections;
    private Category category;
    private Difficulty level;

    private LocalDate postTime;

    //payment
    private Money price;

    //subscription
    private Subscription subscription;


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

    public void addSection(Section section) {
        //section num 겹치는지 확인
        validSectionNumber(section.getSectionNum());
        sections.add(section);
    }

    //constructor1
    public Course(String name, Instructor instructor, Category category, Difficulty level, Money price) {
        this.name = name;
        this.instructor = instructor;
        this.sections = new ArrayList<>();
        this.category = category;
        this.level = level;
        this.price = price;

        this.subscription = Subscription.NONE;

        courseStatus = CourseStatus.DRAFT;
        postTime = null;
    }

    //constructor2 - with subscription
    public Course(String name, Instructor instructor, Category category, Difficulty level, Money price, Subscription subscription) {
        this.name = name;
        this.instructor = instructor;
        this.sections = new ArrayList<>();
        this.category = category;
        this.level = level;
        this.price = price;

        this.subscription = subscription;

        courseStatus = CourseStatus.DRAFT;
        postTime = null;
    }

    public void validSectionNumber(int sectionNum) {
        for (Section section : sections) {
            if (section.getSectionNum() == sectionNum) {
                throw new IllegalStateException("섹션 번호가 중복됩니다.");
            }
        }
    }

    public Money getPrice() {
        return price;
    }

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseStatus=" + courseStatus +
                ", name='" + name + '\'' +
                ", instructor=" + instructor +
                ", sections=" + sections +
                ", category=" + category +
                ", level=" + level +
                ", postTime=" + postTime +
                ", price=" + price +
                ", subscription=" + subscription +
                '}';
    }

    //단순하게 이름으로 equals 비교
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Course course = (Course) object;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
