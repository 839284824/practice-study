package com.renrenche.sales.carsource.common.utils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.jolokia.util.Base64Util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pigsoldier on 16/10/26.
 */
public class OctoUtil {

    public static String getOctoToken(String octoKey, String octoSecret) {
        try {
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");

            Date begin = new Date();
            Date end = new Date(begin.getTime() + 2000000);

            String result = Jwts.builder().setHeader(header).setIssuer(octoKey).setIssuedAt(begin).setExpiration(end)
                    .signWith(SignatureAlgorithm.HS256, Base64Util.encode(octoSecret.getBytes("UTF-8"))).compact();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}