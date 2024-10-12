``` 
Basic Intro:-
        Threads:- we can think of them as 'Small individual Process by themselves'. 
            eg:-    any task that we give to Java compiler, java has an ability to create threads out of them.
            What happend is:-
                    Java will create threads & each of these threads will take up some part of that particular operaion which we are trying to perform. (operation can be divide into sub parts, if an operation is atomic then we can't use of 
                        multithreading, but the task can be divided into multiple sub-operations then we can use of Multithreading to perform thiese task as Simultaneously || Parallell).
                        Javascript is single threaded lang so we can't use the concept of Parallelisim || Concurrency etc.
            it makes Java Powerful. it is very useful as a backend language specifically to perfom resource intensive task.
            
        Why Go programming language getting popularity in now a days.
            the reason is Multithreading. becoz 'threads that go lang creates are much more light weight compare to java'.
                eg:- Java creates a thread , that thread probably occupied 100kb of memory. where as go lang creates thread, that thread will occupy 1kb of memory. so go lang is much more efficient in spinning the threads & running them. 
                            becoz of the lightweight threads that go lang supports, now a days go lang is more adoptation in industry & it is also replacing java in many role.
        This is the reason that multithreading as a single concept is very much important for the entire software development industry. 
        
        
Process & Threads:-
    Process:-   Any program in execution will be a process. ||  any program which is currently executing.
    Threads:- are the individual units of a process.
    
    A single process does not share memory with other process. other hand A thread shares memory & other resource with other thread.
        whenever we are giving any task to a batch of threads, all of those threads will be working on the same task itself. hence any updation happen on the task that will affect the same memory location. sometimes it is good or sometimes
            it is not.. why ?
             Assume there is a scanerio, that we have one common obj. we don't want that the execution of any one thread affect the common obj for the other thread as well.  what will we do in that case.
                there is a concept called Thread Lccal,  What is Thread Lccal ?
                    so whenever we make use of Thread Lccal object, java will create a copy of the common object & associate that copy with each of the threads. so that any of threads which is workin on that particular obj will affect on 
                     that copy  obj itself. therefore any chage that the thread do that will not affect the other copies of the obj that are being operated by other threads.
             
              read more about Thread Local.
                    let say we have common memory object, we have multiple threads working on that (T1, T2,T3) 
                    Usecase:- we don't want our Memory obj to be affected by the any of the threads like T1, T2,T3.
                        let say T1 thread is working on the Memory obj, T2 & T3 if they make any changes that should no affect whatever T1 is working upon.
                    To solve this usecase, we can make use of the concept of Thread Local.
                        What Thread Local does ?
                         whenever we are make use of Thread Local obj, this memory object will be getting replicated across all the threads individually. like T1-Thread Local memory  obj, T2-Thread Local memory  obj, T3-Thread Local memory  obj.
                         now if T3 thread is makes any changes on  T3-Thread Local  memory obj then the other memory objects T1-Thread Local memory  obj, T2-Thread Local memory  obj will not be affected. 
                         this is the beniifit of using Thread Local obj.
                    Using Threads we have Shared memory objects or isolated memory objects. this is the best part of threads which is not possible in process.
                    Thread Local is a class in java. 
                    
                    Eg:- to understand thread concept better, remembe this example. we have to build a house, so the house is under construction that is called as Process. either we have multiple people to build the house by doing small small parts 
                            or we have one person to build the house. so we can say people / person are the threads. every people should have its own tagari to store the cemet to build the particular task. that we can called as Thread Local.
                            
                    Eg:-
                        In spring all the requests that is coming into our application will always be handlled by a Single thread itself. but after the request comes to our application then we might need to do  some processing, for that processing we  
                            would spin up some Application threads
                            whenever the request is coming in our spring application over the web for the REST api's. those request come into a thread, those threads are not actually a application threads || java threads these threads are called 
                             Calelina threads. so these threads are span up by the web server not our application code. so web server by default  spin up the limit of 200 threads. & that is configrable .
                        So every time the request is coming, that req will be handle by one Catelina thread & upon reaching it in our spring app, if we have very resource intensive task to perform then we can spin up multiple java threads to handle 
                            that case.
                            
    Communication within threads is faster.
        becoz threads are occuping the same memory space or within a process hence the communication will be much faster.
        
    What does it means by Blocked.
        block did not mean that a particular thread is waiting. blocked means there is a kind of deadlock scanerio where a particular thread is waiting for the other resources for which it need to run & those resources are not available at that
        point of time.  
    
    Thread LifeCycle Phase:-
        New Thread() :- whenever we do New Thread() then  we are creating a new thread. so the status of the thread will always be NEW. New thread basically means we have created a thread & that thread has occupied a memory location
                                    but it is not doing anything.
        Start() :-  after that we call the start()  then the thread will go into the runnable phase. In runnable phase thread is not doing anything but it is ready to pick up new jobs / tasks that we want to associated with it.
        Run() :-    after that we call the run() then ther run method will actually make this thread to do something. while the thread is running it means the thread is actually doing some kind of computation / task.
        Sleep() :-  aftter the running phase whenever we call the sleep() || wait() then that thread will go to the waiting phase. means whenever we want that this particular thread should wait for other task to finish it's execution then we will 
                            make use of wait() or sleep().
        Stop() :-   using the stop method we can terminate the thread from the waiting phase or from the running phase directly itself. in that case the thread will be dead & there is no use of that thread. hence the garbage collector will clean up    
                        all the memory location that the thread was occupied.     
          

   In one shot:-
        synchronize means lock that part of the code based on some identified. 
        eg:-    whenever we are locking the house so we need the key. we do not use that key to unlock or lock the other locks in the house. keys are sepecifically made for that lock.
                   here, Synchronized keyword we can consider it as a lock, the object (this) that we are mentioning as a argument we can consider that argument as a key.  so if we are locking the particular block using sync keyword with the 
                   particualr key (this) then we have to use the same key (this) for the other locks as well. becoz everthing has to be consistent.
                   means for the thread to understand that first lock (first Sync block) has been applied using the key (this) then thread also has to understand that the second lock (second  Sync block)  also has to be applied with the same key (this)
                   if we are using diff keys to lock the diff - diff sync block. then thread thinks that both of the locks (Sync block) are independent from each other. hence the thread will not actuallly athered to the sync keyword. so what will happen 
                        one thead will make use of the first sync block & the same thread or the diff thread will make use of the second sync block that we do not know, what will be the eveuntal result that we are going to get.  
  
   Executor service:-
        assume we have an java backend application. and we want 'our backend application to deligate task to multiple threads'. till now we learned that we can spining up threads by using runnable interface || extends Thread class. 
        these are some of the ways using which we can spin up threads. but 'spin up threads is kind of tds process like we need to write run(), we need to manage the thread life cycle and so on'.  we would want the os to perform all these 
        operations for us. that is where the executor framework service come into the picture.      What will happen is ?
            we have a concept of threadpool .
             



























```