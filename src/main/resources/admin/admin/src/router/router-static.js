import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import lukuangyuce from '@/views/modules/lukuangyuce/list'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import cheliangjiankong from '@/views/modules/cheliangjiankong/list'
    import discussjiaotonggonggao from '@/views/modules/discussjiaotonggonggao/list'
    import weiguijiance from '@/views/modules/weiguijiance/list'
    import chepiaogoumai from '@/views/modules/chepiaogoumai/list'
    import tousufankui from '@/views/modules/tousufankui/list'
    import jiaotongpiaowu from '@/views/modules/jiaotongpiaowu/list'
    import jiaotongliuliang from '@/views/modules/jiaotongliuliang/list'
    import jiaotonggonggao from '@/views/modules/jiaotonggonggao/list'
    import systemintro from '@/views/modules/systemintro/list'
    import discussjiaotongliuliang from '@/views/modules/discussjiaotongliuliang/list'
    import config from '@/views/modules/config/list'
    import xinhaodengkongzhi from '@/views/modules/xinhaodengkongzhi/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/lukuangyuce',
        name: '路况预测',
        component: lukuangyuce
      }
      ,{
	path: '/news',
        name: '公告资讯',
        component: news
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/cheliangjiankong',
        name: '车辆监控',
        component: cheliangjiankong
      }
      ,{
	path: '/discussjiaotonggonggao',
        name: '交通公告评论',
        component: discussjiaotonggonggao
      }
      ,{
	path: '/weiguijiance',
        name: '违规监测',
        component: weiguijiance
      }
      ,{
	path: '/chepiaogoumai',
        name: '车票购买',
        component: chepiaogoumai
      }
      ,{
	path: '/tousufankui',
        name: '投诉反馈',
        component: tousufankui
      }
      ,{
	path: '/jiaotongpiaowu',
        name: '交通票务',
        component: jiaotongpiaowu
      }
      ,{
	path: '/jiaotongliuliang',
        name: '交通流量',
        component: jiaotongliuliang
      }
      ,{
	path: '/jiaotonggonggao',
        name: '交通公告',
        component: jiaotonggonggao
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/discussjiaotongliuliang',
        name: '交通流量评论',
        component: discussjiaotongliuliang
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/xinhaodengkongzhi',
        name: '信号灯控制',
        component: xinhaodengkongzhi
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
