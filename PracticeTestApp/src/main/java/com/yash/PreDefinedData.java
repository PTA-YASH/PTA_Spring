package com.yash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.yash.pta.model.Role;
import com.yash.pta.model.RoleName;
import com.yash.pta.repository.RoleRepository;

@Component
public class PreDefinedData implements ApplicationRunner {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Static data in Role Table

		if (roleRepository.count() == 0) {
			Role roleAdmin = new Role();
			roleAdmin.setName(RoleName.ROLE_ADMIN);
			roleRepository.save(roleAdmin);

			Role roleUser = new Role();
			roleUser.setName(RoleName.ROLE_TRAINEE);
			roleRepository.save(roleUser);

			Role roleAssociate = new Role();
			roleAssociate.setName(RoleName.ROLE_TRAINER);
			roleRepository.save(roleAssociate);
		}

	}
}
