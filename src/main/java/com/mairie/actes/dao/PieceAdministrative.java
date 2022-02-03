package com.mairie.actes.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity(name = "t_piece_administrative")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PieceAdministrative {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libellePiece;
    private String codePiece;
}
