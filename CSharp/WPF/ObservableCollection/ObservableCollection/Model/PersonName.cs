using System;
using System.Collections.Generic;
using System.Text;

namespace ObservableCollection.Model
{
    public class PersonName
    {
        private string firstName;
        private string lastName;

        public PersonName(string first, string last)
        {
            this.firstName = first;
            this.lastName = last;
        }

        public string FirstName
        {
            get { return firstName; }
            set { firstName = value; }
        }

        public string LastName
        {
            get { return lastName; }
            set { lastName = value; }
        }
    }


}
