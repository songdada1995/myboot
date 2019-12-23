package com.spbt;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

	int size;// 阻塞队列最大容量

	ReentrantLock lock = new ReentrantLock();

	LinkedList<E> list = new LinkedList<>();// 队列底层实现

	Condition addE = lock.newCondition();// 队列满时的等待条件
	Condition delE = lock.newCondition();// 队列空时的等待条件

	public MyBlockingQueue(int size) {
		this.size = size;
	}

	public void enqueue(E e) throws InterruptedException {
		lock.lock();
		try {
			while (list.size() == size) {
				addE.await();// 队列已满,入队等待，直到队列不满
			}
			list.add(e);// 入队:加入链表末尾
			System.out.println("入队：" + e);
			delE.signal(); // 通知出队线程
		} finally {
			lock.unlock();
		}
	}

	public E dequeue() throws InterruptedException {
		E e;
		lock.lock();
		try {
			while (list.size() == 0) {
				delE.await();// 队列为空,出队等待，直到队列不为空
			}
			e = list.removeFirst();// 出队:移除链表首元素
			System.out.println("出队：" + e);
			addE.signal();// 通知入队线程
			return e;
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 测试
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(2);
		for (int i = 1; i <= 10; i++) {
			int data = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						queue.enqueue(data);// 入队
					} catch (InterruptedException e) {

					}
				}
			}).start();

		}
		for (int i = 1; i <= 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Integer data = queue.dequeue();// 出队
						System.out.println("出队消息..." + data);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}

	}

}
