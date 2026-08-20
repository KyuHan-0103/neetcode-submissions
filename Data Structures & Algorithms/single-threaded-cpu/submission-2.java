class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> processTime = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> enqueueTime = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int time = 0;
        int[] res = new int[tasks.length];
        for(int i = 0; i < tasks.length; i++){
            enqueueTime.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        int i = 0;
        while(!processTime.isEmpty() || !enqueueTime.isEmpty()){
            if(processTime.isEmpty() && time < enqueueTime.peek()[0]){
                time = enqueueTime.peek()[0];
            }
            while(!enqueueTime.isEmpty() && enqueueTime.peek()[0] <= time){
                processTime.add(enqueueTime.poll());
            }
            if(!processTime.isEmpty()){
                res[i] = processTime.peek()[2];
                i++;
                time += processTime.poll()[1];
            }
        }
        return res;
    }
}