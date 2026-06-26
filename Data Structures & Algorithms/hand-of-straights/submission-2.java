class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(groupSize == 1) return true;
        Arrays.sort(hand);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {hand[0], hand[0] + groupSize - 1});
        int i = 1;
        while(i < hand.length){
            if(q.isEmpty()){
                q.add(new int[] {hand[i], hand[i] + groupSize - 1});
                i++;
                continue;
            }
            int size = q.size();
            for(int j = 0; j < size; j++){
                if(i >= hand.length) break;
                if(hand[i] == q.peek()[0] || hand[i] > q.peek()[0] + 1){
                    q.add(new int[] {hand[i], hand[i] + groupSize - 1});
                }else if(hand[i] == q.peek()[1]){
                    q.poll();
                }else{
                    int[] temp = q.poll();
                    q.add(new int[]{temp[0] + 1, temp[1]});
                }

                i++;
            }
        }
        return q.isEmpty();
    }
}
