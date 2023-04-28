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
            component: Home
        },
        {
            path: "/login",
            component: () => import("@/pages/Login/Login.vue")
        }
    ],

})

router.beforeEach((to, from, next) => {
    console.log(to, from, next)
    next()
})

export default router