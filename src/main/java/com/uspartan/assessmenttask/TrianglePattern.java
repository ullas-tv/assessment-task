package com.uspartan.assessmenttask;

import java.util.Scanner;

public class TrianglePattern {

    public static void main(String[] args) {
        
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Please enter the triangle size to be displayed");
    	int rows = sc.nextInt();
    	int k = 0;

        for(int i = 1; i <= rows; ++i, k = 0) {
            for(int space = 1; space <= rows - i; ++space) {
                System.out.print("  ");
            }

            while(k != 2 * i - 1) {
                System.out.print("* ");
                ++k;
            }

            System.out.println();
        }
    }
}