package com.dawn.util;


public class Response {

    /**
     * Response 消息
     */
    private String message;

    /**
     * Response 状态码
     */
    private String status;

    /**
     * Response 数据
     */
    private Object data;

    /**
     * 通话令牌
     */
    private String token;

    private String index;
    private String total;
    private String persize;
    private String totalPages;
    private String uuid;
    private String phoneVCode;

    /**
     * public static void main(String[] args) {
     * <p>
     * Response re = new Response(); re.setData("data").setStatus("status");
     * <p>
     * List<Response> list = new ArrayList<Response>(); list.add(re);
     * list.add(re);
     * <p>
     * String result =
     * <p>
     * Response.build().setStatus("200").setData(new Date()).toJSON();
     * <p>
     * System.out.println(result);
     * <p>
     * }
     */

    public static Response build() {
        return new Response();
    }


    public String getStatus() {
        return status;
    }

    public Response setStatus(String status) {
        this.status = status;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Response setData(Object data) {
        this.data = data;
        return this;
    }

    public String getIndex() {
        return index;
    }

    public Response setIndex(String index) {
        this.index = index;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public Response setTotal(String total) {
        this.total = total;
        return this;
    }

    public String getPersize() {
        return persize;
    }

    public Response setPersize(String persize) {
        this.persize = persize;
        return this;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public Response setTotalPages(String totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Response setToken(String token) {
        this.token = token;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public Response setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getPhoneVCode() {
        return phoneVCode;
    }

    public Response setPhoneVCode(String phoneVCode) {
        this.phoneVCode = phoneVCode;
        return this;
    }

}
