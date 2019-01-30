package com.invech.platform.dsfcenterdata.utils.response;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
  private static final long serialVersionUID = 1L;
  private static final String data = "data";
  private static final String page = "page";
  private static final int SERVER_ERROR = 500;

  public R() {
    put("code", 0);
    put("msg", "success");
  }

  public static R error() {
    return error(SERVER_ERROR, "未知异常，请联系管理员");
  }

  public static R error(String msg) {
    return error(SERVER_ERROR, msg);
  }

  public static R error(int code, String msg) {
    R r = new R();
    r.put("code", code);
    r.put("msg", msg);
    return r;
  }

  public static R ok(String msg) {
    R r = new R();
    r.put("msg", msg);
    return r;
  }

  public static R ok(Object msg) {
    R r = new R();
    r.put("msg", msg);
    return r;
  }

  public static R ok(Map<String, Object> map) {
    R r = new R();
    r.putAll(map);
    return r;
  }

  public static R ok() {
    return new R();
  }

  public R put(String key, Object value) {
    super.put(key, value);
    return this;
  }

  public R putPage(Object value) {
    super.put(page, value);
    return this;
  }

  public R put(Object value) {
    super.put(data, value);
    return this;
  }
}
