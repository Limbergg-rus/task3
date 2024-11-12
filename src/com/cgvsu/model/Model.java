package com.cgvsu.model;
import com.cgvsu.math.Vector2f;
import com.cgvsu.math.Vector3f;

import java.util.*;

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();

    public void deleteVertices(int[] vertexs) {
        for(int element: vertexs){
            deleteVertice(element);
        }

    }

    public void deleteVertice(int vertex) {
        //Удалить вершину из списка вершин
        vertices.remove(vertex);
        //Удалить вершину из полигонов
        //Тут мы проходимся по всем полигонам, получаем
        // в каждом полигоне массив векторов, и если удаленный
        // вектор находится в этом списке, то мы удаляем полигон
        for (int i = 0; i < polygons.size(); i++) {
            for (int j = 0; j < polygons.get(i).getVertexIndices().size(); j++) {
                if (polygons.get(i).getVertexIndices().get(j) == vertex) {
                    polygons.remove(i);
                    i = i == 0? 0: i - 1;
                    j = 0;
                }
            }

        }
    }
}
//            for(var element: polygons.get(i).getVertexIndices()){
//                if(element.equals(vertex)){
//                    element.resolveConsta;
//                }
//            }
//            if (){
//
//            }

