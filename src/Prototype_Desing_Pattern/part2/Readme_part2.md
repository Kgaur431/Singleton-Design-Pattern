``` part 2.      Finding the solution of part 1.
1.  Now every child class (Crow, Sparrow) will also override the clones(). 
    1. 1    The return type of clones() in child classes will be either Bird or specific child class becoz child class is also a Bird. 
    1.2     we have added the sound attribute in Crow class. 
 
   2.  Now how we implement the clones() in the respective child class (Crow, Sparrow).
            approach1:- we implement clones() in the same way that we did in Bird class. means by creating an obj of Crow. 

       Problem 1:-  In the approach1, we are not creating the copy, why ?
                                Because we have added only child attributes in the crow obj & returned it, we didn't add the parent class attributes. 
                                   so without parent attributes, how we create the copy of crow obj. 
                                   Also we can't access the Bird class attributes in the Crow class.                     ==>      issue 1.
                            
                                 assume we don't have the setter method in the Bird class.
       Problem 2:-  In approach2, we are doing super.clones(),  but it returns the bird class object. so how we will return copy of crow obj becoz we still not set the attributes of Bird class. 
       approach3:-   Correct way to implement prototype in case of Extending a class:-
                                            "Try to understand that how were those values of the attributes initially set in the parent class".     ==>     when we created the obj of child class, by calling the constructor of the parent class set the values of those attributes. 
                                                we did same thing, In all the child class we have created the copy constructor where "it call the parent class constructor & after that it will set the attribute of the child class". 
                                                we created the copy constructor in the parent class also where "we copy all the values from the old obj  to the new obj".
                                                            ||  
                                             When we first time created the crow obj that time, somehow someone would have set the attributes of the Bird class.  Who was the person who set the attributes. 
                                             Constructor,  {means In original_birds list we did new Crow(), here we are creating the Crow class obj first time, this time Crow class no-args constructor calls the Bird class constructor
                                             by doing this parent class attributes has set}     ==>  Constructor was set the attribute of Bird class. 
                                                        || 
                                  we can say that If we need the copy of other attributes that means someone would have created those values for the attributes so what was the method that created the copy of Parent attributes in the begining ?
                                    Constructor. 
                                 this is where the solution comes:-
           Main sol:-       "If we are implementing the prototype dp,  where we have multiple child classes, How will we implement them ?
                                        first:-  we will create Private/Public copy constructor on every child class.
                                                        like:-
                                                                    public Crow (Crow old) {
                                                                        this.sound = old.sound;
                                                                    }    
                                                       but I don't just have to copy the own values, what values I have to copy ==> Parent values.   
                                       second:-  parent class also have Private/Public copy constructor.
                                              
                                                         before calling the child class constructor, the child class constructor call the parent class constructor by using super(old);
                                      third:-   child class call the super(old);
          
          if we have copy constructor then how the clones method look like ?
                    fourth:-     Now clones() will return new Crow(this);              
                     
                     how it work?
                        assume we create the crow obj with the help of default constructor & that is c1, we call c1.clones(). (default values will be set to the Bird class attributes (by using super()) as well as child is case) 
                        then c1 obj will be passed as the params of the copy constructor, & then it will also set the parent class , then it will return copy of the crow obj. 
                        
                        
          we need the default constructor to create the first obj in the begining. like new Crow(), new Sparrow() etc. 
                                    
3.
``` 