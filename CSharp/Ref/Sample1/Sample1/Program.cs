using System;

namespace Sample1
{
    class Program
    {
        //https://tyeom.github.io/ 에 있는 내용을 연습삼아 작성하였습니다.
        static void Main(string[] args)
        {
            int num1 = 1;
            ref int num2 = ref num1;
            num1 = 2;


            Console.WriteLine($"num1 : {num1}");
            Console.WriteLine($"num2 : {num2}");
            //num2 로컬 변수에 num1의 값을 참조 형태로 전달한 결과 num1의 값이 변경될때 같이 영향을 받습니다.
            //당연히 그 반대로 num2의 값이 변경 되었을때 num1변수가 영향 받습니다.
            
            int num3= 1;
            ref readonly int num4 = ref num3;
            num3 = 2;
            Console.WriteLine($"num3 : {num3}");
            Console.WriteLine($"num4 : {num4}");


            var bc = new BookCollection();
            bc.ListBooks();

            ref var book = ref bc.GetBookByTitle("Call of the Wild, The");
            if (book != null)
                book = new Book { Title = "Republic, The", Author = "Plato" };
            //"Call of the Wild, The" 객체를 수정한다!
            bc.ListBooks();
        }
    }

    public class Book
    {
        public string Author;
        public string Title;
    }

    public class BookCollection
    {
        private Book[] books = { new Book { Title = "Call of the Wild, The", Author = "Jack London" },
                        new Book { Title = "Tale of Two Cities, A", Author = "Charles Dickens" }
                       };
        private Book nobook = null;

        // Book객체를 참조형식으로 반환
        public ref Book GetBookByTitle(string title)
        {
            for (int ctr = 0; ctr < books.Length; ctr++)
            {
                if (title == books[ctr].Title)
                    return ref books[ctr];
            }
            return ref nobook;  // 참조 반환
        }

        public void ListBooks()
        {
            foreach (var book in books)
            {
                Console.WriteLine($"{book.Title}, by {book.Author}");
            }
            Console.WriteLine();
        }
    }
}
