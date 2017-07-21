package com.learn.microservices;

public class TestProgram {
	public static void main(String[] args) {
		System.out.println("Hello !");
		isPalindrome("MADAM");
	}
	
	public static void isPalindrome(String originalString) {
		String reverseString = new StringBuffer(originalString).reverse().toString();
		if(originalString.equalsIgnoreCase(reverseString)) {
			System.out.println("Entered String "+originalString+ " is Palindrome and the string is "+reverseString);
		} else {
			System.out.println("Entered String "+originalString+ " is not Palindrome and the string is "+reverseString);
		}
	}
}
