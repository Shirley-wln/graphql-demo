import graphql from "graphql-tag";
import { apolloClient } from "../apollo";

export function queryUsers() {
  return apolloClient.query({
    query: graphql`
      query {
        users {
          id
          name
          age
          gender
        }
      }
    `,
  });
}

export function createUser(user) {
  return apolloClient.mutate({
    mutation: graphql`
      mutation testcreate($user: UserInput) {
        create(input: $user) {
          isSucceed
        }
      }
    `,
    variables: { user },
  });
}
