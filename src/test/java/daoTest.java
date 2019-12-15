import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import servlet.cat;
import servlet.dao;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class daoTest
{
    private List<cat> cats=new ArrayList<cat>();
    @Before
    public void setUp()
    {
        cats.add(new cat(1,"wang"));
        cats.add(new cat(2,"wang1"));
    }

    @Test
    public void testSelect() {
        dao dao = mock(dao.class);
        when(dao.select("m")).thenReturn(cats);
        List<cat> cats1=dao.select("m");
        Assert.assertSame(cats,cats1);
    }
    @Test
    public void testDeleteNUll() {
        dao dao = mock(dao.class);

        doThrow(new RuntimeException("参数为空")).when(dao).delete(isA(String.class));
        dao.delete(null);

    }

    @Test
    public void testUpdateNull() {
        dao dao = mock(dao.class);
        final cat cat1=new cat(3,"fff");
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                boolean flag=false;
                for(cat cat:cats)
                {
                    if(cat1.getC_name().equals(cat.getC_name()))
                    {
                        flag=true;
                        break;
                    }
                }
                if (flag)
                {
                    System.out.println("update success");
                }
                else
                {
                    System.out.println("update error");
                }
                return  null;
            }
        }).when(dao).update(isA(cat.class));

        dao.update(cat1);
    }
}
