package com.zh.knowledge.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import com.zh.knowledge.vo.Pager;
import com.zh.knowledge.vo.TreeNodeVo;

@Repository
public class RedisService {

  private final RedisTemplate<String, String> redisTemplate;
  
  @Autowired
    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
  
  /**
	 * 
	 * @param key
	 * @param page  pageSize 默认15  curPage
	 */
	public Pager searchPage(String key,Pager page){
		ZSetOperations<String,String> op=redisTemplate.opsForZSet();
		long totalContentNum=op.zCard(key);
		page.setTotalContentNum(totalContentNum);
		
		int start=setPager(page);
		int end =start+page.getPageSize();
		Set<String> set=op.reverseRange(key, start, end);//JedisClusterUtil.listZaddValMax(key, start, end);
		page.setDatas(set);
		return page;
	}
	
	/**
	 * 计算每页的开始
	 * @param pageSize
	 * @param curPage
	 * @return
	 */
	private int setPager(Pager pages){
		Integer pageSize=pages.getPageSize();//每页显示数量
		Integer curPage=pages.getCurPage();//椰树
		if(pageSize==null||pageSize<=0) pageSize = 15;
		if(curPage==null||curPage<0) curPage = 0;
		int pageOffset =(curPage) * pageSize;//起始
		if(pageOffset<0) pageOffset = 0;
		
		long totalContentNum=pages.getTotalContentNum();
		long pageNum = (totalContentNum  +  pageSize  - 1) / pageSize;
		pages.setTotalPageNum(pageNum);
		
		pages.setCurPage(curPage);
		pages.setPageSize(pageSize);
		pages.setPageOffset(pageOffset);
		return pageOffset;
		
	}

	public String getKey(String key) {
	 ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
     return valueOps.get(key);
	}
	  
	  
}
