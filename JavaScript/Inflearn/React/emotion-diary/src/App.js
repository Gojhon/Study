import './App.css';
import {BrowserRouter, Route,Routes} from "react-router-dom";

import Home from './pages/Home'
import Edit from './pages/Edit'
import New from './pages/New'
import Diary from './pages/Diary'

import RouteTest from './componets/RouteTest';
import Mybutton from './componets/MyButton';
import Myheader from './componets/MyHeader';

function App() {

  const env = process.env;
  env.PUBLIC_URL=env.PUBLIC_URL || "";
  return (
    <BrowserRouter>
    <div className="App">
      <Myheader headText={"App"} 
      leftChild={
      <Mybutton text={"왼쪽 버튼"} onClick={() => alert("왼쪽 클릭")}/>
      }
      rightChild={
        <Mybutton
        text={"오른쪽 버튼"}
        onClick={() =>alert("오른쪽 클릭")}/>
      }
      
      />
      
      <h2>App.js</h2>
      <img src={process.env.PUBLIC_URL + `/assets/emotion1.png`}/>
      <img src={process.env.PUBLIC_URL + `/assets/emotion2.png`}/>
      <img src={process.env.PUBLIC_URL + `/assets/emotion3.png`}/>
      <img src={process.env.PUBLIC_URL + `/assets/emotion4.png`}/>
      <img src={process.env.PUBLIC_URL + `/assets/emotion5.png`}/>
      <Mybutton 
       text={"버튼"} 
       onClick={() => alert("버튼 클릭")}
       type={"positive"}/>

      <Mybutton 
       text={"버튼"} 
       onClick={() => alert("버튼 클릭")}
       type={"negative"}/>
      <Mybutton 
       text={"버튼"} 
       onClick={() => alert("버튼 클릭")}
       />

      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/new' element={<New/>}/>
        <Route path='/edit' element={<Edit/>}/>
        <Route path='/diary' element={<Diary/>}/>
      </Routes>
      <RouteTest/>
    </div>
    </BrowserRouter>
  );
}

export default App;
