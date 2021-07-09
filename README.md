# graphql-demo

后端：graphql-springboot

- API：http://localhost:8080/graphql

- API doc：http://localhost:8080/graphiql

  示例1：获取用户列表

  ```
  query {
    users{
      id
      name
      age
      sex
    }
  }
  ```

  示例2：添加用户

  ```
  mutation {
    create(input:{
      name: "Tom"
      password: "12345"
    }){
      id
    }
  }
  ```

前端：