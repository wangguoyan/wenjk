import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Main from '../views/Main.vue'
import Goods from '../views/Goods.vue'
import Users from '../views/Users.vue'
import Business from '../views/Business.vue'
import Orders from '../views/Orders.vue'
import Tokens from '../views/Tokens.vue'
import Admins from '../views/Admins.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/main',
    name: 'home',
    component: HomeView,
	redirect: "/main",
	children:[
			{path: 'main',name: 'Main',component: Main},
			{path: 'goods',name: 'Goods',component: Goods},
			{path: 'users',name: 'Users',component: Users},
			{path: 'business',name: 'Business',component: Business},
			{path: 'orders',name: 'Orders',component: Orders},
			{path: 'tokens',name: 'Tokens',component: Tokens},
			{path: 'admins',name: 'Admins',component: Admins},
			]
  }
 
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
