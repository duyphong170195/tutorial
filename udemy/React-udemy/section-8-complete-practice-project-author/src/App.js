import './App.css';
import AddUser from './components/Users/AddUser';
import UserList from './components/Users/UserList';
import React, {useState} from 'react';
function App() {

  const [usersList, setUsersList] = useState([]);

  const addUserHandler = (user) => {
    setUsersList((prevState) => {
      return [...prevState, user];
    })
  }

  return (
    // thay vi dung the div => gay ra performance thap
    // dung React.Fragment
    <React.Fragment>
        <AddUser onAddUser={addUserHandler}/>
        <UserList users={usersList}/>
    </React.Fragment>
  );
}

export default App;
