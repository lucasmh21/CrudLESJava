package br.com.fatec.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean
	public FormattingConversionService mvcConversionService()
	{
		DefaultFormattingConversionService defaultFormattingConversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar dateFormatterRegistrar = new DateFormatterRegistrar();
		dateFormatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		dateFormatterRegistrar.registerFormatters(defaultFormattingConversionService);
		return defaultFormattingConversionService;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
}
