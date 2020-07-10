package ru.job4j.dream.servlet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.dream.model.User;
import ru.job4j.dream.store.MemStore;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PsqlStore.class)
public class RegServletTest {
    @Test
    public void whenAddUserThenResultTrue() throws ServletException, IOException {
        Store memStore = MemStore.instOf();
        PowerMockito.mockStatic(PsqlStore.class);
        when(PsqlStore.instOf()).thenReturn(memStore);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpSession sc = mock(HttpSession.class);
        when(req.getSession()).thenReturn(sc);
        when(req.getParameter("name")).thenReturn("root");
        when(req.getParameter("email")).thenReturn("root@local");
        when(req.getParameter("password")).thenReturn("root");
        new RegServlet().doPost(req, resp);
        User resultStore = memStore.findAllUsers().iterator().next();
        assertThat(resultStore.getName(), is("root"));
        assertThat(resultStore.getEmail(), is("root@local"));
        assertThat(resultStore.getPassword(), is("root"));
    }
}