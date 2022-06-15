package com.thinkschool.rnd.guessthenumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessNumber {

	private static List<Integer> numList = new ArrayList<>();
	private static Scanner sc= new Scanner(System.in);
	private static String responce;
	static int count=0;
	
	public static void main(String[] args) {
		System.out.println("Guess any number between 0 to 100, We will guess it within 8 yes/no questions...");
		System.out.println("Let the fun g=beggins");
		for(int i=0;i<=100;i++) {
			numList.add(i);
		}
		System.out.println(numList);


		divideNConcor();

		numList=isNumberEven();


		System.err.println("Your number is   === "+numList.get(0));
	}

	public static void divideNConcor() {

		int mid=numList.size()/2;


		if(numList.size()==2) { return; }
		if(numList.size()==1) {System.err.println("Your number is   === "+numList.get(0));  System.exit(1);}
		count++;

		System.out.println("Question No."+count+":  Is your number bigger than "+numList.get(mid)+"...?");

		responce=sc.nextLine();
		if(responce.toUpperCase().contains("y".toUpperCase())) {
			numList.subList(0, (mid+1)).clear();
			divideNConcor();
		}else {
			numList.subList(mid+1, numList.size()).clear();
			divideNConcor();
		}
	}

	public static List<Integer> isNumberEven(){
		count++;
		System.out.println("Question No."+count+":  Is your number even......?");

		responce=sc.nextLine();
		if(responce.toUpperCase().contains("y".toUpperCase())) {
			numList.removeIf(i -> i%2!=0);
			
			return numList;
		}
		numList.removeIf(i -> i%2 ==0);
		
		return numList;
	}

}
