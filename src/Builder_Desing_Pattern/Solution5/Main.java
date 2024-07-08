package Builder_Desing_Pattern.Solution5;

// Final solution
public class Main {
    public static void main(String[] args) {
        try {
            // Normal way
            Builder_Desing_Pattern.Solution5.UserExam.UserExamBuilder userExamBuilder = Builder_Desing_Pattern.Solution5.UserExam.getUserExamBuilder();
            userExamBuilder.setEnglish(10);         // first we need builder obj, otherwise we can't set the values & also Builder class is doing the validation & creating the obj of UserExam class that is why we need UserExamBuilder object.
            userExamBuilder.setMaths(20);
            userExamBuilder.setScience(40);
            userExamBuilder.setName("Namam");

            // Method chaining way
            UserExam userExam1=
                    UserExam.getUserExamBuilder()
                            .setEnglish(10)
                            .setMaths(20)
                            .setScience(40)
                            .setName("Manan")
                            .build();


            Builder_Desing_Pattern.Solution5.UserExam userExam = userExamBuilder.build();
        }catch (Exception exception)
        {
            System.out.println("Some Parameters are wrong");
        }
    }
}
