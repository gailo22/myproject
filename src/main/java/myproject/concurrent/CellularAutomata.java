package myproject.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CellularAutomata {
	private final Board mainBoard;
	private final CyclicBarrier barrier;
	private final Worker[] workers;

	public CellularAutomata(Board board) {
		this.mainBoard = board;
		int count = Runtime.getRuntime().availableProcessors();
		this.barrier = new CyclicBarrier(count, new Runnable() {
			@Override
			public void run() {
				mainBoard.commitNewValues();
			}
		});
		
		this.workers = new Worker[count];
		for (int i = 0; i < count; i++) {
			workers[i] = new Worker(mainBoard.getSubBoard(count, i));
		}
	}
	
	static class Board {

		public boolean hasConverged() {
			// TODO Auto-generated method stub
			return false;
		}

		public Board getSubBoard(int count, int i) {
			// TODO Auto-generated method stub
			return null;
		}

		public void commitNewValues() {
			// TODO Auto-generated method stub
		}

		public int getMaxX() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getMaxY() {
			// TODO Auto-generated method stub
			return 0;
		}

		public void setNewValue(int x, int y, Object computeValue) {
			// TODO Auto-generated method stub
		}

		public void waitForConvergence() {
			// TODO Auto-generated method stub
		}}
	
	private class Worker implements Runnable {
		private final Board board;
		
		public Worker(Board board) { this.board = board; }
		
		@Override
		public void run() {
			while (!board.hasConverged()) {
				for (int x = 0; x < board.getMaxX(); x++) {
					for (int y = 0; y < board.getMaxY(); y++) {
						board.setNewValue(x, y, computeValue(x, y));
					}
				}
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException ex) {
					return;
				}
			}
		}

		private Object computeValue(int x, int y) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public void start() {
		for (int i = 0; i < workers.length; i++) {
			new Thread(workers[i]).start();
		}
		
		mainBoard.waitForConvergence();
	}
}
