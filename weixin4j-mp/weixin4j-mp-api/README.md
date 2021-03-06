weixin4j-mp-api
===============

[微信公众平台](http://mp.weixin.qq.com/wiki)开发工具包
----------------------------------------------------

功能列表
-------

* MediaApi `上传/下载媒体文件API`

* NotifyApi `客服消息API`

* CustomApi `多客服API`

* MassApi `群发消息API`

* UserApi `用户管理API`

* GroupApi `分组管理API`

* MenuApi `底部菜单API`

* QrApi `二维码API`

* TmplApi `模板消息API`

* HelperApi `辅助API`

* Pay2Api `V2支付API`
  
* Pay3Api `V3支付API`

* CouponApi `代金券API`

* DataApi `数据统计API`

* OauthApi `oauth授权API`

* CashApi `现金API`

如何使用
--------
1.API工程可以单独打包到其他项目中使用,需新增或拷贝`weixin.properties`文件到项目的`classpath`中

weixin.properties说明

| 属性名         |       说明      |
| :----------	| :-------------- |
| account     	| 微信公众号信息 `json格式`  |
| token_path  	| 使用FileTokenHolder时token保存的物理路径 |
| qr_path     	| 调用二维码接口时保存二维码图片的物理路径 |
| media_path  	| 调用媒体接口时保存媒体文件的物理路径 |
| bill_path   	| 调用下载对账单接口保存excel文件的物理路径 |
| ca_file     	| 调用某些接口(支付相关)强制需要auth的ca授权文件 |
| redirect_uri     | 调用OauthApi接口时需要填写的重定向路径 |

示例(properties中换行用右斜杆\\)

	account={"id":"appId","secret":"appSecret",\
		"token":"开放者的token",\
		"encodingAesKey":"公众号设置了加密方式且为「安全模式」时需要填入",\
		"mchId":"V3.x版本下的微信商户号",\
		"partnerId":"财付通的商户号",\
		"partnerKey":"财付通商户权限密钥Key",\
		"version":"针对微信支付的版本号(2,3),如果不填则按照mchId非空与否来判断",\
		"paySignKey":"微信支付中调用API的密钥"}
	
	token_path=/tmp/weixin/token
	qr_path=/tmp/weixin/qr
	media_path=/tmp/weixin/media
	bill_path=/tmp/weixin/bill
	# ca证书存放的完整路径 (V2版本后缀为*.pfx,V3版本后缀为*.p12)
	ca_file=/tmp/weixin/xxxxx.p12
	#classpath路径下:ca_file=classpath:xxxxx.p12
	
	#微信登陆授权的重定向路径
	redirect_uri=http://xxx

2.实例化一个`WeixinProxy`对象,调用API,需要强调的是如果只传入appid,appsecret两个参数将无法调用支付相关接口

    WeixinProxy weixinProxy = new WeixinProxy();
    // weixinProxy = new WeixinProxy(appid,appsecret);
    // weixinProxy = new WeixinProxy(weixinAccount);
    weixinProxy.getUser(openId);

3.针对`token`存储有两种方案,`File存储`/`Redis存储`,当然也可自己实现`TokenHolder`,默认使用文件(xml)的方式保存token,如果环境中支持`redis`,建议使用`RedisTokenHolder`.

    WeixinProxy weixinProxy = new WeixinProxy(new RedisTokenHolder());
    // weixinProxy = new WeixinProxy(new RedisTokenHolder(weixinAccount));
    
4.`mvn package`.
	
更新LOG
-------
* 2014-10-27

  + 用netty构建http服务器&消息分发

* 2014-10-28
   
  + 调整`ActionMapping`抽象化
   
* 2014-10-31

  + `weixin.properties`切分为API调用地址和公众号appid等信息两部分
   
* 2014-11-03

  + 分离为`weixin-mp-api`和`weixin-mp-server`两个工程
   
  + 新增`支付模块`

* 2014-11-06
 
  + 新增V3版本`退款申请`接口
  
* 2014-11-08
 
  + 新增V2版本`退款申请`、`退款查询`、`对账单下载`三个接口
  
  + 新增一个简单的`语义理解`接口

* 2014-11-11

  + 自定义`assembly`将`weixin4j-base`工程也一起打包(`weixin4j-mp-api-full.jar`)
 
* 2014-11-15

  + 新增获取`微信服务器IP地址接口`
  
* 2014-11-16

  + 新增`多客服`接口
 
* 2014-11-17

  + 新增`冲正`和`被扫支付`接口
  
* 2014-12-12

  + 新增设置`模板消息所处行业`、`获取模板消息ID`接口
  
* 2014-12-16

  + 调整方法上@see注解的文档说明接口url
  
  + 新增群发消息预览、状态查询接口
  
  + 新增多客服添加账号、更新账号、上传头像、删除账号接口
  
* 2015-01-04

  + 支付模块拆分为V2跟V3,新增WeixinPayProxy类
  
  + 退款相关类拆分为V2跟V3
  
  + 新增接口上报接口
  
* 2015-01-31
  
  + 新增数据分析接口
  
* 2015-03-06
  
  + 新增oauth授权接口
  
* 2015-03-21

  + 新增群发消息给所有人接口
  
  + 新增素材管理多个接口
  
  + 新增多客服会话管理多个接口
  
* 2015-03-25

  + 根据《微信商户平台文档》修缮[Pay3Api](./src/main/java/com/foxinmy/weixin4j/mp/api/Pay3Api.java)类
  
* 2015-03-29

  + 单行注释调整为多行文档注释
  
  + 新增[CouponApi](./src/main/java/com/foxinmy/weixin4j/mp/api/CouponApi.java)代金券接口
  
* 2015-04-01

  + 新增[CashApi](./src/main/java/com/foxinmy/weixin4j/mp/api/CashApi.java)发红包、企业付款接口