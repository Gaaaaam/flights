# 第三方支付服务
此支付服务使用RMI，服务的功能查看dependece包下的Payservice，相关依赖查看dependense包下的Payment类。  
  
  
使用服务的方法，创建RMIClient的实例对象，通过此对象调用相关方法即可。
  
   关于Payment 对象的说明  
   * String id，商家订单号  （必填，由平台方生成的唯一商家订单号）
   * String payer ，支付账号（必填）
   * String receiver，收款账号（必填）
   * BigDecimal transactionAmount，交易金额（必填）
   * Timestamp timestamp，时间戳
   * String serialNumber，交易序列号
      
方法  
String paycheck(Payment payment)   
参数：参照denpendense文件下payment对象进行实例化，参入参数即可调用服务。  
  
返回值：转换成字符串的JSON（jsonObject.tostring()），json中的内容如下：{“status”：状态码；”状态返回消息“：”具体提示信息“}  
* 状态码为100时，表示支付失败。提示信息为：支付失败，未提供商家订单号。
* 状态码为200时，表示支付成功。 提示信息为：支付成功。
* 状态码为400时，表示支付失败，交易中存在某一方账户无效。提示信息为：支付失败，交易中存在某一方账户无效或未输入。
* 状态码为500时，表示支付失败，付款方余额不足。提示信息为：支付失败，付款方余额不足。  


  
    
      
## 支付信息详情的接口  
支付详细信息如Payment类定义，详细信息会在支付成功后存在第三方， 如需查询详细信息，可以调用相关的接口。  
接口如下：1、获取关于一个用户的全部支付订单详情




