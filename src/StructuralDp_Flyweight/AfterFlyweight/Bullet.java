package StructuralDp_Flyweight.AfterFlyweight;

public class Bullet {
    private BulletType bulletType;
    private double weight;
    private double size;
    private byte[] bulletImage;

    public void setBulletType(BulletType bulletType) {
        this.bulletType = bulletType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setBulletImage(byte[] bulletImage) {
        this.bulletImage = bulletImage;
    }

    public BulletType getBulletType() {
        return bulletType;
    }

    public double getWeight() {
        return weight;
    }

    public double getSize() {
        return size;
    }

    public byte[] getBulletImage() {
        return bulletImage;
    }
}