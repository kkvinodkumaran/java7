package com.vinod.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * This class helps to understand the feature of ForkJoinPool and ForkJoinTasks
 *
 * 1) ForkJoinTask is an abstract class ,RecursiveAction and RecursiveTasks are
 * the subclasses of ForkJoinTask class
 *
 * 2) In case of return type required we need to use RecursiveTask
 *
 * 3) In this example we used RecursiveAction and override its call() method to
 * implement fork and join
 *
 * 4) This is an example to print 1 to the given number
 *
 * 5) The given number is less then 100 it will not split the task (fork)
 *
 * 6) If the given number is 100 or greater than 100 it will split it in to two
 * task (1 to 50 and 51 to 100) 7) Finally join each task
 *
 * @authorvinod
 */

public class ForkAndJoinExample {
	public static void main(String[] args) {
		ForkJoinPool fjpool = new ForkJoinPool(2);
		RecursiveAction task = new PrintJob(100);
		fjpool.invoke(task);
	}
}

class PrintJob extends RecursiveAction {
	private static final long serialVersionUID = 1L;
	private int lines = 0;

	public PrintJob(int lines) {
		this.lines = lines;
	}

	@Override
	protected void compute() {
		if (lines < 100) {
			print(1, lines, "single task");
		} else {
			PrintJob p1 = new PrintJob(lines);
			p1.print(1, lines / 2, "task 1");
			PrintJob p2 = new PrintJob(lines);
			p2.print(lines / 2, lines, "task 2");
			p1.fork();
			p2.fork();
			p1.join();
			p2.join();
		}
	}

	private void print(int start, int end, String taskname) {
		for (int i = start; i <= end; i++) {
			System.out.println("print job triggerd from " + taskname + " " + i);
		}
	}
}