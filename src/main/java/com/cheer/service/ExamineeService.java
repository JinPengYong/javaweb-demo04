package com.cheer.service;

import com.cheer.model.Admin;
import com.cheer.model.Examinee;

public interface ExamineeService {
    Examinee find(String num);

    int update(Examinee examinee);
}
