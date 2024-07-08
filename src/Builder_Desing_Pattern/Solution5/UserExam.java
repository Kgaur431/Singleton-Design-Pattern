package Builder_Desing_Pattern.Solution5;

import java.security.InvalidParameterException;

// this class is an immutable class.
public class UserExam {
    private int english;
    private int maths;
    private int science;
    private String name;

    // No need of creating getter & setter of this class. We only need a constructor, but it should be private.             step1
    private UserExam() {}           //   if we are not defined then default constructor will be created.

    // to get the object of userExamBuilder.                                                                                                                               step4
    public static UserExamBuilder getUserExamBuilder(){
        return new UserExamBuilder();
    }

    public static class UserExamBuilder {      // by putting into the UserExam class, Now UserExamBuilder class has access to Private attributes of UserExam class.
        private int english;
        private int maths;
        private int science;
        private String name;

        public UserExamBuilder setEnglish(int english) {
            this.english = english;
            return  this;
        }

        public UserExamBuilder setMaths(int maths) {
            this.maths = maths;
            return  this;
        }

        public UserExamBuilder setScience(int science) {
            this.science = science;
            return  this;
        }

        public UserExamBuilder setName(String name) {
            this.name = name;
            return  this;
        }

        public UserExam build() {       // validating the obj before create it, then create the obj of UserExam.
            if (english > 100 || maths > 100 || science > 100) {
                throw new InvalidParameterException("Marks can't be greater than 100");
            }

            if (name.startsWith("0")) {
                throw new InvalidParameterException("Name can't be start with 0");
            }

            // Now we access the constructor of the UserExam class.                          step2
            UserExam userExam = new UserExam();
            // Now we have to assign the value to the UserExam class attributes        step3
            userExam.english = this.english;
            userExam.maths = this.maths;
            userExam.science = this.science;
            userExam.name = this.name;

            return userExam;
        }
    }


}
