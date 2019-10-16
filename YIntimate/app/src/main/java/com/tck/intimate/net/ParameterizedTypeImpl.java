package com.yaoyanshe.commonlibrary.util.gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * author: tck
 * created on: 2018/8/20 13:28
 * description:
 */
public class ParameterizedTypeImpl implements ParameterizedType {
    private final Class raw;
    private final Type[] args;

    public ParameterizedTypeImpl(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }

    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }

    @Override
    public Type getRawType() {
        return raw;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}

