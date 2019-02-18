
/**
 * Mmn 14
 *
 * @author Niv Shashoua
 * Id - 312485220
 * @version 6.6.18
 */

public class Ex14
{
     //////////////
    //Question 1//
    /////////////
   
    //answer for the first qustion -> 3,5,6 = true
    
    /**
     * This method check if a number exist in an 2D array(that was check first in the what mthod).start to check from the last row and the first column.
     * if val(the number we wanted to find) smaller than the cell we checked move to the upper row(becouse it cannot be on the riht cells),
     * else go to the right(becouse it cammot be on the upper celles).
     * Time complexity = O(n).
     * Storage complexity = O(1).
     * @param m array that got true from the method what, val - a number we check if exist in the array.
     * @return true if the number we wanted to find exist in the array.
     */
    public static boolean findValWhat (int [][] m, int val)
    {
        int col = 0; //variable for the column.
        int row = m.length -1; //variable for the row.
        while(row >= 0 && col < m.length) //check that it wont get out of the array.
        {
            if(m[row][col] == val)// find val.
                return(true);
            else if(m[row][col] > val) //if val is smaller search up.
                row--;
            else //if val is bigger search right.
                col++;
        }

        return(false);
    }
    
    /**
     * This method check if a number exist in an 2D array(that was check first in the test mthod). it check if val is smaller than
     * the first number in the row(start to check from the second row) and if so, check the if val exist in the row and in row before.if its not smaller
     * than the first number of a row check the last row.
     * Time complexity = O(n).
     * Storage complexity = O(1).
     * @param m array that got true from the method test, val - a number we check if exist in the array.
     * @return true if the number we wanted to find exist in the array.
     */
    public static boolean findValTest (int [][] m, int val)
    {
        int row;
        for(row = 1; row < m.length && m[row][0] < val; row++)//start from the secend row. find if val might be in the row below the one we check. 
            ;
        row--; //val might be in the row below the one we checked. and if the number is in the last row that is also ok,becouse it will check m.length-1. 
        int stop = row+1; //the row below, and when to stop the next loop. 
        
        for(;row <= stop ;row++)//check the row before and the row.
            for(int col=0; col < m.length && row < m.length ; col++)// check if val exist in the two rows.
                if(m[row][col] == val)
                    return(true);
                    
        return(false);
    }
    
    
     //////////////
    //Question 2//
    /////////////
    
    /**
     * This method get a string and a charecter, and it find how many subsring it have with this char at the start, middle and end of the string.
     * eample: string -"abcbcabcacabcc" char- 'c' --> 4 - "cbcabc", "cabcac", "cacabc", "cabcc".
     * Time complexity = O(n).
     * Storage complexity = O(1).
     * @param s the string, c - the char.
     * @return the number of subsring that have the char we wanted at the start, middle and end of the string.
     */
    public static int subStrC(String s, char c)
    {
        int answer = 0; //variable for the number of substring we wanted to find.
        int numberOfC = 0; //variable for the number of the character.
        for(int num = 0;num < s.length(); num++) //count how many of the charcter the string have.
        {  
            if(s.charAt(num) == c)
                numberOfC++;
        }
 
        if (numberOfC >= 3) //check if there are at least 3 of the char(for 1 substring).
            answer = numberOfC -2; //the number of substring is the number of char(at least 3) -2.
            
        return(answer);
    }
    
    /**
     * This method find how many substring are inside a given string, and every substring begin and and with a given char(we will call it c),
     * and also this char appear in the maximum k times inside the substing. Every time we find the letter(we wanted) there will be one more substring 
     * to add to the last number of substring we added, until the number of letter is bigger than k+2, and than add the same number of substring.
     * example, when k+2=4: numberOfC=2 answer=1 -> numberOfC=3 answer=1+(1+1) -> numberOfC=4 answer=1+(1+1+1) -> numberOfC=5 answer=1+(1+1+1)
     * Time complexity = O(n).
     * Storage complexity = O(1).
     * @param @param s the string, c - the char, k - the maximum of how many times the char will apear inside the substing.
     * @return how many substring there are.
     */
    public static int subStrMaxC(String s, char c, int k)
    {
        int answer = 0; //variable for the number of substring we wanted to find.
        int numberOfC = 0; //variable for the number of the character.
        int addNumber = 1; //variable that help to calculate the answer.
        for(int num = 0;num < s.length(); num++) //get over all the letters in the string.
        {  
            if(s.charAt(num) == c) //when we found the letter we wanted.
            {
                numberOfC++;
                
                if(numberOfC >= 2) //there will be at least 1 substring.
                {
                    answer = answer + addNumber; //calculate the final answer.
                    
                    //every time we find the letter there will be one more substring to add to the last number of substring we added, until the
                    //number of letter is k+2, and than add the same number of substring.
                    //example, when k+2=4: numberOfC=2 answer=1 -> numberOfC=3 answer=1+(1+1) -> numberOfC=4 answer=1+(1+1+1)
                    //-> numberOfC=5 answer=1+(1+1+1)
                    if(numberOfC < k+2)
                        addNumber++;    
                }
            }
        }
        return(answer);
    }
   
