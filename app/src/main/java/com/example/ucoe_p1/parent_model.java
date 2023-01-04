package com.example.ucoe_p1;

import java.util.List;

public class parent_model
{
    String title;
    List<child_model> child_modelList;

    public parent_model(String title, List<child_model> child_modelList) {
        this.title = title;
        this.child_modelList = child_modelList;
    }
}
