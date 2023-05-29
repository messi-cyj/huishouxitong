import Vue from 'vue';
import Router from 'vue-router';

//import router from '@vue/cli-service/generator/router/template/src/router';

Vue.use(Router);


const router = new Router({
    routes: [
        {
            path: '/',
            redirect: '/Home'
        },
        {
            path: '/Home',
          
            component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
            meta: { title: '自述文件'  },
            children: [
            
                {
                    path: '/user',
                    component: () => import('../components/page/User'),
                    meta: { title: '用户管理',icon:"el-icon-user-solid" }
                },
                {
                    path: '/product',
                    component: () => import(/*  webpackChunkName: "icon",  */ '../components/page/Product'),
                    meta: { title: '回收物管理',icon: 'dashboard' }
                },
                {
                    path: '/donate',
                    component: () => import(/* webpackChunkName: "icon" */ '../components/page/Donate'),
                    meta: { title: '捐赠服务' }
                },
                {
                    path: '/life',
                    component: () => import(/* webpackChunkName: "icon" */ '../components/page/Life'),
                    meta: { title: '生活服务' }
                },
                {
                    path: '/notice',
                    component: () => import(/* webpackChunkName: "icon" */ '../components/page/Notice'),
                    meta: { title: '通知管理' }
                },
                {
                    path: '/sort',
                    component: () => import(/* webpackChunkName: "icon" */ '../components/page/Sort'),
                    meta: { title: '分类管理' }
                },
                {
                    path: '/store',
                    component: () => import(/* webpackChunkName: "icon" */ '../components/page/Store'),
                    meta: { title: '仓库管理' }
                },
                {
                    path: '/dic',
                    component: () => import(/* webpackChunkName: "icon" */ '../components/page/Dictionary'),
                    meta: { title: '字典管理' }
                },



                {
                    path: '/404',
                    component: () => import(/* webpackChunkName: "404" */ '../components/page/404.vue'),
                    meta: { title: '404' }
                },
                {
                    path: '/403',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/403.vue'),
                    meta: { title: '403' }
                }
            ]
        },
        {
            path: '/login',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
            meta: { title: '登录' }
        },
        {
            path: '/register',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Register'),
            meta: { title: '注册' }
        },
        //如果这里后面路由有问题，把这个404注释掉
        {
            path: '*',
            redirect: '/404'
        }
    ]
});

router.beforeEach((to,from,next) =>{
    if (to.path === '/login') {
        next()
    }else{
        const token = sessionStorage.getItem('userStatus');
        if (!token){
            next('/login')
        }else{
            next();
        }
    }
});


export default router
