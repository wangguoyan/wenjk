<template>
    <div class="page">
        <div class="content">
            <p class="title">{{ type ? '注册' : '登录' }}</p>
            <template v-if="!type">
                <el-form :model="loginForm" status-icon :rules="loginRules" ref="loginForm" label-width="100px">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model.trim="loginForm.username" autocomplete="off" :maxlength="100"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model.trim="loginForm.password" autocomplete="off" :maxlength="20"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button class="btn" size="medium" type="primary" @click="submitForm">登录</el-button>
                    </el-form-item>
                    <span class="change" @click="change">{{ type ? '去登录' : '去注册' }}</span>
                </el-form>
            </template>
            <template v-else>
                <el-form :model="registerForm" status-icon :rules="registerRules" ref="registerForm" label-width="100px">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model.trim="registerForm.username" autocomplete="off" :maxlength="100"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model.trim="registerForm.password" autocomplete="off" :maxlength="40"></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="checkPass">
                        <el-input type="password" v-model.trim="registerForm.checkPass" autocomplete="off" :maxlength="40"></el-input>
                    </el-form-item>
                    <el-form-item label="身份证" prop="userid">
                        <el-input v-model.trim="registerForm.userid" :maxlength="30"></el-input>
                    </el-form-item>
                    <el-form-item label="地址" prop="address">
                        <el-input v-model.trim="registerForm.address" :maxlength="100"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱" prop="mail">
                        <el-input v-model.trim="registerForm.mail" :maxlength="100"></el-input>
                    </el-form-item>
                    <el-form-item label="手机号" prop="phone">
                        <el-input v-model.trim="registerForm.phone" :maxlength="11"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button class="btn" size="medium" type="primary" @click="submitRegisterForm">注册</el-button>
                    </el-form-item>
                    <span class="change" @click="change">{{ type ? '去登录' : '去注册' }}</span>
                </el-form>
            </template>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'login',
    data() {
        var validatePass = (rule, value, callback) => {
            if (value === '') {
            callback(new Error('请输入密码'));
            } else {
            if (this.registerForm.checkPass !== '') {
                this.$refs.registerForm.validateField('checkPass');
            }
            callback();
            }
        };
        var validatePass2 = (rule, value, callback) => {
            console.log(rule)
            console.log(value)
            if (value === '') {
            callback(new Error('请再次输入密码'));
            } else if (value !== this.registerForm.password) {
            callback(new Error('两次输入密码不一致!'));
            } else {
            callback();
            }
        };
        return {
            // url: 'http://localhost:8888/',
            type: 0, // 0登录 1 注册
            loginForm: {
                username: '',
                password: ''
            },
            registerForm: {
                username: '',
                password: '',
                checkPass: '',
                userid: '',
                address: '',
                mail: '',
                phone: ''
            },
            loginRules: {
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                ]
            },
            registerRules: {
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                ],
                password: [
                    { required: true, validator: validatePass, trigger: 'blur' }
                ],
                checkPass: [
                    { required: true, validator: validatePass2, trigger: 'blur' }
                ],
                userid: [
                    { required: true, message: '请输入身份证', trigger: 'blur' },
                ],
                address: [
                    { required: true, message: '请输入地址', trigger: 'blur' },
                ],
                mail: [
                    { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                    { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
                ],
                phone: [
                    { required: true, message: '请输入手机号', trigger: 'blur' },
                    { pattern: /^1[3456789]\d{9}$/, message: '手机号不正确', trigger: ['blur', 'change'] },
                ],
            }
        }
    },
    methods: {
        change() {
            this.loginForm = this.$options.data().loginForm;
            this.registerForm = this.$options.data().registerForm;
            this.type = Number(!this.type);
            this.$nextTick(() => {
                this.$refs.loginForm && this.$refs.loginForm.clearValidate();
                this.$refs.registerForm && this.$refs.registerForm.clearValidate();
            })
        },
        // 登录
        submitForm() {
            this.$refs.loginForm.validate((valid) => {
                console.log()
                const url = 'http://' + window.location.hostname + ':8888/';
                if (valid) {
                    axios.post(url + "tokens/login", this.loginForm)
					.then(res => {
                        if (res.data.code == 0) {
                            const { data } = res.data;
							this.$message.success("登录成功");
                            if (data.role === '用户') {
                                this.$router.push({
                                    path: "/index"
                                });
                            } else if (data.role === '管理员') {
                                this.$router.push({
                                    path: "/aside"
                                });
                            }
						} else {
							this.$message.error(res.data.msg)
						}
					})
                }
            });
        },
        // 注册
        submitRegisterForm() {
            this.$refs.registerForm.validate((valid) => {
                if (valid) {
                    axios.post(url + ':8888/' + "users/register", this.registerForm)
					.then(res => {
                        if (res.data.code == 0) {
                            const { data } = res.data;
							this.$message.success("注册成功");
                            this.change();
						} else {
							this.$message.error(res.data.msg)
						}
					})
                }
            });
        }
    }
}
</script>

<style scoped>
.page {
    width: 100vw;
    min-height: 100vh;
    overflow-y: auto;
    background: url('../assets/bg.jpg')no-repeat 100% 100%;
    display: flex;
    align-items: center;
    justify-content: center;
}
.title {
    font-size: 24px;
    font-weight: bold;
    margin: 0 0 24px 32px;
}
.content {
    width: 30%;
    background-color: #fff;
    border-radius: 24px;
    padding: 48px 48px 48px 24px;
    opacity: 0.9;
}
.btn {
    width: 100%;
    line-height: 24px;
}
.change {
    color: #409EFF;
    float: right;
    cursor: pointer;
}
</style>
