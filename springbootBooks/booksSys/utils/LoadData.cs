using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using booksSys.pojo;

namespace booksSys.utils
{
    internal class LoadData
    {
        public void LoadBooks(ListView listView1, List<Book> books)
        {
            //先清除列表视图中每一行的视图
            listView1.Items.Clear();
            foreach (Book book in books)
            {
                ListViewItem item = new ListViewItem(Convert.ToString(book.id));
                //ListViewItem item = new ListViewItem();
                item.SubItems.Add(book.type);
                item.SubItems.Add(book.name);
                item.SubItems.Add(book.description);
                listView1.Items.Add(item);
            }
            
        }
    }
}
