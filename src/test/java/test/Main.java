package test;

import com.utils.expression.exceptions.ExpressionException;
import com.utils.expression.parser.TokenParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 */
public class Main {

    public static void main(String[] args) throws ExpressionException {
        Map<String, String> set = new HashMap<>();
        set.put("name", "李四");
        set.put("age", "18");
        //set.contains(1);
//        String expression = "" +
//                "IF @set?.containsKey(2) THEN " +
//                "(IF @set?.contains(1) THEN 1d ELSE 'false' END) " +
//                "ELSE " +
//                "2 " +
//                "END";
//        String expression = "@set?.contains(1) || @set?.contains(2) && @set?.contains(3) || @set?.contains(4)";
        String expression = "@name? == 张三 && @age? == 19";
        String expression2 = "@name? == 李四 && @age? == 18";

        Object execResult = new TokenParser(expression).parse();
        Object execResult2 = new TokenParser(expression2).parse();
        System.out.println(execResult);
        System.out.println(execResult2);
    }
}
