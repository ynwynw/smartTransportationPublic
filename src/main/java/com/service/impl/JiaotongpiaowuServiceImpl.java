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


import com.dao.JiaotongpiaowuDao;
import com.entity.JiaotongpiaowuEntity;
import com.service.JiaotongpiaowuService;
import com.entity.vo.JiaotongpiaowuVO;
import com.entity.view.JiaotongpiaowuView;

@Service("jiaotongpiaowuService")
public class JiaotongpiaowuServiceImpl extends ServiceImpl<JiaotongpiaowuDao, JiaotongpiaowuEntity> implements JiaotongpiaowuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaotongpiaowuEntity> page = this.selectPage(
                new Query<JiaotongpiaowuEntity>(params).getPage(),
                new EntityWrapper<JiaotongpiaowuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaotongpiaowuEntity> wrapper) {
		  Page<JiaotongpiaowuView> page =new Query<JiaotongpiaowuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaotongpiaowuVO> selectListVO(Wrapper<JiaotongpiaowuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaotongpiaowuVO selectVO(Wrapper<JiaotongpiaowuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaotongpiaowuView> selectListView(Wrapper<JiaotongpiaowuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaotongpiaowuView selectView(Wrapper<JiaotongpiaowuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
