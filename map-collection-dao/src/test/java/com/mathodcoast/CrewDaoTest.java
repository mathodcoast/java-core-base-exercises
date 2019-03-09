package com.mathodcoast;

import com.mathodcoast.dao.CrewDao;
import com.mathodcoast.dao.implementation.CrewDaoImpl;
import com.mathodcoast.model.CrewMember;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith ( JUnit4.class )
public class CrewDaoTest {
    private CrewDao crewDao;

    @Test
    public void testAddNewSpecialization() {
        crewDao = new CrewDaoImpl();
        crewDao.addNewSpecialization("Cameraman");
        List<CrewMember> cameramen = crewDao.getAllCrewMembersBySpecialization("Cameraman");

        assertEquals(1,crewDao.getSpecializationsCount());
        assertTrue(cameramen.isEmpty());
    }

    @Test
    public void testAddCrewMemberInNotExistingSpecialization() {
        crewDao = new CrewDaoImpl();
        CrewMember cameraman = getSingleCameraman();
        crewDao.addCrewMember("Cameraman",cameraman);

        List<CrewMember> cameramenFromDB = crewDao.getAllCrewMembersBySpecialization("Cameraman");

        assertEquals(cameraman,cameramenFromDB.get(0));
    }

    @Test
    public void testAddCrewMemberInExistingSpecialization() {
        crewDao = getFullCrew();
        CrewMember cameraman = getSingleCameraman();
        crewDao.addCrewMember("Cameraman",cameraman);

        List<CrewMember> cameramenFromDB = crewDao.getAllCrewMembersBySpecialization("Cameraman");

        assertTrue(cameramenFromDB.contains(cameraman));
        assertEquals(5,crewDao.getSpecializationsCount());
    }

    @Test
    public void testGetCrewMemberByGeneratedID() {
        crewDao = getFullCrew();

        CrewMember cameraman = getSingleCameraman();
        crewDao.addCrewMember("Cameraman",cameraman);

        CrewMember crewMemberById = crewDao.getCrewMemberById(14);
        assertEquals(cameraman,crewMemberById);
    }

    @Test
    public void testGetAllCrewMembers() {
        crewDao = getFullCrew();

        List<CrewMember> crewMemberList = crewDao.getAllCrewMembers();
        assertEquals(14,crewMemberList.size());
    }

    @Test
    public void testGetAllSpecializations() {
        crewDao = getFullCrew();

        List<String> specializations = crewDao.getAllSpecializations();
        assertEquals(5,specializations.size());
        assertTrue(specializations.contains("Cameraman"));
        assertTrue(specializations.contains("Focus"));
        assertTrue(specializations.contains("Illuminator"));
        assertTrue(specializations.contains("Sound"));
        assertTrue(specializations.contains("Producer"));
    }

    @Test
    public void testUpdateCrewMember() {
        crewDao = getFullCrew();

        CrewMember memberForUpdate = new CrewMember("Kate","Gay","gay@mad.com",12000);
        memberForUpdate.setId(12);

        crewDao.updateCrewMember(memberForUpdate);
        CrewMember updatedMember = crewDao.getCrewMemberById(12);
        assertEquals(12000,updatedMember.getSalary(),0.0);
    }

    @Test
    public void testDeleteCrewMemberById() {
        crewDao = getFullCrew();

        crewDao.deleteCrewMemberById(12);
        assertEquals(13,crewDao.getAllCrewMembers().size());
    }

    @Test
    public void testGetCrewMembersByEmailDomain() {
        crewDao = getFullCrew();
        String email = "pocus@gmail.com";
        List<CrewMember> membersByEmailDomain = crewDao.getCrewMembersByEmailDomain("gmail.com");
        boolean contain = membersByEmailDomain
                .stream()
                .anyMatch(crewMember -> crewMember
                        .getEmail()
                        .equals(email));

        assertTrue(contain);
    }

    @Test
    public void testGetAllCrewMembersCount() {
        crewDao = getFullCrew();
        assertEquals(14,crewDao.getCrewMembersCount());
    }

    @Test
    public void testDeleteCrewMembersBySpecialization() {
        crewDao = getFullCrew();

        crewDao.deleteCrewMembersBySpecialization("Focus");
        assertEquals(12,crewDao.getCrewMembersCount());
    }

    @Test
    public void testDeleteAllCrewMembers() {
        crewDao = getFullCrew();
        crewDao.deleteAllCrewMembers();

        assertTrue(crewDao.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        crewDao = new CrewDaoImpl();
        assertTrue(crewDao.isEmpty());
    }

    @Test
    public void testCrewIteratorHasNext() {
        crewDao = getFullCrew();

        Iterator<CrewMember> iterator = crewDao.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testCrewIteratorNext() {
        crewDao = getFullCrew();

        Iterator<CrewMember> iterator = crewDao.iterator();
        System.out.println(iterator.next());
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testCrewDaoForEach() {
        crewDao = getFullCrew();
        int counter = 0;
        for (CrewMember member : crewDao) {
            System.out.println(member);
            counter++;
        }
        assertEquals(14,counter);
    }


    private CrewMember getSingleCameraman() {
        return new CrewMember("Roger","Deakins","deakins@gmail.com",200000);
    }

    private CrewDao getFullCrew() {
        CrewDao crewDao = new CrewDaoImpl();
        crewDao.addCrewMember("Cameraman",
                new CrewMember("Emmanuel","Lubezki","lubezki@mail.com",150000));
        crewDao.addCrewMember("Cameraman",
                new CrewMember("Robert","Richardson","richardson@gmail.com",160000));
        crewDao.addCrewMember("Cameraman",
                new CrewMember("Christopher","Doyle","doyle@gmail.com",160000));
        crewDao.addCrewMember("Illuminator",
                new CrewMember("Serhiy","Hizhnyak","hizhnyak@mail.com",100));
        crewDao.addCrewMember("Illuminator",
                new CrewMember("Bob","Taylor","taylor@gmail.com",500));
        crewDao.addCrewMember("Illuminator",
                new CrewMember("Canu","Hubatu","hubatu@mad.com",100));
        crewDao.addCrewMember("Illuminator",
                new CrewMember("Tutto","Pyoni","pyoni@mad.com",400));
        crewDao.addCrewMember("Focus",
                new CrewMember("Tim","Pocus","pocus@gmail.com",400));
        crewDao.addCrewMember("Focus",
                new CrewMember("Bim","Zeiss","zeiss@mail.com",700));
        crewDao.addCrewMember("Sound",
                new CrewMember("Kim","Wave","vawe@mail.com",700));
        crewDao.addCrewMember("Sound",
                new CrewMember("Leon","Mickhazer","mickhazer@mail.com",400));
        crewDao.addCrewMember("Sound",
                new CrewMember("George","Petlichniy","petlichniy@mad.com",500));
        crewDao.addCrewMember("Producer",
                new CrewMember("Kate","Gay","gay@mad.com",1000));
        crewDao.addCrewMember("Producer",
                new CrewMember("Andriy","Zaiko","zaiko@mad.com",800));

        return crewDao;
    }
}
