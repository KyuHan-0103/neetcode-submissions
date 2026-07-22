class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] < 0){
                boolean asteroid = true;
                while(!stack.isEmpty() && asteroid){
                    if(stack.peek() < 0){
                        break;
                    }
                    if((stack.peek() + asteroids[i]) < 0){
                        stack.pop();
                    } else if (stack.peek() + asteroids[i] == 0){
                        stack.pop();
                        asteroid = false;
                    } else {
                        asteroid = false;
                    }
                }
                if(asteroid){
                    stack.push(asteroids[i]);
                }
            } else {
                stack.push(asteroids[i]);
            }
            
        }
        return stack.reversed().stream().mapToInt(Integer::intValue).toArray();
    }
}