package ru.novosoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.novosoft.model.Person;
import ru.novosoft.repository.PeopleRepository;
import ru.novosoft.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> personOptional = peopleRepository.findByUsername(s);

        if (!personOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }

        Person person = personOptional.get();
        return new PersonDetails(person);
    }
}

