package com.believe.sun.user.api;

import org.apache.ibatis.io.ResolverUtil;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sungj on 17-5-24.
 */
@RestController
@RequestMapping("/test")
public class TestApi {
    Logger logger = Logger.getLogger(TestApi.class);

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity test(){
        logger.debug("aaaaaaa");
        return new ResponseEntity("ok", HttpStatus.OK);
    }
}
