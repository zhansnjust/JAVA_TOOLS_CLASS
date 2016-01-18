package jdk5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//模拟缓存。 延迟
public class CacheDemo {
	private Map<String, Object> cache = new HashMap<>();
	private ReadWriteLock lock = new ReentrantReadWriteLock();

	public Object getData(String key) {
		Object o = null;
		lock.readLock().lock();
		try {
			o = cache.get(key);
			if (o == null) {
				lock.readLock().unlock();
				//写之前上写锁
				lock.writeLock().lock();
				try {
					if(o==null)
						o = "aaaa";// 此处可以在数据库中搜索（query)得到的、 在实际系统中
				} finally {
					lock.writeLock().unlock();
				}
				lock.readLock().unlock();
			}
		} finally {
			lock.readLock().unlock();
		}

		return o;
	}
}
