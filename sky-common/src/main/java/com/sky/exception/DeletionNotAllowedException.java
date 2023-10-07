package com.sky.exception;

import com.sky.context.BaseContext;

public class DeletionNotAllowedException extends BaseException {
    public DeletionNotAllowedException(String msg) {
        super(msg);
    }
}
