package ru.novosoft.repository;

import ru.novosoft.model.Person;

import java.util.Optional;

public interface PeopleRepository {
    Optional<Person> findByUsername(String username);
}

