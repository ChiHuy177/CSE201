package FINAl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MERGESORT {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int n = reader.nextInt();
        int[] arr = new int[n];
        int[] res = new int[n];
        for (int  i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}		
		mergeSort(arr, 0, arr.length - 1, res);
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
    }

    private static void mergeSort(int[] arr, int startIndex, int endIndex, int[] res) {
        if (startIndex >= endIndex){
            return;
        } 
        int mid = (startIndex + endIndex) / 2;
        mergeSort(arr, startIndex, mid, res);
        mergeSort(arr, mid + 1, endIndex, res);
        merge(arr, startIndex, mid, endIndex, res);
    }

    private static void merge(int[] arr, int startIndex, int mid, int endIndex, int[] res) {
        int pointer1 = startIndex;
        int pointer2 = mid + 1;
        int n = endIndex - startIndex + 1;
        int i = 0;
        for (i = 0; i < n; i++){
            if (pointer1 > mid || pointer2 > endIndex){
                break;
            } else {
                if (arr[pointer1] < arr[pointer2]){
                    res[i] = arr[pointer1++];
                } else {
                    res[i] = arr[pointer2++];
                }
            }
        }

        while (pointer1 <= mid) {
            res[i++] = arr[pointer1++];
        }
        while(pointer2 <= endIndex){
            res[i++] = arr[pointer2++];
        }

        for (i = 0; i < n; i++){
            arr[startIndex++] = res[i];
        }
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
