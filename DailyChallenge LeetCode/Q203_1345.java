class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if(n==1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i); 
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        boolean[] vis = new boolean[n];
        vis[0] = true;

        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr = q.poll();

                if(curr == n-1) return step;
                
                int left = curr-1;
                int right = curr + 1;

                if(left >= 0 && !vis[left]){
                    vis[left] = true;
                    q.add(left);
                }
                if(right < n && !vis[right]){
                    vis[right] = true;
                    q.add(right);
                }

                if(map.containsKey(arr[curr])){
                    for(int idx : map.get(arr[curr])){
                        if(!vis[idx]){
                            vis[idx] = true;
                            q.add(idx);
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            step++;
        }
        return step;
    }
}
