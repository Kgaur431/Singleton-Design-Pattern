package Prototype_Desing_Pattern.Prototype_Registry.Bird;

// step1
public class Bird implements Cloneable<Bird> {

    private String name;
    private String color;
    private  int weight;

    @Override
    public Bird clones() {
        return new Bird(this);
    }

        // Copy constructor
    public Bird(Bird old)                   // second
    {
        this.color = old.color;
        this.name = old.name;
        this.weight = old.weight;
    }

    public Bird() {}
}

/**
 *
*  Now the clone() has return type Bird, becoz Cloneable interface has type Bird.      ==>  becoz of generics.
 *
 *  the simplest way to implement prototype was:-                       \\  default solution for creating the copy.
 *      @Override
 *     public Bird clones() {
 * //        Bird copy = new Bird();                 In the clones() create a new empty obj of a Bird type,
 * //        copy.name = this.name;               then one by one copy the values.
 * //        copy.color = this.color;
 * //        copy.weight = this.weight;
 * //        return copy;
 *     }
 *     but the problem is that "this way will only work in Base / Parent class. becoz we have to copy the attributes of the other class also.
 *          means If we implement the prototype in child class. to create the copy of the child class obj we have to copy the attributes of the parent class also. how we can do this,
 *                  eg:-
 *                                          public Crow clones(){
 *                                                  Crow copy = new Crow();
 *                                                  copy.sound = this.sound;
 *                                                  // how can we copy the attributes of parent class, in the child class.                           so we are not able to copy the obj.
 *                                          }
 *                                                              \\
 *      'This solution only works when the class that I am cloning is the parent class'.       but not work in case of Extending a class.
 */
