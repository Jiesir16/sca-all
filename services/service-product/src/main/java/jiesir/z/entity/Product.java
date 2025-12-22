package jiesir.z.entity;

//import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
//@TableName("product")
public class Product {

    private Long id;

    private String productName;

    private BigDecimal price;

    private Integer stock;

}
