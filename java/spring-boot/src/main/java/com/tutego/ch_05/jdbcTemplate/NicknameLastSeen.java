package com.tutego.ch_05.jdbcTemplate;

import java.time.LocalDateTime;

public record NicknameLastSeen(String name, LocalDateTime seen) { }
