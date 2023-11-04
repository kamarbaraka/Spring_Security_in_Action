package com.kamar.spring_security_in_action.app;

import lombok.Data;

public record Message(
        String message,
        String from
) {
}
