package Builder_Desing_Pattern.Solution4;

import java.security.InvalidParameterException;

public class UserExam {
    private int english;
    private int maths;
    private int science;
    private String name;

    public UserExam(Parameters parameters)
    {   // before creating the obj of UserExam class, we are validating the values.
        if(parameters.english > 100 || parameters.maths > 100 || parameters.science > 100)
        {
            throw new InvalidParameterException("Marks can't be greater than 100");
        }

        if (parameters.name.startsWith("0"))
        {
            throw new InvalidParameterException("Name can't be start with 0");
        }
        this.english = parameters.english;
        this.maths = parameters.maths;
        this.science = parameters.science;
        this.name = parameters.name;
    }
}
