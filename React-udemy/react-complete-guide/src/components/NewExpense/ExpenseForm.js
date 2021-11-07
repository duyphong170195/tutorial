import { useState } from 'react';
import './ExpenseForm.css'

const ExpenseForm = (props) => {
    const [addNewExpenseForm, setAddNewExpenseForm] = useState(false);


    const [enteredTitle, setEnteredTitle] = useState('');
    const [enteredDate, setEnteredDate] = useState('');
    const [enteredAmount, setEnteredAmount] = useState('');
    // the difference is
    // that whenever you update this state
    //  you need to update all
    // three properties and not just one.
    // const [userInput, setUserInput] = useState({
    //     enteredTitle: '',
    //     enteredAmount: '',
    //     enteredDate: ''
    // })

    const titleChangeHandle = (event) => {
        setEnteredTitle(event.target.value);
        // setUserInput({
        //     ...userInput,
        //     // overide title
        //     enteredTitle: event.target.value,
        // })
        // setUserInput((prevState) => {
        //     return { ...prevState, enteredTitle: event.target.value};
        // })
    }

    const amountChangeHandle = (event) => {
        setEnteredAmount(event.target.value);
        // setUserInput({
        //     ...userInput,
        //     // overide date
        //     enteredAmount: event.target.value,
        // })
    }

    const dateChangeHandle = (event) => {
        setEnteredDate(event.target.value);
        // setUserInput({
        //     ...userInput,
        //     // overide amount
        //     enteredAmount: event.target.value,
        // })
    }
    
    const submitHandler = (event) => {
        // khong cho gui request len => khong bi. reload page
        event.preventDefault();

        const expenseData = {
            title: enteredTitle,
            amount: +enteredAmount,
            date: new Date(enteredDate)
        };

        // 58. Child-to-Parent Component Communication
        props.onSaveExpenseData(expenseData);

        // two way binding
        setEnteredTitle('');
        setEnteredAmount('');
        setEnteredDate('');

        setAddNewExpenseForm(!addNewExpenseForm);
    }

    const formHandler = () => {
        setAddNewExpenseForm(!addNewExpenseForm);
    }

    // display logic
    if(addNewExpenseForm === false) {
        return (
            <div className="new-expenses__add">
              <button onClick={formHandler}>Add New Expense</button>
            </div>
          );       
    }
    
    return (
        <form onSubmit={submitHandler}>
            <div className="new-expense__controls">
                <div className="new-expense__control">
                    <label>Title</label>
                    <input type="text" value={enteredTitle} onChange={titleChangeHandle}/>
                </div>
                <div className="new-expense__control">
                    <label>Amount</label>
                    <input type="number" value={enteredAmount} min="0.01" step="0.01" onChange={amountChangeHandle}/>
                </div>

                <div className="new-expense__control">
                    <label>Date</label>
                    <input type="date" value={enteredDate} min="2019-01-01" step="2022-12-31" onChange={dateChangeHandle}/>
                </div>
                <div className="new-expense__actions">
                    <button type="submit">Add Expense</button>
                    <button onClick={formHandler}>Cancel</button>
                </div>
            </div>
        </form>
        // checkNumber === 0 ? buttonNewExpense : expenseForm
    );
}

export default ExpenseForm;