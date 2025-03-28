package onlineLectureExample.enrollment;

import onlineLectureExample.course.Course;

public class Enrollment {

    private Course course;
    private EnrollmentStatus enrollmentStatus;

    public static Enrollment of(Course course) {
        Enrollment enrollment = new Enrollment();
        enrollment.course = course;
        enrollment.enrollmentStatus = EnrollmentStatus.IN_PROGRESS;
        return enrollment;
    }

    public Course getCourse() {
        return course;
    }
}

