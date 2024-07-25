package StructuralDP_DecoratorDp;

import StructuralDP_DecoratorDp.Icecream.*;

// assume Customer class is the Main class
public class Customer {
    public static void main(String[] args) {
        System.out.println("this customer wants to create an Icecream with Orange Cone and 2 vanilla scoops then 1 chocolate scoop & then 1 vanilla scoop");
        Icecream icecream =
                                    new VanillaIScope(
                                                new ChocolateIScope(
                                                        new VanillaIScope(
                                                                new VanillaIScope(new OrangeCone())
                                                        )));

        System.out.println("Cost of the Icecream: "+icecream.getCost());
        System.out.println("Constituents of the Icecream: "+icecream.getConstituents());

        System.out.println("customer want to create an chocobar with 2 chocolate scoops in the blue cone");
        Icecream chocobar =
                                new ChocolateIScope(
                                        new ChocolateIScope(
                                                new BlueCone()
                                        ));
        System.out.println("customer want to create an chocoVanilla with 1 chocolate scoop and 1 vanilla scoop in the blue cone");
        Icecream chocoVanilla =
                                new VanillaIScope(
                                        new ChocolateIScope(
                                                new BlueCone()
                                        ));
        System.out.println("Customer want to create a chocobar with 1 vanilla scoop");
        Icecream chocobarWithVanilla = new VanillaIScope(chocobar);                 // this is using the already created chocobar object not creating the new object if the requirement is same.

    }
}


/**
 *         //  1.  user first want to create an Icecream cone with Orange Cone                         ==>     we create an Orange Cone object
 *         //  2.  customer said add 1 vanilla scope to it.  how do we do it ?                              ==>
 *         //  3.  customer said add 1 more vanilla scope to it.  how do we do it ?                    ==>
 *         //  4.  customer said add 1 chocolate scope to it.  how do we do it ?                        ==>
 *         //  5.  customer said add 1 more vanilla scope to it.  how do we do it ?                     ==>
 */
