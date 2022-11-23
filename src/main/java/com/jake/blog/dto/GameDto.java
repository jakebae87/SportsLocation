package com.jake.blog.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameDto {

    private String number;
    private String status;
    private String type;
    private String title;
    private String period;
    private String detail;

}
