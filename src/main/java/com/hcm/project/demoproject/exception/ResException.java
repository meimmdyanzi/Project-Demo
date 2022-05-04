package com.hcm.project.demoproject.exception;

/**
 * @description:
 * @author: josnhuang
 * @CodeReviewer: josnhuang
 * @CreateTime 2022/5/2 10:26
 */
public class ResException extends Exception {
    private String errorCode;

    public ResException(String errorCode) {
        this.errorCode = errorCode;
    }
}
