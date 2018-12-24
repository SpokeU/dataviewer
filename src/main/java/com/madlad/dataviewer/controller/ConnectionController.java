package com.madlad.dataviewer.controller;

import java.util.List;
import java.util.Map;

import com.madlad.dataviewer.entity.ConnectionDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.madlad.dataviewer.connection.service.ConnectionService;
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
		ConnectionDetailsEntity connectionDetails = connectionRestRepository.getOne(Long.valueOf(id));
		DBConnection<?> connection = connectionFactory
				.getConnection(HibernateUtils.unproxy(connectionDetails, ConnectionDetailsEntity.class));
		QueryResult<?> result = connection.search(params.getQueryString(), params.getQueryParams());
		return new ResponseEntity<QueryResult<?>>(result, HttpStatus.OK);
	}*/

	@RequestMapping(path = "/{id}/test", method = RequestMethod.GET)
	public boolean testConnection(@PathVariable Integer id) {
		return connectionService.testConnection(Long.valueOf(id));
	}

	@PostMapping("/test")
	public boolean testConnection(@RequestBody ConnectionDetailsEntity details) {
		return false;
	}

	@GetMapping("/types")
	public List<ConnectionType> getAllTypes() {
		return connectionService.getAvailableConnectionTypes();
	}

	/**
	 * Returns list of required fields for particular connection type. This is
	 * required by UI in order to display create connection page.
	 */
	@GetMapping(path = "/{type}/parameters")
	public List<String> getParametersForConnectionType(@PathVariable ConnectionType type) {
		return connectionService.getAvailableParametersForConnection(type);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConnectionDetailsEntity> get(@PathVariable Long id){
		return connectionService.getById(id).map(details -> new ResponseEntity(details, HttpStatus.OK)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ConnectionDetailsEntity create(@RequestBody Map<String, String> connectionDetails) {
		String name = connectionDetails.remove(NAME_PARAMETER);
		ConnectionType type = ConnectionType.valueOf(connectionDetails.remove(TYPE_PARAMETER));
		return connectionService.saveConnection(name, type, connectionDetails);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ConnectionDetailsEntity> update(@PathVariable Long id, @RequestBody Map<String, String> connectionDetails){
		String name = connectionDetails.remove(NAME_PARAMETER);
		ConnectionType type = ConnectionType.valueOf(connectionDetails.remove(TYPE_PARAMETER));
		ConnectionDetailsEntity details = connectionService.updateConnection(id, name, type, connectionDetails);
		return new ResponseEntity<>(details, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id){
		connectionService.delete(id);
		return ResponseEntity.accepted().build();
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
