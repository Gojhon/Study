import logo from "./logo.svg";
import "./App.css";
import { useState, useEffect } from "react";

function App() {
  const [color, setColor] = useState();

  const changeColor = (color) => {
    setColor(color);
  };

  return (
    <div>
      <div
        style={{
          width: "200px",
          height: "100px",
          margin: "12px auto",
          backgroundColor: color,
          border: "solid 1px #ccc",
        }}
      ></div>
      <div>
        <button onClick={() => changeColor("#f00")}>Red</button>
        <button onClick={() => changeColor("#000")}>Black</button>
        <button onClick={() => changeColor("#0f0")}>Green</button>
        <button onClick={() => changeColor("#f0f")}>Pink</button>

      </div>
    </div>
  );
}

export default App;
