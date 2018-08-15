package win.yellowpal.springboot.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

@Configuration
public class MemcacheConfig {
	
	@Autowired
	SockIOPoolConfig sockIOPoolConfig;
	
	@Bean
	public SockIOPool initSockIOPool(){
		SockIOPool sockIOPool = SockIOPool.getInstance("mcctest");
        //服务器列表及其权重
        String[] servers = sockIOPoolConfig.getServers();
        Integer[] weights = sockIOPoolConfig.getWeights();
        //设置服务器信息
        sockIOPool.setServers(servers);
        sockIOPool.setWeights(weights);
        //设置初始连接数、最小连接数、最大连接数、最大处理时间
        sockIOPool.setInitConn(sockIOPoolConfig.getInitConn());
        sockIOPool.setMinConn(sockIOPoolConfig.getMinConn());
        sockIOPool.setMaxConn(sockIOPoolConfig.getMaxConn());
        //设置连接池守护线程的睡眠时间
        sockIOPool.setMaintSleep(sockIOPoolConfig.getMaintSleep());
        //设置TCP参数，连接超时
        sockIOPool.setNagle(sockIOPoolConfig.isNagle());
        sockIOPool.setSocketConnectTO(sockIOPoolConfig.getSocketTO());
        //初始化并启动连接池
        sockIOPool.initialize();
		return sockIOPool;
	}
	
    @Bean
    public MemCachedClient memCachedClient(){
    	MemCachedClient mcc = new MemCachedClient("mcctest");
    	mcc.setPrimitiveAsString(true);
        return mcc;
    }
}
