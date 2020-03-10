package org.chat.service.impl;

import org.chat.bean.vo.Face;
import org.chat.dao.FaceMapper;
import org.chat.service.IFaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaceServiceImpl implements IFaceService {

    @Autowired
    private FaceMapper faceMapper;

    @Override
    public int add(Face face) {
        return faceMapper.insert(face);
    }
}
