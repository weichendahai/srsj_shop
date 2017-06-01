package com.srsj.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by weichen on 2017/6/1.
 */
public class HttpUtil {

    public static String httpEncoding = "UTF-8";
    private static final Logger logger = Logger.getLogger("HttpUtil");

    public HttpUtil() {
    }

    public static void allowJsCrossDomain(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Max-Age", "3600");
    }

    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    public static void ajaxStatus(HttpServletResponse response, int status, String tip) {
        try {
            response.setContentType("text/html;charset=" + httpEncoding);
            response.setStatus(status);
            PrintWriter out = response.getWriter();
            out.print(tip);
            out.flush();
        } catch (IOException var4) {
            logger.severe(var4.toString());
        }

    }

    public static String getQueryString(HttpServletRequest request, String encode) throws IOException {
        StringBuffer sb = new StringBuffer(request.getRequestURL());
        String query = request.getQueryString();
        if(query != null && query.length() > 0) {
            sb.append("?").append(query);
        }

        return URLEncoder.encode(sb.toString(), encode);
    }

    public static boolean inContainURL(HttpServletRequest request, String url) {
        boolean result = false;
        if(url != null && !"".equals(url.trim())) {
            String[] urlArr = url.split(";");
            StringBuffer reqUrl = new StringBuffer(request.getRequestURL());

            for(int i = 0; i < urlArr.length; ++i) {
                if(reqUrl.indexOf(urlArr[i]) > 1) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    public static String encodeRetURL(String url, String retParam, String retUrl) {
        return encodeRetURL(url, retParam, retUrl, (Map)null);
    }

    public static String encodeRetURL(String url, String retParam, String retUrl, Map<String, String> data) {
        if(url == null) {
            return null;
        } else {
            StringBuffer retStr = new StringBuffer(url);
            retStr.append("?");
            retStr.append(retParam);
            retStr.append("=");

            try {
                retStr.append(URLEncoder.encode(retUrl, httpEncoding));
            } catch (UnsupportedEncodingException var7) {
                logger.severe("encodeRetURL error." + url);
                var7.printStackTrace();
            }

            if(data != null) {
                Iterator i$ = data.entrySet().iterator();

                while(i$.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry)i$.next();
                    retStr.append("&").append((String)entry.getKey()).append("=").append((String)entry.getValue());
                }
            }

            return retStr.toString();
        }
    }

    public static String decodeURL(String url) {
        if(url == null) {
            return null;
        } else {
            String retUrl = "";

            try {
                retUrl = URLDecoder.decode(url, httpEncoding);
            } catch (UnsupportedEncodingException var3) {
                logger.severe("encodeRetURL error." + url);
                var3.printStackTrace();
            }

            return retUrl;
        }
    }

    public static boolean isGet(HttpServletRequest request) {
        return "GET".equalsIgnoreCase(request.getMethod());
    }

    public static boolean isPost(HttpServletRequest request) {
        return "POST".equalsIgnoreCase(request.getMethod());
    }

    public static void sendRedirect(HttpServletResponse response, String location) {
        try {
            response.sendRedirect(location);
        } catch (IOException var3) {
            logger.severe("sendRedirect location:" + location);
            var3.printStackTrace();
        }

    }

    public static String requestPlayload(HttpServletRequest request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if(inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                boolean var5 = true;

                int bytesRead;
                while((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException var13) {
            throw var13;
        } finally {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException var12) {
                    throw var12;
                }
            }

        }

        return stringBuilder.toString();
    }

    public static String getRequestUrl(HttpServletRequest request) {
        StringBuffer url = new StringBuffer(request.getScheme());
        url.append("://");
        url.append(request.getHeader("host"));
        url.append(request.getRequestURI());
        if(request.getQueryString() != null) {
            url.append("?").append(request.getQueryString());
        }

        return url.toString();
    }
}
