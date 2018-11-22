package com.madlad.dataviewer.entity;

import com.madlad.dataviewer.model.ConnectionType;

import java.util.Map;

import javax.persistence.*;

/**
 * 
 * TODO: Connection details should be abstract and subclasses will declare all
 * required fields for particular
 * 
 * This is a single class which is used for parsing connection details from UI
 * in JSON and when for storing and retrieving it from DB. Thats why so many
 * annotations
 * 
 * @author Oleksandr_Myshko
 *
 */
@Entity(name = "connection")
public class ConnectionDetails {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ConnectionType type;

	@ElementCollection(targetClass = String.class)
	@CollectionTable(name = "connection_parameters", joinColumns = @JoinColumn(name = "connection_id"))
	@MapKeyColumn(name = "name")
	@Column(name = "value")
	private Map<String, String> connectionParameters;

	public ConnectionDetails() {
		super();
	}

	public ConnectionDetails(String name, ConnectionType type, Map<String, String> connectionParameters) {
		super();
		this.name = name;
		this.type = type;
		this.connectionParameters = connectionParameters;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConnectionType getType() {
		return type;
	}

	public void setType(ConnectionType type) {
		this.type = type;
	}

	public Map<String, String> getConnectionParameters() {
		return connectionParameters;
	}

	public void setConnectionParameters(Map<String, String> connectionParameters) {
		this.connectionParameters = connectionParameters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConnectionDetails other = (ConnectionDetails) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
