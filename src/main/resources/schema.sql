CREATE TABLE public.oauth_client_details
(
    client_id character varying(255)  NOT NULL,
    access_token_validity_seconds integer,
    additional_information character varying(255) ,
    authorized_grant_types character varying(255) ,
    autoapprove character varying(255) ,
    client_secret character varying(255) ,
    refresh_token_validity_seconds integer,
    resource_ids character varying(255) ,
    scope character varying(255) ,
    web_server_redirect_uri character varying(255) ,
    CONSTRAINT oauth_client_details_pkey PRIMARY KEY (client_id)
);