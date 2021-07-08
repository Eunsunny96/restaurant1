package com.example.restaurant.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoryDbEntity {

    //모든 데이터 베이스를 가진 애들은 index 를 상속
    protected int index;
}
