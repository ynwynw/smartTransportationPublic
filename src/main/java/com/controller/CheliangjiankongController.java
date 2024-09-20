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

import com.entity.CheliangjiankongEntity;
import com.entity.view.CheliangjiankongView;

import com.service.CheliangjiankongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 车辆监控
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
@RestController
@RequestMapping("/cheliangjiankong")
public class CheliangjiankongController {
    @Autowired
    private CheliangjiankongService cheliangjiankongService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheliangjiankongEntity cheliangjiankong, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			cheliangjiankong.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CheliangjiankongEntity> ew = new EntityWrapper<CheliangjiankongEntity>();


		PageUtils page = cheliangjiankongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangjiankong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheliangjiankongEntity cheliangjiankong, 
		HttpServletRequest request){
        EntityWrapper<CheliangjiankongEntity> ew = new EntityWrapper<CheliangjiankongEntity>();

		PageUtils page = cheliangjiankongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliangjiankong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheliangjiankongEntity cheliangjiankong){
       	EntityWrapper<CheliangjiankongEntity> ew = new EntityWrapper<CheliangjiankongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheliangjiankong, "cheliangjiankong")); 
        return R.ok().put("data", cheliangjiankongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheliangjiankongEntity cheliangjiankong){
        EntityWrapper< CheliangjiankongEntity> ew = new EntityWrapper< CheliangjiankongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheliangjiankong, "cheliangjiankong")); 
		CheliangjiankongView cheliangjiankongView =  cheliangjiankongService.selectView(ew);
		return R.ok("查询车辆监控成功").put("data", cheliangjiankongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheliangjiankongEntity cheliangjiankong = cheliangjiankongService.selectById(id);
        return R.ok().put("data", cheliangjiankong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheliangjiankongEntity cheliangjiankong = cheliangjiankongService.selectById(id);
        return R.ok().put("data", cheliangjiankong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheliangjiankongEntity cheliangjiankong, HttpServletRequest request){
    	cheliangjiankong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheliangjiankong);

        cheliangjiankongService.insert(cheliangjiankong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheliangjiankongEntity cheliangjiankong, HttpServletRequest request){
    	cheliangjiankong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheliangjiankong);

        cheliangjiankongService.insert(cheliangjiankong);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CheliangjiankongEntity cheliangjiankong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliangjiankong);
        cheliangjiankongService.updateById(cheliangjiankong);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cheliangjiankongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
