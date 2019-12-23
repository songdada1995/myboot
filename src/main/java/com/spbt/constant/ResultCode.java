package com.spbt.constant;

/**
 * @Author songbo
 * @Date 2019/12/10 16:46
 * @Version 1.0
 */
public interface ResultCode {

    //1001xxx
    enum Common {
        UNKNOWN_ERROR(1001000),             //未知错误
        NOT_FOUND(1001001),                 //资源不存在
        ILLEGAL_ARGUMENT(1001002),          //参数非法
        INTERNAL_SERVER_ERROR(1001500),     //服务器内部错误
        ;
        public int code;
        Common(int code) {
            this.code = code;
        }
    }

    //1000xxx
    enum User {
        NOT_SIGNIN(1000000),           //未登录或者回话过期

        ;
        public int code;
        User(int code) {
            this.code = code;
        }
    }

    //1002xxx
    enum AmazonPpc {
        NOT_USE_PROFILE(1002001),      //没有选择profile
        PROFILE_NOT_AUTHORIZE(1002002),//profile没有授权

        ;
        public int code;
        AmazonPpc(int code) {
            this.code = code;
        }
    }

}
