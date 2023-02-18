using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FormsMain
{
    public class KimoViewModel
    {

        public string Name { get; set; }
        public bool IsTest { get; set; }

        public KimoViewModel()
        {
            Name = "kimo";
            IsTest = true;
        }

    }
}
