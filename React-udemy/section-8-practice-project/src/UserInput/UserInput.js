import React, {useState} from "react";


const UserInput = props => {


    const[enteredUsername, setEnteredUsername] = useState('');
    const[enteredAge, setEnteredAge] = useState('');

    const usernameInputChangeHandler = event => {
        setEnteredUsername(event.target.value);
    };

    const ageInputChangeHandler = event => {
        setEnteredAge(event.target.value);
    };

    const formSubmitHandler = event => {
        event.preventDefault();
        
        const userData = {
            username: enteredUsername,
            age: enteredAge,
            id: Math.random().toString()
        }
        props.onAddUser(userData);
        setEnteredUsername('');
        setEnteredAge('');
    };

    return (
        <form onSubmit={formSubmitHandler}>
            <div>
                <label>Username</label>
                <input type="text" onChange={usernameInputChangeHandler}/>
            </div>
            <div>
                <label>Age (Years)</label>
                <input type="text" onChange={ageInputChangeHandler}/>
            </div>
            <button>Add User</button>
        </form>
    );
}

export default UserInput;