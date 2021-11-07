import './Card.css';

const Card = (props) => {
    // nhớ ôn lại đoạn này 
    const classes = 'card ' + props.className; 
    return (
        <div className={classes}>{props.children}</div> // children is a reserved name. giá  trị  của  children  will  be  always  the  content between opening and closing tags of component (take note 1)
    );
}

export default Card;