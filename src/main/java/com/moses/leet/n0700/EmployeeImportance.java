package com.moses.leet.n0700;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e:employees){
            map.put(e.id, e);
        }

        return rec(map, id);
    }

    private int rec(Map<Integer, Employee> map, int id) {
        int cur = map.get(id).importance;
        for(Integer sub : map.get(id).subordinates){
            cur += rec(map, sub);
        }
        return cur;
    }


    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}
