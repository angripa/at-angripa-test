# at-angripa-test

to create oauth client default, please execute script as below.

INSERT INTO oauth_client_details (client_id, client_secret, scope, authorized_grant_types, access_token_validity_seconds, additional_information,resource-ids)
VALUES
('test-client', 'secret', 'read,write', 'authorization_code,password,refresh_token,implicit', '900', '{}','Sidapdap!@#');



for full documentation, you can access swagger-docs in "/api/swagger-ui.html"
