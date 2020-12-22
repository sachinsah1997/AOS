// Java program for implementation of FCFS process Scheduling 
class Fcfs { 

	// This method is used to find the waiting time for all processes 
	static void waitingTime(int processes[], int n, 
			int bt[], int wt[]) {

		// waiting time for first process is 0 
		wt[0] = 0; 

		for (int i = 1; i < n; i++) { 
			// calculating waiting time
			wt[i] = bt[i - 1] + wt[i - 1]; 
		} 
	} 

	// This method is used to calculate turn around time 
	static void turnAroundTime(int processes[], int n, 
			int bt[], int wt[], int tat[]) { 
		for (int i = 0; i < n; i++) { 
			// calculating turnaround time by adding waiting time + burst time of a process
			tat[i] = bt[i] + wt[i]; 
		} 
	} 

	//This method is used to calculate average waiting time and average turn around time.
	static void avgTime(int processes[], int n, int bt[]) { 
		int wt[] = new int[n], tat[] = new int[n]; 
		int total_wt = 0, total_tat = 0; 

		//This method is call to find waiting time of all processes 
		waitingTime(processes, n, bt, wt); 

		//This method is to find turn around time for all processes 
		turnAroundTime(processes, n, bt, wt, tat); 

		
		// Calculate total waiting time and total turn around time 
		for (int i = 0; i < n; i++) { 
			//by adding all processes waiting time we will get total waiting time.
			total_wt = total_wt + wt[i]; 
			//by adding all processes turn around time we will get total waiting time.
			total_tat = total_tat + tat[i]; 
		}
		 
		 // we will get average average waiting time by dividing total waiting time with total no. of process.
		float avg_wt = (float)total_wt /(float) n; 
		 // we will get average average turn around time by dividing total turn around time with total no. of process.
		int avg_tat = total_tat / n; 
		System.out.printf("Average waiting time = %f", avg_wt); 
		System.out.printf("\n"); 
		System.out.printf("Average turn around time = %d ", avg_tat); 
	} 

	public static void main(String[] args){ 

		//list of processes and it's ids.
		int processes[] = {1, 2, 3}; 
		int n = processes.length; 

		//Burst time of all processes  corresponding with processes ids.
		int burst_time[] = {10, 5, 8}; 

		// this method is called to find avg wating time and average turn around time.
		avgTime(processes, n, burst_time); 
	} 
}  