package com.jason.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    private int id;
    private Book book;
    private Reader reader;
    private String borrowTime;
    private String returnTime;
    private int state;

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", book=" + book +
                ", reader=" + reader +
                ", borrowTime='" + borrowTime + '\'' +
                ", returnTime='" + returnTime + '\'' +
                ", state=" + state +
                '}';
    }
}
