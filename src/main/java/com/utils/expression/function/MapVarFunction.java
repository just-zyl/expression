package com.utils.expression.function;

import com.utils.expression.exceptions.ExpressionException;

import java.util.Map;

/**
 * MapVarFunction
 *
 */
public class MapVarFunction implements VarFunction<String, Object> {

    private final Map<String, Object> map;

    private MapVarFunction(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public Object get(String key) throws ExpressionException {
        return map.get(key);
    }

    @Override
    public boolean contains(String key) throws ExpressionException {
        return map.containsKey(key);
    }

    public static MapVarFunction create(Map<String, Object> map) {
        return new MapVarFunction(map);
    }
}
