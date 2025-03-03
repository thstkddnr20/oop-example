package onlineLectureExample.enrollment;

import onlineLectureExample.course.Course;

public class Enrollment {

    private Course course;
    private EnrollmentStatus enrollmentStatus;

    public Enrollment(Course course) {
        this.course = course;
        this.enrollmentStatus = EnrollmentStatus.IN_PROGRESS;
    }

    public Course getCourse() {
        return course;
    }
}

