using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Mvvm_Example
{
    class MainWindowViewModel
    {
        //Model 과 ViewModel의 결합
        private Model _getModel = new Model();
        public Model GetModel { get => _getModel; set => _getModel = value; }
        
        private Book _selectedItem;
        public Book SelectedItem { get => _selectedItem; set => _selectedItem = value; }

        public ICommand QueryData { get; set; }

        public MainWindowViewModel()
        {
            QueryData = new RelayCommand(GetData);
        }

        private void GetData(object sender)
        {
            this.GetModel.GetData();
        }
    }

    public class RelayCommand : ICommand
    {
        private Action<object> execute;
        private Func<object, bool> canExecute;

        public event EventHandler CanExecuteChanged
        {
            add { CommandManager.RequerySuggested += value; }
            remove { CommandManager.RequerySuggested -= value; }
        }

        public RelayCommand(Action<object> execute, Func<object, bool> canExecute = null)
        {
            this.execute = execute;
            this.canExecute = canExecute;
        }

        public bool CanExecute(object parameter)
        {
            return this.canExecute == null || this.canExecute(parameter);
        }

        public void Execute(object parameter)
        {
            this.execute(parameter);
        }
    }
}
