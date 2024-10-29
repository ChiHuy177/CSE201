package FINAl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import FINAl.MERGESORT.InputReader;

public class QUICKSORT {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();

        int n = reader.nextInt();
        int[] arr = new int[n];
        arr[0] = reader.nextInt();
        for (int i = 1; i < n; i++) {
            arr[i] = reader.nextInt();

        }

        quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + "\n");
        }

        System.out.println(sb);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right){
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }


    private static int partition(int[]arr, int left, int right){
        if (isAllElementsSame(arr, left, right)){
            return (left + right)/2;
        }
        int pivot = median(arr, left, right);
        int tempIndex = pivot + 1;
        for(int i = tempIndex; i <= right; i++){
            if (arr[i] < arr[pivot]){
                swap(arr, i, tempIndex++);
            }
        }
        swap(arr, tempIndex - 1, pivot);

        
        return tempIndex - 1;
    }

    private static int median(int[]arr, int left, int right){
        int mid  = (left + right) / 2;
        if (arr[left] > arr[mid]){
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]){
            swap(arr, left, right);
        }
        if (arr[mid] > arr[right]){
            swap(arr, right, mid);
        }
        swap(arr, left, mid);

        return left;
    }
    private static void swap(int[] arr, int index1, int index2){
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    private static boolean isAllElementsSame(int[]arr, int left, int right){
        for (int i = left + 1; i <= right; i++){
            if (arr[i] != arr[i-1]){
                return false;
            }
        }
        return true;
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
