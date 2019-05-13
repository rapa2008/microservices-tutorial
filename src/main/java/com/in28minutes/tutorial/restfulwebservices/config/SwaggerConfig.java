package com.in28minutes.tutorial.restfulwebservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;


/**
 * Created by RA371996 on 4/13/2019.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Rahul Pattar", "www.google.com", "rahul.pattar@gmail.com");
    private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));
    private static VendorExtension<String> vendorExtension = new VendorExtension<String>() {
        @Override
        public String getName() {
            return "Vendor1";
        }

        @Override
        public String getValue() {
            return "Rahul Enterprises";
        }
    };

    private static VendorExtension<String> vendorExtension2 = new VendorExtension<String>() {
        @Override
        public String getName() {
            return "Vendor2";
        }

        @Override
        public String getValue() {
            return "Pattar Enterprises";
        }
    };

    static List<VendorExtension> list1 = new ArrayList<VendorExtension>();

    static{
        list1.add(vendorExtension);
        list1.add(vendorExtension2);
    }


    public static final ApiInfo DEFAULT = new ApiInfo("Awesome API", "Nice Description",
            "1.0", "urn:tos", DEFAULT_CONTACT, "Apache", "https://www.apache.org/licenses/LICENSE-2.0",
            list1);

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT)
                .produces(DEFAULT_PRODUCES_CONSUMES)
                .consumes(DEFAULT_PRODUCES_CONSUMES);
    }


}
