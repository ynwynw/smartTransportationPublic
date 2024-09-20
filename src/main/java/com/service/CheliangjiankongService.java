package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheliangjiankongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CheliangjiankongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangjiankongView;


/**
 * 车辆监控
 *
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
public interface CheliangjiankongService extends IService<CheliangjiankongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangjiankongVO> selectListVO(Wrapper<CheliangjiankongEntity> wrapper);
   	
   	CheliangjiankongVO selectVO(@Param("ew") Wrapper<CheliangjiankongEntity> wrapper);
   	
   	List<CheliangjiankongView> selectListView(Wrapper<CheliangjiankongEntity> wrapper);
   	
   	CheliangjiankongView selectView(@Param("ew") Wrapper<CheliangjiankongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangjiankongEntity> wrapper);
   	

}

