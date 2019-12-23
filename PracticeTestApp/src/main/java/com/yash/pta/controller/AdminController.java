
package com.yash.pta.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yash.pta.model.User;
import com.yash.pta.service.AdminService;
import com.yash.pta.util.PtaApi;

/**
 * This is Rest controller which handles all HTTP requests related to Admin.
 * @RestController marks this class as controller which handles all HTTP requests.
 * @CrossOrigin annotation to handle Cross-Origin-Resource-Sharing (CORS).
 */
@RestController
public class AdminController {
	/**
	 * This is AdminService instance.
	 */
	@Autowired
	AdminService adminService;

	/**
	 * This method fetches the Users who are in active status from DB.
	 * @GetMapping is used to handle GET type of request method
	 * @return Active User list
	 */
	@GetMapping(PtaApi.GET_ALL_ACTIVE_USER)
	public List<User> getActiveUserList() {
		return adminService.getActiveUsers();
	}

	/**
	 * This method fetches the Users who are in In-active status from DB.
	 * @GetMapping is used to handle GET type of request method
	 * @return In-active User list
	 */
	@GetMapping(PtaApi.GET_ALL_INACTIVE_USER)
	public List<User> getInActiveUserList() {
		return adminService.getInActiveUsers();
	}
}
