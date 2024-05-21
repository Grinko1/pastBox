package com.shortlinks.testtask.service;

import com.shortlinks.testtask.entity.PastBoxEntity;
import com.shortlinks.testtask.exception.NotFoundPastBoxException;
import com.shortlinks.testtask.payload.PastBoxResponse;
import com.shortlinks.testtask.repository.PastBoxRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class PastBoxServiceImplTest {
    @Autowired
    private PastBoxService pastBoxService;

//    @MockBean
//    private PastBoxRepository repository;

    @Test
    public void notExistHash(){
//        when(repository.findByHash(anyString())).thenThrow(NotFoundPastBoxException.class);
        assertThrows(NotFoundPastBoxException.class, () -> pastBoxService.getByHash("ksdjfhsdklfjhdfjk"));
    }
//    @Test
//    public void getExistHash(){
//        PastBoxEntity entity = new PastBoxEntity();
//        entity.setHash("1");
//        entity.setData("111");
//        entity.setPublic(true);
//        when(repository.findByHash("1"))
//                .thenReturn(entity);
//        PastBoxResponse expect = new PastBoxResponse("111", true);
//        PastBoxResponse actial = pastBoxService.getByHash("1");
//        assertEquals(expect, actial);
//
//    }
}