package com.byc.merchants.merchants_cms.util;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ValidatorUtils {


    public static boolean isEmpty(String str) {

        return ((str == null) || (str.trim().length() == 0));
    }

    public static boolean isNotEmpty(String str) {
        if (str == null) {
            return false;
        }

        return ((str != null) && (str.trim().length() > 0) && !"null".equals(str.trim()));
    }

    public static boolean isNotEmpty(@SuppressWarnings("rawtypes") Map result) {
        if (result != null && !result.isEmpty() && result.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(@SuppressWarnings("rawtypes") Map result) {
        return !isNotEmpty(result);
    }

    public static boolean isNotEmpty(@SuppressWarnings("rawtypes") List result) {
        if (result != null && !result.isEmpty() && result.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(@SuppressWarnings("rawtypes") List result) {
        return !isNotEmpty(result);
    }

    public static boolean isNotEmpty(@SuppressWarnings("rawtypes") Set result) {
        if (result != null && !result.isEmpty() && result.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(@SuppressWarnings("rawtypes") Set result) {
        return !isNotEmpty(result);
    }

    public static boolean isNotNull(String str) {
        if (str == null) {
            return false;
        }
        return ((str != null) && (str.trim().length() > 0) && !"null"
                .equals(str.trim()));
    }

    public static boolean isNotNull(Object obj) {
        if (obj == null) {
            return false;
        }
        return isNotNull(obj + "");
    }

    public static boolean isNull(Object obj) {
        return !isNotNull(obj);
    }

    public static boolean isNull(String str) {
        return !isNotNull(str);
    }

    public static boolean isNotNull(Integer str) {
        if (str == null) {
            return false;
        }
        return true;
    }

    public static boolean isNull(Integer str) {
        return !isNotNull(str);
    }

    public static boolean isNotNull(Long str) {
        if (str == null) {
            return false;
        }
        return true;
    }

    public static boolean isNull(Long str) {
        return !isNotNull(str);
    }

    public static boolean isNotNull(Date str) {
        if (str == null) {
            return false;
        }
        return true;
    }

    public static boolean isNull(Date str) {
        return !isNotNull(str);
    }


    public static boolean isBlank(String str) {

        int length = 0;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkString(String str, String regex) {

        return str.matches(regex);
    }

    public static boolean isMd5(String md5) {

        if (md5.length() != 32) {
            return false;
        }

        return checkString(md5, "[0-9A-Fa-f]+");
    }

    public static boolean isLoginMobile(String code) {
        code = StringUtils.nullToStrTrim(code);
        if (isNull(code)) {
            return false;
        }
        if (code.length() != 11) {
            return false;
        }
        String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";

        boolean flg = code.matches(regex);
        if (!flg) {
            return false;
        }
        return true;
    }

    public static boolean isPassword(String password) {
        password = StringUtils.nullToStrTrim(password);
        if (password.length() < 6 || password.length() > 20) {
            return false;
        }
        return true;
    }

    public static String nullToStrTrim(String str) {
        if (str == null) {
            str = "";
        }
        return str.trim();
    }

    public static boolean isInfoCode(String code) {

        code = nullToStrTrim(code);
        if (code.length() != 6) {
            return false;
        }

        String regex = "^([1-9])\\d{5}$";

        return code.matches(regex);
    }

    /**
     * 校验身份证长度
     *
     * @param cardNo
     * @return
     * @author lgh
     */
    public static boolean isCardNoLength(String cardNo) {

        cardNo = nullToStrTrim(cardNo);
        cardNo = cardNo.replaceAll(" ", "");
        if (cardNo.length() == 15 || cardNo.length() == 18) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是姓名
     *
     * @param name
     * @return
     * @author lgh
     */
    public static boolean isRealName(String name) {

        name = nullToStrTrim(name);
        name = name.replaceAll(" ", "");
        String regex = "^[\u4e00-\u9fa5]{2,20}$";
        return name.matches(regex);
    }

    /**
     * 手机号脱敏（例：18245671234 脱敏后返回 182****1234）
     *
     * @param
     * @return
     * @author lgh
     */
    public static String mobileEncrypt(String mobilePhone) {

        if (isEmpty(mobilePhone) || mobilePhone.length() != 11) {
            return mobilePhone;
        }

        mobilePhone = nullToStrTrim(mobilePhone);
        return mobilePhone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 验证码校验（四位且纯数字）
     *
     * @param code
     * @return
     * @author lgh
     */
    public static boolean isFourValidCode(String code) {

        code = nullToStrTrim(code);
        String regex = "^\\d{4}$";
        return code.matches(regex);
    }

    /**
     * 身份证脱敏
     *
     * @param cardNo
     * @return
     * @author lgh
     */
    public static String encryptCardNo(String cardNo) {

        cardNo = nullToStrTrim(cardNo);

        if (cardNo.length() == 15) {
            return cardNo.substring(0, 6) + "****" + cardNo.substring(8);
        }

        if (cardNo.length() == 18) {
            return cardNo.substring(0, 6) + "****" + cardNo.substring(10);
        }

        return cardNo;
    }

    /**
     * 根据身份证判断性别
     *
     * @param cardNo
     * @return
     * @author lgh
     */
    public static String getSexByCardNo(String cardNo) {

        cardNo = nullToStrTrim(cardNo);

        if (cardNo.length() == 15) {
            return Integer.parseInt(cardNo.substring(14)) % 2 != 0 ? "男" : "女";
        }

        if (cardNo.length() == 18) {
            return Integer.parseInt(cardNo.substring(16, 17)) % 2 != 0 ? "男" : "女";
        }

        return "无法识别";
    }

        /*
    校验过程：
    1、从卡号最后一位数字开始，逆向将奇数位(1、3、5等等)相加。
    2、从卡号最后一位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，将个位十位数字相加，即将其减去9），再求和。
    3、将奇数位总和加上偶数位总和，结果应该可以被10整除。
    */

    /**
     * 校验银行卡卡号
     */
    public static boolean checkBankCard(String bankCard) {
        if (isNull(bankCard)) {
            return false;
        }

        if (bankCard.length() < 15 || bankCard.length() > 19) {
            return false;
        }
        char bit = getBankCardCheckCode(bankCard.substring(0, bankCard.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return bankCard.charAt(bankCard.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     *
     * @param nonCheckCodeBankCard
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeBankCard) {
        if (nonCheckCodeBankCard == null || nonCheckCodeBankCard.trim().length() == 0
                || !nonCheckCodeBankCard.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeBankCard.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    /**
     * 根据卡号获取银行名称
     *
     * @param bankNo
     * @return
     */
    public static String getBankNameByBankNo(String bankNo) {
        if (isNull(bankNo)) {
            return null;
        }
        //发送请求
        String url = "https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo=" + bankNo + "&cardBinCheck=true";
        bankNo = sendGet(url);
        Map<String, String> map = JSON.parseObject(bankNo, Map.class);
        System.out.println(map);
        if ("false".equals(map.get("validated"))) {
            return null;
        }
        bankNo = map.get("bank");


        return bankNo;

    }


    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            System.out.println("url:" + url);
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result = line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(getBankNameByBankNo("6212261716004053989"));
    }

}
