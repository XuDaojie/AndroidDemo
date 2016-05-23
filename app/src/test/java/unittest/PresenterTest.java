package unittest;


import com.example.xdj.androiddemo.unittest.Presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by xdj on 16/5/1.
 */
public class PresenterTest {

    /**
     * 模拟对象
     * 内部所有属性都为null，并且方法返回值都为null
     */
    @Mock
    private Presenter mPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTest1() throws Exception {
        mPresenter.test1();
    }

    @Test
    public void testTestRetrun() throws Exception {
        String str = mPresenter.testRetrun();
    }
}