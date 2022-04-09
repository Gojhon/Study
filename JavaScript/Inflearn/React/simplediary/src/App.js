import { useCallback, useEffect, useReducer, useRef, useState } from "react";
import "./App.css";
import DiaryEditor from "./DiaryEditor";
import DiaryList from "./DiaryList";
//import Lifecycle from "./Lifecycle";

const reducer = (state, action)=>{
  switch(action.type)
  {
    case 'INIT':
      {
        return action.data
      }
    case 'CREATE':
      {
        const created_date = new Date().getTime();
        const newItem = {
          ...action.data,
          created_date 
        };
        return [newItem,...state]
      }
    case 'REMOVE':{
      return state.filter((it)=>it.id !== action.targetId);
    }
    case 'EDIT': {
      return state.map((it)=>it.id === action.targetId?
      {...it,content : action.newContent} : it);
    }
    default : 
    return state;
  }
}

function App() {

  //const [data,setData] = useState([])

  const [data,dispatch] = useReducer(reducer,[])
  const dataId = useRef(0)

  const getData = async() =>{
    const res= await fetch("https://jsonplaceholder.typicode.com/comments").
    then((res) =>res.json());

    const initData= res.slice(0,20).map((it) =>
    {
      return {
        author :it.email,
        content : it.body,
        emotion : Math.floor(Math.random()*5)+1,
        created_date : new Date().getTime(),
        id:dataId.current++,
      };

    });
    
    setData(initData);
  };

  useEffect(()=>{
    getData();
  },[]);
  const onCreate = useCallback((author,content,emotion)=>{
    dispatch(
      {type:'CREATE',
    data:{ author,
           content,
           emotion,
           created_date,
           id : dataId.current
          }
        });
   
    dataId.current +=1;
 
  },[]);

  const onRemove = useCallback((targetId)=>{
    dispatch({type:"REMOVE",targetId})
    // console.log(`${targetId}가 삭제 되었습니다.`)
    // const newDiaryList = data.filter((it)=> it.id!==targetId);
    // console.log(newDiaryList);
    // setData(newDiaryList);
  },[]);

  const onEdit =useCallback((targetId,newContent) =>{
    // setData(
    //   data.map((it)=>it.id === targetId ? {...it,content : newContent} : it)
    // );
    dispatch({type:"EDIT",targetId,newContent})
  },[]);
  return (
    <div className="App">
      <h2>일기장</h2>
      <DiaryEditor onCreate={onCreate} />
      <DiaryList onEdit = {onEdit} onRemove={onRemove} DiaryList={data} />
    </div>
  );
}

export default App;
