package lab_1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray {
	private int[] array;

	/**
	 * @param array
	 */
	public MyArray(int[] array) {
		this.array = array;
	}

	// Method mirror that outputs the contents of an array in a
	// reverse order like a mirror
	// Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		int[] resultArray = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			resultArray[i] = array[i];
		}
		for (int i = 0; i < array.length; i++) {
			resultArray[resultArray.length - 1 - i] = array[i];
		}
		return resultArray;

	}

	// removes all duplicate elements from an array and returns a
	// new array
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8
	public int[] removeDuplicates() {
		Arrays.sort(array);

		ArrayList<Integer> listArr = new ArrayList<>();
		listArr.add(array[0]);
		for (int i = 1; i < array.length; i++) {
			if (array[i] != array[i - 1]) {
				listArr.add(array[i]);
			}
		}

		int[] resultArr = arrayListToArray(listArr);
		return resultArr;
	}

	public int[] arrayListToArray(ArrayList<Integer> arrList) {
		int[] array = new int[arrList.size()];

		for (int i = 0; i < arrList.size(); i++) {
			array[i] = arrList.get(i);
		}

		return array;

	}

	// Input: 10 11 12 13 14 16 17 19 20
	// Output: 15 18
	public int[] getMissingValues() {
		ArrayList<Integer> arrList = new ArrayList<>();
		for (int i = 0; i < array.length - 1; i++) {
			int before = array[i];
			int after = array[i + 1];
			if (after - before > 1) {
				for (int j = before + 1; j < after; j++) {
					arrList.add(j);
				}
			}
		}

		return arrayListToArray(arrList);
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		MyArray myArr = new MyArray(arr1);
		System.out.println(Arrays.toString(myArr.mirror()));

		int[] arr2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		int[] arr3 = { 2, 4, 5, 1, 2, 2, 4, 5, 8, 9, 10, 5 };
		myArr = new MyArray(arr2);
		System.out.println(Arrays.toString(myArr.removeDuplicates()));
		myArr = new MyArray(arr3);
		System.out.println(Arrays.toString(myArr.removeDuplicates()));

		int[] arr4 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		myArr = new MyArray(arr4);
		System.out.println(Arrays.toString(myArr.getMissingValues()));
	}

}
