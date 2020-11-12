package me.thewing.demobootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;

//Web과 관련된 Bean으로 인식하여 등록
@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new PersonFormatter());
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).order(0);
        registry.addInterceptor(new AnotherInterceptor())
                .addPathPatterns("/hi") //hi에만 적용
                .order(-1);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**") // mobile 이하 요청
                .addResourceLocations("classpath:/mobile/", "file:/Users/sungjun/files/") // 어디서 찾는지
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES))
        // 이 응답은 10분동안 캐싱 , 리소스가 변경되지 않았다면, 10분이 지나면 리소스를 받아온다
//                .resourceChain(true) // 캐시를 쓸지 말지, 운영 true, 개발 false
//                .addResolver() //어떤 요청에 해당하는 리소스를 찾는 방법
//                .addTransformer() //응답으로 내보낼 리소스를 변경하는 방법

                ;
    }

//    // add하는 순간 기본 컨버터를 사용하지 못한다.
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//    }
//
//    // 추가해서 메세지 컨버터를 사용해도 된다. 주로 사용하진 않음
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//    }
}
