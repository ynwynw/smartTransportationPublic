package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeiguijianceEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeiguijianceVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeiguijianceView;


/**
 * 违规监测
 *
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
public interface WeiguijianceService extends IService<WeiguijianceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeiguijianceVO> selectListVO(Wrapper<WeiguijianceEntity> wrapper);
   	
   	WeiguijianceVO selectVO(@Param("ew") Wrapper<WeiguijianceEntity> wrapper);
   	
   	List<WeiguijianceView> selectListView(Wrapper<WeiguijianceEntity> wrapper);
   	
   	WeiguijianceView selectView(@Param("ew") Wrapper<WeiguijianceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeiguijianceEntity> wrapper);
   	

}

