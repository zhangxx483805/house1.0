package com.house.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyFastJsonConfig {
    @Bean
    public HttpMessageConverters getFastJSONHttpMessageConvert() {
        FastJsonHttpMessageConverter fhmc = new FastJsonHttpMessageConverter();

        //json打印格式处理
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        //处理中文乱码
        List<MediaType> mediaTypes = new ArrayList<>();
        //配置fastjson的默认编码 UTF-8==MediaType.APPLICATION_JSON_UTF8
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

        //修改响应类型
        fhmc.setSupportedMediaTypes(mediaTypes);

        fhmc.setFastJsonConfig(fastJsonConfig);

        return new HttpMessageConverters(fhmc);
    }
}


