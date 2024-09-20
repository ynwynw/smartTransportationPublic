package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WeiguijianceDao;
import com.entity.WeiguijianceEntity;
import com.service.WeiguijianceService;
import com.entity.vo.WeiguijianceVO;
import com.entity.view.WeiguijianceView;

@Service("weiguijianceService")
public class WeiguijianceServiceImpl extends ServiceImpl<WeiguijianceDao, WeiguijianceEntity> implements WeiguijianceService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeiguijianceEntity> page = this.selectPage(
                new Query<WeiguijianceEntity>(params).getPage(),
                new EntityWrapper<WeiguijianceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeiguijianceEntity> wrapper) {
		  Page<WeiguijianceView> page =new Query<WeiguijianceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeiguijianceVO> selectListVO(Wrapper<WeiguijianceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeiguijianceVO selectVO(Wrapper<WeiguijianceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeiguijianceView> selectListView(Wrapper<WeiguijianceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeiguijianceView selectView(Wrapper<WeiguijianceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
