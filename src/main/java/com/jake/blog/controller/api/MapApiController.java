package com.jake.blog.controller.api;

import com.jake.blog.config.auth.PrincipalDetail;
import com.jake.blog.dto.ResponseDto;
import com.jake.blog.model.Map;
import com.jake.blog.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MapApiController {

    @Autowired
    private MapService mapService;

    @PostMapping("/coordinate")
    public ResponseDto<Integer> mapData(@RequestBody Map map,
                                        @AuthenticationPrincipal PrincipalDetail principalDetail) {
        mapService.write(map, principalDetail.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @GetMapping("/information")
    public List<Map> mapInfo() {
        return mapService.give();
    }
}
