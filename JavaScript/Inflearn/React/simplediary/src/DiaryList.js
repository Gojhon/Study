import DiaryItem from "./DiaryItem";

const DiaryList = ({ DiaryList }) => {
  
  return (
    <div className="DiaryList">
      <h2>일기리스트</h2>
      <h4>{DiaryList.length}개의 일기가 있습니다.</h4>
      <div>
        {DiaryList.map((it) => (
          <DiaryItem key={it.id} {...it}/>  
          
        ))}
      </div>
    </div>
  );
};

DiaryList.defaultProps = {
  DiaryList: [],
};

export default DiaryList;
