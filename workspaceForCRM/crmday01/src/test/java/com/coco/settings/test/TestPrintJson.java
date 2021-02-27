package com.coco.settings.test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author radio
 * @create 2021-02-27 9:55 PM
 */
public class TestPrintJson {

    public static String printJsonObj( Object obj){

        /*
         *
         * Person p
         * 	id name age
         * {"id":"?","name":"?","age":?}
         *
         * List<Person> pList
         * [{"id":"?","name":"?","age":?},{"id":"?","name":"?","age":?},{"id":"?","name":"?","age":?}...]
         *
         * Map
         * 	key value
         * {key:value}
         *
         *
         */

        ObjectMapper om = new ObjectMapper();
        String json=null;
        try {
             json = om.writeValueAsString(obj);


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;


    }

    public static void main(String[] args) {
        String msg="直接打印错误";

        Map<String, Object> map = new HashMap<>();
        map.put("success",false);
        map.put("msg",msg);
        String jsonObj = TestPrintJson.printJsonObj(map);
        System.out.println(jsonObj);
    }
}
