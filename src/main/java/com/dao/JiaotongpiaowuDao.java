package com.dao;

import com.entity.JiaotongpiaowuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaotongpiaowuVO;
import com.entity.view.JiaotongpiaowuView;


/**
 * 交通票务
 * 
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
public interface JiaotongpiaowuDao extends BaseMapper<JiaotongpiaowuEntity> {
	
	List<JiaotongpiaowuVO> selectListVO(@Param("ew") Wrapper<JiaotongpiaowuEntity> wrapper);
	
	JiaotongpiaowuVO selectVO(@Param("ew") Wrapper<JiaotongpiaowuEntity> wrapper);
	
	List<JiaotongpiaowuView> selectListView(@Param("ew") Wrapper<JiaotongpiaowuEntity> wrapper);

	List<JiaotongpiaowuView> selectListView(Pagination page,@Param("ew") Wrapper<JiaotongpiaowuEntity> wrapper);
	
	JiaotongpiaowuView selectView(@Param("ew") Wrapper<JiaotongpiaowuEntity> wrapper);
	

}
