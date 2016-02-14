package com.vinod.test;

public class BinaryLiterals {
	public static void main(String[] args) {
		System.out.println("Before java 7" + Integer.parseInt("101010", 2));
		int binary = 0b101010;
		System.out.println("In java 7" + binary);
	}
}
