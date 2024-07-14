package Prototype_Desing_Pattern.part2.Bird;

// step1
public class Sparrow extends Bird {

    // Copy constructor
    public Sparrow (Sparrow old) {            // first
        super(old);                                           // third
    }

    public Sparrow() {
        super();
    }

    @Override
    public Sparrow clones() {                   // fourth
        return new Sparrow(this);
    }
}
