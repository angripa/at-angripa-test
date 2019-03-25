package hita.rokkap.com.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import hita.rokkap.com.enums.ServiceStatus;
import hita.rokkap.com.exception.AppAuthException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import java.io.IOException;

public class AppAuthExceptionSerializer extends StdSerializer<AppAuthException> {

    /**
     *
     */
    private static final long serialVersionUID = -5874866948482845076L;

    protected AppAuthExceptionSerializer() {
        super(AppAuthException.class);
    }

    @Override
    public void serialize(AppAuthException e, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        if (e.getOAuth2ErrorCode().equals(OAuth2Exception.INVALID_REQUEST) && e.getMessage().equals("Bad credentials")) {
            gen.writeStringField("status", ServiceStatus.LOGIN_FAIL.getValue());
            gen.writeStringField("message", ServiceStatus.LOGIN_FAIL.getReasonPhrase());
        }
        gen.writeEndObject();
    }

}
