const Mybutton =({text,type,onClick}) =>
{
    return (
        <button className={["MyButton",`MyButton_${type}`].join(" ")}
         onClick={onClick}>
         {text}
        </button>
    )
}

Mybutton.defaultProps={
    type:"default",
};


export default Mybutton;