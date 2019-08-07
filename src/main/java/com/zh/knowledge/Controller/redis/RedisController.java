package com.zh.knowledge.Controller.redis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zh.knowledge.pojo.User;
import com.zh.knowledge.pojo.UserAttr;
import com.zh.knowledge.service.RedisService;
import com.zh.knowledge.service.UserService;
import com.zh.knowledge.vo.Pager;

@RestController
public class RedisController {

	@Autowired
	private RedisService redisService;
	
	@Autowired
	private UserService userService;
	@Autowired
    private RestTemplate restTemplate;
	private static final String PREFIX = "http://INTEGRAL";  // 微服务名字


	
	@RequestMapping("/listPersonPageCloud")
	@ResponseBody
	public String listPersonPageCloud(Integer pageNum,Integer pageSize){
		  return restTemplate.getForEntity(PREFIX + "/listPersonPageCloud",String.class).getBody();

	}
	
	
	@RequestMapping("/subjectContent")
	@ResponseBody
	public Pager getsubjectContent(String key,Pager page){
		Pager pager=redisService.searchPage(key, page);
		return pager;
	}
	
	@RequestMapping("/subjectTree")
	@ResponseBody
	public String getHsubjectTree(String key){
		String vo=redisService.getKey(key);
		return vo;
	}
	
	@RequestMapping("/listPerson")
	@ResponseBody
	public List<User> listPerson(String key){
		List<User> list=userService.getAll();
		return list;
	}
	
	@RequestMapping("/listPersonPage")
	@ResponseBody
	public PageInfo<User> listPersonPage(Integer pageNum,Integer pageSize){
		Page<User> user = PageHelper.startPage(pageNum, pageSize);
		List<User> list=userService.getAll();
		PageInfo<User> pagelist = new PageInfo<>(list);
		return pagelist;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(HttpServletRequest request, HttpServletResponse response,User user,UserAttr userAttr){
		//userService.insert();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String province  = 	request.getParameter("province");
		String city = request.getParameter("city");
		String county = request.getParameter("county");
		 Map<String,String> paramMap= new HashMap<String, String>();
		 paramMap.put("createTime",df.format(new Date()));
		 paramMap.put("userProvince", province+city+county);
		 userService.insertUser(user,userAttr,paramMap);
		 return "233";
	}
	
	@RequestMapping("/index")
	public String index(Map<String,Object> map){
		map.put("name", "Andy");
		return "index";
	}
}
