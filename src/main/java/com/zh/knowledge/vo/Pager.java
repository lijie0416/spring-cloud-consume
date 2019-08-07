package com.zh.knowledge.vo;

import java.util.List;

/**
 * 分页对象
 * @author Administrator
 *
 * @param <T>
 */
public class Pager {
	/**
	 * 分页的大小
	 */
	private int pageSize=10;
	private long totalContentNum;
	/**
	 * 分页的起始页
	 */
	private int curPage;
	/**
	 * 总记录数
	 */
	private long totalPageNum;
	/**
	 * 分页的数据
	 */
	private Object datas;
	
	private int pageOffset;
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public long getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(long totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	
	
	public Object getDatas() {
		return datas;
	}
	public void setDatas(Object datas) {
		this.datas = datas;
	}
	public long getTotalContentNum() {
		return totalContentNum;
	}
	public void setTotalContentNum(long totalContentNum) {
		this.totalContentNum = totalContentNum;
	}
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	
}

