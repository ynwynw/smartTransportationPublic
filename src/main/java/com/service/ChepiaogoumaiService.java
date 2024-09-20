package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChepiaogoumaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChepiaogoumaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChepiaogoumaiView;


/**
 * 车票购买
 *
 * @author 
 * @email 
 * @date 2023-06-25 08:13:00
 */
public interface ChepiaogoumaiService extends IService<ChepiaogoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChepiaogoumaiVO> selectListVO(Wrapper<ChepiaogoumaiEntity> wrapper);
   	
   	ChepiaogoumaiVO selectVO(@Param("ew") Wrapper<ChepiaogoumaiEntity> wrapper);
   	
   	List<ChepiaogoumaiView> selectListView(Wrapper<ChepiaogoumaiEntity> wrapper);
   	
   	ChepiaogoumaiView selectView(@Param("ew") Wrapper<ChepiaogoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChepiaogoumaiEntity> wrapper);
   	

}

