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


import com.dao.JiaotonggonggaoDao;
import com.entity.JiaotonggonggaoEntity;
import com.service.JiaotonggonggaoService;
import com.entity.vo.JiaotonggonggaoVO;
import com.entity.view.JiaotonggonggaoView;

@Service("jiaotonggonggaoService")
public class JiaotonggonggaoServiceImpl extends ServiceImpl<JiaotonggonggaoDao, JiaotonggonggaoEntity> implements JiaotonggonggaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaotonggonggaoEntity> page = this.selectPage(
                new Query<JiaotonggonggaoEntity>(params).getPage(),
                new EntityWrapper<JiaotonggonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaotonggonggaoEntity> wrapper) {
		  Page<JiaotonggonggaoView> page =new Query<JiaotonggonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiaotonggonggaoVO> selectListVO(Wrapper<JiaotonggonggaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaotonggonggaoVO selectVO(Wrapper<JiaotonggonggaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaotonggonggaoView> selectListView(Wrapper<JiaotonggonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaotonggonggaoView selectView(Wrapper<JiaotonggonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
