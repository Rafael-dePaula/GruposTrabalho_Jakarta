package io.github.rafadepaula.grupostrabalho.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EstadosDDD {
    private static final Map<String, Set<Byte>> stateDDDs = new HashMap<>() {{
        put("Distrito Federal", Set.of((byte) 61));
        put("Goiás", Set.of((byte) 62, (byte) 64));
        put("Mato Grosso", Set.of((byte) 65, (byte) 66, (byte) 67));
        put("Alagoas", Set.of((byte) 82));
        put("Bahia", Set.of((byte) 71, (byte) 73, (byte) 74, (byte) 75, (byte) 77));
        put("Ceará", Set.of((byte) 85, (byte) 88));
        put("Maranhão", Set.of((byte) 98, (byte) 99));
        put("Paraíba", Set.of((byte) 83));
        put("Pernambuco", Set.of((byte) 81, (byte) 87));
        put("Piauí", Set.of((byte) 86, (byte) 89));
        put("Rio Grande do Norte", Set.of((byte) 84));
        put("Sergipe", Set.of((byte) 79));
        put("Acre", Set.of((byte) 68));
        put("Amapá", Set.of((byte) 96));
        put("Amazonas", Set.of((byte) 92, (byte) 97));
        put("Pará", Set.of((byte) 91, (byte) 93, (byte) 94));
        put("Rondônia", Set.of((byte) 69));
        put("Roraima", Set.of((byte) 95));
        put("Tocantins", Set.of((byte) 63));
        put("Espírito Santo", Set.of((byte) 27, (byte) 28));
        put("Minas Gerais", Set.of((byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 37, (byte) 38));
        put("Rio de Janeiro", Set.of((byte) 21, (byte) 22, (byte) 24));
        put("São Paulo", Set.of((byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19));
        put("Paraná", Set.of((byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46));
        put("Rio Grande do Sul", Set.of((byte) 51, (byte) 53, (byte) 54, (byte) 55));
        put("Santa Catarina", Set.of((byte) 47, (byte) 48, (byte) 49));
    }};

    public static Set<Byte> getDDDsEstado(Byte ddd) {
        for (Map.Entry<String, Set<Byte>> state : stateDDDs.entrySet()) {
            if (state.getValue().contains(ddd)) return state.getValue();
        }
        throw new Error("DDD Not found");
    }

    public static Set<Byte> getDDDsEstado(String state) {
        return stateDDDs.get(state);
    }
}
