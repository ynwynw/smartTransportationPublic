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


import com.dao.ChepiaogoumaiDao;
import com.entity.ChepiaogoumaiEntity;
import com.service.ChepiaogoumaiService;
import com.entity.vo.ChepiaogoumaiVO;
import com.entity.view.ChepiaogoumaiView;

@Service("chepiaogoumaiService")
public class ChepiaogoumaiServiceImpl extends ServiceImpl<ChepiaogoumaiDao, ChepiaogoumaiEntity> implements ChepiaogoumaiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChepiaogoumaiEntity> page = this.selectPage(
                new Query<ChepiaogoumaiEntity>(params).getPage(),
                new EntityWrapper<ChepiaogoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChepiaogoumaiEntity> wrapper) {
		  Page<ChepiaogoumaiView> page =new Query<ChepiaogoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChepiaogoumaiVO> selectListVO(Wrapper<ChepiaogoumaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChepiaogoumaiVO selectVO(Wrapper<ChepiaogoumaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChepiaogoumaiView> selectListView(Wrapper<ChepiaogoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChepiaogoumaiView selectView(Wrapper<ChepiaogoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
