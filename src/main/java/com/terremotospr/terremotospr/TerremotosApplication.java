package com.terremotospr.terremotospr;

/**
 * Created on February 27, 2020 - 11:34PM
 *
 * @author Victor Nazario
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@ComponentScan("com.terremotospr")
@EnableJpaRepositories("com.terremotospr")
@EntityScan("com.terremotospr")
@SpringBootApplication
@EnableSwagger2
public class TerremotosApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(TerremotosApplication.class);

    static String configPath = "classpath:/,file:/etc/app-configs/terremotos-api/";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        logger.info("Terremotos API");
        return application
                .sources(TerremotosApplication.class)
                .properties(String.format("spring.config.location:%s",configPath));
    }

    public static void main(String[] args) {
        final String[] a = new String[args.length + 1];
        a[0] = String.format("--spring.config.location=%s",configPath);
        System.arraycopy(args, 0, a, 1, args.length);
        SpringApplication.run(TerremotosApplication.class, a);
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.terremotospr"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().title("TerremotosPR Api").build());
    }
}