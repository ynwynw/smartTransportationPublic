import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import cheliangjiankongList from '../pages/cheliangjiankong/list'
import cheliangjiankongDetail from '../pages/cheliangjiankong/detail'
import cheliangjiankongAdd from '../pages/cheliangjiankong/add'
import lukuangyuceList from '../pages/lukuangyuce/list'
import lukuangyuceDetail from '../pages/lukuangyuce/detail'
import lukuangyuceAdd from '../pages/lukuangyuce/add'
import weiguijianceList from '../pages/weiguijiance/list'
import weiguijianceDetail from '../pages/weiguijiance/detail'
import weiguijianceAdd from '../pages/weiguijiance/add'
import jiaotongpiaowuList from '../pages/jiaotongpiaowu/list'
import jiaotongpiaowuDetail from '../pages/jiaotongpiaowu/detail'
import jiaotongpiaowuAdd from '../pages/jiaotongpiaowu/add'
import chepiaogoumaiList from '../pages/chepiaogoumai/list'
import chepiaogoumaiDetail from '../pages/chepiaogoumai/detail'
import chepiaogoumaiAdd from '../pages/chepiaogoumai/add'
import tousufankuiList from '../pages/tousufankui/list'
import tousufankuiDetail from '../pages/tousufankui/detail'
import tousufankuiAdd from '../pages/tousufankui/add'
import jiaotongliuliangList from '../pages/jiaotongliuliang/list'
import jiaotongliuliangDetail from '../pages/jiaotongliuliang/detail'
import jiaotongliuliangAdd from '../pages/jiaotongliuliang/add'
import xinhaodengkongzhiList from '../pages/xinhaodengkongzhi/list'
import xinhaodengkongzhiDetail from '../pages/xinhaodengkongzhi/detail'
import xinhaodengkongzhiAdd from '../pages/xinhaodengkongzhi/add'
import jiaotonggonggaoList from '../pages/jiaotonggonggao/list'
import jiaotonggonggaoDetail from '../pages/jiaotonggonggao/detail'
import jiaotonggonggaoAdd from '../pages/jiaotonggonggao/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'cheliangjiankong',
					component: cheliangjiankongList
				},
				{
					path: 'cheliangjiankongDetail',
					component: cheliangjiankongDetail
				},
				{
					path: 'cheliangjiankongAdd',
					component: cheliangjiankongAdd
				},
				{
					path: 'lukuangyuce',
					component: lukuangyuceList
				},
				{
					path: 'lukuangyuceDetail',
					component: lukuangyuceDetail
				},
				{
					path: 'lukuangyuceAdd',
					component: lukuangyuceAdd
				},
				{
					path: 'weiguijiance',
					component: weiguijianceList
				},
				{
					path: 'weiguijianceDetail',
					component: weiguijianceDetail
				},
				{
					path: 'weiguijianceAdd',
					component: weiguijianceAdd
				},
				{
					path: 'jiaotongpiaowu',
					component: jiaotongpiaowuList
				},
				{
					path: 'jiaotongpiaowuDetail',
					component: jiaotongpiaowuDetail
				},
				{
					path: 'jiaotongpiaowuAdd',
					component: jiaotongpiaowuAdd
				},
				{
					path: 'chepiaogoumai',
					component: chepiaogoumaiList
				},
				{
					path: 'chepiaogoumaiDetail',
					component: chepiaogoumaiDetail
				},
				{
					path: 'chepiaogoumaiAdd',
					component: chepiaogoumaiAdd
				},
				{
					path: 'tousufankui',
					component: tousufankuiList
				},
				{
					path: 'tousufankuiDetail',
					component: tousufankuiDetail
				},
				{
					path: 'tousufankuiAdd',
					component: tousufankuiAdd
				},
				{
					path: 'jiaotongliuliang',
					component: jiaotongliuliangList
				},
				{
					path: 'jiaotongliuliangDetail',
					component: jiaotongliuliangDetail
				},
				{
					path: 'jiaotongliuliangAdd',
					component: jiaotongliuliangAdd
				},
				{
					path: 'xinhaodengkongzhi',
					component: xinhaodengkongzhiList
				},
				{
					path: 'xinhaodengkongzhiDetail',
					component: xinhaodengkongzhiDetail
				},
				{
					path: 'xinhaodengkongzhiAdd',
					component: xinhaodengkongzhiAdd
				},
				{
					path: 'jiaotonggonggao',
					component: jiaotonggonggaoList
				},
				{
					path: 'jiaotonggonggaoDetail',
					component: jiaotonggonggaoDetail
				},
				{
					path: 'jiaotonggonggaoAdd',
					component: jiaotonggonggaoAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
