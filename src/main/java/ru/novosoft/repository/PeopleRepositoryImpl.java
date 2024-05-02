package ru.novosoft.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.novosoft.generators.Generator;
import ru.novosoft.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public class PeopleRepositoryImpl implements PeopleRepository {

    private final List<Person> people;

    @Autowired
    public PeopleRepositoryImpl(Generator generator) {
        this.people = generator.getUsers(); // Инициализация списка пользователей из generator
    }

    @Override
    public Optional<Person> findByUsername(String username) {
        return people.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

}

