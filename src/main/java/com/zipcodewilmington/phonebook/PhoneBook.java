package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private Map <String, List<String>> mapPhone;
    private List<String> existingList = new ArrayList<>();



    public PhoneBook(Map<String, List<String>> map) {
        this.mapPhone = map;
    }


    public PhoneBook() {
        mapPhone = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (mapPhone.containsKey(name))
        {
            existingList = mapPhone.get(name);
            existingList.add(phoneNumber);
            mapPhone.replace(name, existingList);
        }
        else
        {
            // existingList = new ArrayList<>();
            existingList.add(phoneNumber);
            mapPhone.put(name,existingList);
        }

    }

    public void addAll(String name, String... phoneNumbers) {
        if (mapPhone.containsKey(name))
        {
            existingList = mapPhone.get(name);
            ArrayList ph = new ArrayList<String>(Arrays.asList(phoneNumbers));
            existingList.addAll(ph);
            mapPhone.replace(name, existingList);
        }
        else
        {
            // existingList = new ArrayList<>();
            ArrayList ph = new ArrayList<String>(Arrays.asList(phoneNumbers));
            existingList.addAll(ph);
            mapPhone.put(name,existingList);
        }
    }


    public void remove(String name) {
        mapPhone.remove(name);
    }

    public Boolean hasEntry(String phoneNumber) {
        return reverseLookup(phoneNumber)!="";
    }

    public List<String> lookup(String name) {
        return mapPhone.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String nameofPhonenumber = "";
        Iterator it = mapPhone.entrySet().iterator();

        while(it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            existingList  = (List<String>)pair.getValue();
            if (existingList.contains(phoneNumber))
            {
                nameofPhonenumber = (String)pair.getKey();
                break;
            }
        }
        return nameofPhonenumber;
    }

    public List<String> getAllContactNames() {
        existingList.clear();
        Set nameSet = mapPhone.keySet();
        existingList.addAll(nameSet);
        return existingList;
    }

    public Map<String, List<String>> getMap() {
        return mapPhone;
    }
}
