package org.chat.service;

import org.chat.bean.vo.Face;
import org.chat.dao.FaceMapper;
import org.springframework.stereotype.Service;


public interface IFaceService {

    int add(Face face);
}
