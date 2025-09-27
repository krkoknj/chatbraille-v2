package com.chatbraille.api.entity.language;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TranslationApiConfigId implements Serializable {
    private String sourceLanguageSeq;
    private String targetLanguageSeq;

}
