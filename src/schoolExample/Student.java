package schoolExample;

public class Student {
    private final String name;
    private int mathAbility;
    private int scienceAbility;
    private int englishAbility;

    private int mathScore;
    private int scienceScore;
    private int englishScore;

    public Student(String name) {
        this.name = name;
    }

    //공부를 하다
    public void study(Subject subject) {
        if (subject == Subject.ENGLISH) {
            englishAbility++;
        } else if (subject == Subject.MATH) {
            mathAbility++;
        } else if (subject == Subject.SCIENCE) {
            scienceAbility++;
        }
    }

    //시험을 보다
    public void takeTest(Subject subject) {
        if (subject == Subject.ENGLISH) {
            englishScore = englishAbility;
        } else if (subject == Subject.MATH) {
            mathScore = mathAbility;
        } else if (subject == Subject.SCIENCE) {
            scienceScore = scienceAbility;
        }
        else {
            throw new IllegalStateException("Wrong Subject");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mathAbility=" + mathAbility +
                ", scienceAbility=" + scienceAbility +
                ", englishAbility=" + englishAbility +
                ", mathScore=" + mathScore +
                ", scienceScore=" + scienceScore +
                ", englishScore=" + englishScore +
                '}';
    }
}
