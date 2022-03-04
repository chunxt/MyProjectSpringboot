using booksSys.pojo;
using Newtonsoft.Json;
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

namespace booksSys.UIs
{
    public partial class FormUpdate : Form
    {
        public FormUpdate()
        {
            InitializeComponent();
        }
        static string URL = "http://localhost:8080/books/";
        private async void button1_Click(object sender, EventArgs e)
        {
            HttpClient client = new HttpClient();
            Book book = new Book();
            book.id =Convert.ToInt32(textBox1.Text);
            book.name =textBox2.Text;
            book.type = textBox3.Text;
            book.description =textBox4.Text;
            string str = JsonConvert.SerializeObject(book);
            HttpContent content = new StringContent(str);
            //用来告诉服务端消息主体是序列化后的 JSON 字符串。
            //由于 JSON 规范的流行，服务端语言也都有处理 JSON 的函数
            content.Headers.ContentType = new System.Net.Http.Headers.MediaTypeHeaderValue("application/json");
            HttpResponseMessage response = await client.PutAsync(URL, content);
            if (response.IsSuccessStatusCode)
            {
                MessageBox.Show("修改成功！");
            }
            else
                MessageBox.Show("修改失败！");
            
        }
    }
}
