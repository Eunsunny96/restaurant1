package com.example.restaurant.db;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class MemoryDbRepositoryAbstract <T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {
    //데이터를 저장할 ArrayList
    //List에 데이터를 쭉 넣는 형태
    private final List<T> db =new ArrayList<>();
    //오토 제너레잇
    private int index = 0;
    @Override
    public Optional<T> findById(int index) {
        //get Index의 값이 index의 값과 동일하면 findFirst를 리턴 (있을수도 없을수도)
        return db.stream().filter(it -> it.getIndex() == index).findFirst();


    }

    @Override
    public T save(T entity) {
        var optionalEntity = db.stream().filter(it ->it.getIndex() == entity.getIndex()).findFirst();

        //db에 데이터가 없는 경우
        if(optionalEntity.isEmpty()){
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        }else {//db에 이미 데이터가 있는 경우

            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            //삭제후 생성성
            deleteByID(preIndex);
            db.add(entity);
            return entity;
        }
    }

    @Override
    public void deleteByID(int index) {

        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();
        //데이터가 있으면
        if(optionalEntity.isPresent()){
            //해당 entity를 찾아서 지움
            db.remove(optionalEntity.get());
        }

    }

    @Override
    public List<T> listAll() {
        return db;
    }
}
