using System;
using System.Net.Http;
using httpdemo.pojo;
using Newtonsoft.Json;


namespace httpdemo
{
    internal class Program
    {     
        static async void TaskAsync()
        {
            using(var client = new HttpClient())
            {
                try
                {
                    user user1=new user();
                    user1.account = "root";
                    user1.password = "123456";
                    //java对象作为响应转换为json数据发回给客户端，称为序列化
                    var str =JsonConvert.SerializeObject(user1);

                   
                    HttpContent content = new StringContent(str);
                    content.Headers.ContentType =new System.Net.Http.Headers.MediaTypeHeaderValue("application/json");
                    
                    HttpResponseMessage response=await client.PostAsync("http://localhost:8080/aaa", content);
                    response.EnsureSuccessStatusCode();
                    string responseBody=await response.Content.ReadAsStringAsync();
                    Console.WriteLine(responseBody);
                }catch (Exception e)
                {
                    Console.WriteLine("\nException Caught!");
                    Console.WriteLine("Message :{0} ", e.Message);
                }
            }
        }
        static void Main(string[] args)
        {
            TaskAsync();
            Console.ReadLine();
        }
    }
}

