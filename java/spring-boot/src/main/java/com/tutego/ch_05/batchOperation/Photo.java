package com.tutego.ch_05.batchOperation;

import java.time.LocalDateTime;

public record Photo(long profile, String name, boolean isProfilePhoto, LocalDateTime created) {
}