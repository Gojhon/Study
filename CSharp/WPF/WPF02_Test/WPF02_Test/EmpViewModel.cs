using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace WPF02_Test
{
    public class EmpList : ObservableCollection<EmpViewModel>
    {
        public EmpList()
        {
            Add(new EmpViewModel() { Empno = 1, Ename = "Jo", Job = "Programmer" });
            Add(new EmpViewModel() { Empno = 2, Ename = "Kim", Job = "Programmer" });
            Add(new EmpViewModel() { Empno = 3, Ename = "lee", Job = "Programmer" });
            Add(new EmpViewModel() { Empno = 4, Ename = "Cha", Job = "Programmer" });
            Add(new EmpViewModel() { Empno = 5, Ename = "Cho", Job = "Programmer" });
            Add(new EmpViewModel() { Empno = 6, Ename = "Min", Job = "Programmer" });
        }
    }

    public class EmpViewModel
    {
        int empno = 0;
        string ename = string.Empty;
        string job = string.Empty;

        public int Empno
        {
            get { return empno; }
            set { this.empno = value; }
        }

        public string Ename
        {
            get { return ename; }
            set { this.ename = value; }
        }

        public string Job
        {
            get { return job; }
            set { this.job = value; }
        }
    }

}
