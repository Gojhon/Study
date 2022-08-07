using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using WpfStudy.Models;

namespace WpfStudy
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnTest1_Click(object sender, RoutedEventArgs e)
        {
            List<User> myList1 = new List<User>();

            labeltest1.Content = "내용 변경 완료";
            //MessageBox.Show(TextBox1.Text);

            User userA = new User();
            userA.UserImg = @"C:\Users\kimo8\Documents\GitHub\Study\CSharp\WPF\WpfStudy\WpfStudy\image.png";
            userA.Name = "Noah";
            userA.UserAge = 15;

            User userB = new User();
            userB.UserImg = @"C:\Users\kimo8\Documents\GitHub\Study\CSharp\WPF\WpfStudy\WpfStudy\image.png";
            userB.Name = "Liam";
            userB.UserAge = 15;

            myList1.Add(userA);
            myList1.Add(userB);

            listView1.ItemsSource = myList1;


        }
    }
}
