package com.senontech.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/***
 * 下载文件工具类
 */
public class FileDownloadUtils {

    public static void downFirmware(String fileName,byte[] firmware, HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        writeFile(fileName,firmware);
        downFile(fileName, request, response);
        delFile(fileName);
    }


    /**
     * 向浏览器发送文件下载，支持断点续传
     *
     * @param fileName
     *            要下载的文件名称
     * @param request
     *            请求对象
     * @param response
     *            响应对象
     * @return 返回错误信息，无错误信息返回null
     */
    public static void downFile(String fileName, HttpServletRequest request,
                                  HttpServletResponse response) throws IOException {
        //获取当前浏览器类别
        String userAgent= request.getHeader("User-Agent");

        //附件信息
        String filwPath=System.getProperty("user.dir")+"\\"+fileName;

        //解决IE中文乱码
        // 针对IE或者以IE为内核的浏览器：
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }

        //设置文件的类型
        response.setContentType("application/octet-stream");
        //设置编码
        response.setCharacterEncoding("UTF-8");

        response.setHeader("Content-disposition", "attachment; filename=" + fileName);

        FileInputStream fi = new FileInputStream(filwPath);
        //输出流
        OutputStream os = response.getOutputStream();
        byte[] bytes = new byte[4096];
        int length;
        while ((length = fi.read(bytes)) > 0){
            os.write(bytes, 0, length);
        }
        fi.close();
        os.flush();
    }

    public static void writeFile(String fileName,byte[] firmware) throws IOException {
        String directory = System.getProperty("user.dir");

        //2.  创建文件夹对象     创建文件对象
        File file = new File(directory);
        //如果文件夹不存在  就创建一个空的文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(directory, fileName);
        //如果文件不存在  就创建一个空的文件
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //3.写入数据
        //创建文件字节输出流
        FileOutputStream fos = new FileOutputStream(directory + "\\" + fileName);
        //将byte数组中的所有数据全部写入
        if (firmware!=null){  fos.write(firmware);}
        //关闭流
        fos.close();
    }

    public static void delFile(String fileName) {
        try {
            String filePath = System.getProperty("user.dir")+"\\"+fileName;
            filePath = filePath.toString();
            File myDelFile = new File(filePath);
            myDelFile.delete();
        } catch (Exception e) {
            System.out.println("删除文件操作出错");
            e.printStackTrace();
        }
    }

}
