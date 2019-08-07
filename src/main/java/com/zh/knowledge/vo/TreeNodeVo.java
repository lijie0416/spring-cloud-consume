package com.zh.knowledge.vo;

import java.io.Serializable;
import java.util.List;


public class TreeNodeVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name="";				//显示名称
	private String code="";				//编码
	private String actUrl="";			//点击动作url, null表示不活动节点。
	private String status="1";			//节点状态，1:编辑，2：完成
	private boolean haveSon=false;		//是否还有子节点
	private int securityLevel;          //节点安全级别，0：公开，1：秘密，2：机密, ...。
	private String iconName="";			//图标文件名称
	private String id;					//节点的id
	private String dn;					//节点的dn
	private int pos;					//节点兄弟之间的位置
	private String title;
	private List<TreeNodeVo> sonList = null; //包含的子节点，null表示需要再加载。
	//pojo
	public String getActUrl() {
		return actUrl;
	}
	public void setActUrl(String actUrl) {
		this.actUrl = actUrl;
	}
	public boolean isHaveSon() {
		return haveSon;
	}
	public void setHaveSon(boolean haveSon) {
		this.haveSon = haveSon;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TreeNodeVo> getSonList() {
		return sonList;
	}
	public void setSonList(List<TreeNodeVo> sonList) {
		this.sonList = sonList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
