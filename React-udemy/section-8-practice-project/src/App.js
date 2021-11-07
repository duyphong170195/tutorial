import React, {useState} from "react";
import './App.css';
import UserInput from './UserInput/UserInput.js';
import UserList from './UserList/UserList';

const DUMMY_USERS = [
  {
    id: 1,
    username: "un1",
    age: 12
  },
  {
    id: 2,
    username: "un2",
    age: 13
  }
];

const App = () => {

  const [users, setUsers] = useState(DUMMY_USERS);

  const addUserHandler = userData => {

    console.log("App.js")
    console.log(userData);
    setUsers((prevUser) => {
      return [userData, ... prevUser];
    })
  };

  const deleteUserHandler = (id) => {
    const userList = users.filter(user => user.id !== id);
    setUsers(userList);
  };

  return (
    <div className="App">
      <UserInput onAddUser={addUserHandler}></UserInput>

      <UserList items={users} onDeleteUser={deleteUserHandler}></UserList>
    </div>
  );
}

export default App;