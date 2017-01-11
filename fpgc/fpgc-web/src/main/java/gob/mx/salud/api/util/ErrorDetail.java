package gob.mx.salud.api.util;

import java.util.List;

/**
 * @author GOCL4767
 *
 */
public class ErrorDetail {
	private String errId;
	private String errMsg;
	private String errDetail;
	private List<ErrorDetail> details;

	public ErrorDetail() {
		super();
	}
	public ErrorDetail(String errId, String errMsg) {
		super();
		this.errId = errId;
		this.errMsg = errMsg;
	}
	public ErrorDetail(String errId, String errMsg, String errDetail) {
		super();
		this.errId = errId;
		this.errMsg = errMsg;
		this.errDetail = errDetail;
	}
	public ErrorDetail(String errId, List<ErrorDetail> details) {
		super();
		this.errId = errId;
		this.details = details;
	}
	/**
	 * @return the errId
	 */
	public String getErrId() {
		return errId;
	}
	/**
	 * @param errId the errId to set
	 */
	public void setErrId(String errId) {
		this.errId = errId;
	}
	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}
	/**
	 * @param errMsg the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	/**
	 * @return the errDetail
	 */
	public String getErrDetail() {
		return errDetail;
	}
	/**
	 * @param errDetail the errDetail to set
	 */
	public void setErrDetail(String errDetail) {
		this.errDetail = errDetail;
	}
	/**
	 * @return the details
	 */
	public List<ErrorDetail> getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List<ErrorDetail> details) {
		this.details = details;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result
				+ ((errDetail == null) ? 0 : errDetail.hashCode());
		result = prime * result + ((errId == null) ? 0 : errId.hashCode());
		result = prime * result + ((errMsg == null) ? 0 : errMsg.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorDetail other = (ErrorDetail) obj;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (errDetail == null) {
			if (other.errDetail != null)
				return false;
		} else if (!errDetail.equals(other.errDetail))
			return false;
		if (errId == null) {
			if (other.errId != null)
				return false;
		} else if (!errId.equals(other.errId))
			return false;
		if (errMsg == null) {
			if (other.errMsg != null)
				return false;
		} else if (!errMsg.equals(other.errMsg))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ErrorDetail [errId=" + errId + ", errMsg=" + errMsg
				+ ", errDetail=" + errDetail + ", details=" + details + "]";
	}
}
