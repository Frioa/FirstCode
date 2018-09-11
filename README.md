# FirstCode
Android第一行代码，基础知识练习
# Broadcast
onReceive() 接受广播，并执行具体逻辑。

1.动态广播<BR/>
  (1) 代码中注册.<BR/>
  (2) 自由控制注册与注销，但只有程序启动之后才能接收广播.<BR/>
  (3) 动态广播使用后一定要注销.<BR/>
  
2.静态广播<BR/>
  (1) AndroidManifest.xml 中注册<BR/>
  (2) 程序未启动可以收到广播<BR/>
  
# 自定义广播<br/>
1.标准广播<br/>
(1) AndroidManifest.xml 中注册<BR/>
(2) Intend 对象   Intent intent = new Intent("com.example.broadcasttest.MY_BROADCASE"); 发送广播,同时可以携带数据<br/>
