package StructuralDP_DecoratorDp.Icecream;

/**
 *  assume Vanilla scope is going to be added to the icecream only. means it is only exist to decorate the icecream
 *      then,   How can we construct the obj of VanillaIScope?
 *      means to construct the obj of VanillaIScope becoz a VanillaIScope only be added over the icecream.
 *          we  need to pass the obj of Icecream to the constructor of VanillaIScope
 *
 */
public class VanillaIScope implements Icecream{

    private Icecream icecream;
    public VanillaIScope(Icecream icecream){
        this.icecream = icecream;
    }

    @Override
    public int getCost() {
        return icecream.getCost() + 15;          //  icecream.getCost() means the cost of the empty cone or the cone which is already decorated with some other scope, over that we are adding the Vanilla scope
    }

    @Override
    public String getConstituents() {
        return icecream.getConstituents() + "  "+ "Vanilla";            //  icecream.getConstituents() means the constituents of the empty cone or the cone which is already decorated with some other scope, over that we are adding the Vanilla scope
    }
}
