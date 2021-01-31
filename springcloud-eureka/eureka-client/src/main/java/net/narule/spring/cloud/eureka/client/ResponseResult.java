package net.narule.spring.cloud.eureka.client;

import java.io.Serializable;

/**
 * @author Narule
 *
 */
public class ResponseResult implements Serializable{
	private String data;
	private String msg;
	private int status;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public static ResponseResult ok(Object data) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.setData(data == null ? "no data" : data.toString());
		responseResult.setStatus(200);
		responseResult.setMsg("ok");
		return responseResult;
	}
	
	public static ResponseResult failed(Object data) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.setData(data == null ? "no data" : data.toString());
		responseResult.setStatus(-1);
		responseResult.setMsg("failed");
		return responseResult;
	}
	
	@Override
	public String toString() {
		return "ResponseResult [data=" + data + ", msg=" + msg + ", status=" + status + "]";
	}
	
}
