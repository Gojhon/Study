using ObservableCollection.Model;
using System.Collections.ObjectModel;

namespace ObservableCollection.ViewModel
{
    //ObservableCollection을 상속하는 클래스를 만들면
    //View에서 바인딩이 편리해짐.
    public class NameList : ObservableCollection<PersonName>
    {
        public NameList() : base()
        {
            Add(new PersonName("안", "창호"));
            Add(new PersonName("윤", "봉길"));
            Add(new PersonName("유", "관순"));
            Add(new PersonName("다카키", "마사오"));
            Add(new PersonName("오카모토", "미노루"));
        }
    }


}
