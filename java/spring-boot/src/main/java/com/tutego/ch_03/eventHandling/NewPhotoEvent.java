package com.tutego.ch_03.eventHandling;

import java.time.OffsetDateTime;

public record NewPhotoEvent(String name, OffsetDateTime dateTime) { }
