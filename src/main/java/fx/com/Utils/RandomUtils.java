package fx.com.Utils;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 生成随机码工具类
 *
 * @author jerryfu
 */
public class RandomUtils {
    private static final String INT = "123456789";
    private static final String INTS = "0123456789";
    private static final String STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random rd = new Random();

    //    private RandomUtils() {
//    }
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 按行读取txt文件并返回一个List<String>集合
     *
     * @param path 文件路径
     * @return List<String>
     */
    public static List<String> txt2UrlList(String path) {
        List<String> strList = new ArrayList<>();
        File file = new File(path);
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            // 将字节流向字符流转换
            inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            // 创建字符流缓冲区
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            // 按行读取
            while ((line = bufferedReader.readLine()) != null) {
                strList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        HashSet<String> h = new HashSet<>(strList);
        strList.clear();
        strList.addAll(h);
        return strList;
    }

    /**
     * 向文件中写入内容
     *
     * @param filepath 文件路径与名称
     * @param newstr   写入的内容
     * @return
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath, String newstr) throws IOException {
        boolean bool = false;
        String filein = newstr + "\r\n";//新写入的行，换行
        String temp = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();

            //文件原有内容
            for (int i = 0; (temp = br.readLine()) != null; i++) {
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }

    /**
     * 函数功能说明：生成0-9的随机码. Administrator 2015-9-8 修改者名字 修改日期 修改内容
     *
     * @return String
     * @throws
     * @参数： @param length
     * @参数： @return
     */
    public static String randomInts(int length) {

        return random(length, RndType.INTS);
    }

    public static int randomInt(int length) {

        return Integer.parseInt(random(length, RndType.INT));
    }

    /**
     * 函数功能说明：生成a-z的随机码. Administrator 2015-9-8 修改者名字 修改日期 修改内容
     *
     * @return String
     * @throws
     * @参数： @param length
     * @参数： @return
     */
    public static String randomStr(int length) {
        return random(length, RndType.STRING);
    }

    /**
     * 函数功能说明：成长数字加字母的随机码. Administrator 2015-9-8 修改者名字 修改日期 修改内容
     *
     * @return String
     * @throws
     * @参数： @param length
     * @参数： @return
     */
    public static String randomAll(int length) {
        return random(length, RndType.ALL);
    }

    private static String random(int length, RndType rndType) {
        StringBuilder s = new StringBuilder();
        char num = 0;
        for (int i = 0; i < length; i++) {
            if (rndType.equals(RndType.INT)) {
                num = INT.charAt(rd.nextInt(INT.length()));// 产生数字0-9的随机数
            } else if (rndType.equals(RndType.INTS)) {
                num = INTS.charAt(rd.nextInt(INTS.length()));
            } else if (rndType.equals(RndType.STRING)) {
                num = STR.charAt(rd.nextInt(STR.length()));// 产生字母a-z的随机数
            } else {
                num = ALL.charAt(rd.nextInt(ALL.length()));
            }
            s.append(num);
        }
        return s.toString();
    }

    public enum RndType {
        INT, STRING, ALL, INTS
    }
}
