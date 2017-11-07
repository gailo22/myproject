package myproject.java8.async;

import java.util.Stack;
import java.util.concurrent.ForkJoinPool;

import myproject.java8.async.BaseTask.FinishTask;

public final class Runtime {
	
	private Runtime() {}
	
	private static final ThreadLocal<Stack<BaseTask>> threadLocalTaskStack = 
			ThreadLocal.withInitial(Stack::new);
	
	private static ForkJoinPool taskPool = new ForkJoinPool();
	
	public static BaseTask currentTask() {
		Stack<BaseTask> taskStack = Runtime.threadLocalTaskStack.get();
		if (taskStack.isEmpty()) {
			return null;
		} else {
			return taskStack.peek();
		}
	}

	public static void submitTask(BaseTask newTask) {
		taskPool.execute(newTask);
	}

	public static void pushTask(BaseTask task) {
		Runtime.threadLocalTaskStack.get().push(task);
	}
	
	public static void popTask() {
		Runtime.threadLocalTaskStack.get().pop();
	}

}
