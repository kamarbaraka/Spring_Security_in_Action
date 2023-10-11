package com.kamar.spring_security_in_action.app;

import lombok.Getter;

public record Message(
        String message,
        String from
) {
}
