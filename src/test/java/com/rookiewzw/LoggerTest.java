package com.rookiewzw;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by RookieWangZhiWei on 2018/9/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoggerTest.class)
public class LoggerTest {

    Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test(){
        logger.info("hello");
        logger.error("he,man");
    }
}
