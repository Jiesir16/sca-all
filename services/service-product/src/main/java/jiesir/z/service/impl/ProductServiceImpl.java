package jiesir.z.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiesir.z.entity.Product;
import jiesir.z.mapper.ProductMapper;
import jiesir.z.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {



}
