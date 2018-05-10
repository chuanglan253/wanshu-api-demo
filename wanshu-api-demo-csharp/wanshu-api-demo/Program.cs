using System;

namespace wanshu_api_demo
{
	class Program
	{
		public static void Main(string[] args)
		{
			while(true){
				Console.WriteLine("请输入项目代号:1.羊毛党检测	2.空号检测	3.身份认证	4.银行卡认证	5.企业工商查询	0.退出");

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
					case "5":
						Console.WriteLine("请输入子项目代号:");
						Console.WriteLine("1.变更记录	2.董监高	3.对外投资	4.分支机构");
						Console.WriteLine("5.股东信息	6.经营异常	7.联系信息	8.模糊查询");
						Console.WriteLine("9.年报列表	10.年报详情	11.三要素认证	12.营业执照");
						string str_biz = Console.ReadLine();
						switch(str_biz){
							case "1":
								new BianGengJiLuApi().Check();
								break;
							case "2":
								new DongJianGaoApi().Check();
								break;
							case "3":
								new DuiWaiTouZiApi().Check();
								break;
							case "4":
								new FenZhiJiGouApi().Check();
								break;
							case "5":
								new GuDongXinXiApi().Check();
								break;
							case "6":
								new JingYingYiChangApi().Check();
								break;
							case "7":
								new LianXiXinXiApi().Check();
								break;
							case "8":
								new MoHuChaXunApi().Check();
								break;
							case "9":
								new NianBaoLieBiaoApi().Check();
								break;
							case "10":
								new NianBaoXiangQingApi().Check();
								break;
							case "11":
								new SanYaoSuApi().Check();
								break;
							case "12":
								new YingYeZhiZhaoApi().Check();
								break;
							default:
								Console.WriteLine("输入错误");
								break;
						}
						break;
					case "0":
						return;
					default:
						Console.WriteLine("输入错误");
						break;
				}
				Console.WriteLine();
			}
		}
	}
}
