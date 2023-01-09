import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue42627 {
    class disk {
		int start;
		int end;

		disk(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public int soultion(int[][] jobs) {
		PriorityQueue<disk> q = new PriorityQueue<>(new Comparator<disk>() {
			@Override
			public int compare(disk o1, disk o2) {
				return o1.end - o2.end;
			}
		});

		Arrays.sort(jobs, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int answer = 0;
		int cnt = 0;
		int time = jobs[0][0];
		int index = 0;

		while (cnt < jobs.length) {
			while (index < jobs.length && jobs[index][0] <= time)
				q.offer(new disk(jobs[index][0], jobs[index++][1]));

			if (!q.isEmpty()) {
				disk now = q.poll();
				time += now.end;
				answer += time - now.start;
				cnt++;
			} else
				time = jobs[index][0];

		}

        return answer / cnt;
	}
    
}
