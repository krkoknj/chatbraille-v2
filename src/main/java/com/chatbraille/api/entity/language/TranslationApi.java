package com.chatbraille.api.entity.language;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TranslationApi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "translation_api_seq")
    private Long seq;

    private String name;

    private boolean isDefault;
}
