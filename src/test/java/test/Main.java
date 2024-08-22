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
        templateList.add("(@name === '张三' && @age =S= '18') || (@name === '李四' && @age === '20')");
        templateList.add("@name === '李四' && @age === '20'");
        templateList.add("@name === 王五 && @age === 25");
        templateList.add("@list.contains(@name)");

        //业务上需要匹配的人员信息
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("张三");
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三8");
        map.put("age", "18");
        map.put("list",list);


        //解析模板
        for (String template : templateList) {
            try {
                TokenParser parser = new TokenParser(template);
                Object expression = parser.parse().exec(map::get);
                System.out.println(expression);
            } catch (Exception e) {
                // 有可能的异常，如模板不正确，需要执行异常业务处理，如前端报错
                System.out.println(e);
            }

        }
    }
}
