package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {
    //해당 타입을 옵셔널하세 int 라는 해당 데이터를 리턴
    Optional<T> findById(int index);

    //저장 save 메소드
    T save(T entity);

    //삭제
    void deleteByID(int index);

    //전체를 리턴 시킴킴
    List<T> listAll();
}
