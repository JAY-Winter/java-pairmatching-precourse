package pairmatching.model.course;

public enum CourseSet {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private final String title;

    private final String path;

    CourseSet(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public static String getPathForInput(String input) {
        for (CourseSet courseSet : CourseSet.values()) {
            if (courseSet.getTitle().equals(input)) {
                return courseSet.getPath();
            }
        }
        return null;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }
}
