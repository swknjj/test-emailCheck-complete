package com.example.test.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private Long id;
    private int foodCode;
    private int foodPrice;
    private String foodName;
    private int fileAttached;
    private MultipartFile foodFile;
}
