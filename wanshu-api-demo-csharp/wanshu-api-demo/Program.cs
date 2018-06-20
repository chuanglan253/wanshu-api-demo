using System;

namespace wanshu_api_demo
{
	class Program
	{
		public static void Main(string[] args)
		{
			while(true){
				Console.WriteLine("请输入项目代号:1.羊毛党检测 2.空号检测 3.身份认证 4.银行卡认证 5.企业工商 6.企业信用 7.司法风险 8.知识产权 9.图片OCR 10. 人证核验 99.余额查询 0.退出");

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
						Console.WriteLine("5.股东信息	6.历史曾用名	7.联系信息	8.模糊查询");
						Console.WriteLine("9.年报列表	10.年报详情	11.三要素认证	12.营业执照");
						Console.WriteLine("13.纳税人识别号");
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
								new LiShiCengYongMingApi().Check();
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
							case "13":
								new NaShuiRenShiBieHaoApi().Check();
								break;
							default:
								Console.WriteLine("输入错误");
								break;
						}
						break;
					case "6":
						Console.WriteLine("请输入子项目代号:");
						Console.WriteLine("1.抽查检查	2.动产抵押	3.股权出质	4.经营异常");
						Console.WriteLine("5.纳税信用	6.欠税信息	7.行政处罚	8.严重违法");
						string str_biz1 = Console.ReadLine();
						switch(str_biz1){
							case "1":
								new ChouChaJianChaApi().Check();
								break;
							case "2":
								new DongChanDiYaApi().Check();
								break;
							case "3":
								new GuQuanChuZhiApi().Check();
								break;
							case "4":
								new JingYingYiChangApi().Check();
								break;
							case "5":
								new NaShuiXinYongApi().Check();
								break;
							case "6":
								new QianShuiXinXiApi().Check();
								break;
							case "7":
								new XingZhengChuFaApi().Check();
								break;
							case "8":
								new YanZhongWeiFaApi().Check();
								break;
							default:
								Console.WriteLine("输入错误");
								break;
						}
						break;
					case "7":
						Console.WriteLine("请输入子项目代号:");
						Console.WriteLine("1.被执行人	2.法院公告	3.法院诉讼	4.开庭公告	5.失信信息");
						string str_biz2 = Console.ReadLine();
						switch(str_biz2){
							case "1":
								new BeiZhiXingRenApi().Check();
								break;
							case "2":
								new FaYuanGongGaoApi().Check();
								break;
							case "3":
								new FaYuanSuSongApi().Check();
								break;
							case "4":
								new KaiTingGongGaoApi().Check();
								break;
							case "5":
								new ShiXinXinXiApi().Check();
								break;
							default:
								Console.WriteLine("输入错误");
								break;
						}
						break;
					case "8":
						Console.WriteLine("请输入子项目代号:");
						Console.WriteLine("1.软件著作权	2.商标信息	3.域名备案	4.专利信息	5.作品著作权");
						string str_biz3 = Console.ReadLine();
						switch(str_biz3){
							case "1":
								new RuanJianZhuZuoQuanApi().Check();
								break;
							case "2":
								new ShangBiaoXinXiApi().Check();
								break;
							case "3":
								new YuMingBeiAnApi().Check();
								break;
							case "4":
								new ZhuanLiXinXiApi().Check();
								break;
							case "5":
								new ZuoPinZhuZuoQuanApi().Check();
								break;
							default:
								Console.WriteLine("输入错误");
								break;
						}
						break;
					case "9":
						Console.WriteLine("请输入子项目代号:");
						Console.WriteLine("1.身份证OCR");
						string str_biz4 = Console.ReadLine();
						switch(str_biz4){
							case "1":
								new IdOcrApi().Check();
								break;
							default:
								Console.WriteLine("输入错误");
								break;
						}
						break;
					case "10":
						Console.WriteLine("请输入子项目代号:");
						Console.WriteLine("1.活体检测	2.人证对比	3.人证核验");
						string str_biz5 = Console.ReadLine();
						switch(str_biz5){
							case "1":
								new HuoTiJianCeApi().Check();
								break;
							case "2":
								new RenZhengDuiBiApi().Check();
								break;
							case "3":
								new RenZhengHeYanApi().Check();
								break;
							default:
								Console.WriteLine("输入错误");
								break;
						}
						break;
					case "99":
						new YuEChaXunApi().Check();
						break;;
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
