package com.dao;

import com.entity.JiaotonggonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaotonggonggaoVO;
import com.entity.view.JiaotonggonggaoView;


/**
 * 交通公告
 * 
 * @author 
 * @email 
 * @date 2023-06-25 08:13:01
 */
public interface JiaotonggonggaoDao extends BaseMapper<JiaotonggonggaoEntity> {
	
	List<JiaotonggonggaoVO> selectListVO(@Param("ew") Wrapper<JiaotonggonggaoEntity> wrapper);
	
	JiaotonggonggaoVO selectVO(@Param("ew") Wrapper<JiaotonggonggaoEntity> wrapper);
	
	List<JiaotonggonggaoView> selectListView(@Param("ew") Wrapper<JiaotonggonggaoEntity> wrapper);

	List<JiaotonggonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<JiaotonggonggaoEntity> wrapper);
	
	JiaotonggonggaoView selectView(@Param("ew") Wrapper<JiaotonggonggaoEntity> wrapper);
	

}
