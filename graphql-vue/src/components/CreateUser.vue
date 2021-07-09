<template>
  <a-form
    style="margin-top:20px"
    :form="form"
    :label-col="{ span: 8 }"
    :wrapper-col="{ span: 10 }"
  >
    <a-form-item label="用户名">
      <a-input
        v-decorator="[
          'name',
          { rules: [{ required: true, message: '请输入用户名!' }] },
        ]"
      />
    </a-form-item>
    <a-form-item label="密码">
      <a-input-password
        v-decorator="[
          'password',
          { rules: [{ required: true, message: '请输入密码!' }] },
        ]"
      />
    </a-form-item>
    <a-form-item label="年龄">
      <a-input-number
        style="width:100%"
        v-decorator="[
          'age',
          {
            initialValue: 20,
          },
        ]"
      />
    </a-form-item>
    <a-form-item label="性别">
      <a-select v-decorator="['gender']" placeholder="请选择">
        <a-select-option value="male">
          male
        </a-select-option>
        <a-select-option value="female">
          female
        </a-select-option>
      </a-select>
    </a-form-item>
    <a-form-item :wrapper-col="{ span: 10, offset: 8 }">
      <a-button type="primary" @click="create">
        提交
      </a-button>
    </a-form-item>
  </a-form>
</template>
<script>
import { createUser } from "../apis/users";
export default {
  data() {
    return {
      form: this.$form.createForm(this, { name: "createUser" }),
    };
  },
  methods: {
    create() {
      this.form.validateFields((err, values) => {
        if (!err) {
          console.log("Received values of form: ", values);
          createUser(values).then((response) => {
            let data = response.data.create;
            if (data.isSucceed) {
              this.$message.info("创建用户成功");
              window.location.reload();
            } else {
              this.$message.error("创建用户失败");
            }
          });
        }
      });
    },
    // ,
    // handleSelectChange(value) {
    //   console.log(value);
    //   //   this.form.setFieldsValue({
    //   //     note: `Hi, ${value === "male" ? "man" : "lady"}!`,
    //   //   });
    // },
  },
};
</script>
