package Prototype_Desing_Pattern.part2.Bird;

// step1
public class Crow extends Bird {
    private String sound = "Kaw";

   // TODO:-   approach1
//    @Override
//    public Crow clones() {
//        Crow crow = new Crow();
//        crow.sound = this.sound;                      // we are not actually copy the objects
//        return  crow;
//    }

    // TODO:-   approach 2
//    @Override
//    public Crow clones() {
//        Bird bird = super.clones();
//        // bird.color                                   How we will access the attributes of Bird class, becoz if we unable to access then how we set the attributes of the Bird class.
//        Crow crow = new Crow();     // How crow class obj will copy the Bird class attributes also.
//        crow.sound = this.sound;
//        return  crow;
//    }

    // TODO:- approach3
    public Crow (Crow old) {            // first             // Copy constructor
        super(old);                                // third
        this.sound = old.sound;
    }

    public Crow() {
        super();
    }

    @Override
    public Crow clones() {                  // fourth
        return new Crow(this);
    }
}
