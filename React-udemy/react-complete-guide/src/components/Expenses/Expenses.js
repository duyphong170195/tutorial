import { useState } from 'react';
import Card from "../UI/Card";
import './Expenses.css';
import ExpensesFilter from "./ExpensesFilter";
import ExpensesList from './ExpensesList';
import ExpensesChart from './ExpensesChart';

const Expenses = (props) => {

  const [filteredYear, setFilteredYear] = useState('2021');

  const filterChangeHandle = (selectedYear) => {
    setFilteredYear(selectedYear);
  }

  const expenseElements = props.expenseData.filter(expense => expense.date.getFullYear().toString() === filteredYear);

    return (
      <div>
        <Card className = "expenses">
            <ExpensesFilter selected={filteredYear} onChangeFilter={filterChangeHandle} />
            <ExpensesChart expenses={expenseElements}/>
            <ExpensesList items={expenseElements}/>
        </Card>
        </div>
    );
}

export default Expenses;
