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
      <el-form-item label="验证码" class="verification">
        <el-row type="flex" align="middle" justify="space-around">
          <el-col :span="11">
            <el-input
              v-model="formLabelAlign.verification"
              autocomplete="off"
            ></el-input>
          </el-col>
          <el-col :span="11" :offset="2">
            <el-image
              style="width: 120px; height: 60px"
              :src="url"
              fit="fill"
            ></el-image>
          </el-col>
        </el-row>
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
        verification: "",
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
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0 auto;

  max-width: 800px;
  min-width: 300px;
  .verification {
    display: flex;
    align-items: center;
  }
}
</style>