import java.io.*;
import java.util.*;
public class diamond {
	public static void main(String[] args) throws IOException {


		int k = 4;
		int[] list = new int[]{ 1, 2, 3, 4, 5, 6};
    int n = list.length;

		Arrays.sort(list);
		// leftmostIndex[i] stores the index of the smallest diamond that can be included given that
		// the largest diamond in the case has size list[i].
		int[] leftmostIndex = getLeftmost(list, k);
		// leftSize[i] stores the maximum number of diamonds given that all diamonds have size at most list[i].
		int[] leftSize = new int[n];
		for(int i = 0; i < n; i++) {
			leftSize[i] = i - leftmostIndex[i] + 1;

			if(i > 0) {
				leftSize[i] = Math.max(leftSize[i], leftSize[i-1]);
			}
		}
		// rightmostIndex[i] stores the index of the smallest diamond that can be included given that
		// the smallest diamond in the case has size list[i].
		int[] rightmostIndex = getRightmost(list, k);
		// leftSize[i] stores the maximum number of diamonds given that all diamonds have size at least list[i].
		int[] rightSize = new int[n];
		for(int i = n-1; i >= 0; i--) {
			rightSize[i] = rightmostIndex[i] - i + 1;

			if(i < n-1) {
				rightSize[i] = Math.max(rightSize[i], rightSize[i+1]);
			}

		}
		int ret = 0;
		for(int i = 0; i < n-1; i++) {
      System.out.println(leftSize[i] + ", " + rightSize[i+1]);
			ret = Math.max(ret, leftSize[i] + rightSize[i+1]);
		}

	}

	public static int[] getRightmost(int[] list, int k) {
		int[] ret = new int[list.length];
		int j = list.length-1;
		for(int i = list.length-1; i >= 0; i--) {
			while(j >= 0 && list[j] - list[i] > k) {
				j--;
			}
			ret[i] = j;

		}
		return ret;

	}

	public static int[] getLeftmost(int[] list, int k) {
		int[] ret = new int[list.length];
		int j = 0;
		for(int i = 0; i < list.length; i++) {
			while(j < list.length && list[i] - list[j] > k) {
				j++;


			}

			ret[i] = j;

		}
		return ret;
	}

}
