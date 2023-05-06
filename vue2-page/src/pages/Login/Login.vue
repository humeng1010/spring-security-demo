<template>
  <div class="login">
    <h1>登陆</h1>
    <el-form
      :label-position="labelPosition"
      label-width="80px"
      :model="formLabelAlign"
    >
      <el-form-item label="用户名">
        <el-input
          v-model="formLabelAlign.username"
          autocomplete="off"
        ></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input
          v-model="formLabelAlign.password"
          type="password"
          autocomplete="off"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { login } from "@/api/index.js";
import axios from "axios";
export default {
  name: "Login",
  data() {
    return {
      labelPosition: "right",
      formLabelAlign: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    async submitForm() {
      console.log(this.formLabelAlign);
      // application/x-www-form-urlencoded
      const res = await axios({
        url: "/api/login",
        method: "POST",
        data: this.formLabelAlign,
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
      });
      console.log(res);
    },
  },
};
</script>

<style lang="less" scoped>
.login {
  margin: 0 auto;
  max-width: 800px;
  min-width: 300px;
}
</style>