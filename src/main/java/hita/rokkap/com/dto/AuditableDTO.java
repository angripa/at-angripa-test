package hita.rokkap.com.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public abstract class AuditableDTO<ID extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -825708601352746024L;
	@JsonDeserialize(as = String.class)
	private ID id;
	@JsonProperty("created_date")
	private Date createdDate;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("updated_date")
	private Date updatedDate;
	@JsonProperty("updated_by")
	private String updatedBy;
	private Long version;

	public void nullifyAuditData() {
		this.createdDate = null;
		this.createdBy = null;
		this.updatedDate = null;
		this.updatedBy = null;
		this.version = null;
	}

}
