package com.jake.blog.controller.api;

import com.jake.blog.config.auth.PrincipalDetail;
import com.jake.blog.dto.ResponseDto;
import com.jake.blog.model.Map;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class MapApiController {

    @PostMapping("/map")
    public ResponseDto<Integer> mapData(@RequestBody Map map,
                                        @AuthenticationPrincipal PrincipalDetail principalDetail) {
        System.out.println(map.getLatitude());
        System.out.println(map.getLongitude());
        System.out.println(principalDetail.getUsername());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
