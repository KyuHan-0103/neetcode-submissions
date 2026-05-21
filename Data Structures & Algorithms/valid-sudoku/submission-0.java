class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowCounter = new HashMap<>();
        Map<Integer, Set<Character>> columnCounter = new HashMap<>();
        Map<List<Integer>, Set<Character>> squareCounter = new HashMap<>();

        for(int i = 0; i < board.length; i++){
            //Initialize each row with empty set
            rowCounter.put(i, new HashSet<Character>());
            for(int j = 0; j < board[i].length; j++){
                //Initialize each column with empty set
                if(i==0){
                    columnCounter.put(j, new HashSet<Character>());
                }

                List<Integer> currentSquare = new ArrayList<Integer>();
                currentSquare.add(i/3);
                currentSquare.add(j/3);
                //Initialize each square
                if((i+3) % 3 == 0 && (j+3) % 3 == 0){
                    squareCounter.put(currentSquare, new HashSet<Character>());
                }

                if(!squareCounter.get(currentSquare).contains(board[i][j])){
                    if(board[i][j] != '.'){
                        squareCounter.get(currentSquare).add(board[i][j]);
                    }
                } else {
                    return false;
                }


                if(!rowCounter.get(i).contains(board[i][j])){
                    if(board[i][j] != '.'){
                        rowCounter.get(i).add(board[i][j]);
                    }
                } else {
                    return false;
                }

                if(!columnCounter.get(j).contains(board[i][j])){
                    if(board[i][j] != '.'){
                        columnCounter.get(j).add(board[i][j]);
                    }
                } else {
                    return false;
                }
            }
        }

        return true;

    }
}
