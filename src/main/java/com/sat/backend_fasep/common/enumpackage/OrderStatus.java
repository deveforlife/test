package com.sat.backend_fasep.common.enumpackage;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderStatus {
    @JsonProperty("Success") // Allow lowercase values
    SUCCESS,

    @JsonProperty("Falure") // Allow lowercase values
    FALURE,

    @JsonProperty("Pending") // Allow lowercase values
    PENDING
}
