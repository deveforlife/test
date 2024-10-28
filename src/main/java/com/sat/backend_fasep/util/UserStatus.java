package com.sat.backend_fasep.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserStatus {
    @JsonProperty("active") // Allow lowercase values
    ACTIVE,

    @JsonProperty("inactive") // Allow lowercase values
    INACTIVE
}
