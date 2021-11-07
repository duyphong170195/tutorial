import React from "react";
import CssButton from "./Button.module.css";

const Button = (props) => {
    return (
        // type={props.type || 'button'}
        // onClick={props.onClick}
        <button className={CssButton.button} type={props.type || 'button'} onClick={props.onClick}>
            {props.children}
        </button>
    );
};

export default Button;