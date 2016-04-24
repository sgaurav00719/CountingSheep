/*
Problem

Bleatrix Trotter the sheep has devised a strategy that helps her fall asleep faster. First, she picks a number N. Then she starts naming N, 2 × N, 3 × N, and so on. Whenever she names a number, she thinks about all of the digits in that number. She keeps track of which digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) she has seen at least once so far as part of any number she has named. Once she has seen each of the ten digits at least once, she will fall asleep.

Bleatrix must start with N and must always name (i + 1) × N directly after i × N. For example, suppose that Bleatrix picks N = 1692. She would count as follows:

N = 1692. Now she has seen the digits 1, 2, 6, and 9.
2N = 3384. Now she has seen the digits 1, 2, 3, 4, 6, 8, and 9.
3N = 5076. Now she has seen all ten digits, and falls asleep.
What is the last number that she will name before falling asleep? If she will count forever, print INSOMNIA instead.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with a single integer N, the number Bleatrix has chosen.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the last number that Bleatrix will name before falling asleep, according to the rules described in the statement.

Limits

1 ≤ T ≤ 100.
Small dataset

0 ≤ N ≤ 200.
Large dataset

0 ≤ N ≤ 106. 
 
 */


package Problem1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;



public class CountingSheep {
	
	public static int sumOfArray ( int array[] ){
		int sum = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileReader("input.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.out"));
        int array[] = new int[10];
        int testCase = sc.nextInt();
        for ( int i = 0; i< testCase ; i++){
        	for ( int j = 0; j < 10; j++){
        		array[j] = 0;
        	}
        	int count = 1;
        	int N = sc.nextInt();
        	if ( N == 0){
        		pw.println("Case #"+(i+1)+": INSOMNIA");
        	}
        	else
        	{
        		while(true){
        			int number = count * N;
        			String numberAsString = Integer.toString(number);
        			for( int k = 0; k < numberAsString.length(); k++){
        				if ( array[ Character.getNumericValue(numberAsString.charAt(k))] == 0){
        					array[ Character.getNumericValue(numberAsString.charAt(k)) ] = 1;
        				}
        			}
        			int checkSum = sumOfArray(array);
        			if (checkSum == 10){
        				pw.println("case #"+ (i+1) +": "+ numberAsString);
        				break;
        			}
        			else
        			count++;
        		}
        	}
        }
        System.out.println("Done!!");
        pw.flush();
        pw.close();
        sc.close();
    }
	
}
