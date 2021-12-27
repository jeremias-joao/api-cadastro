//package br.com.novenovejobs.cadastro.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//public class SwaggerConfig {
//	
//	// http://localhost:8080/swagger-ui/index.html
//		@Bean
//		public Docket swaggerEditoraApi() {
//			return new Docket(DocumentationType.SWAGGER_2)
//					.select()
//					.apis(RequestHandlerSelectors.any())
//					.paths(PathSelectors.any())
//					.build();
//		}
//
//}
