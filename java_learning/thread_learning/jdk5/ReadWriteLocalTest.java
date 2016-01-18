package jdk5;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocalTest {
	public static void main(String[] args) {
		ReadWriteLock rwlock=new ReentrantReadWriteLock();
		rwlock.readLock().lock();
		rwlock.writeLock().lock();
	}
}
