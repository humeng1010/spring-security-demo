import VueRouter from 'vue-router'
import Home from '@/pages/Home/Home.vue'

const router = new VueRouter({
    mode: "hash",
    routes: [
        {
            path: "/",
            redirect: "/home"
        },
        {
            path: "/home",
            component: Home,
            meta: {
                auth: true
            }
        },
        {
            path: "/login",
            component: () => import("@/pages/Login/Login.vue")
        }
    ],

})

router.beforeEach((to, from, next) => {
    console.log(to, from, next)
    if (to.meta.auth) {
        // 认证过的，在本地有token
        const token = localStorage.getItem("token")
        if (token) {
            // 验证token
            console.log("验证token")
            // if 验证成功
            next()
        }
        // 如果需要认证授权
        console.log('未登录需要登陆认证授权')
        next({ path: "/login" })
        return
    }
    next()
})

export default router