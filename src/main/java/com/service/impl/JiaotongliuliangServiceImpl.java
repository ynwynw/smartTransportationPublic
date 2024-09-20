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


import com.dao.JiaotongliuliangDao;
import com.entity.JiaotongliuliangEntity;
import com.service.JiaotongliuliangService;
import com.entity.vo.JiaotongliuliangVO;
import com.entity.view.JiaotongliuliangView;

@Service("jiaotongliuliangService")
public class JiaotongliuliangServiceImpl extends ServiceImpl<JiaotongliuliangDao, JiaotongliuliangEntity> implements JiaotongliuliangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaotongliuliangEntity> page = this.selectPage(
                new Query<JiaotongliuliangEntity>(params).getPage(),
                new EntityWrapper<JiaotongliuliangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaotongliuliangEntity> wrapper) {
		  Page<JiaotongliuliangView> page =new Query<JiaotongliuliangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaotongliuliangVO> selectListVO(Wrapper<JiaotongliuliangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaotongliuliangVO selectVO(Wrapper<JiaotongliuliangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaotongliuliangView> selectListView(Wrapper<JiaotongliuliangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaotongliuliangView selectView(Wrapper<JiaotongliuliangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
