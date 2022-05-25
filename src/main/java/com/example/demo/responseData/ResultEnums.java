package com.example.demo.responseData;


public enum ResultEnums {

   SUCCESS("200", "请求成功"),
   ERROR("400", "请求失败"),
   SYSTEM_ERROR("500", "系统异常"),
   BUSSINESS_ERROR("501", "业务逻辑错误"),
   VERIFY_CODE_ERROR("502", "业务参数错误"),
   PARAM_ERROR("503", "业务参数错误");

   private String code;
   private String msg;

   ResultEnums(String code, String msg) {
       this.code = code;
       this.msg = msg;
   }

   public String getCode() {
       return code;
   }

   public void setCode(String code) {
       this.code = code;
   }

   public String getMsg() {
       return msg;
   }

   public void setMsg(String msg) {
       this.msg = msg;
   }
}