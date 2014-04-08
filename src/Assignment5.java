import java.util.*;
import java.lang.*;
import java.math.*;

public class Assignment5 {

	private static final int cylinderCount = 4999;

	private static int secondCyl = 2255;
	private static int firstCyl = 1723;



	public static int fcfs(int[] requestQueue) {
		System.out.println("Testing First-Come First-Served Disk Algorithm:\n");
		int totalDistance = secondCyl - firstCyl;
		for (int i = 0; i < requestQueue.length; i++){
			int previousCyl = 0;
			if (i == 0) {
				previousCyl = secondCyl;
			}
			else {
				previousCyl = requestQueue[i-1];
			}
			int currentCyl = requestQueue[i];
			int distanceBetweenCyl = Math.abs(currentCyl - previousCyl);
			totalDistance += distanceBetweenCyl;
			System.out.format("Distance from %d to %d = %d\tTotal = %d\n", previousCyl, currentCyl, distanceBetweenCyl, totalDistance);
		}
		System.out.println("====");
		return totalDistance;
	}
	public static int sstf(int[] requestQueue) {
		System.out.println("Testing Shortest Seek Time First");
		int totalDistance = secondCyl - firstCyl;

		int currentCyl = secondCyl;

		ArrayList<Integer> queue = new ArrayList<Integer>(requestQueue.length);
		for (Integer i : requestQueue) {
			queue.add(i);
		}
		ArrayList<Integer> seekTimes = new ArrayList<Integer>();
		for (int i = 0; i < queue.size(); i++) {
			seekTimes.add(0);
		}
		ArrayList<Integer> orderVisited = new ArrayList<Integer>();

		// Find shortest seek time
		int minTime = Integer.MAX_VALUE;
		for (int i = 0; i < queue.size(); i++) {
			int nextIndex = 0;
			
			currentCyl = queue.get(i);
			// Create new seek times from current head position
			for (int k = 0; k < queue.size(); i++) {
				seekTimes.set(k, Math.abs(currentCyl - queue.get(k)));
			}
			
			for (int current = 0; current < seekTimes.size(); current++) {
				if (seekTimes.get(current) < minTime) {
					minTime = seekTimes.get(current);
					nextIndex = current;
				}
			}
			orderVisited.add(queue.get(nextIndex));
			queue.remove(i);
			totalDistance += minTime;
		}
		
		System.out.format("Total distance traveled = %d", totalDistance);
		System.out.println("Cylinder positions listed by order visited:");
		for (Integer i : orderVisited) {
			System.out.println(i);
		}
		System.out.println("====");

		return totalDistance;
	}
	public static int scan() {
		return 0;
	}
	public static int look() {
		return 0;
	}
	public static int cscan() {
		return 0;
	}
	public static int clook() {
		return 0;
	}

	public static void main(String[] args) {
		int pendingReq[] = { 2055, 1175, 2304, 2700, 513, 1680, 256, 1401, 4922, 3692 };
		


		fcfs(pendingReq);
		sstf(pendingReq);
	}
}