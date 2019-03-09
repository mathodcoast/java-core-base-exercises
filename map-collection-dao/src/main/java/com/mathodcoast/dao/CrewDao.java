package com.mathodcoast.dao;

import com.mathodcoast.model.CrewMember;

import java.util.List;

public interface CrewDao extends Iterable<CrewMember> {
    void addNewSpecialization(String spec);
    void addCrewMember(String spec,CrewMember crewMember);
    List<CrewMember> getAllCrewMembers();
    List<CrewMember> getAllCrewMembersBySpecialization(String spec);
    List<String> getAllSpecializations();
    CrewMember getCrewMemberById(int id);
    void updateCrewMember(CrewMember crewMember);
    void deleteCrewMemberById(int id);
    void deleteCrewMembersBySpecialization(String spec);
    void deleteAllCrewMembers();
    List<CrewMember> getCrewMembersByEmailDomain(String emailResource);
    int getSpecializationsCount();
    int getCrewMembersCount();
    boolean isEmpty();
}
