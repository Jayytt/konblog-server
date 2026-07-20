package com.konblog.config;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handle -> {
            SaRouter.match("/**")
                .notMatch(
                    "/auth/**", "/health", "/stats", "/error",
                    "/article/user/**", "/category/user/**",
                    "/tag/user/**", "/link/user/**", "/comment/user/**",
                    "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html",
                    "/doc.html", "/webjars/**", "/favicon.ico"
                )
                .check(r -> StpUtil.checkLogin());
        })).addPathPatterns("/**")
          .excludePathPatterns(
              "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html",
              "/doc.html", "/webjars/**", "/favicon.ico", "/health", "/stats"
          );
    }
}