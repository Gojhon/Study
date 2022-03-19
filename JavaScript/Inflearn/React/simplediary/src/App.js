import "./App.css";
import DiaryEditor from "./DiaryEditor";
import DiaryList from "./DiaryList";

const dummyList = [
  {
    id: 1,
    author: "고요한",
    content: "문정택 바보",
    emotion: 3,
    created_date: new Date().getTime(),
  },
  {
    id: 2,
    author: "고요한",
    content: "문정택 바보",
    emotion: 4,
    created_date: new Date().getTime(),
  },
  {
    id: 3,
    author: "고요한",
    content: "문정택 바보",
    emotion: 5,
    created_date: new Date().getTime(),
  },
  {
    id: 4,
    author: "고요한",
    content: "문정택 바보",
    emotion: 2,
    created_date: new Date().getTime(),
  },
  {
    id: 5,
    author: "고요한",
    content: "문정택 바보",
    emotion: 4,
    created_date: new Date().getTime(),
  }
];
function App() {
  return (
    <div className="App">
      <h2>일기장</h2>
      <DiaryEditor />
      <DiaryList DiaryList={dummyList} />
    </div>
  );
}

export default App;
