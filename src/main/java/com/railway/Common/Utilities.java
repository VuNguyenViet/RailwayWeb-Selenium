package com.railway.Common;

import java.io.*;
import java.util.Properties;

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


}
