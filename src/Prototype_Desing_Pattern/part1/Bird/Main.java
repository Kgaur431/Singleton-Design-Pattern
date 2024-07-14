package Prototype_Desing_Pattern.part1.Bird;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Bird>  original_birds = List.of(              // First, we create this list that stores actual obj.
                            new Crow(),                                 // default constructor to create the actual object of the respective classes first time.
                            new Sparrow(),
                            new Crow()
        );

        List<Bird> copy_birds = new ArrayList<>();
        for (Bird bird : original_birds){
            copy_birds.add(bird.clones());
        }

    }
}
