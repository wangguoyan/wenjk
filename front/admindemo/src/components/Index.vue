<template>  
  <div id="container">  
    <div id="header">  
      <div id="search">  
        <form @submit.prevent="search">  
          <input type="text" v-model="searchText" placeholder="搜索农产品" />  
          <button type="submit">搜索</button>  
        </form>  
      </div>  
    </div>  
    <div id="nav">  
      <ul>  
        <li><a @click="goToPage('home')">主页</a></li>  
        <li><a @click="goToPage('sight')">小草坝旅游景点</a></li>  
        <li><a @click="goToPage('products')">农产品介绍</a></li>  
        <!-- 其他导航链接 -->  
        <router-link to="/Aside.vue"><li><a @click="goToPage('login')">登录</a></li></router-link>  
        <!-- 其他导航链接 -->  
      </ul>  
    </div>  
    <!-- 其他内容 -->  
  </div>  
</template>  
  
<script>  
export default {  
  data() {  
    return {  
      searchText: '',  
      currentPage: 'home' // 默认主页  
    };  
  },  
  methods: {  
    search() {  
      // 执行搜索逻辑  
    },  
    goToPage(page) {  
      // 导航到指定页面逻辑  
    }  
  }  
};  
</script>