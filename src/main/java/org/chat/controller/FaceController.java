package org.chat.controller;

import org.chat.bean.Result;
import org.chat.bean.vo.Face;
import org.chat.service.IFaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FaceController {

    @Autowired
    private IFaceService faceService;

    @PostMapping("/upload")
    @ResponseBody
    public Result upload(String stuNumber,String stuName,String date){
        Face face = new Face();
        face.setStuNumber(stuNumber);
        face.setStuName(stuName);
        if(faceService.add(face) > 0){
            return new Result(200,"人脸数据加入成功");
        }
        return new Result(0,"数据插入失败");
    }
}
