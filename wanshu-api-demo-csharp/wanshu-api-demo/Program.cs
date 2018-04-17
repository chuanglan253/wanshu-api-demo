using System;

namespace wanshu_api_demo
{
	class Program
	{
		public static void Main(string[] args)
		{
			while(true){
				Console.WriteLine("请输入需要检测的项目(1：羊毛党检测	2：空号检测	3：身份认证	4：银行卡认证 0：退出）");
				string str = Console.ReadLine();
				switch(str){
					case "1":
						new YangmaodangApi().Check();
						break;
					case "2":
						new KonghaoApi().Check();
						break;
					case "3":
						new ShenfenApi().Check();
						break;
					case "4":
						new YinhangkaApi().Check();
						break;
					case "0":
						return;
					default:
						Console.WriteLine("输入不合法");
						break;
				}
				Console.WriteLine();
			}
		}
	}
}
