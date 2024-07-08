package Builder_Desing_Pattern.Solution4;

public class Main {
    public static void main(String[] args) {
        Parameters parameters = new Parameters();
        parameters.english = 20;            // setting the values directly.
        parameters.maths=10;
        parameters.science=40;
        parameters.name="Manan";

        try {
            UserExam userExam = new UserExam(parameters);
        }catch (Exception exception)
        {
            System.out.println("Some Parameters are wrong");
        }


    }
}
