<template>

	<el-container style="min-height: 100vh; ">
		<!-- 侧边导航栏 -->
		<Aside>这是aside</Aside>
		<el-container>
		<!-- 顶部 -->
		<el-header style="text-align: right; font-size: 12px;border-bottom: 1px solid #ccc; line-height: 60px;">
			<Header ></Header>
		</el-header>
		<el-main >
			<!-- 主体区域 -->
			<router-view style="margin: 0ex"></router-view>
		</el-main>
		</el-container>
	</el-container>

</template>

<script>
	import Aside from '@/components/Aside.vue'
	import Header from '@/components/Header.vue'
	import Index from '@/components/Index.vue'
	import axios from 'axios'
	export default {
		name: 'HomeView',
		components: {
			Aside,
			Header,
			Index
		},
		data() {
			return {
				tableData: [],
				pageNum: 1,
				pageSize: 5,
				headerBg: 'headerBg',
				total: 0,
				goodsid: '',
				gooodsname: '',
				dialogFormVisible: false,
				form: {},
				multipleSelection: []
			}
		},
		created() {
			this.load()
		},
		methods: {
			// 分页查询
			load() {
				/* axios.get("http://localhost:8888/goods/list")
				   .then(res =>{
					   console.log(res)
					   this.tableData=res.data
				   }) */
				axios.get("http://localhost:8888/goods/page?page=" + this.pageNum + "&limit=" + this.pageSize + "&goodsid=" +
						this.goodsid + "&goodsname=" + this.gooodsname)
					.then(res => {
						console.log(res);
						this.tableData = res.data.data
						this.total = res.data.count
						/* this.goodsName=""
						this.goodsType="" */
					})
			},
			handleSizeChange(pageSize) {
				console.log(pageSize)
				this.pageSize = pageSize
				this.load()
			},
			handleCurrentChange(pageNum) {
				console.log(pageNum)
				this.pageNum = pageNum
				this.load()
			},
			// 保存
			save() {
				// console.log(this.form)
				axios.post("http://localhost:8888/goods/save", this.form)
					.then(res => {
						// console.log(res)
						if (res.data.code == 0) {
							this.$message.success("保存成功！")
							this.load()
							this.dialogFormVisible = false
							this.form = {}
						} else {
							this.$message.error("新增失败！")
						}
					})
			},
			// 编辑
			edit(row) {
				// console.log(row)
				this.dialogFormVisible = true
				this.form = row;
			},
			// 删除
			del(id) {
				axios.get("http://localhost:8888/goods/del?id=" + id)
					.then(res => {
						if (res.data.code == 0) {
							this.$message.success("删除成功！")
							this.load()
						} else {
							this.$message.error("删除失败！")
						}
					})
			},
			// 批量删除
			delbat() {
				// 取选中数据的id
				let ids = this.multipleSelection.map(v => v.id);
				axios.post("http://localhost:8888/goods/delbat", ids)
					.then(res => {
						if (res.data.code == 0) {
							this.$message.success("删除成功！")
							this.load()
						} else {
							this.$message.error("删除失败！")
						}
					})
			},
			// 获取选中的数据
			handleSelectionChange(val) {
				this.multipleSelection = val
				console.log(val)
			},
			// 导出数据
			exp() {
				// alert(111)
				window.open(`http://localhost:8888/goods/export`)
			},
			// 导入成功后重新加载数据
			handleExcelImportSuccess() {
				this.load()
				this.$message.success("导入成功！")
			}
		}

	}
</script>

<style>
	.headerBg {
		background: #ccc !important;
	}
</style>