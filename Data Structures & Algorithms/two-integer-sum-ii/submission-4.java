class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int l = 0, r = numbers.length-1;
            int mid = (l + r)/2;
            int tNum = target - numbers[i];
            while(l <= r){
                if(numbers[mid]==tNum && mid != i) return new int[]{i+1, mid+1};
                if(numbers[mid] > tNum){
                    r = mid - 1;
                    mid = (l + r)/2;
                }else{
                    l = mid + 1;
                    mid = (l + r)/2;
                }
            }
        }
        return new int[]{};
    }
}
