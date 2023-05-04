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
export default {
  name: "Login",
  data() {
    return {
      url: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
      labelPosition: "right",
      formLabelAlign: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    submitForm() {
      console.log(this.formLabelAlign);
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