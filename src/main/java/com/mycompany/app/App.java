package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static boolean search(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int count, ArrayList<String> arr3, String target) {
        System.out.println("inside search");
        if (arr1 == null) return false;
        if (arr2 == null) return false;
        if (arr3 == null) return false;
        if (target == null) return false;

        int check = 0;
        for(Integer i : arr1){
            if(arr2.contains(i)){
                check++;
            }
        }
        if(check < count) return false;

        return arr3.contains(target);
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList1.add(value);
            }
            System.out.println(inputList1);

            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
            }
            System.out.println(inputList2);

            String input3 = req.queryParams("input3").replaceAll("\\s","");
            int count = Integer.parseInt(input3);

            String input4 = req.queryParams("input4");
            java.util.Scanner sc3 = new java.util.Scanner(input4);
            sc3.useDelimiter("[;\r\n]+");
            java.util.ArrayList<String> inputList3 = new java.util.ArrayList<>();
            while (sc3.hasNext())
            {
                String value = sc3.next().replaceAll("\\s","");
                inputList3.add(value);
            }
            System.out.println(inputList3);

            String target = req.queryParams("input5").replaceAll("\\s","");

            boolean result = App.search(inputList1, inputList2, count, inputList3, target);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
