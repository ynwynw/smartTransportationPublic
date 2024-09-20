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

import com.entity.JiaotongliuliangEntity;
import com.entity.view.JiaotongliuliangView;

import com.service.JiaotongliuliangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 交通流量
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
@RestController
@RequestMapping("/jiaotongliuliang")
public class JiaotongliuliangController {
    @Autowired
    private JiaotongliuliangService jiaotongliuliangService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaotongliuliangEntity jiaotongliuliang, 
		HttpServletRequest request){

        EntityWrapper<JiaotongliuliangEntity> ew = new EntityWrapper<JiaotongliuliangEntity>();


		PageUtils page = jiaotongliuliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaotongliuliang), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaotongliuliangEntity jiaotongliuliang, 
		HttpServletRequest request){
        EntityWrapper<JiaotongliuliangEntity> ew = new EntityWrapper<JiaotongliuliangEntity>();

		PageUtils page = jiaotongliuliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaotongliuliang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaotongliuliangEntity jiaotongliuliang){
       	EntityWrapper<JiaotongliuliangEntity> ew = new EntityWrapper<JiaotongliuliangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaotongliuliang, "jiaotongliuliang")); 
        return R.ok().put("data", jiaotongliuliangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaotongliuliangEntity jiaotongliuliang){
        EntityWrapper< JiaotongliuliangEntity> ew = new EntityWrapper< JiaotongliuliangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaotongliuliang, "jiaotongliuliang")); 
		JiaotongliuliangView jiaotongliuliangView =  jiaotongliuliangService.selectView(ew);
		return R.ok("查询交通流量成功").put("data", jiaotongliuliangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaotongliuliangEntity jiaotongliuliang = jiaotongliuliangService.selectById(id);
        return R.ok().put("data", jiaotongliuliang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaotongliuliangEntity jiaotongliuliang = jiaotongliuliangService.selectById(id);
        return R.ok().put("data", jiaotongliuliang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaotongliuliangEntity jiaotongliuliang, HttpServletRequest request){
    	jiaotongliuliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaotongliuliang);

        jiaotongliuliangService.insert(jiaotongliuliang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaotongliuliangEntity jiaotongliuliang, HttpServletRequest request){
    	jiaotongliuliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaotongliuliang);

        jiaotongliuliangService.insert(jiaotongliuliang);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaotongliuliangEntity jiaotongliuliang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaotongliuliang);
        jiaotongliuliangService.updateById(jiaotongliuliang);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaotongliuliangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
