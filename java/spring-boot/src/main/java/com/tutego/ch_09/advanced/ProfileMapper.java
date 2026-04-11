package com.tutego.ch_09.advanced;

import com.tutego.ch_07.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper extends Converter<Profile, ProfileDto> {
    ProfileDto convert(Profile profile);
}