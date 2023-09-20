package com.cos.person.web;

import com.cos.person.domain.*;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;


//    // 리플렉션에서 서블릿 컨에티너가 UserController 를 new 할 때 default 생성자가 없어서 IOC 에서 UserRepository 에 관련된 것을 찾음
//    // DI => 의존성 주입
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    //http://localhost:8080/user => rest API 는 모델명
    @GetMapping("/user")
    public CommonDto<List<User>> findAll() {
//        System.out.println(userRepository);
        System.out.println("findAll");
        return new CommonDto<>(HttpStatus.OK.value(), userRepository.findAll());
    }

    //http://localhost:8080/user/2
    @GetMapping("/user/{id}")
    public CommonDto<User> findById(@PathVariable int id) {
        // @PathVariable => 주소로 들어오는 값은 String 이기 때문에 그 값을 int 로 바꿔줌, String 으로 받기도 가능
        System.out.println("findById");
        System.out.println("id = " + id);
        return new CommonDto<>(HttpStatus.OK.value(), userRepository.findById(id));
    }

    //http://localhost:8080/user
    @PostMapping("/user")
    //x-www-form-urlencoded => request.getParameter()
    // text/plain => @RequestBody 어노테이션
    // application/json => @RequestBody 어노테이션 + 오브젝트
    public CommonDto<?> save(@Valid @RequestBody JoinReqDto dto, BindingResult bindingResult) {

//        if (bindingResult.hasErrors()) {
//            HashMap<String, String> errorMap = new HashMap<>();
//
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//            }
//
//            return new CommonDto<>(HttpStatus.BAD_REQUEST.value(), errorMap);
//        }

        System.out.println("save");
        System.out.println("user = " + dto);
        userRepository.save(dto);
//        System.out.println("data = " + data);
//        System.out.println("username = " + username);
//        System.out.println("password = " + password);
//        System.out.println("phone = " + phone);
        return new CommonDto<>(HttpStatus.CREATED.value(), "ok");
    }

    //http://localhost:8080/user/2
    @DeleteMapping("/user/{id}")
    public CommonDto<String> delete(@PathVariable int id){
        System.out.println("delete");
        userRepository.delete(id);
        return new CommonDto<>(HttpStatus.OK.value());
    }

    //http://localhost:8080/user/2
    @PutMapping("/user/{id}") // 라우팅, controller 의 역할 라우팅하고 데이터를 응답할지, 파일 응답할지
    public CommonDto<?> update(@PathVariable int id,@Valid @RequestBody UpdateReqDto dto,BindingResult bindingResult){
        
//
        
        System.out.println("update");

        userRepository.update(id,dto);
        return new CommonDto<>(HttpStatus.OK.value(),dto); // 데이터 응답
    }

}
