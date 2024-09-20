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

import com.entity.WeiguijianceEntity;
import com.entity.view.WeiguijianceView;

import com.service.WeiguijianceService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 违规监测
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
@RestController
@RequestMapping("/weiguijiance")
public class WeiguijianceController {
    @Autowired
    private WeiguijianceService weiguijianceService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeiguijianceEntity weiguijiance, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			weiguijiance.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WeiguijianceEntity> ew = new EntityWrapper<WeiguijianceEntity>();


		PageUtils page = weiguijianceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weiguijiance), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeiguijianceEntity weiguijiance, 
		HttpServletRequest request){
        EntityWrapper<WeiguijianceEntity> ew = new EntityWrapper<WeiguijianceEntity>();

		PageUtils page = weiguijianceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weiguijiance), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeiguijianceEntity weiguijiance){
       	EntityWrapper<WeiguijianceEntity> ew = new EntityWrapper<WeiguijianceEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weiguijiance, "weiguijiance")); 
        return R.ok().put("data", weiguijianceService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeiguijianceEntity weiguijiance){
        EntityWrapper< WeiguijianceEntity> ew = new EntityWrapper< WeiguijianceEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weiguijiance, "weiguijiance")); 
		WeiguijianceView weiguijianceView =  weiguijianceService.selectView(ew);
		return R.ok("查询违规监测成功").put("data", weiguijianceView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeiguijianceEntity weiguijiance = weiguijianceService.selectById(id);
        return R.ok().put("data", weiguijiance);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeiguijianceEntity weiguijiance = weiguijianceService.selectById(id);
        return R.ok().put("data", weiguijiance);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeiguijianceEntity weiguijiance, HttpServletRequest request){
    	weiguijiance.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weiguijiance);

        weiguijianceService.insert(weiguijiance);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeiguijianceEntity weiguijiance, HttpServletRequest request){
    	weiguijiance.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weiguijiance);

        weiguijianceService.insert(weiguijiance);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeiguijianceEntity weiguijiance, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weiguijiance);
        weiguijianceService.updateById(weiguijiance);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weiguijianceService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
