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

import com.entity.LukuangyuceEntity;
import com.entity.view.LukuangyuceView;

import com.service.LukuangyuceService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 路况预测
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
@RestController
@RequestMapping("/lukuangyuce")
public class LukuangyuceController {
    @Autowired
    private LukuangyuceService lukuangyuceService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LukuangyuceEntity lukuangyuce, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			lukuangyuce.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LukuangyuceEntity> ew = new EntityWrapper<LukuangyuceEntity>();


		PageUtils page = lukuangyuceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lukuangyuce), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LukuangyuceEntity lukuangyuce, 
		HttpServletRequest request){
        EntityWrapper<LukuangyuceEntity> ew = new EntityWrapper<LukuangyuceEntity>();

		PageUtils page = lukuangyuceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lukuangyuce), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LukuangyuceEntity lukuangyuce){
       	EntityWrapper<LukuangyuceEntity> ew = new EntityWrapper<LukuangyuceEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lukuangyuce, "lukuangyuce")); 
        return R.ok().put("data", lukuangyuceService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LukuangyuceEntity lukuangyuce){
        EntityWrapper< LukuangyuceEntity> ew = new EntityWrapper< LukuangyuceEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lukuangyuce, "lukuangyuce")); 
		LukuangyuceView lukuangyuceView =  lukuangyuceService.selectView(ew);
		return R.ok("查询路况预测成功").put("data", lukuangyuceView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LukuangyuceEntity lukuangyuce = lukuangyuceService.selectById(id);
        return R.ok().put("data", lukuangyuce);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LukuangyuceEntity lukuangyuce = lukuangyuceService.selectById(id);
        return R.ok().put("data", lukuangyuce);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LukuangyuceEntity lukuangyuce, HttpServletRequest request){
    	lukuangyuce.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lukuangyuce);

        lukuangyuceService.insert(lukuangyuce);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LukuangyuceEntity lukuangyuce, HttpServletRequest request){
    	lukuangyuce.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lukuangyuce);

        lukuangyuceService.insert(lukuangyuce);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LukuangyuceEntity lukuangyuce, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lukuangyuce);
        lukuangyuceService.updateById(lukuangyuce);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lukuangyuceService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
