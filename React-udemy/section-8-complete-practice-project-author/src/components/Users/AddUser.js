import React, {useState} from "react";
import Wrapper from "../Helpers/Wrapper.js";
import Button from "../UI/Button.js";
import Card from "../UI/Card.js";
import ErrorModal from "../UI/ErrorModal.js";
import CssClasses from "./AddUser.module.css";

const AddUser = (props) => {

    const [enteredUsername, setEnteredUsername] = useState('');
    const [enteredAge, setEnteredAge] = useState('');
    const [error, setError] = useState();

    const usernameChangeHandle = (event) => {
        setEnteredUsername(event.target.value);
    }
    const ageChangeHandle = (event) => {
        setEnteredAge(event.target.value);
    }

    const addUserHandler = (event) => {
        event.preventDefault();
        if(enteredUsername.trim().length === 0 || enteredAge.trim().length === 0) {
            setError({
                title: 'Invalid input',
                message: 'Please enter a valid name and age (non-empty values)'
            })
            // setIsValid(!isValid);
            // setEnteredMessage("username must not be blank");
            return;
        }

        // +enteredAge . The character + is to make sure to convert string to number 
        if(+enteredAge < 1) {
            // setIsValid(!isValid);
            // setEnteredMessage("age must be greater than 1");
            setError({
                title: 'Invalid age',
                message: 'Please enter a valid age (>1)'
            })
            return;
        }


        const user = {
            name: enteredUsername,
            age: enteredAge,
            id: Math.random().toString()
        }

        props.onAddUser(user);

        setEnteredUsername('');
        setEnteredAge('');
    }

    const errorHandle = () => {
        setError(null);
    }

    return(
        // because Card is out custom component
        // it's not one of those built in HTML components
        // And therefore, since it's our component, 
        // it only has props or it only is able to work with props we use inside of that component
        // vi` la` mot component cua chung ta tu xay dung nen no khong the su dung css nhu cac HTML components
        <Wrapper>
            {error && <ErrorModal title={error.title} message={error.message} onConfirm={errorHandle}/>}
            <Card className={CssClasses.input}>
                {/* if we add function like addUserHandler() to onSumit
                this would immediately execute addUserHandler when this line is parsed.

                if we add pointer(addUserHandler) to that function to the onSubmit
                so that the form component internally can use that function when it needs to use it */}
                <form onSubmit={addUserHandler}>
                    <label htmlFor="username">Username</label>
                    <input id="username" type="text" value={enteredUsername} onChange={usernameChangeHandle}/>
                    <label htmlFor="age">Age (Years)</label>
                    <input id="age" type="number" value={enteredAge} onChange={ageChangeHandle}/>
                    {/* <button type="submit">Add User</button> */}
                    <Button type="submit">Add User</Button>
                </form>
            </Card>
        </Wrapper>
    )
};

export default AddUser;