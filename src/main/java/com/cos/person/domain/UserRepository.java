package com.cos.person.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        users.add(new User(1, "paul", "1234", "01012345678"));
        users.add(new User(1, "paul", "1234", "01012345678"));
        users.add(new User(1, "paul", "1234", "01012345678"));
        return users;
    }

    public User findById(int id) {
        return new User(1, "paul", "1234", "01012345678");
    }

    public void save(JoinReqDto dto){
        System.out.println("DB에 저장 성공");
    }
    public void delete(int id){
        System.out.println("DB에 삭제 성공");
    }

    public void update(int id,UpdateReqDto dto){
        System.out.println("DB에 수정 성공");
//        throw new IllegalArgumentException("argument error ");
    }
}
