package StructuralDp_Flyweight.AfterFlyweight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**
         *
         *     Ques:-  Before we start creating the flyingbullet obj, what  we need to do ?
         *     Ans:-    we need  to create the BulletRegistry obj. so that we can store the bullet obj in the bulletRegistry obj and we can retrieve it when we create the flyingbullet obj.
         */
        BulletRegistry bulletRegistry = new BulletRegistry();
        Bullet fiveMMBullet = new Bullet();                                                                 // create the first type of bullet object  ==> 5mm bullet
            fiveMMBullet.setBulletType(BulletType.FIVE_MM);                                 // then set the bullet type of the newly created bullet obj. like 5mm bullet
            bulletRegistry.registerBullet(BulletType.FIVE_MM, fiveMMBullet);      // then register the bullet obj in the bulletRegistry obj.
        Bullet nineMMBullet = new Bullet();
            nineMMBullet.setBulletType(BulletType.NINE_MM);
            bulletRegistry.registerBullet(BulletType.NINE_MM, nineMMBullet);
        Bullet sevenMMBullet = new Bullet();
            sevenMMBullet.setBulletType(BulletType.SEVEN_MM);
            bulletRegistry.registerBullet(BulletType.SEVEN_MM, sevenMMBullet);





        List<BulletExtrinsic> flyingBullets = new ArrayList<>();
        for (int i = 0; i < 200000; i++) {
            BulletExtrinsic flyingBullet = new BulletExtrinsic();
            /**
             *      Ques:-  when we create the flyingbullet obj, what we the diff  attributes that I have to set ?
             *      Ans:-    we have to set the Extrinsic attributes of the flyingbullet obj only.
             */
           flyingBullet.setSpeed(120.0);
           //   .... assume we have set the other attributes of the flyingbullet obj.
            /**
             *      Ques:-  apart from the extrinsic attributes, what is the other attribute that we have to set ?
             *      Ans:-    we have to set the bullet obj. so that we can get the bullet obj whenever we need it.
             *
             *      Ques:-  How we will set the bullet obj ?
             *      Ans:-    we will get the bullet obj from the bulletRegistry obj and set it to the flyingbullet obj.
             */
            flyingBullet.setBullet(bulletRegistry.getBullet(BulletType.FIVE_MM));   // get the bullet obj from the bulletRegistry obj and set it to the flyingbullet obj.
            flyingBullets.add(flyingBullet);
        }
    }
}


/**
 *  Important:- read1
 *      Ques:-  do we think that there will be 200000 objs of bullet ?
 *      Ans  :-   No, currently there are only 3 types of bullets are there in total. or like 10-20 types of bullets.
 *                     so we can say, we only need 1 type of  bullet obj, for per type of flyingbullet object. like 30 flyingbullet obj of bullet type 1, 20 flyingbullet obj of bullet type 2 and so on.
 *                     those three bullet type objects are used across all the flyingbullet objects. & even if we create the new flyingbullet obj, we can use the already existing bullet obj.
 *                     so where we can store the bullet obj ?  so that we can retrieve it whenever we need it.  like whenever we need of bullet type 1, we can get the bullet type 1 obj.
 *                          we can store it in the bulletRegistry class. so that we can get the bullet obj whenever we need it.
 */
