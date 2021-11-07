import React, { useState } from 'react';


import ExpenseDate from './ExpenseDate';
import Card from "../UI/Card";
import './ExpenseItem.css';

const ExpenseItem = (props) => {

  const [title, setTitle] = useState(props.title);
  const clickHandler = () => {
    setTitle('Updated');
    console.log(title);
  }

  return (

    // take note 1 duoc ap dung o day
    // Card component is a custom card defined by you
    // nhớ ôn lại đoạn này <Card className="expense-item"> 
    <li> 
  <Card className="expense-item">   
    <ExpenseDate date={props.date}/>
    <div className="expense-item__description">
      <h2>{props.title}</h2>
      <div className="expense-item__price">${props.amount}</div>
    </div>
    <button onClick={clickHandler}>Change title</button>
  </Card>
  </li>);
}

export default ExpenseItem;
