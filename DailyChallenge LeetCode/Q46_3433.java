class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentionCount = new int[numberOfUsers];
        int[] offlineTime = new int[numberOfUsers];

        Collections.sort(events,(a,b)->{
            int t1=Integer.parseInt(a.get(1));
            int t2=Integer.parseInt(b.get(1));

            if(t1==t2){
                char c1=a.get(0).charAt(1);
                char c2=b.get(0).charAt(1);
                return Character.compare(c2,c1);
            }
            return Integer.compare(t1,t2);
        });

        for (List<String> event : events) {

            if (event.get(0).equals("MESSAGE")) {
                applyMessageEvent(event, mentionCount, offlineTime);

            } else if (event.get(0).equals("OFFLINE")) {
                int timestamp = Integer.parseInt(event.get(1));
                int id = Integer.parseInt(event.get(2));

                offlineTime[id] = timestamp;
            }
        }
        return mentionCount;
    }
        private void applyMessageEvent(List<String> event, int[] mentionCount, int[] offlineTime) {
        int timestamp = Integer.parseInt(event.get(1));
        String[] tokens = event.get(2).split(" ");

        for (String token : tokens) {

            if (token.equals("ALL")) {
                for (int i = 0; i < mentionCount.length; i++) {
                    mentionCount[i]++;
                }
            } else if (token.equals("HERE")) {
                for (int i = 0; i < mentionCount.length; i++) {
                    if (offlineTime[i] == 0 || offlineTime[i] + 60 <= timestamp) {
                        mentionCount[i]++;
                    }
                }
            } else {
                int userId = Integer.parseInt(token.substring(2));
                mentionCount[userId]++;
            }
        }
    }
}
