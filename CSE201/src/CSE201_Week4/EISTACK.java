package CSE201_Week4;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EISTACK {
    public static void main(String[] args) {
        MyInputReader11 reader = new MyInputReader11(System.in);
        // MyInputReader reader = new MyInputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int n = reader.nextInt();
        int m = reader.nextInt();
        int testCase = reader.nextInt();
        MyArrayStack1<Integer> stack = new MyArrayStack1<Integer>(n);
        for (int i = 0; i < m; i++) {
            stack.push(reader.nextInt());
        }
        while (testCase-- > 0) {
            String command = reader.next();
            if (command.equalsIgnoreCase("peek")) {
                sb.append(stack.peek() + "\n");
            } else if (command.equalsIgnoreCase("sum")) {
                sb.append(stack.sum() + "\n");
            } else if (command.equalsIgnoreCase("average")) {
                sb.append(stack.average() + "\n");
            } else if (command.equalsIgnoreCase("pop")) {
                sb.append(stack.pop() + "\n");
            } else if (command.equals("push")) {
                int number = reader.nextInt();
                stack.push(number);
            }
        }
        System.out.println(sb);
    }
}

class MyArrayStack1<T extends Number> {
    int firstOccur = 0;
    int willOccur = 0;
    long sum = 0;
    Object[] data;
    
    int count = 0;

    public MyArrayStack1(int capacity) {
        data = new Object[capacity];
    }

    public int count() {

        return count;
    }

    public double sum() {

        return sum;
    }

    public double average() {
        if (sum == 0) {
            return 0;
        }
        return sum * 1.0 / count();
    }

    /**
     * @description: When stack is full => override the earliest added item
     */
    public void push(T item) {
       if (count == 0) {
    	   data[0] = item;
    	   sum += (int)item;
    	   count++;
    	   willOccur++;
    	   
       }
       else if (count!=0 && count != data.length ) {
    	   if (willOccur == data.length) {
    		   willOccur = 0;
    	   }
    	   data[willOccur] = item;
    	   sum += (int)item;
    	   count++;
    	   willOccur++;
    	   
       }
       else if (count == data.length) {
    	   sum -= (int) data[firstOccur];
    	   willOccur = firstOccur;
    	   firstOccur++;
    	   if (firstOccur == data.length) {
    		   firstOccur = 0;
    	   }
    	   data[willOccur] = item;
    	   sum += (int)item;
    	   
    	   willOccur++;
    	   
    	   
    	   
       }
    }

    /**
     * @return: return and remove top item, or null when stack is empty
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (count == 0) {
        	return null;
        }
        else {
        	T result;
        	int itemIndex = willOccur - 1;
        	if (itemIndex > -1) {
        		willOccur--;
        		result = (T)data[itemIndex];
        		sum -= (int)result;
        		count --;
        		return result;
        	}
        	else {
        		willOccur = data.length - 1;
        		result = (T) data[willOccur];
        		sum -= (int) result;
        		count--;
        		return result;
        	}
        }
    	
  

    }

    /**
     * @return: return top item, or null when stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (count == 0) {
            return null;
        } else {
        	T result;
        	int itemIndex = willOccur - 1;
        	if (itemIndex < 0) {
        		result = (T) data[data.length-1];
        	} else {
        		result = (T) data[itemIndex];
        	}
            

            return result;
        }
    }
}

class MyInputReader11 {
    StringTokenizer tokenizer;
    BufferedReader reader;
    String token;
    String temp;

    public MyInputReader11(InputStream stream) {
        tokenizer = null;
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public MyInputReader11(FileInputStream stream) {
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