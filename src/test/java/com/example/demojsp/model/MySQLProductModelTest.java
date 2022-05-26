package com.example.demojsp.model;

import com.example.demojsp.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MySQLProductModelTest {

    private IProduct iProduct;

    @BeforeEach
    void setUp() {
        iProduct = new MySQLProductModel();
    }

    @Test
    void save() {
       Product product = new Product();
       product.setId("p001");
       product.setCategoryId(1);
       product.setName("Quần bò nam");
       product.setPrice(BigDecimal.valueOf(120));
       product.setThumbnails("https://dojeannam.com/wp-content/uploads/2018/12/quan-jean-nam-thun-den-xam-wash.jpg");
       product.setDescription("Quần jeans cao cấp của Levis");
       product.setDetail("Levis là thương hiệu jeans hàng đầu cho phái mạnh, các sản phẩm thời trang của Levis có mặt hầu hết các nước trên toàn thế giới. Những chiếc quần jean nam của Levis nổi tiếng với kiểu quần jeans rách ngả xanh hay xanh đen chất liệu cotton mềm, tạo cảm giác thoải mái khi mặc. Tuy nhiên dự đoán trong tương lai những chiếc quần jeans tối màu, cứng và nặng sẽ được ưa chuộng hơn, mức giá của các mẫu quần jeans thương hiệu Levis từ 800.000 vnđ, được phái mạnh ưa chuộng.");
       iProduct.save(product);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}