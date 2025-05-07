package hexlet.code.controller;

import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserUpdateDTO;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.UserMapper;
import hexlet.code.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> index() {
        var users = userRepository.findAll();
        var result = users.stream()
                .map(p -> userMapper.map(p))
                .toList();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(result.size()))
                .body(result);
    }

    @GetMapping(path = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO show(@PathVariable long id) {
        var user =  userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        var userDto = userMapper.map(user);
        return userDto;
    }

    @PostMapping(path = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Valid @RequestBody UserCreateDTO userData) {
        var user = userMapper.map(userData);
        userRepository.save(user);
        var userDTO = userMapper.map(user);
        return userDTO;
    }

    @PutMapping(path = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("@userUtils.isAuthor(#id)")
    public UserDTO update(@PathVariable Long id, @RequestBody UserUpdateDTO userData) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found."));
        userMapper.update(userData, user);
        userRepository.save(user);
        return userMapper.map(user);
    }

    @DeleteMapping(path = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("@userUtils.isAuthor(#id)")
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }
}
