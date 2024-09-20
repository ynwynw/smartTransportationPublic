package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussjiaotonggonggaoEntity;
import com.entity.view.DiscussjiaotonggonggaoView;

import com.service.DiscussjiaotonggonggaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 交通公告评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
@RestController
@RequestMapping("/discussjiaotonggonggao")
public class DiscussjiaotonggonggaoController {
    @Autowired
    private DiscussjiaotonggonggaoService discussjiaotonggonggaoService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjiaotonggonggaoEntity discussjiaotonggonggao, 
		HttpServletRequest request){

        EntityWrapper<DiscussjiaotonggonggaoEntity> ew = new EntityWrapper<DiscussjiaotonggonggaoEntity>();


		PageUtils page = discussjiaotonggonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiaotonggonggao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjiaotonggonggaoEntity discussjiaotonggonggao, 
		HttpServletRequest request){
        EntityWrapper<DiscussjiaotonggonggaoEntity> ew = new EntityWrapper<DiscussjiaotonggonggaoEntity>();

		PageUtils page = discussjiaotonggonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiaotonggonggao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjiaotonggonggaoEntity discussjiaotonggonggao){
       	EntityWrapper<DiscussjiaotonggonggaoEntity> ew = new EntityWrapper<DiscussjiaotonggonggaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjiaotonggonggao, "discussjiaotonggonggao")); 
        return R.ok().put("data", discussjiaotonggonggaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjiaotonggonggaoEntity discussjiaotonggonggao){
        EntityWrapper< DiscussjiaotonggonggaoEntity> ew = new EntityWrapper< DiscussjiaotonggonggaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjiaotonggonggao, "discussjiaotonggonggao")); 
		DiscussjiaotonggonggaoView discussjiaotonggonggaoView =  discussjiaotonggonggaoService.selectView(ew);
		return R.ok("查询交通公告评论表成功").put("data", discussjiaotonggonggaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjiaotonggonggaoEntity discussjiaotonggonggao = discussjiaotonggonggaoService.selectById(id);
        return R.ok().put("data", discussjiaotonggonggao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjiaotonggonggaoEntity discussjiaotonggonggao = discussjiaotonggonggaoService.selectById(id);
        return R.ok().put("data", discussjiaotonggonggao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussjiaotonggonggaoEntity discussjiaotonggonggao, HttpServletRequest request){
    	discussjiaotonggonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjiaotonggonggao);

        discussjiaotonggonggaoService.insert(discussjiaotonggonggao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjiaotonggonggaoEntity discussjiaotonggonggao, HttpServletRequest request){
    	discussjiaotonggonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjiaotonggonggao);

        discussjiaotonggonggaoService.insert(discussjiaotonggonggao);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussjiaotonggonggaoEntity discussjiaotonggonggao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjiaotonggonggao);
        discussjiaotonggonggaoService.updateById(discussjiaotonggonggao);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussjiaotonggonggaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
