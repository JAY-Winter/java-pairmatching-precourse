package pairmatching.model.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {

    private final String title;

    public Course(String title) {
        validateInvalidTitle(title);

        this.title = title;
    }

    private static void validateInvalidTitle(String title) {
        List<String> courses = new ArrayList<>();
        for (CourseSet courseSet : CourseSet.values()) {
            courses.add(courseSet.getTitle());
        }

        if (!courses.contains(title)) {
            throw new IllegalArgumentException("[ERROR] 올바른 과정을 입력하세요.");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        for (CourseSet courseSet : CourseSet.values()) {
            if (title.equals(courseSet.getTitle())) {
                return courseSet.getPath();
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return Objects.equals(title, course.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
