package lab_1;

import java.util.Scanner;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n; // shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	public char encryptChar(char c) {
		char resultChar = c;
		// Trường hợp nếu người dùng cho vào c là chữ thường -> chuyển thành chữ hoa
		if (c >= 'a' && c <= 'z') {
			c -= 32;
		}

		// Trường hợp kí tự này không thuộc ALPHABET
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c != ALPHABET[i]) {
				resultChar = c;
			}
		}

		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				resultChar = ALPHABET[(i + n) % 26];
			}
		}
		return resultChar;
	}

	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		StringBuilder encryptedText = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char eachChar = encryptChar(input.charAt(i));
			encryptedText.append(eachChar);
		}
		return encryptedText.toString();
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char decryptChar(char c) {
		char resultChar = c;

		// Trường hợp nếu người dùng cho vào c là chữ thường -> chuyển thành chữ hoa
		if (c >= 'a' && c <= 'z') {
			c -= 32;
		}

		// Trường hợp kí tự này không thuộc ALPHABET
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c != ALPHABET[i]) {
				resultChar = c;
			}
		}

		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				resultChar = ALPHABET[(i + 26 - n) % 26];
			}
		}
		return resultChar;
	}

	// Decrypt a encrypted text using the above function for decrypting a charater.
	public String decrypt(String input) {
		StringBuilder decryptedText = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char eachChar = decryptChar(input.charAt(i));
			decryptedText.append(eachChar);
		}
		return decryptedText.toString();
	}

	// Task3
	// Expanding the problem in Task 3 so that the program can encrypt
	// and decrypt a given text including numbers and characters
	// Theo bảng mã ASCll

	// encrypt
	public String encryptTask3(String input) {
		StringBuilder encryptedText = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				encryptedText.append((char) (input.charAt(i) + n));
			} else {
				encryptedText.append(encryptChar(input.charAt(i)));
			}
		}

		return encryptedText.toString();
	}

	// decrypt
	public String decryptTask3(String input) {
		StringBuilder decryptedText = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				decryptedText.append((char) (input.charAt(i) - n));
			} else {
				decryptedText.append(decryptChar(input.charAt(i)));
			}
		}

		return decryptedText.toString();
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào số bước nhảy: ");
		int buocNhay = input.nextInt();

		MyCaesar myCaesar = new MyCaesar(buocNhay);
		System.out.println(myCaesar.encryptChar('A'));
		System.out.println(myCaesar.encryptChar('Z'));
		System.out.println(myCaesar.encryptChar('K'));
		System.out.println(myCaesar.encryptChar('y'));

		String str1 = "Encrypt in Java!";
		String str2 = "   My name is Java ";
		String resultStr1 = myCaesar.encrypt(str1);
		String resultStr2 = myCaesar.encrypt(str2);
		System.out.println(resultStr1);
		System.out.println(resultStr2);

		System.out.println(myCaesar.decryptChar('A'));
		System.out.println(myCaesar.decryptChar('Z'));
		System.out.println(myCaesar.decryptChar('K'));
		System.out.println(myCaesar.decryptChar('y'));

		System.out.println(myCaesar.decrypt(resultStr1));
		System.out.println(myCaesar.decrypt(resultStr2));

		// TestCase of Test3
		// Encrypt text including numbers and characters
		String str3 = "Encrypt Expanding with number12345";
		String str4 = "My name is CTDL_2024";
		String resultStr3 = myCaesar.encryptTask3(str3);
		String resultStr4 = myCaesar.encryptTask3(str4);
		System.out.println(resultStr3);
		System.out.println(resultStr4);

		// TestCase of Test3
		// Decrypt and text including numbers and characters
		System.out.println(myCaesar.decryptTask3(resultStr3));
		System.out.println(myCaesar.decryptTask3(resultStr4));
		
	}
}
