package com.tutego.ch_03.testing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@ContextConfiguration(classes = TestingApplication.class)
public class JSONTest {

    // serialization can be customized through the JsonSerializer<T> and JsonDeserializer<T> beans
    public record Registrations(List<Data> data) {
        record Data(@JsonProperty("x") YearMonth yearMonth, @JsonProperty("y") int count) {
        }
    }

    @TestConfiguration
    public static class ObjectMapperConfig {
        @Bean
        public ObjectMapper customJson(Jackson2ObjectMapperBuilder builder) {
            return builder.indentOutput(true).serializationInclusion(JsonInclude.Include.NON_NULL).build();
        }
    }

    @Autowired
    private JacksonTester<Registrations> jacksonTester;

    @Test
    @DisplayName("marshal registrations")
    public void marshal_registrations() throws IOException {
        var registrations = new Registrations(
                Arrays.asList(
                        new Registrations.Data(YearMonth.of(2020, 1), 100),
                        new Registrations.Data(YearMonth.of(2022, 2), 300),
                        new Registrations.Data(YearMonth.of(2022, 9), 500)
                )
        );

        var result = jacksonTester.write(registrations);
        assertThat(result).hasJsonPathArrayValue("$.data");
        assertThat(result).extractingJsonPathStringValue("$.data[1].x").isEqualTo("2022-02");
        assertThat(result).extractingJsonPathNumberValue("$.data[1].y").isEqualTo(300);
    }

    @Test
    @DisplayName("unmarshal registrations")
    void unmarshal_registrations() throws IOException {
        var json = """
                {
                  "data": [
                    {"x": "2020-01", "y": 100},
                    {"x": "2022-02", "y": 300},
                    {"x": "2022-09", "y": 500}
                  ]
                }
                """;

        var result = jacksonTester.parse(json).getObject();
        assertThat(result.data).hasSize(3);
        assertThat(result.data).element(0).extracting(data -> data.count).isEqualTo(100);
    }

}
