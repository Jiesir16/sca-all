package jiesir.z.iam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("jiesir.z.iam.infrastructure.db.mapper")
public class IamServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IamServiceApplication.class, args);
    }
}