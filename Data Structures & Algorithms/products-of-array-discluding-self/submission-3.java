class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int[] pre = new int[len];
        int[] post = new int[len];
        pre[0] = 1;
        post[len - 1] = 1;

        for(int i = 1; i < len; i++){
            pre[i] = nums[i-1] * pre[i-1];
        }

        for(int i = len - 2; i >=0; i--){
            post[i] = nums[i + 1] * post[i + 1];
        }

        for(int i =0; i < len; i++){
            output[i] = post[i] * pre[i];
        }

        return output;
    }
}