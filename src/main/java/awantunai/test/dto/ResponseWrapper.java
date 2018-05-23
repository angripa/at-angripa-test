package awantunai.test.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import awantunai.test.enums.ServiceStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties({ "jsonString", "status", "mapper" })
@Data 
public class ResponseWrapper<D> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseWrapper.class);

	private ResponseWrapper() {
		this.code = null;
		this.message = null;
		this.data = null;
	}

	private ResponseWrapper(D data, ServiceStatus status) {
		Assert.notNull(status, "ServiceStatus cannot be null");
		this.status = status;
		this.code = String.valueOf(this.status.getValue());
		this.message = this.status.getReasonPhrase();
		this.data = data;
	}

	private ResponseWrapper(D data, String code, String message) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	private final ObjectMapper mapper = new ObjectMapper();

	private final String code;
	private final String message;
	private final D data;

	@Getter(value = AccessLevel.PRIVATE)
	@Setter(value = AccessLevel.PRIVATE)
	private ServiceStatus status;

	@Setter(value = AccessLevel.PRIVATE)
	private String jsonString;

	public static <D> ResponseWrapper<D> build(D data, ServiceStatus status) {
		return new ResponseWrapper<D>(data, status);
	}

	public static <D> ResponseWrapper<D> build(D data, String code, String message) {
		return new ResponseWrapper<D>(data, code, message);
	}
	
	public static <D> ResponseWrapper<D> build(String code, String message) {
		return new ResponseWrapper<D>(null, code, message);
	}

	public String getJsonString() {
		String json = "{}";

		try {
			json = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage(), e);
		}

		setJsonString(json);

		return jsonString;
	}
}
