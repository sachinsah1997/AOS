// Java program to implement Shortest Remaining Time First 
class Process{ 
    int pid; // Process ID 
    int bt; // Burst Time 
    int art; // Arrival Time 
    
    //this is the constructor to store varaible values of object at once. 
    public Process(int pid, int bt, int art){ 
        this.pid = pid; //process ID
        this.bt = bt; // Burst Time
        this.art = art; // Arrival Time
    } 
} 

public class Sjf{ 

    // Method to find the waiting time for all processes 
    static void waitingTime(Process proc[], int n, 
                                    int wt[]){ 
        // remaining time of the process.
        int rt[] = new int[n]; 
    
        // Copy the burst time into rt[] 
        for (int i = 0; i < n; i++) 
            rt[i] = proc[i].bt; 
    
        int complete = 0, t = 0, min = Integer.MAX_VALUE; 
        int shortest = 0, finish_time; 
        boolean check = false; 
    
        // Process until all processes gets completed 
        while (complete != n) { 
    
            // Find process with minimum remaining time among the processes that arrives till the current time` 
            for (int j = 0; j < n; j++) 
            { 
                if ((proc[j].art <= t) && 
                (rt[j] < min) && rt[j] > 0) {
                // stored the minimum value 
                    min = rt[j]; 
                // we have stored the index of minumum remaining time to decrement in further.
                    shortest = j; 
                    check = true; 
                } 
            } 
    
            if (check == false) { 
                t++; 
                continue; 
            } 
    
            // Reduce remaining time by one 
            rt[shortest]--; 
    
            // Update minimum value
            min = rt[shortest]; 
            if (min == 0) 
                min = Integer.MAX_VALUE; 
    
            // If a process gets completely executed 
            if (rt[shortest] == 0) { 
    
                // Increment complete so we could track that how much process if completed
                complete++; 
                check = false; 
    
                // after thr process is finishes we get the completed time of corresponding process. 
                finish_time = t + 1; 
    
                // Calculate waiting time by subtracting complete time with burst time and turn around time.
                wt[shortest] = finish_time - 
                            proc[shortest].bt - 
                            proc[shortest].art; 
    
                if (wt[shortest] < 0) 
                    wt[shortest] = 0; 
            } 
            // Increment time 
            t++; 
        } 
    } 
    
    // Method to calculate turn around time 
    static void turnAroundTime(Process proc[], int n, 
                            int wt[], int tat[]) 
    { 
        // calculating turnaround time by adding burst time + waiting time. 
        for (int i = 0; i < n; i++) 
            tat[i] = proc[i].bt + wt[i]; 
    } 
    
    // Method to calculate average time 
    static void avgTime(Process proc[], int n) 
    { 
        int wt[] = new int[n], tat[] = new int[n]; 
        int total_wt = 0, total_tat = 0; 
    
        // This method called to find waiting time of all  processes 
        waitingTime(proc, n, wt); 
    
        // This method called to find turn around time for all processes 
        turnAroundTime(proc, n, wt, tat); 
    
        // Calculate total waiting time and total turnaround time 
        for (int i = 0; i < n; i++) { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i]; 
        } 
    
         // we will get average average waiting time by dividing total waiting time with total no. of process.
        System.out.println("Average waiting time = " + 
                        (float)total_wt / (float)n); 
         // we will get average average turn around time by dividing total turn around time with total no. of process.
        System.out.println("Average turn around time = " + 
                        (float)total_tat / (float)n); 
    } 
    
    public static void main(String[] args) 
    { 
        // this is process object array to store each process with its pid, burst time and arrival time.
        Process proc[] = { new Process(1, 6, 1), 
                            new Process(2, 8, 1), 
                            new Process(3, 7, 2), 
                            new Process(4, 3, 3)}; 
        

        avgTime(proc, proc.length); 
    } 
} 
