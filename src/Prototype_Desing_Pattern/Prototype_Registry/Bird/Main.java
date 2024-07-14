package Prototype_Desing_Pattern.Prototype_Registry.Bird;

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

        Crow intelligent_crow = new Crow();
        intelligent_crow.setSound("nice");

        BirdRegistry birdRegistry = new BirdRegistry();
        birdRegistry.registerBird("intelligent_crow", intelligent_crow);

        Bird bird = birdRegistry.getBird("intelligent_crow");
        System.out.println("**********" +  bird);

    }
}
