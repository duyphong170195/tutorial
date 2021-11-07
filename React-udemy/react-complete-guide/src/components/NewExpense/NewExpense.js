import React from 'react';

import ExpenseForm from './ExpenseForm.js'

import './NewExpense.css';


const NewExpense = (props) => {

    // 58. Child-to-Parent Component Communication
    const saveExpenseDataHandler = (enteredExpenseData) => {
        const expenseData = {
            ...enteredExpenseData,
            id: Math.random().toString
        };
        // mặc  dù  được  thực  thi  ở  child  ExpenseForm  nhưng  data  ở NewExpense
        console.log(expenseData);
        props.onAddExpense(expenseData);
    };

    return (<div className="new-expense">
        {/* 58. Child-to-Parent Component Communication */}
        <ExpenseForm onSaveExpenseData={saveExpenseDataHandler}/>
    </div>
    );
}

export default NewExpense;