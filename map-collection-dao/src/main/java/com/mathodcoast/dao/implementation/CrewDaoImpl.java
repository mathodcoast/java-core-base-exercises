package com.mathodcoast.dao.implementation;

import com.mathodcoast.dao.CrewDao;
import com.mathodcoast.model.CrewMember;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CrewDaoImpl implements CrewDao {

    private Map<String, Set<CrewMember>> crew;
    private int idCounter;

    public CrewDaoImpl() {
        this.crew = new HashMap<>();
    }

    @Override
    public void addNewSpecialization(String spec) {
        crew.put(spec,new HashSet<>());
        System.out.println(crew.size());

    }

    @Override
    public void addCrewMember(String spec,CrewMember crewMember) {
        crewMember.setId(idCounter++);
        Set<CrewMember> crewBySpecialization;
        if (!crew.containsKey(spec)) {
            crewBySpecialization = new HashSet<>();
            crewBySpecialization.add(crewMember);
            crew.put(spec,crewBySpecialization);
        } else {
            crewBySpecialization = crew.get(spec);
            crewBySpecialization.add(crewMember);
        }
    }

    @Override
    public List<CrewMember> getAllCrewMembers() {
        return crew.values().stream().map(Set::stream).flatMap(Function.identity()).collect(Collectors.toList());
    }

    @Override
    public List<CrewMember> getAllCrewMembersBySpecialization(String spec) {
        System.out.println(crew.get(spec));
        return new ArrayList<>(crew.get(spec));
    }

    @Override
    public List<String> getAllSpecializations() {
        return new ArrayList<>(crew.keySet());
    }

    @Override
    public CrewMember getCrewMemberById(int id) {
        CrewMember crewMember = null;

        for (Set<CrewMember> value : crew.values()) {
            for (CrewMember member : value) {
                if (member.getId() == id) {
                    crewMember = member;
                }
            }
        }

//      Stream API approach:

//        crewMember = crew.values().stream()
//                .map(Set::stream)
//                .flatMap(Function.identity())
//                .filter(cm -> cm.getId() == id)
//                .findFirst().get();
        return crewMember;
    }

    @Override
    public void updateCrewMember(CrewMember crewMember) {
        CrewMember memberFromDB = this.getCrewMemberById(crewMember.getId());
        System.out.println(memberFromDB);
        memberFromDB.setFirstName(crewMember.getFirstName());
        memberFromDB.setSecondName(crewMember.getSecondName());
        memberFromDB.setEmail(crewMember.getEmail());
        memberFromDB.setSalary(crewMember.getSalary());
    }

    @Override
    public void deleteCrewMemberById(int id) {
        String specialization = null;
        CrewMember memberFromDB = null;

        for (Map.Entry<String, Set<CrewMember>> entry : crew.entrySet()) {
            for (CrewMember member : entry.getValue()) {
                if (member.getId() == id) {
                    specialization = entry.getKey();
                    memberFromDB = member;
                }
            }
        }

        crew.get(specialization).remove(memberFromDB);

    }

    @Override
    public void deleteCrewMembersBySpecialization(String spec) {
        crew.remove(spec);
    }

    @Override
    public void deleteAllCrewMembers() {
        crew.clear();
    }

    @Override
    public List<CrewMember> getCrewMembersByEmailDomain(String emailResource) {
        return crew.values().stream()
                .map(Set::stream)
                .flatMap(Function.identity())
                .filter(crewMember -> crewMember.getEmail().split("@")[1].equals(emailResource))
                .collect(Collectors.toList());
    }

    @Override
    public int getSpecializationsCount() {
        return crew.size();
    }

    @Override
    public int getCrewMembersCount() {
        return (int)crew.values().stream().map(Set::stream).flatMap(Function.identity()).count();
    }

    @Override
    public boolean isEmpty() {
        return crew.isEmpty();
    }


    @Override
    public Iterator<CrewMember> iterator() {
        return new Iterator<>() {
            Iterator<CrewMember> mainIterator;
            Iterator<Map.Entry<String, Set<CrewMember>>> entryIterator = crew.entrySet().iterator();

            @Override
            public boolean hasNext() {
                if (mainIterator == null){
                    if (entryIterator.hasNext()){
                        mainIterator = entryIterator.next().getValue().iterator();
                        return mainIterator.hasNext();
                    } else {
                        return false;
                    }
                } else {
                    if (mainIterator.hasNext()){
                        return true;
                    } else {
                        mainIterator = null;
                        return hasNext();
                    }
                }
            }

            @Override
            public CrewMember next() {
                if (hasNext()){
                    return mainIterator.next();
                } else {
                    return null;
                }
            }
        };
    }
}
