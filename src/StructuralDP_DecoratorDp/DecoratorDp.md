``` 
Case Study 1:- 
        we go to a Icecream shop, from there we Buy an icecream cone. 
            initially there is an empty cone which we can call                                              ==>     Icecream cone. 
            after that we asked them to add one scope vanilla, so we can call                 ==>     stil an Icecreame cone.   
            after that we asked them to add one scope choclate, still we can call           ==>     an Icecreame cone.   
            after that we asked them to add one scope butterscotch, still we can call    ==>     an Icecreame cone.   

Case Study 2:- 
        we go to a Dominz pizza shop, from there we Buy a pizza. 
            initially there is a pizza base which we can call                                                 ==>    Pizza. 
            after that we asked them to add some cheese, so we can call                       ==>    stil a Pizza.   
            after that we asked them to add some vegies, still we can call                       ==>    a Pizza.   
            after that we asked them to add some olives, still we can call                        ==>    a Pizza.


generally we are decorating the gift with some gift wrapper, after decorating the gift, the cost of the gift is changed. but still we are calling the gift with the same name.
" By decorating something, the category of the object that I am decorating is still remains the same, but some additional features are added to the object which might change the cost or some other properties of the object". 
    like 
            In the above case studies, we can see that we are adding something to the existing object (like empty cone, pizza base) and still we are calling the same object with the same name  after adding something to it.  like it still an Icecream cone, still a pizza.
            after adding something, the cost of the object is changed for the Domiz pizza and Icecream cone. 




How we can implement the Dominoz pizza odering system:-
        complex things "We can add topings to the pizza in any order & whatever we will add, the cost of the pizza will be changed accordingly". 
        assume we have to create an interface, which method we might need to create the pizza. so while creating the pizza, we can add the topings to the pizza also we can get the cost of the pizza.
            interface Pizza {
                public String getConstituents();    // whatever we will add to the pizza that we can get by this method. like cheese, olives, vegies etc.
                public double getCost();
            }
        How we will implement the PizzaCreater class:-
           Problem:-  Dominoz allows customer to order a pizza with two bases & then customer can add topings to the pizza but when we start adding the topings to the pizza, then Dominoz can't allows customer to add the base to the pizza (sandwich pizza).
            approach 1:-    we can Use Builder Dp. but it is not a good approach because we have to create the object of the pizzaCreater class and then we have to call the methods to add the topings to the pizza. 
                                        so once we will create the object of the pizzaCreater class, then we can't add the another base to the pizza. becoz In Builder Dp we can't modify the object once we have created the object of the class.
                                        assume if we done this with the Builder Dp, then the new Problem statement is :-
                                            Dominoz allows customer to create a Pizza, 
                                                   1.   Either from Scratch.    (like we start adding the base, then again we can add the base, & then we add the topings to the pizza and so on)
                                                    2.   Or from the existing pizza. (like Margarita pizza, then we start adding the topings to the pizza)
                                       If we use Builder Dp (once the object is created, then we can't modify the object), then we can't add the topings to the existing pizza. so we can't use the Builder Dp.
                                            means if we add something to the pizza,  it is still an Pizza only but it is the new Pizza. so we can't use the Builder Dp.
            approach 2:-    we can use the Prototyep Dp.
                                        assume we have two Pizza class, one is Margarita pizza and another is Farmhouse pizza which implements the Pizza interface.
                                        Prototype we are using when we have two object & only difference is that the values of the attributes, not the type of the attributes. so we should not create the separate class for the same type of the attribute.
                                        here we are creating the two classes for the two types of the pizza (Margarita pizza, Farmhouse pizza) and the only difference is that the values of the attributes. so we can't use the Prototype Dp.
                                        suppose if dominoz introduces the 10 new pizza, then we have to create the 10 new classes for the 10 new pizza. so it is not a good approach to create the separate class for the same type of the attribute.
            approach 3:-    we can use Factory Dp.
                                        we can create the Factory class which will create the object of the pizza. so we can create the object of the pizza from the Factory class. 
                                        but the problem is whenever we call the getPizza() method from factory class, then we will get the new obj. means Assume we want Margarita pizza, then we will get the new Margarita pizza obj everytime.
                                         but we can use same Margarita pizza obj becoz the cost of the Margarita pizza is same everytime. it is not a good approach to create the new obj everytime. so we can't use the Factory Dp.
                                          
Decorator Dp:-
            1.  it says "whenever we decorate something, we have type of objects to create".
                        Ques:-  If I want to decorate a IceCream Cone, then what is a type of the IceCream Cone I have to create?   
                        Sol   :-   we are trying to create a IceCream Cone obj, then type of the object we are creating are IceCream Cone. so we have to create the interface called IceCream Cone.  becoz we are only concerned about the IceCream Cone.  interface 1.                       
            2.  "whenever we decorate something, that means we are adding feature. 
                     so we have to create the class which will implement the interface".
                        before we adding the feature / decorating the objects, what was the type of  object?        ==>     IceCream Cone
                        after we adding the feature / decorating the objects, what is the type of the object?          ==>     IceCream Cone
                        Interesting thing come into the picture:-
                            Ques:-  How we will decorate the gift?
                            Ans  :-   we will use the gift wrapper to decorate the gift.
                            same way, "we will decorate the IceCream Cone by wrapping it". 
                            How ?
                                let's say we create the base class. means "the base classes are, From where the creation of IceCream Cone will start from". 
                                Ques:-  what are those base classes? ||  How do we start creating the IceCream Cone?  ||   what is the base to create the IceCream Cone?
                                Sol   :-   cone.  class 1. 
                                so, let us implement, "for every feature that we add, implement a decorator class for that feature".    means feature like Vanilla scope, choclate scope, butterscotch scope etc.
                                    first feature that we are adding is cone. so we have to create the cone class which will implement the IceCream Cone interface. becoz cone is like an IceCream Cone so it should implement the IceCream Cone interface.
                                    Will cone be a base entity, or we have to decorate something ? ==>  cone will be a base entity. if "anything is a base entity then we can't put anything into its constructor".   class 1.
                                    Now we have 1 base entity, so we can have multiple child entities || there can be other child entities which we can put over it (IceCreamCone). so one of the Decorate thing is VanillaScope class. 
                                   When we add the VanillaScope over the IceCreamCone.  (once we create VanillaScope class will it still be an IceCreamCone?)
                                         Yes, it is still an IceCreamCone. so VanillaScope class will implement the IceCreamCone interface.  class 2.
                                        Ques:-  Can VanillaScope class start creating the IceCreamCone?  
                                        Ans   :-  No,  an obj of the VanillaScope class is only be created when we have the obj of the IceCreamCone. so we have to put the IceCreamCone obj into the constructor of the VanillaScope class.  class 2 
                                                        means, we will put the vanilla scope over the IceCreamCone. so we need the IceCreamCone obj to put the vanilla scope over it.   ||   an obj of the VanillaScope class is only be created over the IceCreamCone obj.             
                                        Ques:-   Why did we pass the IceCreamCone not the Cone into the constructor of the VanillaScope class?
                                        Ans   :-   VanillaScope can decorate a IceCreamCone,  it can be just an empty cone or it can be the IceCreamCone which has already with the some other scope || Vanilla scope. 
                                                          means, When can we decorate with Vanilla scope, 
                                                                     either we have empty cone then we can decorate it with the Vanilla scope.
                                                                     or we have the IceCreamCone which is already decorated with the some other scope || Vanilla scope, then we can decorate it with the Vanilla scope.
                                        becoz it is implementing the IceCreamCone interface, so  
                                        what will be the cost of the icecream after adding the VanillaScope?                   ==>            cost of the original cone + 100 (cost of vanilla scope)
                                        what are the constituents of the icecream after adding with VanillaScope?        ==>          constituents of the original cone + vanilla scope.



// class 1.                                                                                 interface 1.                                                                            class 2.            
class Cone implements IceCream Cone {                interface IceCreamCone {                                                            class VanillaScope implements IceCreamCone {
    public String getConstituents() {                             public String getConstituents();                                                      private IceCreamCone cone;                      // we are storing the cone either it is empty or it has some icecream already. 
        return "cone";                                                         public double getCost();                                                                     public ThinCrustPizza(IceCreamCone cone) {
    }                                                                                       }                                                                                                                 inside = one;
    public double getCost() {                                                                                                                                                             }
        return 100;                                                                                                                                                                                  public getCost() {                                                               
    }                                                                                                                                                                                                            return inside.getCost() + 100;                                                                                                                            
}                                                                                                                                                                                                               }
                                                                                                                                                                                                            public getConstituents() {
                                                                                                                                                                                                                return ThinCrust + inside.getConstituents();
                                                                                                                                                                                                            } }

Conclusion:-
        We want to create a Cone, in that cone we want to add one scope of vanilla, then we want to add one scope of choclate, then we want to add one scope of butterscotch. How we will do it ?
                we will start by creating the cone obj.                                                                                                                                                                                                      new Cone();
                now we want to add vanilla scope to the cone obj. means we are decorating the cone obj with the vanilla scope.                                                                  new VanillaScope(new Cone());
                now we want to add ChoclateScope obj to the IceCreamCone obj. means we are decorating the IceCreamCone obj with the ChoclateScope.                new ChoclateScope(new VanillaScope(new Cone()));
                now we want to add ButterscotchScope obj to the IceCreamCone obj. means we are decorating the IceCreamCone obj with the ButterscotchScope.  new ButterscotchScope(new ChoclateScope(new VanillaScope(new Cone())));
        this is how the IceCreamCone obj is decorated with the multiple scopes || is created with the multiple scopes.

        this same example we can use if interviewer ask How we can build Coffee machine, how we can build Dominoz system etc. 

How HTML language build ?
        assume we created a button, button is nothing but an HTML element.
        now  we decorate that button with Border, then it is still be an HTML element.
        now  we decorate that button with inside a table, then the complete thing is still be an HTML element.

        this is how HTML created.
        "every object is nothing but an Decorator thing".

How decorator are used in Spring Application || web frameworks:-
        In Springboot we are creating an spring application. let us say we want to add Security in this spring applicaiton so that this spring applicaiton would be secured.
        "we will decorate the spring application inside the Spring security decorator". beocz even after adding the security, it is still an Spring Applicaiton.
        this is how spring security internally works. 

HTTPS:-
        we will decorate the HTTP with security layer       ==>           HTTPS.
        
In decorator pattern the original entity is remains the same we can just add the features to it.
use case:-  
                    it used to add the functionality to an already existing functionality.
                    
                    
How decorator dp is diff from Inheritance ?
        1.  we inherit the class at compile time, means we extend the class at compile time.                   but we can deocrate the things at runtime. like if we want to add one choclate scope we can add it                                                                                                                                                                          
                                                                                                                                                                                            eg:-        Class Customer {
                                                                                                                                                                                                                Pizza  currentPizza = Farmhouse;
                                                                                                                                                                                                                    ........
                                                                                                                                                                                                                String newToppings =  addTopings(cheese);
                                                                                                                                                                                                                if(newToppings == cheese)   {
                                                                                                                                                                                                                    currentChessePizza = new Cheese(current);   }
                                                                                                                                                                                                           }
