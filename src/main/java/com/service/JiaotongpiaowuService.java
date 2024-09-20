package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaotongpiaowuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaotongpiaowuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaotongpiaowuView;


/**
 * 交通票务
 *
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
public interface JiaotongpiaowuService extends IService<JiaotongpiaowuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaotongpiaowuVO> selectListVO(Wrapper<JiaotongpiaowuEntity> wrapper);
   	
   	JiaotongpiaowuVO selectVO(@Param("ew") Wrapper<JiaotongpiaowuEntity> wrapper);
   	
   	List<JiaotongpiaowuView> selectListView(Wrapper<JiaotongpiaowuEntity> wrapper);
   	
   	JiaotongpiaowuView selectView(@Param("ew") Wrapper<JiaotongpiaowuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaotongpiaowuEntity> wrapper);
   	

}

