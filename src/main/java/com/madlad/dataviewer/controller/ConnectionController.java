package com.madlad.dataviewer.controller;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.madlad.dataviewer.config.Dataviewer;
import com.madlad.dataviewer.connection.ConnectionFactory;
import com.madlad.dataviewer.connection.DBConnection;
import com.madlad.dataviewer.model.ConnectionDetails;
import com.madlad.dataviewer.model.ConnectionType;
import com.madlad.dataviewer.query.QueryResult;
import com.madlad.dataviewer.repository.rest.ConnectionRestRepository;
import com.madlad.dataviewer.utils.HibernateUtils;
import com.madlad.dataviewer.utils.ViewerUtils;

@RestController
@RequestMapping("connection")
public class ConnectionController {

	@Autowired
	private ConnectionFactory connectionFactory;

	@Autowired
	private ConnectionRestRepository connectionRestRepository;
	
	@Autowired
	private List<Dataviewer<?,?>> viewers;

	/**
	 * 
	 * Connection<Typed with connection inside>.executeQuery QueryResult<typed with result type>
	 * 
	 */
	@RequestMapping(path = "/{id}/runQuery", method = RequestMethod.POST)
	public ResponseEntity<QueryResult<?>> run(@PathVariable Integer id, @RequestBody RunQueryParameters params) {
		ConnectionDetails connectionDetails = connectionRestRepository.getOne(Long.valueOf(id));
		DBConnection<?> connection = connectionFactory.getConnection(HibernateUtils.unproxy(connectionDetails, ConnectionDetails.class));
		QueryResult<?> result = connection.search(params.getQueryString(), params.getQueryParams());
		return new ResponseEntity<QueryResult<?>>(result, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}/test", method = RequestMethod.GET)
	public boolean testConnection(@PathVariable Integer id) {
		ConnectionDetails connectionDetails = connectionRestRepository.getOne(Long.valueOf(id));
		DBConnection<?> connection = connectionFactory.getConnection(HibernateUtils.unproxy(connectionDetails, ConnectionDetails.class));
		return connection.testConnection();
	}

	@PostMapping("/test")
	public boolean testConnection(@RequestBody ConnectionDetails details) {
		return false;
	}

	/**
	 * TODO: Implement
	 * 
	 * Returns list of required fields for particular connection type. This is
	 * required by UI in order to display create connection page.
	 * 
	 * TODO: Connection details should be abstract and subclasses will declare all
	 * required fields for particular
	 * 
	 */
	@RequestMapping(path = "/{type}/parameters", method = RequestMethod.GET)
	public List<String> getParametersForConnectionType(@PathVariable ConnectionType type) {
		Class<?> connectionDetailsClass = ViewerUtils.findByType(viewers, type).connectionDetailsClass();
		List<Field> fields = Arrays.asList(connectionDetailsClass.getDeclaredFields());
		return fields.stream().map(field -> field.getName()).collect(Collectors.toList());
	}

	@GetMapping("/types")
	public List<ConnectionType> getAllTypes() {
		return Arrays.asList(ConnectionType.values());
	}

	public static class RunQueryParameters {
		private String queryString;
		private Integer queryId;
		private Map<String, String> queryParams;

		public String getQueryString() {
			return queryString;
		}

		public void setQueryString(String queryString) {
			this.queryString = queryString;
		}

		public Integer getQueryId() {
			return queryId;
		}

		public void setQueryId(Integer queryId) {
			this.queryId = queryId;
		}

		public Map<String, String> getQueryParams() {
			return queryParams;
		}

		public void setQueryParams(Map<String, String> queryParams) {
			this.queryParams = queryParams;
		}
	}

}
