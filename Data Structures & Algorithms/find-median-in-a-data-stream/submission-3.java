class MedianFinder {

    PriorityQueue<Integer> bottomHalf;
    PriorityQueue<Integer> topHalf;
    public MedianFinder() {
        this.bottomHalf = new PriorityQueue<>(Collections.reverseOrder());
        this.topHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        int botSize = (bottomHalf.size() == 0) ? 0 : bottomHalf.size();
        if(!topHalf.isEmpty()){
            //If number needs to go in the top half;
            if(num >= topHalf.peek()){
                if(botSize == 0){
                    bottomHalf.add(topHalf.poll());
                    topHalf.add(num);
                } else if(topHalf.size() > botSize){
                    bottomHalf.add(topHalf.poll());
                    topHalf.add(num);
                } else {
                    topHalf.add(num);
                }
            } else {
                if(botSize == topHalf.size()){
                    if(num >= bottomHalf.peek()){
                        topHalf.add(num);
                    } else {
                        topHalf.add(bottomHalf.poll());
                        bottomHalf.add(num);
                    }
                    
                } else {
                    bottomHalf.add(num);
                }
            }
        } else {
            topHalf.add(num);
        }

    }
    
    public double findMedian() {
        boolean evenOrOdd = ((topHalf.size() + bottomHalf.size()) % 2 == 0);

        return (evenOrOdd) ? (double)(topHalf.peek() + bottomHalf.peek())/2 : (double) topHalf.peek();
    }
}
