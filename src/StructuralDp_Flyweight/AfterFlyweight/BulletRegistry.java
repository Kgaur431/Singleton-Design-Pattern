package StructuralDp_Flyweight.AfterFlyweight;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {
    /**
     *      Ques:-  what will be the key of every bullet ?
     *      Ans:-    key will be the bulletType. becoz we have to create the bullet obj on the basis of bulletType.
     *
     *      Question:-  what will be the type of value we are storing?
     *      Ans:-        value will be the bullet obj.
     *
     */

    private Map<BulletType, Bullet> bulletMap = new HashMap<>();

    public  void registerBullet(BulletType bulletType, Bullet bullet){
        bulletMap.put(bulletType, bullet);
    }

    public Bullet getBullet(BulletType bulletType){
        return bulletMap.get(bulletType);
    }

}