     //////////////
    //Question 3//
    /////////////
    
    /**
     *This methods calculate how many possibilities Spiderman have to climb a building with n floors. He can climb 1 or 2 floors in a time. 
     *This methods use the recursive method spiderman(int n,int x).
     *@param n number of floors in the building.
     *@rutern the number of possibilities that spiderman have to climb the building.
     */
    public static int spiderman(int n)
    {
        if(n==0) //If the floor is zero there are 0 possibilities.
            return(0);
        
        return(spiderman(n,0));
    }
    
    //the recursive calculate from the top to the bottom. In the first and the zero floor the number of possibilities is 1. 
    private static int spiderman(int n,int x)
    {
        if(n == 0 || n == 1) //in the first and the zero floor the number of possibilities is 1
            return(1);
        
        return(spiderman(n-1,x) + spiderman(n-2,x)); //add the number of possibilities, that once he climb one floor at a time and once two floors.
    }
    
    
    
    /**
     * This methods calculate how many possibilities Spiderman have to climb a building with n (19<n<30) floors. He can climb 1 or 2 floors in a time.
     * But this time if spiderman get to the 20's floor he get automatically to the top.
     * This method use the recursive method spidermanPhoneBooth20(int n,int x) to calculate how many possibilities spiderman have to climb, without
     * steping on the 20's floor. And in the end add the number of possibilities to get to the 20's floor, to the final answer.
     * @param n number of floors in the building.
     * @rutern the number of possibilities that spiderman have to climb the building.
     */
    public static int spidermanPhoneBooth20(int n)
    {
       if(n > 29 || n < 20) //out of range.
            return(0);
            
       if(n == 20) //number of possibilities to get to the 20's floor.
            return(spiderman(19) + spiderman(18));
       
       return(spidermanPhoneBooth20(n,0) + spiderman(20)); //add the number of possibilities to get to the 20's floor.
    }
    
    //This method use the recursive method spidermanPhoneBooth20(int n,int x) to calculate how many possibilities spiderman have to climb, without
    //steping on the 20's floor.
    private static int spidermanPhoneBooth20(int n,int x)
    {
        if(n == 21)
            return(spiderman(19));
        
        if(n == 22)
            return(spiderman(19));
            
        return( spidermanPhoneBooth20(n-1,x) + spidermanPhoneBooth20(n-2,x) );
    }
    
    
    //////////////
    //Question 4//
    /////////////
    
    /**
     * This method get a 2D array, and calculate how many possible ways there are to go from the point (0,0) to last point (r,c) (r = number of rows,
     * c = number of column).how the moves go? each "jump" is disieded acording to the number inside the cell we are in. we take the first digit and
     * the second digit of the number and add them do the numbers of the cell in the array. for example: mat[0][0]= 21 -(jump)->  mat[1][2] or mat[2][1].
     * This method use use the recursive method- countPaths (int [][] mat, int row, int col).
     * @param mat the 2D array.
     * @return how many possible ways there are to go from the point (0,0) to last point (r,c) (r = number of rows, c = number of column).
     */
    public static int countPaths(int [][] mat)
    {
       return( countPaths(mat,0 ,0) );
    }
    
    //A recursive method that check the possible number of ways from (0,0) to the last point (r,c) (r = number of rows, c = number of column).
    private static int countPaths (int [][] mat, int row, int col)
    {
        int FirstDigit;
        int SecondDigit;
        if(row < mat.length && col < mat[row].length) //check that its not out of range.
        {
            FirstDigit = mat[row][col] / 10; //the fist digit of the number inside the cell.
            SecondDigit = mat[row][col] % 10; //the second digit of the number inside the cell.
        }
        else
            return(0); // if it is out of range dont count that possiblity in the final answer.
        
        if(row == mat.length -1 && col == mat[row].length -1) // if it get to the end of the array, add 1 possible way. 
            return(1);
        if(FirstDigit == 0 && SecondDigit == 0) // if the number inside the cell is 0, we are stuck, so there is no possible way here. 
            return(0);
 
        if(FirstDigit==SecondDigit) // if the FirstDigit = SecondDigit, there is only one possible way.
            return(countPaths(mat,row + FirstDigit,col + SecondDigit));
        else //try the two possible way
            return( countPaths(mat,row + FirstDigit,col + SecondDigit) + countPaths(mat,row + SecondDigit,col + FirstDigit) ); 

    }
    
}
