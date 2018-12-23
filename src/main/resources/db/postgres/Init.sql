DROP TABLE connection_parameters;
DROP TABLE connection;

CREATE TABLE connection
(
    id bigint NOT NULL,
    name character varying(255),
    type character varying(255),
    CONSTRAINT connection_details_pkey PRIMARY KEY (id)
);

CREATE TABLE connection_parameters
(
	connection_id bigint NOT NULL,
    name character varying(255),
    value character varying(255),
	FOREIGN KEY (connection_id) REFERENCES connection(id)
)



