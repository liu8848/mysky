package com.sky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Slf4j
public class SkyApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SkyApplication.class,args);
    }
}
