package com.ansdev.course_management_backend.services.language;

import com.ansdev.course_management_backend.models.mybatis.language.Language;
import java.util.List;

public interface LanguageService {

    void insert(Language language);
    List<Language> findAll();
    Language findById(Long id);
    void update (Language language);

    Language getDefaultLanguage();

    List<Language> getAllLanguagesIsLocalize();
}