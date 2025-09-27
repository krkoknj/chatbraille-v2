package com.chatbraille.api.entity.language;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class LanguageLiblouis {

    @Id
    private Long languageSeq;

    @OneToOne
    @MapsId
    @JoinColumn(name = "language_seq")
    private Language language;

    private String translationTable;

}
