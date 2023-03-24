package com.common.enums;

import com.common.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrackingContextEnum {

    X_FORWARD_FOR("x-forwarded-for", "clientIP"),
    USER_INFO("x-user", Constants.ACTION_USER),
    X_CORRELATION_ID("X-Correlation-ID", "correlationID");

    private final String headerKey;
    private final String threadKey;
}