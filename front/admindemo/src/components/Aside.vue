<template>
	<el-aside width="220px" style="background-color: rgb(238, 241, 246)" >
	  <el-menu :default-openeds="['1', '3']" style="min-height: 100%;overflow-x: hidden;" 
			 background-color="rgb(48,65,86)" 
			 text-color="#fff"
			 active-text-color="#ffd84b"
			 router>
			 <div style="height: 60px; line-height: 60px; text-align: center;">
			 			 <img src="../assets/logo1.jpg" alt="" style="width: 20px;position: relative; top: 5px;margin-right: 5px;">
			 			 <b style="color: white;">农产品后台管理系统</b>
			 </div>
	    
	    
	    <el-menu-item index="/"><i class="el-icon-house"></i>主页</el-menu-item>
			   <el-submenu index="3">
			   	    <template slot="title"><i class="el-icon-menu"></i>系统管理</template>  
			   	    <el-menu-item index="/users"><i class="el-icon-s-custom"></i>用户</el-menu-item>
					<el-menu-item index="/business"><i class="el-icon-s-custom"></i>商家</el-menu-item>
					<el-menu-item index="/admins"><i class="el-icon-s-custom"></i>管理员</el-menu-item>
					<el-menu-item index="/goods"><i class="el-icon-s-goods"></i>商品管理</el-menu-item>
					<el-menu-item index="/orders"><i class="el-icon-s-promotion"></i>订单管理</el-menu-item>
			   	  </el-submenu>
				 
	  </el-menu>
	</el-aside>
</template>

<script>
export default{
	data() {
		return {}
	}
}
</script>

<style>
</style>