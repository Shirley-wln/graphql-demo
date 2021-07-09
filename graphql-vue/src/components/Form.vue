<template>
<div>
    <a-form :form="formTemp">
    <a-form-item
      :label-col="formItemLayout.labelCol"
      :wrapper-col="formItemLayout.wrapperCol"
      label="Name"
    >
      <a-input
        v-decorator="[
          'username',
          { rules: [{ required: true, message: 'Please input your name' }] },
        ]"
        placeholder="Please input your name"
      />
    </a-form-item>
    <a-form-item
      :label-col="formItemLayout.labelCol"
      :wrapper-col="formItemLayout.wrapperCol"
      label="Nickname"
    >
      <a-input
        v-decorator="[
          'nickname',
          {
            rules: [
              { required: checkNick, message: 'Please input your nickname' },
            ],
          },
        ]"
        placeholder="Please input your nickname"
      />
    </a-form-item>
    <a-form-item
      :label-col="formTailLayout.labelCol"
      :wrapper-col="formTailLayout.wrapperCol"
    >
      <a-checkbox :checked="checkNick" @change="handleChange">
        Nickname is required
      </a-checkbox>
    </a-form-item>
    <a-form-item
      :label-col="formTailLayout.labelCol"
      :wrapper-col="formTailLayout.wrapperCol"
    >
      <a-button type="primary" @click="check">
        Check
      </a-button>
    </a-form-item>
    </a-form>
  </div>
</template>

<script>
import { Form } from "ant-design-vue";
const formItemLayout = {
  labelCol: { span: 4 },
  wrapperCol: { span: 8 },
};
const formTailLayout = {
  labelCol: { span: 4 },
  wrapperCol: { span: 8, offset: 4 },
};
export default {
  data() {
    return {
      checkNick: false,
      formItemLayout,
      formTailLayout,
      formTemp: Form.createForm(this, { name: "dynamic_rule" }),
    };
  },
  methods: {
    check() {
      this.formTemp.validateFields((err) => {
        if (!err) {
          console.info("success");
        }
      });
    },
    handleChange(e) {
      this.checkNick = e.target.checked;
      this.$nextTick(() => {
        this.formTemp.validateFields(["nickname"], { force: true });
      });
    },
  },
};
</script>
