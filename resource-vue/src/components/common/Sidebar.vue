<template>
    <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            :default-active="onRoutes"
            :collapse="collapse"
            background-color="#363f67"
            text-color="#a8aec1"
            active-text-color="#4e72ee"
            unique-opened
            router
        >
            <template v-for="item in items">
                <template v-if="item.subs">
<!--                    一级菜单-->
                    <el-submenu :index="item.index" :key="item.index">
                        <template slot="title">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.title }}</span>
                        </template>
                        <template v-for="subItem in item.subs">
                            <el-submenu
                                v-if="subItem.subs"
                                :index="subItem.index"
                                :key="subItem.index"
                            >
                                <template slot="title"><i :class="subItem.icon"></i>{{ subItem.title }}</template>
<!--                                二级菜单-->
                                <el-menu-item
                                    v-for="(threeItem,i) in subItem.subs"
                                    :key="i"
                                    :index="threeItem.index"
                                ><i :class="threeItem.icon"></i>{{ threeItem.title }}</el-menu-item>
                            </el-submenu>
                            <el-menu-item
                                v-else
                                :index="subItem.index"
                                :key="subItem.index"
                            ><i :class="subItem.icon"></i>{{ subItem.title }}</el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i>
                        <span slot="title">{{ item.title }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
import bus from '../common/bus';
export default {
    data() {
        return {
            collapse: false,
            items:[],
            itemList: [
                    {
                        "id":4,
                        "pid":1,
                        "icon":"el-icon-s-order",
                        "index":"3",
                        "title":"统一管理",
                        "subs":[
                        {
                                "id":9,
                                "pid":4,
                                "icon":"el-icon-s-finance",
                                "index":"product",
                                "title":"回收管理",
                                "subs":null
                            },
                          
                            {
                                "id":9,
                                "pid":4,
                                "icon":"el-icon-s-home",
                                "index":"store",
                                "title":"仓库管理",
                                "subs":null
                            },
                            {
                                "id":9,
                                "pid":4,
                                "icon":"el-icon-s-home",
                                "index":"bus",
                                "title":"车辆管理",
                                "subs":null
                            },
                            {
                                "id":9,
                                "pid":4,
                                "icon":"el-icon-s-cooperation",
                                "index":"life",
                                "title":"生活服务",
                                "subs":null
                            },
                            {
                                "id":9,
                                "pid":4,
                                "icon":"el-icon-s-home",
                                "index":"member",
                                "title":"员工管理",
                                "subs":null
                            },
                            {
                                "id":9,
                                "pid":4,
                                "icon":"el-icon-s-data",
                                "index":"donate",
                                "title":"捐赠管理",
                                "subs":null
                            },

                            {
                                "id":9,
                                "pid":4,
                                "icon":"el-icon-notebook-2",
                                "index":"notice",
                                "title":"通知管理",
                                "subs":null
                            },
                            {
                                "id":9,
                                "pid":4,
                                "icon":"el-icon-s-management",
                                "index":"sort",
                                "title":"分类管理",
                                "subs":null
                            },

                            {
                                "id":9,
                                "pid":4,
                                "icon":"el-icon-reading",
                                "index":"dic",
                                "title":"字典管理",
                                "subs":null
                            },
                            {
                                "id":9,
                                "pid":4,
                                "icon":"el-icon-setting",
                                "index":"user",
                                "title":"用户管理",
                                "subs":null
                            },




                        ]
                    },
                  ],
            itemList2:[
                {
                    "id":5,
                    "pid":1,
                    "icon":"el-icon-s-data",
                    "index":"6",
                    "title":"员工管理",
                    "subs":[
                        {
                            "id":9,
                            "pid":4,
                            "icon":"el-icon-plus",
                            "index":"product",
                            "title":"回收物管理",
                            "subs":null
                        },
                        {
                            "id":9,
                            "pid":4,
                            "icon":"el-icon-plus",
                            "index":"life",
                            "title":"生活服务",
                            "subs":null
                        },
                        {
                            "id":9,
                            "pid":4,
                            "icon":"el-icon-plus",
                            "index":"donate",
                            "title":"捐赠管理",
                            "subs":null
                        },
                        {
                            "id":9,
                            "pid":4,
                            "icon":"el-icon-plus",
                            "index":"notice",
                            "title":'通知信息',
                            "subs":null
                        },
                    ]
                }
            ],
            itemList3:[
                {
                    "id":5,
                    "pid":1,
                    "icon":"el-icon-s-data",
                    "index":"6",
                    "title":"用户管理",
                    "subs":[
                        {
                            "id":9,
                            "pid":4,
                            "icon":"el-icon-plus",
                            "index":"user",
                            "title":"用户信息",
                            "subs":null
                        },
                        {
                            "id":9,
                            "pid":4,
                            "icon":"el-icon-plus",
                            "index":"product",
                            "title":"回收物管理",
                            "subs":null
                        },
                        {
                            "id":9,
                            "pid":4,
                            "icon":"el-icon-plus",
                            "index":"life",
                            "title":"生活服务",
                            "subs":null
                        },
                        {
                            "id":9,
                            "pid":4,
                            "icon":"el-icon-plus",
                            "index":"notice",
                            "title":"通知管理",
                            "subs":null
                        },
                        {
                            "id":9,
                            "pid":4,
                            "icon":"el-icon-plus",
                            "index":"donate",
                            "title":"捐赠管理",
                            "subs":null
                        },
                    ]
                }
            ],
        };
    },
    computed: {
        onRoutes() {
            return this.$route.path.replace('/', '');
        },
    },
    created() {
        // 通过 Event Bus 进行组件间通信，来折叠侧边栏
        bus.$on('collapse', msg => {
            this.collapse = msg;
            bus.$emit('collapse-content', msg);
        });
        //初始化menuList
        if ("1" === sessionStorage.getItem('userType')){
            this.items = this.itemList;
        }else if ("2" === sessionStorage.getItem('userType')){
            this.items = this.itemList2;
        }else {
            this.items = this.itemList3;
        }
    }
};
</script>

<style scoped>
.sidebar {
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
 
}
.sidebar::-webkit-scrollbar {
    width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
    width: 250px;
}
.sidebar > ul {
    height: 100%;
}
</style>
