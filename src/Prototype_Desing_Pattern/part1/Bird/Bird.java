package Prototype_Desing_Pattern.part1.Bird;

// step1
public class Bird implements Cloneable<Bird> {

    private String name;
    private String color;
    private  int weight;

    @Override
    public Bird clones() {
        Bird copy = new Bird();                 // creating new another obj, which we want that clone() should return.
        copy.name = this.name;               // put the current obj value into the copy obj.
        copy.color = this.color;
        copy.weight = this.weight;
        return copy;
    }
}

/**
 *
*  Now the clone() has return type Bird, becoz Cloneable interface has type Bird.      ==>  becoz of generics.
 */
