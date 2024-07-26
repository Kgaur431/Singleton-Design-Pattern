 ``` 
 let us say we are playing battleground game and we have ground, on that ground we have multiple players. every player has 1 gun with them also they have few bullets in their bag, some bullets they are firing & players are fighting with each other so some 
    bullets are in the ground.
assume we are at Engineer at @PUBG, we are the person who is building the Frontend of pubg. 
    Ques:-      we are building the frontend of pubg, so what are the diff classes are there in the codebase of Pubg ?
    Ans:-       1. Player   2. Gun  3 . Bullet  4. Ground 
    Ques:-      what might be attributes of Bullet class ?
    Ans:-       1. Double:  BulletSize  2. Double:  BulletWeight  3. Double:  BulletXCordinate  4. Double: BulletYCordinate  5. Double: BulletZCordinate    (bulllet is moving so it has x & y cordinate otherwise how we know where the bullet is. it also has direction) 
                     6. Double:  BulletDirection    7. Double:  BulletSpeed   8.  Int:  BulletSates (fired, onGround, inBag)     9. Int:  BulletType    10. byte[]:  BulletImage   11. long:  userID           this is how we can define the bullet class in frontend of pubg.
                        Ques:-  How we will represent the bullet Image in the frontend of pubg ?
                        Ans:-      we descide that we store the image in the byte array & we are storing whole images as a array of bytes.
                        Ques:-  What is Byte array ?
                        Ans:-      Byte array is a array of bytes.  
                                            eg:- Image is nothing but an file & we are store the file in the form of 0 1 1 0 1 0 1  etc. it is nothing but an binary data. so we can store this binary data as it is as a byte array.
                                            means we are storing the whole image as it is in the form of byte array.
                        Ques:-  what is the amount of memory used by the bullet object ?
                        Ans:-      1. 8 bytes for BulletSize  2. 8 bytes for BulletWeight  3. 8 bytes for BulletXCordinate  4. 8 bytes for BulletYCordinate  5. 8 bytes for BulletZCordinate  6. 8 bytes for BulletDirection  7. 8 bytes for BulletSpeed  
                                        8. 4 bytes for BulletSates  9. 4 bytes for BulletType  10. 1000 bytes for BulletImage  11. 8 bytes for userID
                                    so total 8+8+8+8+8+8+8+4+4+1kb+8 = 1kb + 64 bytes, so we can it it taking almost 1kb of memory.
    assume In the pubg game there are arround 400 bullets per player, so if 100 players are playing the game then what will be the total size of the bullets ?          ==>         1kb * 400 * 100 = 40mb 
        means 40mb of RAM will be used to just to store the bullet objects. this is the number of bullets that are there in the pubg game at one time, normally In over all game, one person ends up having almost 2000 bullets in the game.
        total RAM:- 1KB * 2000 * 100 = 200mb.   Is this too much ?  yes, this is too much.
    Ques:-  can we reduce the memory usage of the bullet object ?
    Ans:-     Think:-  is there something we are repeating in all the bullet object ?  yes, we are repeating the image, image is in all the bullet object.
                              In the pubg game, we have only10-20 types of bullets, so do we need to repeat the image in all the bullet object ?  no, we can store the images of bullet & we can reuse the image in all the bullet object. here Flyweight dp comes into the picture.
Flyweight Dp:-
        it says, there are two type of attributes in the class, 
            like:-   1. Intrinsic attributes  are the attributes that are the property of the object, means the values of these attributes are not change.      internal property of the object.
                                    means "when an obj is created, the values of these attributes are not going to change."
                        2. Extrinsic attributes are that depend upon the external environment. means the values of these attributes keep on chaning.            external property of the object.
                                    means "when an obj is created, the values of these attributes are keep on changing when we go ahead."
                        eg:- we have created Bullet class object of type 5.56mm.
                                        BulletSize is not going to change               ==>  Intrinsic attributes                becoz if the Bullet obj is moving then the size of the bullet is not going to change. 
                                        BulletWeight is not going to change         ==>  Intrinsic attributes                 becoz for every bullet obj of 5.56mm the weight is going to be same.
                                        BulletXCordinate is going to change         ==>  Extrinsic attributes               becoz if the Bullet obj is moving then the x cordinate of the bullet is going to change.  BulletYCordinate, BulletZCordinate.
                                        BulletDirection is going to change           ==>  Extrinsic attributes                 becoz if the Bullet obj is moving then the direction of the bullet is going to change.         
                                        BulletSpeed is not going to change            ==>  Extrinsic attributes                 becoz initially the speed of the bullet is going to be fast but as the bullet is moving the speed of the bullet is going to decrease.
                                        BulletSates is going to change                    ==>  Extrinsic attributes                 becoz initially the state of the bullet is going to be in the bag but as the bullet is fired the state of the bullet is going to change.
                                        BulletType is not going to change                ==>  Intrinsic attributes                 becoz for every bullet obj of 5.56mm the type of the bullet is going to be same.     BulletImage. 
                                        UserID is going to change                            ==>  Extrinsic attributes                 becoz for every user the userID is going to be different.
        it says, "if we have class that has two type of attributes (Intrinsic & Extrinsic) then we can divide that class into two classes, becoz that will help us to reduce the memory".
            means often the no. of distinct type of objects is smaller. like How many distinct types of Bullets that we have in the pubg game ? 20. so In total How many diff images should be stored in the pubg system? 20. 
        Complete defination of Flyweight dp:-  
                        " according the Flyweight dp, if we have a class which has two types of attributes & if the Total no. of objects that are going to be there in the system are very large & the no. of distinct types of objects are very small
                         then we can divide that class into two classes.
                                means assume there are 1 million player playing pubg so 1M Bullet class objects are there in the system & there are only 20 distinct types of bullets are there in the system so we should divide the Bullet class into two classes.
                                                    OR      if the no. of distinct types of objects are very small then the total no. of objects that are going to be there in the system then we should divide that class into two classes.
                                                    means there are only 20 types of unique bullet, out of which we are creating 1M bullets in the system. so we can divide the Bullet class into two classes.
                              we convert the Bullet class into two classes. Class1 :- Intrinsic attributes  Class2 :- Extrinsic attributes "     
        Booking defination:-    it is a structural design pattern that allows us to save computer memory by sharing the common parts of object state among multiple objects instead of keeping all of the data in each object.
        How it happened ?
                suppose we divide the Bullet class into two classes, first class is BulletIntrinsic & second class is BulletExtrinsic. both of the classes are stored respective attributes.
                remember we are not doing inheritance here (means there is no class called Bullet, which has two child class). means  
                        Ques:-  When a bullet is flying then this is the obj of which class ?           ==>         BulletExtrinsic class.
                        Ques:-  If this is the Bullet of BulletIntrinsic class then How we will show / get the image of the bullet ?  ==>  we will show the image of the bullet by 
                                        if BulletExtrinsic extends the BulletIntrinsic class then we have all the attributes of BulletIntrinsic class in the BulletExtrinsic class. so we come back to previous problem of memory. so extending class is not possible. 
                        we are doing composition here. means In the BulletExtrinsic class we have the obj of BulletIntrinsic class. so we can access the attributes of BulletIntrinsic class by the obj of BulletIntrinsic class.
                        Ques:-   How many obj of BulletIntrinsic class are there in the system ?  ==>  assume there are 20 types of bullets in the system so there are 20 obj of BulletIntrinsic class in the system.
                        Ques:-   How many obj of BulletExtrinsic class are there in the system ?  ==>  assume there are 1M bullets in the system so there are 1M obj of BulletExtrinsic class in the system.
                        Ques:-   How much memory is going to used by 1 obj of BulletExtrinsic class ?  ==>  8+8+8+8+8+8+8+4+4+8 = 76 bytes.
                        Ques:-   How much memory is going to used by 1 obj of BulletIntrinsic class ?  ==>  8+8+1kb+4 = 1kb + 20 bytes. it is almost 1kb.
                        Now there were 2000 bullets per player & 100 players are playing the game.  ==>     so total bullets are 2000 * 100 = 200000 bullets.   ==>     2 * 100 kb.
                               if we don't use the Flyweight dp then the total memory used by the bullet obj is                         200mb.
                               if we use the Flyweight dp then the total memory used by the bullet obj is:-
                                                                        size of 1 obj of BulletIntrinsic class = 76 bytes.    
                                                                        so we can say,                                        76 * 2 * 100kb =      15200kb =    15.2mb. 
                                                                        & there are 20 type of BulletIntrinsic class obj so the total memory used by the BulletIntrinsic class obj is 20 * 1kb = 20kb.        
                                                                        so the total memory used by the bullet obj is 15.2mb + 20kb =               15.22mb.     
                By using the Flyweight dp we are able to reduce the memory usage of the bullet obj from 200mb to 15.22mb.
        This dp allows us to use the memory efficiently. 
        
        Ques:-  if we don't create two classes & just make those attributes static then what will happen ?  
        Ans  :-   static attribute means the value of that attribute is same across all the obj of that class. but for the Bullet class (old), the value of the BulletSize attributes are same across all the type of bullets ==>    No. 
                        BulletSize is different for all the type of bullets. so we can't make the BulletSize attribute as well as other attributes static.
                        means assume there are 1M bullets in the system & 20 types of bullets are there in the system. those 1M bullets are of 20 types like 5.56mm, 7.62mm etc. (any bullet can be of any type)
                            so if we make the BulletSize attribute static then the value of the BulletSize attribut should be same for all the 1M bullets but the value of the BulletSize attribute is not same, so we can't make the BulletSize attribute static.
                        therefor if we have one type of attribute than only we can make that attribute static. here we have 10-20 type of attributes so we can't make those attributes static. becoz the value of those attributes are not same for all the obj.
                        
Conclusion:-                        
                Ques1:-     When do we use Flyweight dp ?
                Ans1:-        when we have a class that has two types of attributes (Intrinsic & Extrinsic).    don't think that when we have to save the memory then we use the Flyweight dp, anythink like this. 
                
                Ques2:-     Should we use Flyweight dp everytime when we have class that has two types of attributes (Intrinsic & Extrinsic) ?
                Ans2:-        No, we will only use when we need to save the memory.
                                        means if there are lots of Intrinsic & Extrinsic attributes that a total memory is too much, then we should use the Flyweight dp.   so when the total memory is too much then we will use the Flyweight dp.
                
                Ques3:-   How to use the Flyweight dp ?
                Ans3:-    1.  we will divide the class into two classes. first class (Intrincsic Class) has Intrinsic attributes & second class (Extrinsic Class) has Extrinsic attributes. 
                                2.  we will use the composition. (means How we will link the obj of Intrinsic class in the Extrinsic class?     ==>   In the Extrinsic class we will have the obj of Intrinsic class) //reference of the obj.  so size of the obj = size of the address (8bytes)
                                3.  we create the BulletRegistry class.
                                 
                                
                Ques4:-     How to identify the Intrinsic & Extrinsic attributes ?
                Ans    :-      eg:-  Bullet obj, what will be the attribute of the Bullet obj ?  
                                                attributes are Type, name, image, size, weight etc.   & all the others are not the attributes they are probably current state of the Bullet becoz the Bullet obj is moving, so the values of these attributes are changing. 
                                                "So, Probaly the attributes that are not inherit properties of the object are known as the Extrinsic attributes."   means the attributes that are not the property of the object are known as the Extrinsic attributes.

Important stuff about Flyweight dp:-
                " The bullet objects (fiveMMBullet, sevenMMBullet etc) are being shared between all the flyingBullet objects.  yes, 
                    if the bullet objects are mutuable (changable) then there can be a problem happens. yes, 
                    becoz of the object is mutuable, one of the flyingBullet object can change the value of any attributes (of the bullet object like size, weight) & it will change for all the other flyingBullet objects"
               
               so when we make use of Flyweight dp, In the object that has a Intrinsic attributes, we should make sure that that object is immutable.                     
                                (we are not saying that make the attributes const final, we are saying that object should be immutable) means once we set the value of the attributes of the object then we can not change the value of the attributes of the object.
               
               How we make the object immutable ?
                        we can make the object immutable by "Using a Builder pattern OR removing the setters of the object".        we can use Builder Dp for the Class which has Intrinsic attributes. 
                        
                        Why we can't use Prototype Dp here ?
                                becoz for the bullet object we are not making the clone of the bullet object. we are just using the same bullet object for all the flyingBullet objects. 
                                & as per prototype dp, we have to create a clone obj. we don't need a clone, clone obj will end up create extra memory.  so we can't use the Prototype Dp here.


How to remember Flyweight dp ?
                this dp says, "if we have a object that have lots of weight & we have to move those objects (moving heavy objects is difficult) then remove the weight, now thin object can easily fly".  
                    eg:-    In bullet obj, we have 1kb of image, so we can remove the image from the bullet obj so the bullet obj is now thin & it can easily fly. 


Real world example:-
        In scaler codebase, let us say whenever a user does a submission, In that submission object we have their code, language, questionDescription, questionInputCase, questionOutputCase etc.
                here their are some attributes that should be put outside of the submission object. like questionDescription, questionInputCase, questionOutputCase etc. becoz they are same for all the submission object.
                & put those attributes in the Question object (Intrinsic attributes). so the submission object will have the reference of the Question object. so we can save the memory.      
                
                In that case 99% people use Prototype dp without even knowing about it. but we can use Flyweight dp here.          