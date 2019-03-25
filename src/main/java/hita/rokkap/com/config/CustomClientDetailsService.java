package hita.rokkap.com.config;

import java.util.List;

import hita.rokkap.com.repository.ClientDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import hita.rokkap.com.domain.OauthClientDetails;

@Service
public class CustomClientDetailsService implements ClientDetailsService, ClientRegistrationService {

	private static final Logger LOG = LoggerFactory.getLogger(CustomClientDetailsService.class);

	private final ClientDetailRepository clientDetailRepository;

	@Autowired
	public CustomClientDetailsService(final ClientDetailRepository clientDetailRepository) {
		this.clientDetailRepository = clientDetailRepository;
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		try {
			LOG.debug("loadClientByClientId --> {}", clientId);
			OauthClientDetails clientIdDetail = clientDetailRepository.findByClientId(clientId);
			if(null == clientIdDetail){
				LOG.debug("client id not found");
			}
			LOG.debug("clientDetail: {}", clientIdDetail.toString());

			return clientIdDetail;
		} catch (IllegalArgumentException e) {
			throw new ClientRegistrationException("No Client Details for client id", e);
		}
	}

	@Override
	public void addClientDetails(ClientDetails arg0) throws ClientAlreadyExistsException {		 
		LOG.info("addClientDetails {} ",arg0);
	}

	@Override
	public List<ClientDetails> listClientDetails() {
		LOG.info("listClientDetails {} ");
		final List<OauthClientDetails> all = clientDetailRepository.findAll();
		return FluentIterable.from(all).transform(toClientDetails()).toList();
	}

	@Override
	public void removeClientDetails(String arg0) throws NoSuchClientException { 
		LOG.info("removeClientDetails {} ");
	}

	@Override
	public void updateClientDetails(ClientDetails arg0) throws NoSuchClientException {		

	}

	@Override
	public void updateClientSecret(String arg0, String arg1) throws NoSuchClientException {		 

	}

	private Function<OauthClientDetails, ClientDetails> toClientDetails() {
		return new Function<OauthClientDetails, ClientDetails>() {
			@Override
			public ClientDetails apply(OauthClientDetails input) {
				return input;
			}
		};
	}
}
