package com.kgc.movie.movie.config;

import com.kgc.movie.movie.pojo.Movie_ticket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.UnknownHostException;

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
    @Bean
    public RedisTemplate<Object, Movie_ticket> employeeRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Movie_ticket> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Movie_ticket> serializer = new Jackson2JsonRedisSerializer<Movie_ticket>(Movie_ticket.class);
        template.setDefaultSerializer(serializer);
        return template;
    }


    @Bean//解决序列化问题，现实的不再是二进制
    public RedisCacheManager employeeRedisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        //初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        //设置CacheManager的值序列化方式为json序列化
        RedisSerializer<Movie_ticket> jsonSerializer = new Jackson2JsonRedisSerializer(Movie_ticket.class);

        RedisSerializationContext.SerializationPair<Movie_ticket> pair = RedisSerializationContext.SerializationPair
                .fromSerializer(jsonSerializer);
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair);

        //初始化RedisCacheManager
        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
    }
}
