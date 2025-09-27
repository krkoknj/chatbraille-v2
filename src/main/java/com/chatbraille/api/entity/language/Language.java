package com.chatbraille.api.entity.language;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_seq")
    private Long seq;
    private String languageEndonym;
    private String languageCode;
    private String countryEndonym;
    private String countryCode;
    private boolean isActive;
}
