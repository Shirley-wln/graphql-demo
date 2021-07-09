<template>
  <a-card :bordered="false">
    <a-table :columns="columns" :data-source="data" rowKey="id"> </a-table>
  </a-card>
</template>
<script>
import { queryUsers } from "../apis/users";
export default {
  data() {
    const columns = [
      {
        dataIndex: "name",
        key: "name",
        title: "名字",
      },
      {
        title: "年龄",
        dataIndex: "age",
        key: "age",
      },
      {
        title: "性别",
        key: "gender",
        dataIndex: "gender",
      },
    ];
    return {
      data: [],
      columns,
    };
  },
  methods: {
    query() {
      let _self = this;
      queryUsers().then((response) => {
        _self.data = response.data.users;
      });
    },
  },
  mounted() {
    this.query();
  },
};
</script>
