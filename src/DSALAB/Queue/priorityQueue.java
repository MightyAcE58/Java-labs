package DSALAB.Queue;

import java.util.HashMap;

public class priorityQueue {

    static class PriorityQueue{

        HashMap<Integer,Integer> map = new HashMap<>();

        void enqueue(int value,int priority){
            map.put(value,priority);
        }

        int dequeue(){
            int HighestValue = -1;
            int HighestPriority = Integer.MAX_VALUE;

            for (int value:map.keySet()){
                if (map.get(value)< HighestPriority){
                    HighestPriority = map.get(value);
                    HighestValue = value;
                }
            }

            map.remove(HighestValue);
            return HighestValue;
        }

        void print(){
            System.out.println(map);
        }
    }

    static void main(String[] args) {

    PriorityQueue pq = new PriorityQueue();

        pq.enqueue(10,3);
        pq.enqueue(20,1);
        pq.enqueue(30,1);
        pq.print();

        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());

    }
}
