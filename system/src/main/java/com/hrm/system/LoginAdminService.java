package com.hrm.system;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAdminService {
    @Autowired
    private LoginAdminRepo loginAdminRepo;

    public LoginAdmin getId(long adminId){
        return loginAdminRepo.getReferenceById(adminId);


    }

}
