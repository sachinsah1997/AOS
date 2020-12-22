// Java program for FCFS Disk Scheduling algorithm 
class FcfsDisk 
{ 

static int size = 8; 

static void FCFS(int arr[], int head){ 
	
	// this variable will keep track to how much time to move head to required position.
	int seek_count = 0; 
	int distance, cur_track; 

	for (int i = 0; i < size; i++) 
	{ 
		// this will give required position where we have to move the head.
		cur_track = arr[i]; 

		// calculate absolute distance from  required postion and current head.
		distance = Math.abs(cur_track - head); 

		// total distance of the required position.
		seek_count += distance; 

		// when head is at required position set it as head postion
		head = cur_track; 
	} 

	System.out.println("Total number of " + "seek operations = " + seek_count); 

	// Seek sequence would be the same as request array sequence 
	System.out.println("Seek Sequence is"); 

	for (int i = 0; i < size; i++){ 
		System.out.println(arr[i]); 
	} 
} 

public static void main(String[] args){ 
	// required disk position
	int arr[] = { 176, 79, 34, 60, 
				92, 11, 41, 114 }; 
	//initail head postion
	int head = 50; 

	FCFS(arr, head); 
	} 
} 