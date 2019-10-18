package lab8;

import java.io.*;
import java.util.*;

//Queens are represented by 1 and empty space is 0s

public class NQueen {


	public static void main(String args[]){
		
		int nqueen = 4;
		int arr[][] = new int[nqueen][nqueen];

		//initialize board
		for(int i = 0; i < nqueen; i++){
			for(int j =0; j < nqueen; j++){
				arr[i][j] = 0;
			}
		}

		placeOnBoard(arr, 0, 0, nqueen);
		
		return;
	}

	
	// create a printable verison of board with 0s and 1s
	public static void printBoard(int nqueen, int arr[][]){
		
		for(int i = 0; i < nqueen; i++){
			
			for(int j = 0; j < nqueen; j++){
				
				System.out.print(arr[i][j]+" ");
			}
			
			System.out.println();
		}
		
		System.out.println("--------------------");
		
	}

	// make sure printBoard is correct and able to print correctly
	public static boolean placeOnBoard(int arr[][], int row, int col, int nqueen){
		
		if(row >= nqueen){
			
			printBoard(nqueen, arr);
			
			return true;
			
		}

		boolean res = false; 

		for(int i = col; i < nqueen; i++){
			
			if(isPos(arr, row, i, nqueen)){
				
				arr[row][i] = 1;
				
				res = placeOnBoard(arr, row+1, 0, nqueen)|| res;
				
				arr[row][i] = 0;
			
			}
		}
		
		return res;
	
	}

	public static boolean isPos(int arr[][], int row, int col, int nqueen){

		// check if rows has a queen already inside 
		for(int i = 0; i < nqueen; i++){
			
			if(arr[row][i] == 1) 
				return false;
			
		}

		// check if columns has a queen already inside 
		for(int i = 0; i < nqueen; i++){
			
			if(arr[i][col] == 1)
				return false;
			
		}

		// check if Q are in a diagonal 
		for(int i = 0; i < nqueen; i++){
			
			if((row + i) < nqueen && (col + i) < nqueen && arr[row + i][col + i] == 1)
				return false;
		
			else if((row + i)<nqueen && (col - i)>=0 && arr[row + i][col - i]==1)
				return false;
	
			else if((row - i) >= 0 && (col + i) < nqueen && arr[row - i][col + i] == 1)
				return false;
			
			else if((row - i) >= 0 && (col - i) >= 0 && arr[row - i][col - i] == 1)
				return false;
			
		}

		return true;
	}
}