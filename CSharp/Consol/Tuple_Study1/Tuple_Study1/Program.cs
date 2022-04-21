using System;
using System.Collections.Generic;

namespace Tuple_Study1
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Tuple<int, string, string>> Character = new List<Tuple<int, string, string>>();

            Character.Add(new Tuple<int, string, string>(14, "타이", "전사"));
            Character.Add(new Tuple<int, string, string>(21, "포프", "마법사"));
            Character.Add(new Tuple<int, string, string>(24, "아방", "기사"));
            Character.Add(new Tuple<int, string, string>(45, "마암", "전사"));
            Character.Add(new Tuple<int, string, string>(51, "흉켈", "전사"));
                                            
            for (int idx = 0; idx < Character.Count; idx++)
            {
                Console.WriteLine("{0} : {1} : {2}", Character[idx].Item1, Character[idx].Item2, Character[idx].Item3);
            }

        }
    }
}
