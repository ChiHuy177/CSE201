package CSE201_Week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIUEMSEM {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int testCase = reader.nextInt();

        while (testCase-- > 0) {
            ArrayList<Robot> mapOfRobot = new ArrayList<Robot>();
            long robot = reader.nextLong();
            double budget = reader.nextDouble();
            long min = Long.MAX_VALUE;

            while (robot-- > 0) {

                long productPerHour = reader.nextLong();
                if (productPerHour < min) {
                    min = productPerHour;
                }
                long needToInvest = reader.nextLong();

                mapOfRobot.add(new Robot(productPerHour, needToInvest));
            }

            if (budget == 0) {
                sb.append(min + "\n");
            } else {

                sb.append(binarySearch(mapOfRobot, 0, (long) 1e12, budget) + "\n");
            }

        }
        System.out.println(sb);

    }

    public static long binarySearch(ArrayList<Robot> mapOfRobot, long left, long right, double budget) {

        while (right - left > 1) {
            long middle = ((left + right) / 2);
            double cost = caculateProfit(mapOfRobot, middle);

            if (Double.compare(cost, budget) < 0) {
                left = middle;

            } else if (Double.compare(cost, budget) > 0) {
                right = middle;
            } else {
                return middle;
            }
        }

        return left;

    }

    public static double caculateProfit(ArrayList<Robot> mapOfRobot , long rate) {
        double costThatNeedToInvest = 0;

        for (Robot found : mapOfRobot) {
            if (found.productPerHour < rate) {
                costThatNeedToInvest += ((rate - found.productPerHour) * 1.0 * found.needToInvest);
            }
        }

        return costThatNeedToInvest;
    }

    static class Robot {
        long productPerHour = 0;
        long needToInvest = 0;

        public Robot(long productPerHour, long needToInvest) {
            this.productPerHour = productPerHour;
            this.needToInvest = needToInvest;
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
