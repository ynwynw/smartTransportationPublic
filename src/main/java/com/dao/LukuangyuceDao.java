package com.dao;

import com.entity.LukuangyuceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LukuangyuceVO;
import com.entity.view.LukuangyuceView;


/**
 * 路况预测
 * 
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
public interface LukuangyuceDao extends BaseMapper<LukuangyuceEntity> {
	
	List<LukuangyuceVO> selectListVO(@Param("ew") Wrapper<LukuangyuceEntity> wrapper);
	
	LukuangyuceVO selectVO(@Param("ew") Wrapper<LukuangyuceEntity> wrapper);
	
	List<LukuangyuceView> selectListView(@Param("ew") Wrapper<LukuangyuceEntity> wrapper);

	List<LukuangyuceView> selectListView(Pagination page,@Param("ew") Wrapper<LukuangyuceEntity> wrapper);
	
	LukuangyuceView selectView(@Param("ew") Wrapper<LukuangyuceEntity> wrapper);
	

}
