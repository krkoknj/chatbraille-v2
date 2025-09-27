package com.chatbraille.api.entity.language;

import jakarta.persistence.*;

@Entity
public class TranslationApiConfig {

    @EmbeddedId
    private TranslationApiConfigId id;

    @ManyToOne
    @MapsId("sourceLanguageSeq")
    @JoinColumn(name = "source_language_seq")
    private Language sourceLanguage;

    @ManyToOne
    @MapsId("targetLanguageSeq")
    @JoinColumn(name = "target_language_seq")
    private Language targetLanguage;

    @ManyToOne
    @JoinColumn(name = "translation_api_seq")
    private TranslationApi translationApi;

}
