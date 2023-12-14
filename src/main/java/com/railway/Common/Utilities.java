package com.railway.Common;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Utilities {
    public static String getPathProject () {
        return System.getProperty("user.dir");
   }  //Trả về đường dẫn của dự án
//    Tiếp theo, viết các phương thức với cac tính năng mà mình sẽ sử dụng trong dự án
    public static String getDataFromConfig (String header ,String pathConfig) {
       try (InputStream input = new FileInputStream(pathConfig)) {
           Properties prop = new Properties() ;
           prop.load(input);
           return prop.getProperty(header);
       } catch (IOException ex) {
           return "";
       }
    } ;
    public static void  setDatatoConfig (String pathConfig, String header, String value) {
        try {
            FileInputStream in  = new FileInputStream(pathConfig);
            Properties props = new Properties() ;
            props.load(in);
            in.close();
            OutputStream output = new FileOutputStream(pathConfig) ;
            props.setProperty(header, value);
            props.store(output,null);
            output.close();
            } catch (IOException io) {
            io.printStackTrace();}

    }
//    hàm lấy và cập nhật giá trị
public static String getGenerateString(int string_size) {
    String alpha_numeric = "0123456789" + "abcdefghijklmnopqrstuvxyz";
    StringBuilder string_builder = new StringBuilder(string_size);
    for (int i = 0; i < string_size; i++) {
        int index = (int)(alpha_numeric.length() * Math.random());
        string_builder.append(alpha_numeric.charAt(index));
    }
    return string_builder.toString();
}
    //    Có tác dụng tạo ra 1 chuôi ngẫu nhiên với độ dài xác định
    public static String getCurrentDateByUSFormat(){
        String pattern = "M/d/yyyy";
        return new SimpleDateFormat(pattern).format(new Date());
    }
    //    Có tác dụng trả về ngày tháng hiện tại theo đúng định dang
    public static boolean compareStringDateByUSFormat(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        try {
            return sdf.parse(startDate).toInstant().isBefore(sdf.parse(endDate).toInstant());
        }
        catch (Exception e) {
            return false;
        }
    }
    //    Có tác dụng so sánh 2 chuỗi ngày, và xác định xem ngày bắt đầu có trước ngày kết thúc không
    public static boolean isTwoDifferenceList(List<String> list1, List<String> list2){
        for (int i=0; i<list1.size(); i++) {
            if (list1.get(i) == list2.get(i)) {
                return false;
            }
        }
        return true;
    }
    //    Kiểm tra xem sự khác biệt của 2 danh sách khác nhau
    public static boolean compareStringByTimeFormat(String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            return sdf.parse(startTime).toInstant().isBefore(sdf.parse(endTime).toInstant());
        }
        catch (Exception e) {
            return false;
        }
    }
    //    So sánh hai chuỗi thời gian theo định dạng, xem thời gian bắt đầu có trước thời gian kết thúc k
    public static List<String> getMatchingValues(List<String> list1, List<String> list2) {
        return list1.stream().filter(list2::contains).collect(Collectors.toList());
    }
    //    Có giá trị trả về các giá trị chung của 2 danh sách
}
