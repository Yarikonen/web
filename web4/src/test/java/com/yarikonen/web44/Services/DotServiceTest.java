package com.yarikonen.web44.Services;

import com.yarikonen.web44.Data.Dot;
import com.yarikonen.web44.Repositories.DotRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DotServiceTest {
    private DotService underTest;

    @Mock
    private DotRepository repository;

    @BeforeEach
    void initUseCase(){

        underTest = new DotService(repository);

    }


    @Test
    void canGetAllDots() {
        //when
        underTest.getDots();
        //then
        verify(repository).findAll();

    }

    @Test
    void canAddDot() {
        //given
        Dot dot = new Dot(1L,1,1,1, LocalTime.now(),true,1);
        //when
        underTest.addDot(dot);
        //then
        ArgumentCaptor<Dot> dotArgumentCaptor=ArgumentCaptor.forClass(Dot.class);
        verify(repository).save(dotArgumentCaptor.capture());

        Dot captured = dotArgumentCaptor.getValue();

        assertThat(captured).isEqualTo(dot);
    }

    @Test
    void birthTimeChanged(){
        //given
        Dot dot = new Dot();
        //when
        when(underTest.addDot(dot)).then(returnsFirstArg());
        dot = underTest.addDot(dot);
        //then
        assertThat(dot.getBirthTime()).isNotNull();
    }


}