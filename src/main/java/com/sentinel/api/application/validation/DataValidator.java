package com.sentinel.api.application.validation;

import com.sentinel.api.application.exceptions.InvalidDateException;

import java.time.Duration;
import java.time.LocalDateTime;

public class DataValidator {

    // Valida se inicio < fim
    public static void validarInicioMenorQueFim(LocalDateTime inicio, LocalDateTime fim) {
        if (!inicio.isBefore(fim)) {
            throw new InvalidDateException("Data de início não pode ser após ou igual a data de fim.");
        }
    }

    // Valida se inicio está pelo menos 1 hora antes do fim
    public static void validarAntecedenciaMinima(LocalDateTime inicio, LocalDateTime fim, long horasMinimas) {
        Duration duracao = Duration.between(inicio, fim);
        if (duracao.toHours() < horasMinimas) {
            throw new InvalidDateException("Data de início deve ser no mínimo " + horasMinimas + " hora(s) antes da data de fim.");
        }
    }
}
