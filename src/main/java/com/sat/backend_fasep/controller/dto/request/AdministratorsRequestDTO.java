package com.sat.backend_fasep.dto.request;

import java.io.Serializable;
import java.util.Date;

public class AdministratorsRequestDTO implements Serializable {

    // Declare the components needed for the login page
    private String username;
    private String password;
    private String gaKey;

    // Declare administrator account private information
    private String nickName;
    private String email;
    private String phoneNumber;
    private String otherContactInfo;

    // Declare information for management
    private String type;
    private Date created_date;
    private Date updated_date;
    private int user_id_created;
    private int user_id_updated;
    private int status;

}
