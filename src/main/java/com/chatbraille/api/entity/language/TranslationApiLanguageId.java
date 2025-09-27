package com.chatbraille.api.entity.language;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TranslationApiLanguageId implements Serializable {
    private Long translationApiSeq;
    private Long languageSeq;
}
