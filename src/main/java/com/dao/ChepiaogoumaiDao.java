package com.dao;

import com.entity.ChepiaogoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChepiaogoumaiVO;
import com.entity.view.ChepiaogoumaiView;


/**
 * 车票购买
 * 
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
public interface ChepiaogoumaiDao extends BaseMapper<ChepiaogoumaiEntity> {
	
	List<ChepiaogoumaiVO> selectListVO(@Param("ew") Wrapper<ChepiaogoumaiEntity> wrapper);
	
	ChepiaogoumaiVO selectVO(@Param("ew") Wrapper<ChepiaogoumaiEntity> wrapper);
	
	List<ChepiaogoumaiView> selectListView(@Param("ew") Wrapper<ChepiaogoumaiEntity> wrapper);

	List<ChepiaogoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<ChepiaogoumaiEntity> wrapper);
	
	ChepiaogoumaiView selectView(@Param("ew") Wrapper<ChepiaogoumaiEntity> wrapper);
	

}
