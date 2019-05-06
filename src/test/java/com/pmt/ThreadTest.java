package com.pmt;

import com.pmt.util.ThreadLearn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = {PmtApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ThreadTest {
    @Autowired
    private ThreadLearn threadLearn;

    @Test
    public void test() {
        threadLearn.start();
    }
}
