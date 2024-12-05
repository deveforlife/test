package com.sat.backend_fasep.common.enumpackage;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserStatus {
    @JsonProperty("active") // Allow lowercase values
    ACTIVE,

    @JsonProperty("suspended") // Allow lowercase values
    SUSPENDED,

    @JsonProperty("closed") // Allow lowercase values
    CLOSED
}
