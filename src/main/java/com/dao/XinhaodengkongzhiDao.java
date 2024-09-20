package com.dao;

import com.entity.XinhaodengkongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinhaodengkongzhiVO;
import com.entity.view.XinhaodengkongzhiView;


/**
 * 信号灯控制
 * 
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
public interface XinhaodengkongzhiDao extends BaseMapper<XinhaodengkongzhiEntity> {
	
	List<XinhaodengkongzhiVO> selectListVO(@Param("ew") Wrapper<XinhaodengkongzhiEntity> wrapper);
	
	XinhaodengkongzhiVO selectVO(@Param("ew") Wrapper<XinhaodengkongzhiEntity> wrapper);
	
	List<XinhaodengkongzhiView> selectListView(@Param("ew") Wrapper<XinhaodengkongzhiEntity> wrapper);

	List<XinhaodengkongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<XinhaodengkongzhiEntity> wrapper);
	
	XinhaodengkongzhiView selectView(@Param("ew") Wrapper<XinhaodengkongzhiEntity> wrapper);
	

}
