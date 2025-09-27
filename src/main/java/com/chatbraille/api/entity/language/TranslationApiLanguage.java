package com.chatbraille.api.entity.language;

import jakarta.persistence.*;

@Entity
public class TranslationApiLanguage {

    @EmbeddedId
    private TranslationApiLanguageId id;

    @ManyToOne
    @MapsId("translationApiSeq")
    @JoinColumn(name = "translation_api_seq")
    private TranslationApi translationApi;

    @ManyToOne
    @MapsId("languageSeq")
    @JoinColumn(name = "language_seq")
    private Language language;

    private String apiLanguageCode;

}
