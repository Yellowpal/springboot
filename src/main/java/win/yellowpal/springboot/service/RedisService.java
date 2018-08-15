package win.yellowpal.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService<K,V> {
	
	
	@Autowired
	private RedisTemplate<K, V> redisTemplate;
	
	
	private BoundValueOperations<K,V> getBoundValueOps(K key) {
        return redisTemplate.boundValueOps(key);
    }
	
	public void setIncr(final K key,final V value) {
        BoundValueOperations<K,V> ops  = this.getBoundValueOps(key);
        ops.set(value);
    }
	
	public Long incr(final K key,final long delta) {
        BoundValueOperations<K,V> ops  = this.getBoundValueOps(key);
        return ops.increment(delta);
    }
	
	public Long decr(final K key,final long delta) {
        return incr(key,-delta);
    }
}
