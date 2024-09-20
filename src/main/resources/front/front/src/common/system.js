export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["新增","查看","修改","删除"],"menu":"车辆监控","menuJump":"列表","tableName":"cheliangjiankong"}],"menu":"车辆监控管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"路况预测","menuJump":"列表","tableName":"lukuangyuce"}],"menu":"路况预测管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["新增","查看","修改","删除"],"menu":"违规监测","menuJump":"列表","tableName":"weiguijiance"}],"menu":"违规监测管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["新增","查看","修改","删除"],"menu":"交通票务","menuJump":"列表","tableName":"jiaotongpiaowu"}],"menu":"交通票务管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改","删除","审核"],"menu":"车票购买","menuJump":"列表","tableName":"chepiaogoumai"}],"menu":"车票购买管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改","删除","审核"],"menu":"投诉反馈","menuJump":"列表","tableName":"tousufankui"}],"menu":"投诉反馈管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除","查看评论","信号灯控制"],"menu":"交通流量","menuJump":"列表","tableName":"jiaotongliuliang"}],"menu":"交通流量管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","修改","删除"],"menu":"信号灯控制","menuJump":"列表","tableName":"xinhaodengkongzhi"}],"menu":"信号灯控制管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["新增","查看","修改","删除","查看评论"],"menu":"交通公告","menuJump":"列表","tableName":"jiaotonggonggao"}],"menu":"交通公告管理"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-vip","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-time","buttons":["查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告资讯","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","车票购买"],"menu":"交通票务列表","menuJump":"列表","tableName":"jiaotongpiaowu"}],"menu":"交通票务模块"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","查看评论"],"menu":"交通流量列表","menuJump":"列表","tableName":"jiaotongliuliang"}],"menu":"交通流量模块"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","查看评论"],"menu":"交通公告列表","menuJump":"列表","tableName":"jiaotonggonggao"}],"menu":"交通公告模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看"],"menu":"车辆监控","menuJump":"列表","tableName":"cheliangjiankong"}],"menu":"车辆监控管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看"],"menu":"路况预测","menuJump":"列表","tableName":"lukuangyuce"}],"menu":"路况预测管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看"],"menu":"违规监测","menuJump":"列表","tableName":"weiguijiance"}],"menu":"违规监测管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","支付"],"menu":"车票购买","menuJump":"列表","tableName":"chepiaogoumai"}],"menu":"车票购买管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["新增","查看","修改","删除"],"menu":"投诉反馈","menuJump":"列表","tableName":"tousufankui"}],"menu":"投诉反馈管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","车票购买"],"menu":"交通票务列表","menuJump":"列表","tableName":"jiaotongpiaowu"}],"menu":"交通票务模块"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","查看评论"],"menu":"交通流量列表","menuJump":"列表","tableName":"jiaotongliuliang"}],"menu":"交通流量模块"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","查看评论"],"menu":"交通公告列表","menuJump":"列表","tableName":"jiaotonggonggao"}],"menu":"交通公告模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
