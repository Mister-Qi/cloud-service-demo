package com.ms.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebMVCConfiguration extends WebMvcConfigurationSupport {

	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		System.out.println("**********************************************************************in configuration");
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		ObjectMapper objectMapper = new ObjectMapper();
//		SimpleModule module = new SimpleModule();
//		module.addSerializer(new ToStringSerializer(Long.TYPE));
//		module.addSerializer(new ToStringSerializer(Long.class));
//		module.addSerializer(new ToStringSerializer(BigInteger.class));
//		objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//			@Override
//			public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
//					throws IOException {
//				jsonGenerator.writeString("");
//			}
//		});
//		objectMapper.registerModule(module);
//		converter.setObjectMapper(objectMapper);

		converters.add(converter);

	}

}
