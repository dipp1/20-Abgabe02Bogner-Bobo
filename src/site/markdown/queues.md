# Queue

## What is a queue?

A queue is a data structure, similar to a list with the restriction that you only can take the first element out of a queue. 

For example if you line up on the cash register, you are forming a queue with other people. You usually have to wait for your turn and usually everyone is rung up in the same order they entered the queue in.

    FIFO - first in first out is a principle which describes every queue

There are also priority queues which not only take the order into account, but also the priority of every element. If you are an important politician, you will get rung up first, doesn't matter when you entered the queue. Everything will get held up for that politician.

### Used for

Schedulers for operating systems. Schedulers can decide which process to run next according to the principle of a priority queue.

A waiting list for a doctor can also be seen as a queue.

## How can you test a queue?

Since a queue is basically just a list, we can test basic functions (e.g. size) like an ArrayList.

For the queue specific methods, we need to test if the first object in a queue is actually the first object being removed from the queue.



