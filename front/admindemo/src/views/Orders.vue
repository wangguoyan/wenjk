<template>
	<div>
		<div style="margin-bottom: 10px;">
			<el-breadcrumb separator-class="el-icon-arrow-right">
				<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item>商品管理</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<div style="padding: 10px 0;">
			<el-input style="width: 200px" placeholder="请输入商品编号" v-model="goodsid"></el-input>
			<el-input class="ml-10" style="width: 200px" placeholder="请输入商品名字" v-model="goodsname"></el-input>
			<el-button class="ml-5" type="primary" icon="el-icon-search" @click="load()">搜索</el-button>
		</div>
		<div style="padding: 10px 0;">
			<el-button class="ml-5" type="primary" icon="el-icon-circle-plus-outline"
				@click="dialogFormVisible = true">新增</el-button>
			<el-popconfirm class="ml-5" confirm-button-text='确定' cancel-button-text='取消' icon="el-icon-info"
				icon-color="red" title="您确定删除吗？" @confirm=delbat()>
				<el-button class="ml-5" type="danger" icon="el-icon-remove-outline"
					slot="reference">批量删除</el-button>
			</el-popconfirm>
			<el-upload :action="'http://' + 'localhost:8888/orders/import'" :show-file-list="false" accept="xlsx"
				:on-success="handleExcelImportSuccess" style="display: inline-block">
				<el-button class="ml-5" type="primary" icon="el-icon-upload2">导入</el-button>
			</el-upload>
			<el-button class="ml-5" type="primary" icon="el-icon-download" @click="exp">导出</el-button>
		</div>
		<el-table :data="tableData" border stripe :header-cell-class-name="headerBg"
			@selection-change="handleSelectionChange">
			<el-table-column type="selection" width="55">
			</el-table-column>
			<el-table-column prop="id" label="ID" width="80">
			</el-table-column>
			<el-table-column prop="orderid" label="订单编号" width="120">
			</el-table-column>
			<el-table-column prop="goodsid" label="商品编号" width="120">
			</el-table-column>
			<el-table-column prop="username" label="用户名" width="100">
			</el-table-column>
			<el-table-column prop="phone" label="联系电话" width="120">
			</el-table-column>
			<el-table-column prop="address" label="收货地址" width="120">
			</el-table-column>
			<el-table-column prop="count" label="产量" width="100">
			</el-table-column>
			<el-table-column prop="price" label="价格" width="100">
			</el-table-column>
			<el-table-column prop="goodsname" label="商品名" width="100">
			</el-table-column>
			<el-table-column prop="paystatus" label="支付状态" width="80">
			</el-table-column>
			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button type="success" icon="el-icon-edit" @click="edit(scope.row)">编辑</el-button>
					<el-popconfirm class="ml-5" confirm-button-text='确定' cancel-button-text='我再想想'
						icon="el-icon-info" icon-color="red" title="您确定删除吗？" @confirm=del(scope.row.id)>
						<el-button type="danger" icon="el-icon-delete" slot="reference">删除</el-button>
					</el-popconfirm>
				</template>
			</el-table-column>
		</el-table>
		<div style="padding: 10px 0;">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="pageNum" :page-sizes="[5,10, 15, 20]" :page-size="pageSize"
				layout="total, sizes, prev, pager, next, jumper" :total="total">
			</el-pagination>
		</div>
		<!-- 新增弹出框 -->
		<el-dialog title="商品信息" :visible.sync="dialogFormVisible" width="30%">
			<el-form label-width="120px">
				<el-form-item label="订单编号">
					<el-input v-model="form.orderid" autocomplete="off"></el-input>
					</el-form-item>
				<el-form-item label="商品名字">
						<el-input v-model="form.goodsid" autocomplete="off"></el-input>
					</el-form-item>
				<el-form-item label="用户名">
					<el-input v-model="form.username" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="电话号码">
					<el-input v-model="form.phone" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="收货地址">
					<el-input v-model="form.address" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="产量">
					<el-input v-model="form.count" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="价格">
					<el-input v-model="form.price" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="商品名">
					<el-input v-model="form.goodsname" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="支付状态">
					<el-input v-model="form.paystatus" autocomplete="off"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="dialogFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="save">确 定</el-button>
			</div>
		</el-dialog>
	</div>
</template>

<script>
	import axios from 'axios'
	export default {
		data() {
			return {
				tableData: [],
				pageNum: 1,
				pageSize: 5,
				headerBg: 'headerBg',
				total: 0,
				goodsid: '',
				goodsname: '',
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
				axios.get("http://localhost:8888/orders/page?page=" + this.pageNum + "&limit=" + this.pageSize + "&goodsid=" +
						this.goodsid + "&goodsname=" + this.goodsname)
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
				axios.post("http://localhost:8888/orders/save", this.form)
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
				axios.get("http://localhost:8888/orders/del?id=" + id)
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
				axios.post("http://localhost:8888/orders/delbat", ids)
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
				window.open(`http://localhost:8888/orders/export`)
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
</style>