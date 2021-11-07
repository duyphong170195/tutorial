import React from "react";
import Card from "../UI/Card";
import UserItem from "./UserItem";
import CssClasses from "./UserList.module.css"

const UserList = (props) => {
    return (
        <Card className={CssClasses.users}>
            <ul>
                {props.users.map(user => {
                    return <UserItem
                         key={user.id}
                         name={user.name}
                         age={user.age}
                    />;
                })}
            </ul>
        </Card>
    );
}

export default UserList;