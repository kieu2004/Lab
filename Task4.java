package lab_1;

import java.util.Scanner;

//Expanding the problem in Task 4 so that the program can encrypt 
//and decrypt a given text including numbers and characters where the text is entered from 
//console by users.

public class Task4 {
	public static void main(String[] args) {
		Scanner inputString = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào số bước nhảy: ");
		int buocNhay = inputString.nextInt();

        MyCaesar myCaesar= new MyCaesar(buocNhay);
        // Encrypt text including numbers and characters where the text is entered from console by users.
		Scanner inputString1 = new Scanner(System.in);
		System.out.print("Mời bạn nhập vào chuỗi cần mã hóa: ");
        String strEncrypt = inputString1.nextLine();
        System.out.println("Chuỗi sau khi mã hóa như sau:");
        System.out.println(myCaesar.encryptTask3(strEncrypt));

        // Create a new Scanner for the next input
        Scanner inputString2 = new Scanner(System.in);
        // Decrypt text including numbers and characters where the text is entered from console by users.
        System.out.print("Mời bạn nhập vào chuỗi cần giải mã: ");
        String strDecrypt = inputString2.nextLine();
        System.out.println("Chuỗi sau khi giải mã như sau:");
        System.out.println(myCaesar.encryptTask3(strDecrypt));

    }

}





		

