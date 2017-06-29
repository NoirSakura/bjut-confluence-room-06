package sse.bjut.council.entity;

public class ResTemp {
	private String executeCode;
	private String executeResult;
	private Object data;
	
	public String getExecuteCode() {
		return executeCode;
	}
	public void setExecuteCode(String executeCode) {
		this.executeCode = executeCode;
	}
	public String getExecuteResult() {
		return executeResult;
	}
	public void setExecuteResult(String executeResult) {
		this.executeResult = executeResult;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
