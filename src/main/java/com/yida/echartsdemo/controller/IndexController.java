package com.yida.echartsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class IndexController {
    @GetMapping({"/echarts","","/"})
    public String index() {
        return "echarts";
    }

    @GetMapping("echarts_line_data")
    @ResponseBody
    public Map<String,Object> getEchartsLineData() {
        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        Integer[] arr = new Integer[]{5, 20, 36, 10, 50, 40};
        map.put("data_line",arr);
        return map;
    }

    @GetMapping("echarts_pie_data")
    @ResponseBody
    public Map<String,Object> getEchartsPieData() {
        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        String data = "235,视频广告;274,联盟广告;310,邮件营销;335,直接访问;400,搜索引擎";
        String[] arr = data.split(";");
        List<LinkedHashMap<String,String>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            String[] arr2 = s.split(",");
            LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("value",arr2[0]);
            linkedHashMap.put("name",arr2[1]);
            list.add(linkedHashMap);
        }
        map.put("data_pie",list);
        return map;
    }

    @GetMapping("echarts_bar_data")
    @ResponseBody
    public Map<String,Object> getEchartsBarData() {
        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        Integer[] arr = new Integer[]{5, 20, 36, 10, 50, 40};
        map.put("data_bar",arr);
        return map;
    }
}
