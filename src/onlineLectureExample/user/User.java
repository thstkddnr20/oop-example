package onlineLectureExample.user;

public abstract class User {
    private Long id;
    private String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
