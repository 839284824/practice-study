package mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.*;


/**
 * 路径匹配test
 *
 * @author gongzhao
 * @Date 19:09 2018/12/19
 */
@Slf4j
public class TestAntPathMatcher {
    public static void main(String[] args) throws Exception {
        PathMatcher matcher = new AntPathMatcher();
        //restful 匹配测试
        String requestPath = "gateway/health/a";

        String patternPath0 = "gateway/health/a";
        String patternPath = "gateway/health/{id}";
        String patternPath1 = "gateway/health/{id}/aaaaa";
        String patternPath2 = "gateway/health/**";
        String patternPath3 = "gateway/health/*";
        String patternPath4 = "gateway/health?/";
        String patternPath5 = "gateway/health/?";
        List<String> patternList = new ArrayList<String>();
        patternList.add(patternPath0);
        patternList.add(patternPath);
        patternList.add(patternPath1);
        patternList.add(patternPath2);
        patternList.add(patternPath3);
        patternList.add(patternPath4);
        patternList.add(patternPath5);
        log.info("需匹配的路径:{}", requestPath);

        //匹配到的pattern
        List<String> matchingPatterns = new ArrayList<String>();
        Comparator<String> patternComparator = matcher.getPatternComparator(requestPath);
        String bestPatternMatch = null;
        for (String pattern : patternList) {
            boolean result = matcher.match(pattern, requestPath);
            log.info("匹配结果:pattern:{},result:{}", pattern, result);
            if (result) {
                matchingPatterns.add(pattern);
            }
        }
        if (!matchingPatterns.isEmpty()) {
            Collections.sort(matchingPatterns, patternComparator);
            for (int i = 0; i < matchingPatterns.size(); i++) {
                log.info("匹配规则优先级:{},{},{}", i, matchingPatterns.get(i), requestPath);
            }
        }
        //解析pathVariables注解的参数
//        Map<String, String> matchMap = matcher.extractUriTemplateVariables(patternPath, requestPath1);
//        for (Map.Entry entry : matchMap.entrySet()) {
//            log.info("参数匹配项:key:{},value:{}", entry.getKey(), entry.getValue());
//        }
    }
}