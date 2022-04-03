using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.ObjectModel;   //ObservableCollection을 추가하기 위함.

namespace Mvvm_Example
{
    class Model
    {
        //Binding View에 Notify기능이 첨가된 WPF전용 리스트인 ObservableCollection을 Property로 Define.
        private ObservableCollection<Book> _book = new ObservableCollection<Book>();        
        public ObservableCollection<Book> Books
        {
            get
            {
                return _book;
            }

            set
            {
                _book = value;
            }
        }

        // 1. DB에서 데이터를 가져왔다고 가정하고 DataTable의 자료를 Products로 이동.
        public void GetData()
        {
            //DB에서 데이터 가져옴.
            Books.Add(new Book { ID = 1, Title = "제프리 리처의 CLR via C#", Price = 50000 ,Publisher= "비제이퍼블릭(BJ퍼블릭)" });
            Books.Add(new Book { ID = 2, Title = "찰스 페졸드의 Programming Windows", Price = 52000, Publisher= "비제이퍼블릭(BJ퍼블릭)" });
            Books.Add(new Book { ID = 3, Title = "스티브 맥코넬의 Code Complete", Price = 48000 ,Publisher="위키북스"});
            Books.Add(new Book { ID = 4, Title = "천재동민의 프로그래밍의 정석", Price = 98000 ,Publisher="닷넷오픈채팅방"});
            Books.Add(new Book { ID = 5, Title = "천재동민의 나눔코딩", Price = 0 ,Publisher= "닷넷오픈채팅방" });
        }

        // 2. GetData 후 별도 과정이 필요하면...
        private void SetData()
        {

        }

    }

    class Book
    {
        public int ID { get; set; }
        public string Title { get; set; }
        public int Price { get; set; }
        public string Publisher { get; set; }
    }
}
