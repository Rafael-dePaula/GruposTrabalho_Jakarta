package io.github.rafadepaula.grupostrabalho.utils;

import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.json.bind.config.PropertyOrderStrategy;

import java.util.Locale;

public final class HTMLBuilder {
    private static final JsonbConfig jsonbConfig = new JsonbConfig()
            .withFormatting(true)
            .withDateFormat("dd/MM/yyyy",
                    Locale.forLanguageTag("pt_BR"))
            .withPropertyOrderStrategy(
                    PropertyOrderStrategy.LEXICOGRAPHICAL
            );

    public static String toJson(Object object) {
        return JsonbBuilder
                .create(jsonbConfig)
                .toJson(object);
    }

    public static String blocoRelatorioBuilder(String title, Object relatorio) {
        return "<h2>" + title + "</h2>" +
                "<p><pre> " + toJson(relatorio) + "</pre></p>";
    }
}
