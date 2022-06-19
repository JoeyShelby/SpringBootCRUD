package org.joey.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author: JoeyShelby
 * @date: 2022-06-14 16:27
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的语言参数
        String language = request.getParameter("language");

        if(!StringUtils.isEmpty(language)) {
            String[] split = language.split("_");
            return new Locale(split[0], split[1]);
        }

        // 请求中没有语言参数则返回默认本地配置
        return Locale.getDefault();
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }

}
