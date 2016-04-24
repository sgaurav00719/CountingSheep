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
        Scanner sc = new Scanner(new FileReader("/Users/iNviNciBLe/Desktop/A-large.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("/Users/iNviNciBLe/Desktop/outputAlarge"));
        int array[] = new int[10];
        int testCase = sc.nextInt();
        for ( int i = 0; i< testCase ; i++){
        	for ( int j = 0; j < 10; j++){
        		array[j] = 0;
        	}
        	int count = 1;
        	int N = sc.nextInt();
        	if ( N == 0){
        		System.out.println("Case #"+(i+1)+": INSOMNIA");
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
        				System.out.println("case #"+ (i+1) +": "+ numberAsString);
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
