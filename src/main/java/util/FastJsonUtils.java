package com.renrenche.sales.mismanage.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zhangguangliang on 2017/3/7.
 */
public class FastJsonUtils {


    private static Logger LOG = LoggerFactory.getLogger(FastJsonUtils.class);

    /**
     * 转换obj对象为json字符串
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }

        return JSON.toJSONString(obj,
                SerializerFeature.WriteDateUseDateFormat
        );
    }

    public static String toPrettyJson(Object obj) {
        if (obj == null) {
            return null;
        }

        return JSON.toJSONString(obj,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteClassName,
                SerializerFeature.NotWriteRootClassName,
                SerializerFeature.PrettyFormat
        );
    }

    public static <T> T parseJson(String jsonStr, Class<T> valueType) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }

        return JSON.parseObject(jsonStr, valueType);
    }

    public static <T> T parseJson(String jsonStr, TypeReference<T> typeReference) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }

        return JSON.parseObject(jsonStr, typeReference, new Feature[0]);
    }

    public static <T> T parseJson(String jsonStr, com.fasterxml.jackson.core.type.TypeReference<T> typeReference) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }

        return JSON.parseObject(jsonStr, typeReference.getType(), new Feature[0]);
    }

    public static <T> List<T> parseJsonArray(String jsonStr, Class<T> valueType) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }

        return JSON.parseArray(jsonStr, valueType);
    }
}
