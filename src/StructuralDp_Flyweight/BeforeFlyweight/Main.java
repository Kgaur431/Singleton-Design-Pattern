package StructuralDp_Flyweight.BeforeFlyweight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Bullet> bullets = new ArrayList<>();
        for (int i = 0; i < 200000; i++) {
            Bullet bullet = new Bullet();
            bullets.add(bullet);
        }
    }
}
