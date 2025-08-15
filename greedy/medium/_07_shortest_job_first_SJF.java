package greedy.medium;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _07_shortest_job_first_SJF {
    
    public static float sjf(int n, int []arrivalTime, int []burstTime) {
        class Process {
            int arrivalTime;
            int burstTime;

            public Process(int arrivalTime, int burstTime) {
                this.arrivalTime = arrivalTime;
                this.burstTime = burstTime;
            }
        }

        ArrayList<Process> processes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            processes.add(new Process(arrivalTime[i], burstTime[i]));
        }
        processes.sort((a,b) -> a.arrivalTime - b.arrivalTime);

        PriorityQueue<Process> pq = new PriorityQueue<>((a, b) -> {
            if (a.burstTime == b.burstTime) return a.arrivalTime - b.arrivalTime;
            return a.burstTime - b.burstTime;
        });

        int i = 0; 
        int time = processes.get(0).arrivalTime;
        float totalWaitingTime = 0;

        // Process the jobs in order of their arrival time and burst time
        // while maintaining the current time
        while (i < n || !pq.isEmpty()) {
            // Add all processes that have arrived by the current time
            while (i < n &&processes.get(i).arrivalTime <= time) {
                pq.offer(processes.get(i));
                i++;
            }

            // If there are processes in the queue, process the one with the shortest burst time
            if (!pq.isEmpty()) {
                Process p = pq.poll();
                time += p.burstTime;
                totalWaitingTime += time - p.arrivalTime - p.burstTime;
            } else {
                // If no process is available, jump to the next process arrival time
                time = processes.get(i).arrivalTime; // jump to the next process arrival time
            }
        }

        return totalWaitingTime / n;        
    }
}

// https://www.naukri.com/code360/problems/sjf_1172165
/*
 * You have to implement the shortest job first scheduling algorithm.



Shortest Job First is an algorithm in which the process having the smallest execution(burst) time is chosen for the next execution. Here, you will implement a non - preemptive version (a process will wait till process(es) with shorter burst time executes). You have to return the average waiting for the given number of processes.


 */