package Builder_Desing_Pattern.Solution5;

import java.security.InvalidParameterException;

public class UserExamBuilder_Separate {
    private int english;
    private int maths;
    private int science;
    private String name;

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserExam build() {       // validating the obj before create it then create the obj of UserExam.
        if (english > 100 || maths > 100 || science > 100) {
            throw new InvalidParameterException("Marks can't be greater than 100");
        }

        if (name.startsWith("0")) {
            throw new InvalidParameterException("Name can't be start with 0");
        }
        return  null;
    }
    }

