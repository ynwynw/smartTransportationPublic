package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LukuangyuceEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LukuangyuceVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LukuangyuceView;


/**
 * 路况预测
 *
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
public interface LukuangyuceService extends IService<LukuangyuceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LukuangyuceVO> selectListVO(Wrapper<LukuangyuceEntity> wrapper);
   	
   	LukuangyuceVO selectVO(@Param("ew") Wrapper<LukuangyuceEntity> wrapper);
   	
   	List<LukuangyuceView> selectListView(Wrapper<LukuangyuceEntity> wrapper);
   	
   	LukuangyuceView selectView(@Param("ew") Wrapper<LukuangyuceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LukuangyuceEntity> wrapper);
   	

}

