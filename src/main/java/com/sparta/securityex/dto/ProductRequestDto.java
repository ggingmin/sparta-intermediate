package com.sparta.securityex.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductRequestDto {
    private String title;
    private String image;
    private String link;
    private int lprice;
}
