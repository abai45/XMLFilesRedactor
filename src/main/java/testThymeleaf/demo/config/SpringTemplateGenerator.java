package testThymeleaf.demo.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class SpringTemplateGenerator {

    @Bean
    public SpringResourceTemplateResolver xmlTemplateResolver(ApplicationContext applicationContext) {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".xml");
        templateResolver.setTemplateMode("XML");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(true);
        templateResolver.setOrder(1);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(ApplicationContext applicationContext) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(xmlTemplateResolver(applicationContext));
        return templateEngine;
    }
}
