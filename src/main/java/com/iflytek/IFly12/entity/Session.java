package com.iflytek.IFly12.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

@Data
@ApiModel("会话")
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @ApiModelProperty("会话id")
    private Integer sessionId;
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("对话列表")
    private List<Dialogue> dialogues;
    @ApiModelProperty("对话列表Json")
    private String dialoguesJson;
    public static Gson gson = new Gson();
    public String listToJson(List<Dialogue> dialogues) {
        return gson.toJson(dialogues);
    }
    public List<Dialogue> jsonToList(String dialoguesJson) {
        Type dialogueListType = new TypeToken<List<Dialogue>>(){}.getType();
        return gson.fromJson(dialoguesJson, dialogueListType);
    }
}
