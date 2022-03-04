using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using booksSys.pojo;
using Newtonsoft.Json;

namespace booksSys.UIs
{
    public partial class FormAddBook : Form
    {
        public FormAddBook()
        {
            InitializeComponent();
        }
        static string URL = "http://localhost:8080/books/";

        private async void button1_Click(object sender, EventArgs e)
        {
            Book book = new Book();
            book.id = Convert.ToInt32(textBox1.Text.Trim());
            book.name = textBox2.Text.Trim();
            book.type = textBox3.Text.Trim();
            book.description = textBox4.Text.Trim();
            //将对象进行json格式化

            string v = JsonConvert.SerializeObject(book);
            HttpClient client = new HttpClient();
            HttpContent content = new StringContent(v);
            //用来告诉服务端消息主体是序列化后的 JSON 字符串,
            //由于 JSON 规范的流行，服务端语言也都有处理 JSON 的函数
            content.Headers.ContentType = new System.Net.Http.Headers.MediaTypeHeaderValue("application/json");
            HttpResponseMessage task = await client.PostAsync(URL, content);
            if (task.IsSuccessStatusCode)
            {
                MessageBox.Show("添加成功!");
            }
            else
            {
                MessageBox.Show("添加失败！");

            }
        }
    }
}
