package com.mairie.actes.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReportingParam {
    private String statutActe;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
}
