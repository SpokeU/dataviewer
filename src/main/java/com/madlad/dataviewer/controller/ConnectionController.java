package com.madlad.dataviewer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.madlad.dataviewer.connection.service.ConnectionService;
import com.madlad.dataviewer.model.ConnectionDetails;
import com.madlad.dataviewer.model.ConnectionType;

@RestController
@RequestMapping("connection")
public class ConnectionController {

	private static final String TYPE_PARAMETER = "type";
	private static final String NAME_PARAMETER = "name";

	@Autowired
	private ConnectionService connectionService;

	/**
	 * 
	 * Connection<Typed with connection inside>.executeQuery QueryResult<typed
	 * with result type>
	 * 
	 */
/*	@RequestMapping(path = "/{id}/runQuery", method = RequestMethod.POST)
	public ResponseEntity<QueryResult<?>> run(@PathVariable Integer id, @RequestBody RunQueryParameters params) {
		ConnectionDetails connectionDetails = connectionRestRepository.getOne(Long.valueOf(id));
		DBConnection<?> connection = connectionFactory
				.getConnection(HibernateUtils.unproxy(connectionDetails, ConnectionDetails.class));
		QueryResult<?> result = connection.search(params.getQueryString(), params.getQueryParams());
		return new ResponseEntity<QueryResult<?>>(result, HttpStatus.OK);
	}*/

	@RequestMapping(path = "/{id}/test", method = RequestMethod.GET)
	public boolean testConnection(@PathVariable Integer id) {
		return connectionService.testConnection(Long.valueOf(id));
	}

	@PostMapping("/test")
	public boolean testConnection(@RequestBody ConnectionDetails details) {
		return false;
	}

	@GetMapping("/types")
	public List<ConnectionType> getAllTypes() {
		return connectionService.getAvaiableConnectionTypes();
	}

	/**
	 * TODO: Implement
	 * 
	 * Returns list of required fields for particular connection type. This is
	 * required by UI in order to display create connection page.
	 * 
	 * TODO: Connection details should be abstract and subclasses will declare
	 * all required fields for particular
	 * 
	 */
	@RequestMapping(path = "/{type}/parameters", method = RequestMethod.GET)
	public List<String> getParametersForConnectionType(@PathVariable ConnectionType type) {
		return connectionService.getAvaiableParametersForConnection(type);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ConnectionDetails create(@RequestBody Map<String, String> connectionDetails) {
		String name = connectionDetails.remove(NAME_PARAMETER);
		ConnectionType type = ConnectionType.valueOf(connectionDetails.remove(TYPE_PARAMETER));
		return connectionService.saveConnection(name, type, connectionDetails);
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
