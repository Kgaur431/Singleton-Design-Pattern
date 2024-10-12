``` 
    Before Schema design, we discuss HAS-A relaiton of Class diagram
        eg:-   
            scaler class might have an atttibute of Participants.
            Class Scaler {
                List<User> Participants;        // list of users that are participants of that class.
            }
        so we can say Scaler class have HAS-A relation with participants. here comes the concept of Cardinality.
            
    Cardinality:-
            it says when 2 classes A & B have a HAS-A relationship, cardinality talks about "How many of A" are related / associated to "How many of B".   4
                eg:- How many Scaler class are related to How many Students.
                
                         Ques:-  What is the cardinality of  the relation between Scaler class & User class, for the relationship participants.    
                                        assume the ans will 1:M, M:M. if we choose the ans as 1:M then interviewer said why not M:M then we think like ohh! M:M can be the ans. means we are able to give the correct ans but interviewer just twist & we confused. 
                                        So, ther is trick by using it we can easily solve the cardinality problems.
                        Ans  :-     Trick is,
                                            We want to find the relationship b/w the Scaler class & User. 
                                                    0.  the relation type is Participants (participants is not currently attending the class, he can attend class in future).
                                                -   we will find the relationship in this way:-
                                                     1.     first take an arrow from L to R. means Scaler class to User class.
                                                     2.     & ask (from yourself) that one Scaler class has how many Participants ?
                                                                    ans:-   Many.
                                                     3.     then do a from R to L. means User class to Sclaer class.
                                                     4.     & ask (from yourself) that one User can be a participants of How many classes.
                                                                    ans:-   Many,
                                                    5.      If we see M any side then put it below.
                                                    6.      Now we see M other side as well so put it below. & this this is the final ans. 
                                                    
                                            Tricky question:-
                                                            In Fb, what is the cardinality of relationship b/w a User & User ?
                                                                generally we think that the ans is M:M. 
                                                                but we without knowing the relationship b/w User & User, How we can say the ans is M:M.
                                                                **Whenever we are talking about the relations b/w two entities, then there can be more than one relation b/w two entites**. like 1:M, M:M ans so on. 
                                                                    means On FB, b/w User & User there can be a relation of friend, there can be a relation of follow, there can be a relation of spouse etc. 
                                                                    so If we talk about the fried relations then, the cardinality b/w User & USer is M:M. etc.  
                                                                    
                                                            therefore the imp thing is "what type of relation we are talking aobut b/w the entities".
           How to always get the correct ans for cardinality ?
                Step1:- we should clear that what type of relation are talking about.
                Step2:- then we should follow the above Trick.
**********************************************************************************************************************************************************************************************************************************************
                
   Schema Design:-
                we will talk about :- 
                        what is Schema Design.
                        How to find what tables will be there in my schema.
                        How to store the relationship b/w diff tables within the database. 
                
                Ques:-  What is Schema ?
                Ans  :-   Schema is a blueprint of a Database. like Class.
                                    It tells how will a SQL db actually look like. means  what will be the diff tables thare are going to be there in my db. & what will be the columns inside those table.
                
                Ques:-  What does table represent in the db ?
                Ans   :-  table represent the entity. 
                
                How should we approach Schema Design. 
                The approach is,
                        -   Start with a Class Diagram.
                        -   & then do the Schema design from there . 
                        means "for every table / class that we see in the class diagram, create an associated table".               *******************************************
                            eg:-  first create the class diagram for the given set of requirments & after that for every class that we find for that requirments, create a corresponding table. 
   
   
   
   
   
   
   
   
   
   
   
   
   
   
```
