# Behavioural Design Pattern
    ``` 
    this design pattern are going to talk about that "Often there are some properties / requirments with the behaviour of my system", means In S/w sys there are multiple behaviour(any method {means occurrence of event} / any action).
        like:- s/w sys composed of huge no. of actions like sorting the objects etc. 
    often there are multiple properties of those behaviour.
        like:- one of the properties can be "There are diff variants / types of that behaviour.
                eg:- One of the behaviour in my s/w sys is, Sorting an array (SortingArrayBehaviour).
                Ques:- Are there multiple types of sorting behaviour in my s/w sys ?
                Ans  :- Yes, 
                                we can sort the array by using QuickSort    ==>    so we can have QuickSortSortingArrayBehaviour.
                                we can sort the array by using MergeSort    ==>    so we can have MergeSortSortingArrayBehaviour. etc. 
               
               eg:- 
               CPU Scheduling:- there are multiple ways to perform CPU Scheduling in my PC. so in my pc there is one method called CPUSchedulingBehaviour & there are multiple ways to perfrom this. like RoundRobin FCFS, LRU etc.  
                 so we can have FCFSCPUSchedulingBehaviour, LRUCPUSchedulingBehaviour, RRCPUSchedulingBehaviour etc. 
    
        Conclusion till now:- there are multiple behaviour in my system & one of the behaviour is SortingArrayBehaviour but can we do this behaviour in diff ways, yes.  
                                                "There are Diff ways to perform particular behaviour in my sys"..

    1. This is the one of the problem that BehaviouralDP solves. (problem is:- if we have a behaviour in my sys, for which there are multiple ways to do that behaviour then how will we implement those behaviour).                ****************
    2. When an event occurs, multiple classes might want to do something (means multiple classes might want to know about that event).
            like:-      In Scaler codebase there is a class which create the batch are called BatchCreater , another class which sends the email are called EmailSerice etc. so when a student do signup then we want to do something
                                eg:-  add student into batch, send email, .
            How will we structure the codebase such that  an event (signup)  occur on  that event  multiple actions can be taken up.
    so all the behavioural dp are talking about "how the specific type of behaviour can be implemented in the system" so that the codebase is easy to maintain, easy to readable etc.

1.  ## Strategy DP  
    ```
        read below part when you go through the StrategyDp package. 
            Strategy (CarPathCalculatorStrategy, BikePathCalculatorStrategy and so on.) is not a class why ?
                becoz as per its name suggested that Strategy is just storing the behaviour || a way to do that behaviour. so Strategy class never be have an attributes, it will have an method with some attribute.
    
    
    ```
2.  ## Observer DP
        ```
            generally a huge variety of publishers are there, publishers have to deal with large number of subscribers, so In practical scanerio often publishers interface is not useful.
            even though when we read Refactoring Guru, where we see the examples of publishers interface as well but In practical scanerios publishers are very diverse therefore it become impractical to use common interface for them.
                if we use publisher interface then finding common become more complex. 
               ```
3.  ## Command DP    (we will read about this dp when we do BookMyShow)
       ```