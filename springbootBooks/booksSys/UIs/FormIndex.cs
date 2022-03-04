using booksSys.pojo;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using booksSys.utils;
using booksSys.UIs;

namespace booksSys.UIs
{
    public partial class FormIndex : Form
    {
        public FormIndex()
        {
            InitializeComponent();
        }
        static string URL = "http://localhost:8080/books/";
        private async void button1_Click(object sender, EventArgs e)
        {
            //查询
            HttpClient client = new HttpClient();
            //get请求
            HttpResponseMessage response = await client.GetAsync(URL);
            if (response.IsSuccessStatusCode)
            {
                //MessageBox.Show("查询成功！");
                response.EnsureSuccessStatusCode();
                /*string v = await response.Content.ReadAsStringAsync(); 
                //将返回的字符串反序列化为自定义的格式
                var res = JsonConvert.DeserializeObject<Format>(v);
                //取出数据部分
                List<Book> books = res.data;
                LoadData ld = new LoadData();    
                ld.LoadBooks(listView1, books);*/
                //获取响应的流
                var stream = await response.Content.ReadAsStreamAsync();

                using (var streamReader = new StreamReader(stream))
                {
                    using (var jsonTextReader = new JsonTextReader(streamReader))
                    {
                        var jsonSerializer = new JsonSerializer();
                        var data = jsonSerializer.Deserialize<Format>(jsonTextReader);
                        List<Book> lists = data.data;
                        LoadData ld = new LoadData();
                        ld.LoadBooks(listView1, lists);
                    }
                }

            }
            else
            {
                MessageBox.Show("查询失败！");
            }
            
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            //添加
            
                FormAddBook formAddBook = new FormAddBook();
                formAddBook.ShowDialog();
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            //修改
            if (listView1.CheckedItems.Count != 1)
            {
                MessageBox.Show("请勾选你要修改的项！");
            }
            else
            {
                FormUpdate formUpdate = new FormUpdate();
                formUpdate.ShowDialog();
            }
            

        }

        private async void button3_Click(object sender, EventArgs e)
        {
            //删除选中项
            if(listView1.CheckedItems.Count != 0)
            {
                HttpClient client=new HttpClient();
                foreach (ListViewItem item in listView1.CheckedItems)
                {
                    //int id = Convert.ToInt32(listView1.FocusedItem.Text);
                    int id = Convert.ToInt32(item.Text);

                    HttpResponseMessage task = await client.DeleteAsync(URL+"del/"+id);
                    if (task.IsSuccessStatusCode)
                    {
                        MessageBox.Show("删除成功！");
                    }
                    else
                    {
                        MessageBox.Show("删除失败！");
                    }
                    /*string v = await task.Content.ReadAsStringAsync();
                    Format format = JsonConvert.DeserializeObject<Format>(v);
                    List<Book> data = format.data;
                    var ld=new LoadData();
                    ld.LoadBooks(listView1,data);*/
                }
            }
           
           

        }
    }
}
