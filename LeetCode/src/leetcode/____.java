package leetcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.sql.rowset.CachedRowSet;

public class ____ {
	static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

	public static void main(String args[]) throws IOException, InterruptedException, ExecutionException {
		System.out.println(" Remove Duplicates from Sorted List II".replaceAll(" ", ""));
		System.out.println(Double.valueOf("3"));
	}

	public static class Test extends ReentrantLock implements Runnable {
		@Override
		public void run() {
			map.put(1, 1);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(map.get(1));
		}

	}

	public static class Test1 extends ReentrantLock implements Runnable {

		@Override
		public void run() {
			map.put(1, 2);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(map.get(1));
		}

	}
}

class Task implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("C线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }
}
class Task1 implements Runnable{

	@Override
	public void run() {
		System.out.println("R线程在进行计算");
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
	}
}