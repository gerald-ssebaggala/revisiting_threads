
## Process -->> this is a unit of execution that has its own memory space.

- Each application has its own memory space, also known as the Heap

- The Heap isn't shared btn 2 applications OR 2 processes, they each have their own

## Thread -->> is a single unit of execution, within a process

- Each Process can have multiple threads.#

- Every application has atleast one thread, and that's the main thread

## Threads Share Process Memory
- creating a thread doesn't require as many resources as creating a process does.
- Every thread created by a process, shares that process's memory space, the heap.
  en this can cause big problems with in the application

## Threads also have Stack Memory

- Each thread's got what's called a thread stack
- And this is memory, that a single thread, will have access to.

- Every java application runs as a single process, and each process can then have multiple threads within it
- Every Process has a Heap and every thread has a thread Stack

## Why Use Multiple Threads ?? --->> What're advantages of creating a multi-threaded Application ??

- One of the most common reasons, is -->> to offload long Running tasks
  ... what this basically means is --->> instead of tying up the main thread, we can create additional threads,
  to execute tasks that might take a long time.
    - This in return, frees up the main thread so that it can continue
        + working,
        + and executing,
        + and being Responsive to the user

- You also might use multiple threads to process large amounts of data,
    + which can improve performance of data intensive operations

- A web server, is another usecase for many threads,
    + allowing multiple Connections and
    + Requests to be handled simultenously

### Concurrency -->> Refers to application doing more than one thing at a time.

- What Concurrency really does is;
    + It helps different part of a program to make progress independently.
      --> Often leading to better Resource utilization & improved Performance

One task doesn't have to complete, before another one can start, and multiple threads can make incremental Progress

## Java's Threads

- Threads are the fundamental building blocks, to support concurrency in a java application
- They're essential because they allow us to perform multiple tasks simultaneously within a Single Process

## Creating Thread Instance
- Extend the Thread class, and create an instance of this new subclass
- Create an instance of Thread, and pass it any instance that implements the Runnable interface... this includes passing a lambda expression
- Use an Excutor, to create one or more threads for you

## Runnable is a Functional Interface
- it's functional method, or its single access method (SAM), is run method
- when u see a Runnable type, it's a target for a lambda expression
- You can have any class implement the Runnable interface to run asynchronously 
