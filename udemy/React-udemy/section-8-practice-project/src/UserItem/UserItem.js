import React from "react";


const UserItem = (props) => {

    const deleteHandler = () => {
        console.log("id= " + props.id + " in UserItem.js");
        props.onDeleteUser(props.id);
    };
    return (
        <div>
            <p onClick={deleteHandler}>{props.username} ({props.age})</p>
        </div>
    );
}


export default UserItem;