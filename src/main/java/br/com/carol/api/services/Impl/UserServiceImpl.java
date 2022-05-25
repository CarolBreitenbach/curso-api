package br.com.carol.api.services.Impl;

import br.com.carol.api.domain.User;
import br.com.carol.api.domain.dto.UserDTO;
import br.com.carol.api.repositories.UserRepository;
import br.com.carol.api.services.UserService;
import br.com.carol.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


   public List<User> findAll(){
        return repository.findAll();
   }

    @Override
    public User create(UserDTO obj) {
     return repository.save(mapper.map(obj,User.class));
    }


}
