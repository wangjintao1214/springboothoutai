package com.kgc.movie.movie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author shkstart
 * @create 2020-11-11 16:41
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/demo.html").setViewName("demo");
        registry.addViewController("/echarts1.html").setViewName("echarts1");
        registry.addViewController("/echarts2.html").setViewName("echarts2");
        registry.addViewController("/echarts3.html").setViewName("echarts3");
        registry.addViewController("/echarts4.html").setViewName("echarts4");
        registry.addViewController("/echarts5.html").setViewName("echarts5");
        registry.addViewController("/echarts6.html").setViewName("echarts6");
        registry.addViewController("/kiss-add.html").setViewName("kiss-add");
        registry.addViewController("/kiss-edit.html").setViewName("kiss-edit");
        registry.addViewController("/level-add.html").setViewName("level-add");
        registry.addViewController("/level-edit.html").setViewName("level-edit");
        registry.addViewController("/member-add.html").setViewName("member-add");
        registry.addViewController("/member-del.html").setViewName("member-del");
        registry.addViewController("/member-edit.html").setViewName("member-edit");
        registry.addViewController("/member-kiss.html").setViewName("member-kiss");
        registry.addViewController("/member-level.html").setViewName("member-level");
        registry.addViewController("/member-list.html").setViewName("member-list");
        registry.addViewController("/member-password.html").setViewName("member-password");
        registry.addViewController("/member-view.html").setViewName("member-view");
        registry.addViewController("/product-del.html").setViewName("product-del");
        registry.addViewController("/product-list.html").setViewName("product-list");


    }
}
