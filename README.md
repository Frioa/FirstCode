# FirstCode
Android第一行代码，基础知识练习
# Broadcast
onReceive() 接受广播，并执行具体逻辑。<br/>
广播可以被其他程序接收.<br/>

1.动态广播<BR/>
  (1) 代码中注册.<BR/>
  (2) 自由控制注册与注销，但只有程序启动之后才能接收广播.<BR/>
  (3) 动态广播使用后一定要注销.<BR/>
  
2.静态广播<BR/>
  (1) AndroidManifest.xml 中注册<BR/>
  (2) 程序未启动可以收到广播<BR/>
  
### 自定义广播<br/>
1.标准广播<br/>
(1) AndroidManifest.xml 中注册<BR/>
(2) Intend 对象   Intent intent = new Intent("com.example.broadcasttest.MY_BROADCASE"); 发送广播,同时可以携带数据<br/>

2.有序广播<br/>
(1)  使用sendOrderedBroadcast(intent,null);发送广播.<br/>
(2） 有序广播AndroidManifest.xml设置优先级，使用abortBroadcast();广播截断

### 本地广播<br/>
1 能在本程序内接受广播，防止关键数据别截获
2 接收其他应用发出的垃圾广播
3 全局广播更为高效

（1) 无法通过静态注册接收

# 自定义日历控件<BR/>
1.自定义View，onDraw() 的绘制
2.自定义Attribute 
3.自定义View的响应事件

