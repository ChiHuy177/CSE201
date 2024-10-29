package CSE201_Week5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class EITASKDIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyInputReader1 reader = new MyInputReader1(System.in);
		StringBuilder sb = new StringBuilder();

		int people = reader.nextInt();
		int workNeedToDo = reader.nextInt();
		
		int remainingWork = workNeedToDo;
		PriorityQueue<Integer> queueOfWork = new PriorityQueue<Integer>((s1, w2) -> {
			int compare = w2 - s1;
			if (compare == 0) {
				compare = -1;
			}
			return compare;
		});
		PriorityQueue<Worker> queueOfWorker = new PriorityQueue<Worker>((Worker w1, Worker w2) -> {
			int compare = w1.workNeedToDo - w2.workNeedToDo;
			if (compare == 0) {
				compare = w1.getStt() - w2.getStt();
			}
			
			return compare;
		});

		for (int i = 0; i < workNeedToDo; i++) {
			queueOfWork.add(reader.nextInt());
		}
		for (int i = 0; i < people; i++) {
//			System.out.println(queueOfWork.peek());
			int worked = queueOfWork.poll();
			queueOfWorker.add(new Worker(worked, i, worked));
			remainingWork--;
		}
		
		while (remainingWork-- > 0) {
			
			Worker worker = queueOfWorker.poll();
			int stt = worker.getStt();
		//	System.out.println(worker.getWorkNeedToDo());
			int worked = worker.getWorkNeedToDo() + queueOfWork.poll();
			queueOfWorker.add(new Worker(worked, stt, worked));
			
		}
		PriorityQueue<Worker> res = new PriorityQueue<Worker>((Worker w1, Worker w2)->{
			return w1.getStt() - w2.getStt();
		});
		for (int i = 0; i < people; i++) {
			res.add(queueOfWorker.poll());
		}
		while (res.size()>0) {
			
			sb.append(res.poll().getTotalWork()+" ");
		}
		System.out.println(sb);

		

		

	}

}

class Worker {
	int workNeedToDo;
	int stt;
	int totalWork;
	

	

	public Worker(int workNeedToDo, int stt, int totalWork) {
		super();
		this.workNeedToDo = workNeedToDo;
		this.stt = stt;
		this.totalWork = totalWork;
	}

	public int getWorkNeedToDo() {
		return workNeedToDo;
	}

	public void setWorkNeedToDo(int workNeedToDo) {
		this.workNeedToDo = workNeedToDo;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public int getTotalWork() {
		return totalWork;
	}

	public void setTotalWork(int totalWork) {
		this.totalWork = totalWork;
	}
	
	

}
 class MyInputReader1 {
	StringTokenizer tokenizer;
	BufferedReader reader;
	String token;
	String temp;

	public MyInputReader1(InputStream stream) {
		tokenizer = null;
		reader = new BufferedReader(new InputStreamReader(stream));
	}

	public MyInputReader1(FileInputStream stream) {
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
