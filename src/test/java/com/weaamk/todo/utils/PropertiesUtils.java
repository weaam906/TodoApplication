/* ****************************************************** *
 *  Author: We'am Kamal                                   *
 *  Date: 25th.Apr.23                                     *
 *  Desc: This package is for the properties' utilities   *
 *        this class is for reading/loading properties    *
 *        saved in the production/local.properties        *
 * ****************************************************** */
package com.weaamk.todo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {
      public static Properties loadProperties(String filePath){
          File file = new File(filePath);                           //1-Create a file object and pass the filepath(dynamic) as we
          try {                                                     //  have more than property file
              InputStream inputStream = new FileInputStream(file);  //2-Create an IS to read the data inside the file
              Properties properties = new Properties();             //3-Create a properties object
              properties.load(inputStream);                         //4-Get the file properties through LOADING it from the IS
              inputStream.close();                                  //5-Close the stream and free it after finishing.
              return properties;
          }catch (FileNotFoundException e) {
              throw new RuntimeException("File not found");
          } catch (IOException e) {
              throw new RuntimeException("Error while loading the properties");
          }
      }
}
