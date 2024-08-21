package test;

import com.utils.expression.exceptions.ExpressionException;
import com.utils.expression.parser.TokenParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 */
public class Main {

    public static void main(String[] args) throws ExpressionException {


        // 获取模板列表
        List<String> templateList = new ArrayList<>();
        templateList.add("@name === '张三' && @age === 18");
        templateList.add("@name === '李四' && @age === 20");
        templateList.add("@name === '王五' && @age === 25");

        //业务上需要匹配的人员信息
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", "18");
        for (String template : templateList) {
            TokenParser parser = new TokenParser(template);
            Object expression = parser.parse().exec(map::get);
            System.out.println(expression);
        }
    }
}
