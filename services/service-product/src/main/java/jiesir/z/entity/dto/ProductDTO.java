package jiesir.z.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2527546540496222397L;

    private Long id;

    @NotBlank(message = "商品名称不能为空")
    private String productName;

    private String productDesc;

    @NotNull(message = "商品图片不能为空")
    private List<String> productImages;

}
