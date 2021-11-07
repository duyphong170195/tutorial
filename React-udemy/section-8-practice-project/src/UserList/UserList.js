import React from "react";
import UserItem from "../UserItem/UserItem.js";


const UserList = (props) => {
    
    const deleteUserHandler = (id) => {
        props.onDeleteUser(id);
    }

    const showUser = props.items.map(user => {
                return <UserItem 
                    key={user.id}
                    id={user.id}
                    username={user.username}
                    age={user.age}
                    onDeleteUser={deleteUserHandler}
                />
            });

    return (
        <div>
            {showUser}
        </div>
    );
}


export default UserList;