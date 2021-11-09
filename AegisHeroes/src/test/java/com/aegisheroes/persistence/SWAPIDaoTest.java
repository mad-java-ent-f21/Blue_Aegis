package com.aegisheroes.persistence;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SWAPIDaoTest {

    @Test
    public void getPlanetSuccess() {
        SWAPIDao dao = new SWAPIDao();
        dao.getPlanet();
        assertEquals("Tatooine", dao.getPlanet().getName());
    }
}