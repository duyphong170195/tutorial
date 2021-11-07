import React, { useEffect, useReducer, useState, useContext } from 'react';

import Card from '../UI/Card/Card';
import classes from './Login.module.css';
import Button from '../UI/Button/Button';
import AuthContext from '../../store/auth-context';

const emailReducer =  (state, action) => {
    if(action.type === "USER_INPUT") {
        return {value: action.val, isValid: action.val.includes('@')}
    }
    if(action.type === "INPUT_BLUR") {
      return {value: state.value, isValid: state.value.includes('@')}
  }

    return {value: '', isValid : false};
};

const passwordReducer =  (state, action) => {
  if(action.type === "USER_INPUT") {
      return {value: action.val, isValid: action.val.trim().length > 6}
  }
  if(action.type === "INPUT_BLUR") {
    return {value: state.value, isValid: state.value.trim().length > 6}
}

  return {value: '', isValid : false};
};

const Login = (props) => {
  const ctx = useContext(AuthContext)

  // const [enteredEmail, setEnteredEmail] = useState('');
  // const [emailIsValid, setEmailIsValid] = useState();
  // const [enteredPassword, setEnteredPassword] = useState('');
  // const [passwordIsValid, setPasswordIsValid] = useState();
  const [formIsValid, setFormIsValid] = useState(false);

  const [emailState, dispatchEmail] = useReducer(emailReducer, {value: '', isValid: undefined});
  const [passwordState, dispatchPassword] = useReducer(passwordReducer, {value: '', isValid: undefined});

  // console.log("hello login");
  // Su dung code nay de tranh  unnecessary effect execution,
  const { isValid : emailIsValid } = emailState; 
  const { isValid : passwordIsValid } = passwordState; 

  useEffect(() => {
    // console.log("hello effect");
    const identifier = setTimeout(() => {
      console.log("Checking from validity!");
      setFormIsValid(
        emailIsValid && passwordIsValid
      );
    }, 500)
    
    return () => {
      console.log("CLEANUP");
      clearTimeout(identifier);
    }
    // nhung cai khong lien quan den dependency duoi day thi khong goi useEffect
  }, [emailIsValid, passwordIsValid])

  const emailChangeHandler = (event) => {
    // setEnteredEmail(event.target.value);
    dispatchEmail({
      type: "USER_INPUT",
      val: event.target.value
    });

    setFormIsValid(
      event.target.value.includes('@') && passwordState.isValid
    );
  };

  const passwordChangeHandler = (event) => {
    // setEnteredPassword(event.target.value);
    dispatchPassword({
      type: "USER_INPUT",
      val: event.target.value
    });

    setFormIsValid(
        // enteredEmail.includes('@') && event.target.value.trim().length > 6
        emailState.isValid && event.target.value.trim().length > 6
    );
  };

  const validateEmailHandler = () => {
    // setEmailIsValid(enteredEmail.includes('@'));
    // setEmailIsValid(emailState.isValid);
    dispatchEmail({type: 'INPUT_BLUR'})
  };

  const validatePasswordHandler = () => {
    // setPasswordIsValid(enteredPassword.trim().length > 6);
    dispatchPassword({type: 'INPUT_BLUR'})
  };

  const submitHandler = (event) => {
    event.preventDefault();
    ctx.onLogin(emailState.value, passwordState.value); //props.onLogin(enteredEmail, enteredPassword);
  };


  return (
    <Card className={classes.login}>
      <form onSubmit={submitHandler}>
        <div
          className={`${classes.control} ${
            emailState.isValid === false ? classes.invalid : ''
          }`}
        >
          <label htmlFor="email">E-Mail</label>
          <input
            type="email"
            id="email"
            value={emailState.value}
            onChange={emailChangeHandler}
            onBlur={validateEmailHandler}
          />
        </div>
        <div
          className={`${classes.control} ${
            passwordState.isValid === false ? classes.invalid : ''
          }`}
        >
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            value={passwordState.value}
            onChange={passwordChangeHandler}
            onBlur={validatePasswordHandler}
          />
        </div>
        <div className={classes.actions}>
          <Button type="submit" className={classes.btn} disabled={!formIsValid}>
            Login
          </Button>
        </div>
      </form>
    </Card>
  );
};

export default Login;
