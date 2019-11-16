package com.github.svyaz.dppointsservice.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractConverter<S, T> implements Converter<S, T> {
    public Set<T> convert(Set<S> source) {
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }
}
