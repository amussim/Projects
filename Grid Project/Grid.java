package cmsc256;
/*
Aneesh Mussim
CMSC 256: Project 1
sec 002
2/4/2021
For this project we are implementing a grid that has a two dimensional array with 3 rows
and 3 columns
 */
public class  Grid {
    //instance variables for the grid class
    private char[][] gridValues = new char [3][3];

    /*
    * Initializes a 3 by 3 grid to default char values ('\u0000')
    * */
    public Grid() {
        //this will loop through the values and give a default value
         for(int i = 0; i < 3; i++) {
             for(int j = 0; j < 3; j++) {
                 gridValues[i][j] = '\u0000';
             }
         }
    }


    /**
     * Formats the grid row to a String that consists of a space, the char,
     *  a space, a vertical pipe, a space, the char, a space, a vertical pipe,
     * a space, the char, and a final space,
     * for example: " X | X | X "
     *
     * @param rowIndex  the index of the row to convert to a String
     * @return a formatted String representation of the row
     * @throws IllegalArgumentException if an invalid row index is given
     */
    public String getRow(int rowIndex) throws IllegalArgumentException{

        if (rowIndex >= 3 || rowIndex < 0)  {
            throw  new IllegalArgumentException();
        }
        String row = " ";
        char first = gridValues[rowIndex][0];
        char second = gridValues[rowIndex][1];
        char third = gridValues[rowIndex][2];

        if(first == '\u0000') {
            first = ' ';
        }
        if (second == '\u0000') {
            second = ' ';
        }
        if (third == '\u0000') {
            third = ' ';
        }
        row += first + " | " + second + " | " + third + " ";
        return row;
    }

    /**
     * Sets the grid location to the given value
     * @param value         char value for the grid location
     * @param rowIndex      the index of the row position
     * @param columnIndex   the index of the column position
     * @throws IllegalArgumentException if the row index or column index is invalid
     *                                  or if the position is not null
     */
    public void setPosition(char value, int rowIndex, int columnIndex) throws IllegalArgumentException{
            if(!checkInput(value) || rowIndex >=3 || columnIndex >=3 || rowIndex < 0 || columnIndex < 0) {
                throw new IllegalArgumentException("Invalid");
            }
            if (gridValues[rowIndex][columnIndex] != '\u0000') {
                throw new IllegalArgumentException("Position is not null");
            }
        gridValues[rowIndex][columnIndex] = value;
    }

    /**
     * Checks for valid input value
     * @param inputValue the char value to be checked
     * @return true if input value is X, x, O, or o
     * @throws IllegalArgumentException if character is not X or O
     */
    public boolean checkInput(char inputValue) throws IllegalArgumentException{
        if(inputValue == 'x' || inputValue == 'X' || inputValue == 'o'|| inputValue == 'O') {
            return true;
        }
        else {
            throw new IllegalArgumentException("Invalid");
        }
    }

    /**
     * Checks if all positions have a char value
     * @return true if none of the grid locations contain the null character ('\u0000')
     */
    public boolean isFull(){
        for(int i =0; i < 3; i++) {
            for(int j =0; j < 3; j++) {
                if(gridValues[i][j]=='\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *  Check if row has all the same characters
     * @param rowIndex  the row index to check
     * @return  true if row contains the same char value
     * @throws IllegalArgumentException if an invalid row index is given
     */
    public boolean isRowMatching(int rowIndex) throws IllegalArgumentException{
         if (rowIndex >= 3 || rowIndex < 0) {
             throw new IllegalArgumentException("Invalid");
         }
        if(gridValues[rowIndex][0] == gridValues[rowIndex][1]) {
            if(gridValues[rowIndex][0] == gridValues[rowIndex][2]){
                return true;
            }
        }
        return false;
    }

    /**
     * Check if column has all the same characters
     * @param columnIndex   the column index to check
     * @return  true if column contains the same char value
     * @throws IllegalArgumentException if an invalid column index is given
     */
    public boolean isColumnMatching(int columnIndex) throws IllegalArgumentException {
        if (columnIndex >= 3 || columnIndex < 0) {
            throw new IllegalArgumentException("Invalid");
        }
        if (gridValues[0][columnIndex] == gridValues[1][columnIndex]) {
            if (gridValues[0][columnIndex] == gridValues[2][columnIndex]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if either diagonal has the same characters
     * @return true if grid position 0,0; 1,1; and 2,2 are the same
     *              if grid position 2,0; 1,1; and 0,2 are the same
     */
    public boolean hasDiagonalMatch(){
        if ((gridValues[0][0] != gridValues[1][1] )) {
            if (gridValues[0][0] != gridValues[2][2]) {
                if(gridValues[0][2] != gridValues[1][1] ) {
                    if(gridValues[0][2] != gridValues[2][0]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks if there is a character with three in a row on the grid
     * @return winning character if there is a row, column or diagonal match
     *          otherwise returns the null character
     */
    public char checkForWinner(){
        if(isRowMatching(0) || hasDiagonalMatch()) {
            return gridValues[0][0];
        }
        if (isRowMatching(1)) {
            return gridValues[1][0];
        }
        if (isRowMatching(2) || hasDiagonalMatch())  {
            return gridValues[2][0];
        }
        if (isColumnMatching(0) || hasDiagonalMatch()) {
            return gridValues[0][0];
        }
        if (isColumnMatching(1)) {
            return gridValues[0][1];
        }
        if (isColumnMatching(2) || hasDiagonalMatch()) {
            return gridValues[0][2];
        }
        if(hasDiagonalMatch()){
            return gridValues[1][1];
        }
        if(hasDiagonalMatch()){
            return gridValues[2][2];
        }

        else {
            return '\u0000';
        }
    }

    @Override
    /**
     * Returns a string representation of the grid with each row separated by a line
     * @return string
     */
    public String toString() {
       String result= getRow(0) + "\n" + "---------" + "\n" + getRow(1) + "\n" + "---------" + "\n" + getRow(2) + "\n";
       return  result;
    }
}
