import React from 'react';
import './App.css';
import MyHeader from "./MyHeader"

function App() {
  let name = "고요한"
  
  return (
   <div className='App'>
      <MyHeader />
        <h2>안녕 리엑트 {name}</h2>
        <b id="bold_text">React.js</b>
   </div>
  );
}

export default App;
