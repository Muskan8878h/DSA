class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0]
                    ? Long.compare(a[1], b[1])
                    : Long.compare(a[0], b[0])
        );

        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                // Assign immediately
                int room = availableRooms.poll();
                meetingCount[room]++;
                busyRooms.offer(new long[]{end, room});
            } else {
                // Delay meeting
                long[] earliest = busyRooms.poll();
                long newEndTime = earliest[0] + duration;
                int room = (int) earliest[1];

                meetingCount[room]++;
                busyRooms.offer(new long[]{newEndTime, room});
            }
        }
        int maxMeetings = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetings) {
                maxMeetings = meetingCount[i];
                answer = i;
            }
        }

        return answer;
    }
}
